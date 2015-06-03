package prop.g12.common;

import java.util.*;

/**
 * This class represents non-directed weighted graphs without edges connecting nodes with themselves. The weights must
 * be in the [0,1] interval, since they represent affinities between nodes in a normalized scale.
 *
 * This class is optimized for read operations, rather than write operations.
 *
 * It doesn't allow duplicated nodes, uses the `equals` and `hashCode` methods to determine if a new node is a
 * duplicated one or not.
 *
 * @author Andrés Correa Casablanca
 */
public class AffinitiesGraph<T> implements Iterable<T> {

    /**
     * Adjacency Matrix, defines weighted edges between nodes.
     */
    private HashMap<T, HashMap<T, Double>> adjMatrix;


    /**
     * Simple constructor
     */
    public AffinitiesGraph() {
        adjMatrix = new HashMap<>();
    }

    /**
     * Convenience constructor that pre-allocates memory to store the nodes and edges.
     *
     * @param nodesCapacity The expected number of nodes the graph will have.
     */
    public AffinitiesGraph(int nodesCapacity) {
        adjMatrix = new HashMap<>(nodesCapacity);
    }

    /**
     * Convenience constructor. Casts a Graf instance to an AffinitiesGraph instance.
     * @param srcGraph The source graph represented by a Graf instance.
     */
    public AffinitiesGraph(Graf<T> srcGraph) {
        this(srcGraph.getNumNodes());

        // Using getAdjacencia is a bad idea since it breaks Graf encapsulation, but we have no other choice to access
        // the nodes.
        Set<T> srcNodes = srcGraph.getNodes();

        for (T node : srcNodes) {
            addNode(node);
        }

        for (T node1 : srcNodes) {
            for (T node2 : srcNodes) {
                if (node1.equals(node2)) continue;

                try {
                    if (srcGraph.getAresta(node1, node2) > 0) {
                        addEdge(node1, node2, srcGraph.getAresta(node1, node2));
                    }
                } catch (Exception e) {
                    // Do nothing
                }
            }
        }
    }


    /**
     * Casts this AffinitiesGraph instance to a Graf intance.
     */
    public Graf<T> toGrafInstance() throws Exception {
        int numNodes = adjMatrix.size();
        Graf<T> g = new Graf<T>(numNodes);

        for (T node : adjMatrix.keySet()) {
            g.afegirNode(node);
        }

        for (T node1 : getNodes()) {
            for (T node2 : getNodes()) {
                if (node1.equals(node2)) continue;

                double edgeWeight = getEdge(node1, node2);

                if (edgeWeight > 0) {
                    g.afegirAresta(node1, node2, getEdge(node1, node2));
                }
            }
        }

        return g;
    }


    /**
     * @return The number of nodes belonging to the graph.
     */
    public int numNodes() {
       return adjMatrix.size();
    }


    /**
     * Adds a node to the graph.
     *
     * @param newNode The node that we want to add to the graph.
     */
    public void addNode(T newNode) {
        if (adjMatrix.containsKey(newNode)) {
            throw new IllegalArgumentException("Duplicated node");
        }

        adjMatrix.put(newNode, new HashMap<T, Double>());
    }

    /**
     * Convenience method. Adds a node to the graph. Does nothing if the node already exists and checkDuplicated is
     * false, and raises an exception if checkDuplicated is true.
     *
     * @param newNode The node that we want to add to the graph.
     * @param checkDuplicated
     */
    public void addNode(T newNode, boolean checkDuplicated) {
        if (checkDuplicated && adjMatrix.containsKey(newNode)) {
            throw new IllegalArgumentException("Duplicated node");
        }

        if (null == adjMatrix.get(newNode)) {
            adjMatrix.put(newNode, new HashMap<T, Double>());
        }
    }

    /**
     * "Duplication-Unchecked" bulk nodes addition method.
     */
    public void addNodes(Collection<T> newNodes) {
        for (T newNode : newNodes) {
            addNode(newNode, false);
        }
    }

    /**
     * @param node The node we want to know if belongs to the graph.
     * @return A boolean value telling us if the node exists inside the graph.
     */
    public boolean hasNode(T node) {
        return adjMatrix.containsKey(node);
    }

