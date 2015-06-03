package prop.g12.common;


import com.google.common.collect.Sets;

import java.util.*;

/**
 * This class encapsulates the Clique Percolation algorithm, used to detect overlapped communities inside non-directed
 * and not weighted graphs.
 *
 * This method is slightly modified using suggestions from the article "Extended Clique percolation method to detect
 * overlapping community structure" written by Sumana Maity and Santanu Kumar Rath. It can be found in the following
 * URL : http://ieeexplore.ieee.org/xpl/articleDetails.jsp?arnumber=6968420&pageNumber%3D33268%26rowsPerPage%3D100 .
 *
 * The mentioned modifications are done in order to ensure that every node in the graph is placed at least in one
 * community. We don't apply the third proposed step (merging "similar" communities after adding the left out nodes).
 *
 * @author Andrés Correa Casablanca
 *
 * @param <T> The graph's nodes type.
 */
public class CliquePercolation<T> extends Algorisme<T> {

    /**
     * Clique size
     */
    private int k;

    /**
     * Threshold used to "binarize" the weights between nodes
     */
    private double threshold;


    /**
     * @param k {@link CliquePercolation#k}
     */
    public CliquePercolation(int k, double threshold) {
        if (k <= 2) {
            throw new IllegalArgumentException("k must be greater than 2.");
        }

        if (threshold <= 0) {
            throw new IllegalArgumentException("threshold must be strictly positive.");
        }

        this.k = k;
        this.threshold = threshold;
    }

    /**
     * {@inheritDoc}
     */
    public Solucio<T> generarSolucio(Graf<T> g) {
        return generateSolution(new AffinitiesGraph<T>(g), true);
    }

    /**
     * Implementation of Clique Percolation using an alternative class for graphs.
     */
    public Solucio<T> generateSolution(AffinitiesGraph<T> g) {
        return generateSolution(g, true);
    }

    /**
     * Implementation of Clique Percolation using an alternative class for graphs.
     */
    public Solucio<T> generateSolution(AffinitiesGraph<T> g, boolean processLeftOutNodes) {
        long startTime = System.currentTimeMillis();

        // This is the complicated part: obtaining the Cliques.
        ArrayList<HashSet<T>> kCliques = getKCliquesFromGraph(g);

        // Now we are creating a graph where the nodes are the previously found cliques.
        AffinitiesGraph<HashSet<T>> kCliqueGraf = new AffinitiesGraph<>(kCliques.size());
        kCliqueGraf.addNodes(kCliques);

        for (int i=0; i<kCliques.size(); i++) {
            for (int j=i+1; j<kCliques.size(); j++) {

                if (Sets.intersection(kCliques.get(i), kCliques.get(j)).size() >= k-1) {
                    kCliqueGraf.addEdge(kCliques.get(i), kCliques.get(j), 1.0);
                }
            }
        }

        // Now we are finding the "components" of the clique-graph
        ArrayList<HashSet<T>> communities = findConnectedComponents(kCliqueGraf);

        // Now we apply "Maity-Kumar tweaks" to "classify" the left out nodes.
        if (processLeftOutNodes) {
            applyMaityKumarTweaks(g, communities);
        }

        // Now we "translate" what we've found to a YoutubeSolution instance.
        Solucio<T> solution = new Solucio<>();

        int communityId = 0;
        for (HashSet<T> community : communities) {
            solution.afegirComunitat(communityId);

            for(T node : community) {
                solution.afegirNode(node, communityId);
            }

            communityId++;
        }

        solution.setTempsExec((double)System.currentTimeMillis()-startTime);
        solution.setAlgorisme(this);
        return solution;
    }

    private ArrayList<HashSet<T>> findConnectedComponents(AffinitiesGraph<HashSet<T>> kCliqueGraf) {
        ArrayList<HashSet<T>> communities = new ArrayList<>();
        HashSet<HashSet<T>> processedCliques = new HashSet<>();

        for(HashSet<T> seedClique : kCliqueGraf) {
            if (processedCliques.contains(seedClique)) continue;

            Queue<HashSet<T>> cliquesQueue = new ArrayDeque<>();
            cliquesQueue.add(seedClique);

            HashSet<T> community = new HashSet<>(seedClique.size());

            while (cliquesQueue.size() > 0) {
                HashSet<T> tmpClique = cliquesQueue.poll();

                // Making grow the community
                community.addAll(tmpClique);
                processedCliques.add(tmpClique);

                for (HashSet<T> stemClique : kCliqueGraf.getAdjacentNodes(tmpClique)) {
                    if (processedCliques.contains(stemClique)) continue;
                    cliquesQueue.add(stemClique);
                }
            }

            communities.add(community);
        }

        return communities;
    }