    /**
     * Removes a node from the graph.
     * @param node The node we want to remove.
     */
    public void removeNode(T node) {
        if (!adjMatrix.containsKey(node)) {
            throw new IllegalArgumentException("Trying to remove a node that doesn't belong to the graph.");
        }

        if (adjMatrix.get(node).size() > 0) {
            throw new IllegalArgumentException(
                "Impossible to remove the node because it has at least one connected edge"
            );
        }

        adjMatrix.remove(node);
    }

    /**
     * @return A copy of the graph's nodes set.
     */
    public HashSet<T> getNodes() {
        return new HashSet<T>(adjMatrix.keySet());
    }

    /**
     * @return A set of the adjacent nodes to 'node'.
     */
    public HashSet<T> getAdjacentNodes(T node) {
        if (!adjMatrix.containsKey(node)) {
            throw new IllegalArgumentException("The specified node doesn't belong to the graph.");
        }

        return new HashSet<T>(adjMatrix.get(node).keySet());
    }

    /**
     * Adds an edge between node1 and node2.
     *
     * @param node1 source
     * @param node2 destiny
     * @param weight edge's weight. Must be in the [0, 1] interval.
     */
    public void addEdge(T node1, T node2, double weight) {
        if (!adjMatrix.containsKey(node1) || !adjMatrix.containsKey(node2)) {
            throw new IllegalArgumentException("At least one of the specified nodes doesn't belong to the graph.");
        }

        if (node1.equals(node2)) {
            throw new IllegalArgumentException("It's not allowed to create edges between one one and itself.");
        }

        if (weight < 0) {
            throw new IllegalArgumentException("weight must be in the [0, +infinite) interval.");
        }

        if (weight > 0) {
            adjMatrix.get(node1).put(node2, weight);
            adjMatrix.get(node2).put(node1, weight);
        } else {
            adjMatrix.get(node1).remove(node2);
            adjMatrix.get(node2).remove(node1);
        }
    }

    /**
     * WARNING: It's important to note that this method will return true if node1 equals node2.
     *          This works that way because this class represents affinities between nodes.
     *
     * @param node1 edge "start".
     * @param node2 edge "end".
     * @return Returns a boolean value telling us if the specified edge exists or not.
     */
    public boolean hasEdge(T node1, T node2) {
        // We don't check null values because the system will throw an exception the same way we could do. So no more
        // code is needed.

        if (adjMatrix.containsKey(node1) && node1.equals(node2)) return true;

        // We don't have to check zero values because we don't store them.
        return (adjMatrix.get(node1) != null && adjMatrix.get(node1).get(node2) != null);
    }

    /**
     * @param node1 edge "start".
     * @param node2 edge "end"
     * @return The weight of the specified edge.
     */
    public double getEdge(T node1, T node2) {
        if (!adjMatrix.containsKey(node1) || !adjMatrix.containsKey(node2)) {
            throw new IllegalArgumentException(
                "At least one of the specified nodes doesn't belong to the graph (" +
                node1.toString() + ", " + node2.toString() + ") -- " + adjMatrix.keySet()
            );
        }

        if (node1.equals(node2)) {
            // We can return this value because we know the graph is storing affinities, so even if we haven't nodes
            // connected to themselves, we know that their "auto-affinity" must be 1.0.
            return 1.0;
        }

        Double tmpResult = adjMatrix.get(node1).get(node2);
        return (tmpResult != null) ? tmpResult : 0;
    }

    /**
     * Convenience method. This is faster than calling addEdge(node1, node2, 0).
     * It doesn't check if the nodes exist or not because there isn't danger of breaking inner consistency.
     */
    public void removeEdge(T node1, T node2) {
        if (null != adjMatrix.get(node1)) {
            adjMatrix.get(node1).remove(node2);
        }
        if (null != adjMatrix.get(node2)) {
            adjMatrix.get(node2).remove(node1);
        }
    }

    /**
     * Removes all nodes and edges from the graph.
     */
    public void clear() {
        adjMatrix.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterator() {
        return adjMatrix.keySet().iterator();
    }
}