    private void applyMaityKumarTweaks(AffinitiesGraph<T> g, ArrayList<HashSet<T>> communities) {
        Set<T> leftOutNodes = g.getNodes();
        for (HashSet<T> community : communities) {
            leftOutNodes.removeAll(community);
        }

        // We take apart the "very lonely" nodes because Maity-Kumar tweaks don't handle them in a graceful way.
        // We'll create a singleton community for every one of them at the end of the Maity-Kumar tweaks.
        HashSet<T> singletons = new HashSet<>();

        for(T leftOutNode : leftOutNodes) {
            boolean connected = false;
            for (T node : g.getAdjacentNodes(leftOutNode)) {
                if (g.getEdge(leftOutNode, node) >= threshold)  {
                    connected = true;
                    break;
                }
            }
            if (!connected) {
                singletons.add(leftOutNode);
            }
        }
        leftOutNodes.removeAll(singletons);

        // This numbers will be used to compute a "belonging score".
        HashMap<T, Double> weightsSums = new HashMap<>(leftOutNodes.size());

        // We use this data structure to avoid computing the belonging scores every time.
        HashMap<ImmutablePair<T, HashSet<T>>, Double> belongingScores = new HashMap<>(
                leftOutNodes.size()*communities.size()
        );

        for (T leftOutNode : leftOutNodes) {
            double sum = 0;
            for (T node : g.getAdjacentNodes(leftOutNode)) {
                sum += g.getEdge(leftOutNode, node);
            }
            weightsSums.put(leftOutNode, sum);

            for (HashSet<T> community : communities) {
                double belongingScore = 0;

                for (T node : Sets.intersection(community, g.getAdjacentNodes(leftOutNode))) {
                    belongingScore += g.getEdge(leftOutNode, node);
                }

                belongingScore /= weightsSums.get(leftOutNode);
                belongingScores.put(new ImmutablePair<>(leftOutNode, community), belongingScore);
            }
        }

        HashSet<T> modifiedCommunity = null;

        // The nodes aren't added to existent communities at the same time because we want to optimize the "classification".
        while (leftOutNodes.size() > 0) {
            double maxBelongingScore = 0;
            ImmutablePair<T, HashSet<T>> nextAnnexation = null;

            for (T leftOutNode : leftOutNodes) {
                for (HashSet<T> community : communities) {
                    double belongingScore = 0;

                    ImmutablePair<T, HashSet<T>> annexationKey = new ImmutablePair<>(leftOutNode, community);

                    if (community == modifiedCommunity) {
                        for (T node : Sets.intersection(community, g.getAdjacentNodes(leftOutNode))) {
                            belongingScore += g.getEdge(leftOutNode, node);
                        }

                        belongingScore /= weightsSums.get(leftOutNode);
                        belongingScores.put(annexationKey, belongingScore);
                    } else {
                        belongingScore = belongingScores.get(annexationKey);
                    }

                    if (belongingScore >= maxBelongingScore) {
                        maxBelongingScore = belongingScore;
                        nextAnnexation = annexationKey;
                    }
                }
            }

            nextAnnexation.getSecond().add(nextAnnexation.getFirst());
            leftOutNodes.remove(nextAnnexation.getFirst());

            modifiedCommunity = nextAnnexation.getSecond();
        }

        // Finally, we add the singletons we previously segregated.
        for (T singleton : singletons) {
            HashSet<T> tmpSingleton = new HashSet<>(1);
            tmpSingleton.add(singleton);
            communities.add(tmpSingleton);
        }
    }

    /**
     * Finds all the maximal cliques of g, and returns it in form of sets.
     * Implements the Bron-Kerbosch algorithm.
     */
    private ArrayList<HashSet<T>> getKCliquesFromGraph(AffinitiesGraph<T> g) {
        ArrayList<HashSet<T>> cliques = new ArrayList<>();
        HashSet<T> potentialClique = new HashSet<>();
        HashSet<T> alreadyFound = new HashSet<>();
        HashSet<T> candidates = g.getNodes();

        findCliques(potentialClique, candidates, alreadyFound, cliques, g);

        return cliques;
    }

    /**
     * Body of the Bron-Kerbosch algorithm.
     *
     * @param potentialClique
     * @param candidates
     * @param alreadyFound
     */
    private void findCliques(
            HashSet<T> potentialClique, HashSet<T> candidates, HashSet<T> alreadyFound,
            ArrayList<HashSet<T>> cliques, AffinitiesGraph<T> g
    ) {

        ArrayList<T> candidatesArray = new ArrayList<T>(candidates);

        if (!end(candidates, alreadyFound, g)) {
            for (T candidate : candidatesArray) {
                HashSet<T> newCandidates = new HashSet<>();
                HashSet<T> newAlreadyFound = new HashSet<>();

                // move candidate node to potentialClique
                potentialClique.add(candidate);
                candidates.remove(candidate);

                // create newCandidates by removing nodes in candidates not
                // connected to candidate node
                for (T newCandidate : candidates) {
                    if (g.getEdge(candidate, newCandidate) >= threshold)  {
                        newCandidates.add(newCandidate);
                    }
                }

                // create newAlreadyFound by removing nodes in alreadyFound
                // not connected to candidate node
                for (T newFound : alreadyFound) {
                    if (g.getEdge(candidate, newFound) >= threshold) {
                        newAlreadyFound.add(newFound);
                    }
                }

                // if newCandidates and new_already_found are empty
                if (newCandidates.isEmpty() && newAlreadyFound.isEmpty()) {
                    // potentialClique is maximal_clique
                    if (potentialClique.size() >= k) {
                        cliques.add(new HashSet<T>(potentialClique));
                    }
                } else {
                    findCliques(potentialClique, newCandidates, newAlreadyFound, cliques, g);
                }

                // move candidate_node from potentialClique to alreadyFound;
                alreadyFound.add(candidate);
                potentialClique.remove(candidate);
            }
        }
    }

    /**
     * Tells us if a node inside alreadyFound us connected to all candidate nodes.
     */
    private boolean end(HashSet<T> candidates, HashSet<T> alreadyFound, AffinitiesGraph<T> g)
    {
        int edgeCounter;

        for (T found : alreadyFound) {
            edgeCounter = 0;

            for (T candidate : candidates) {
                if (g.getEdge(found, candidate) >= threshold) {
                    edgeCounter++;
                }
            }

            if (edgeCounter == candidates.size()) {
                return true;
            }
        }

        return false;
    }
}
