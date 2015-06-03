package prop.g12.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import prop.g12.common.Graf;

public class NewmanGirvan<T> extends Algorisme<T>{
	private HashMap<T, LinkedList<T>> parent;
	private HashMap<T, HashMap<T,Double>> edges;
	private HashMap<T, LinkedList<T>> AtoR;
	private static int nSize;
	private static Integer threshold;
	
	/**
	 * Creadora per defecte: Crea una instancia buida de la classe NewmanGirvan
	 * Inicialitza totes les estructures de dades necesaries
	 */
	public NewmanGirvan(){
		parent = new HashMap<T, LinkedList<T>>();
		edges = new HashMap<T, HashMap<T,Double>>();
		AtoR = new HashMap<T, LinkedList<T>>();
	}
	
	/**
	 * Pre: -
	 * @param G: Instancia de la classe Graf
	 * @return Retorna la solució.
	 */
	public Solucio<T> generarSolucio(Graf<T> G) {
		long startT, finishT, Texec;
		startT = System.currentTimeMillis();
		Set<T> nodes = G.getNodes();
		nSize = nodes.size();
		Solucio<T> sol = new Solucio<T>();
		try {
			G = execNG(G);
		} catch (Exception e) {
			System.out.println("Error al executar NG");
		}
		// Generar Solucio
		finishT = System.currentTimeMillis();
		Texec = finishT - startT;
		Integer ncom = -1;
		T nodeAct, nextNode;
		HashMap<T, Boolean> visitado = new HashMap<>();
		
		
	  	Iterator<T> it = nodes.iterator();
		while (it.hasNext()) {
			nodeAct = it.next();
			LinkedList<T> lista = new LinkedList<T>();
			if (!visitado.containsKey(nodeAct)) {
				lista.add(nodeAct);
				++ncom;
				sol.afegirComunitat(ncom);
				sol.afegirNode(nodeAct, ncom);
				visitado.put(nodeAct, true);
			}
			while (!lista.isEmpty()) {
		  		nodeAct = lista.pollFirst();
		  		Map<T, Double> adj = null;
				try {
					adj = G.getAdjacencia(nodeAct);
				} catch (Exception e) {
					System.out.println("Error agafant les adjacencies");
				}
		  		Set<T> n = adj.keySet();
		  		Iterator<T> it2 = n.iterator();
		  		while (it2.hasNext()) {
		  			nextNode = it2.next();
		  			if (!visitado.containsKey(nextNode)) {
		  				lista.add(nextNode);
		  				visitado.put(nextNode,true);
					    sol.afegirNode(nextNode, ncom);
		  			}
		  		}
			}			
		}
		sol.setTempsExec(Texec);		
		return sol;
	}
	
	/**
	 * Pre: -
	 * @param graf: Instancia de la classe graf, on s'aplicara l'algorisme NewmanGirvan
	 * @param first: boolean que ens indica si ens trobem en la primera iteracio, es necesari per temes d'eficiencia
	 * @return Retorna un Graf que es calcula a partir del graf que ens passa la funcio GenerarSolucio(Graf<T> G), aquest
	 * Graf es calcula a partir de la supressio d'arestes del graf que ens passen, i aixi recursivament.
	 */
	private Graf<T> execNG(Graf<T> graf) {
		edges.clear();
		Set<T> nodes = graf.getNodes();
		Iterator<T> it = nodes.iterator();
		T nodeAct, nodeNext;
		while (it.hasNext()) {
			nodeAct = it.next();
			Iterator<T> it2 = nodes.iterator();
			while (it2.hasNext()) {
				nodeNext = it2.next();
				if (!nodeAct.equals(nodeNext)) {
					searchAlg(graf,nodeAct,nodeNext); // arestas con los caminos mas cortos
					addEdges(nodeAct,nodeNext);
				}
			}
		}
		graf = removeEdge(graf);
		if (threshold < (double)Math.sqrt(nSize)) execNG(graf);
		return graf;
	}
	

	/**
	 * Pre: _
	 * @param graf: graf on aplicar la cerca de camins
	 * @param i: node inicial des d'on comença la cerca
	 * @param j: node final on l'algorisme acaba la cerca
	 * @throws no te adjacencies 
	 */
	void searchAlg (Graf<T> graf, T i, T j) {
		LinkedList<T> lista = new LinkedList<T>();
		Set<T> nodesG = graf.getNodes();
		Iterator<T> itt;
		T nodeAct, nextNode;
		parent.clear();
	  	Map<T, Double> distancia = new HashMap<T, Double>();
	  	itt = nodesG.iterator();
	  	while (itt.hasNext()) {
	  		distancia.put(itt.next(), 0.0);
	  	}
	  	Map<T, Boolean> visitado = new HashMap<T, Boolean>();
	  	itt = nodesG.iterator();
	  	while (itt.hasNext()) {
	  		visitado.put(itt.next(), false);
	  	}
	  	lista.add(i);
	  	visitado.put(i,true);
	  	distancia.put(i, -1.0);
	  	while (!lista.isEmpty()) {
	  		nodeAct = lista.pollFirst();
	  		Map<T, Double> adj = new HashMap<T,Double>();
			try {
				adj = graf.getAdjacencia(nodeAct);
			} catch (Exception e) {
				System.out.println("Error agafant les adjacencies");
			}
	  		Set<T> nodes = adj.keySet();
	  		Iterator<T> it = nodes.iterator();
	  		while (it.hasNext()) {
	  			nextNode = it.next();
	  			if (!adj.get(nextNode).equals(-1.0)) {
	  				Double recorregut = null;
	  				if (!distancia.get(nodeAct).equals(-1.0)) {
			  			recorregut = (distancia.get(nodeAct)+adj.get(nextNode));
		  				recorregut = (double)Math.round(recorregut * 100000) / 100000;
	  				}
	  				else {
	  					recorregut = adj.get(nextNode);
	  				}
	  				if (visitado.get(nextNode)) {
			  			if (visitado.get(nextNode) && (distancia.get(nextNode).equals(recorregut))) {
			  				if (!parent.containsKey(nextNode)) {
			  					LinkedList<T> aux = new LinkedList<T>();
			  					aux.add(nodeAct);
			  					parent.put(nextNode, aux);
			  				}
			  				else {
			  					LinkedList<T> aux = parent.get(nextNode);
			  					aux.add(nodeAct);
			  					parent.put(nextNode, aux);
			  				}
			  			}
			  			else if (visitado.get(nextNode) && ((distancia.get(nextNode)>(recorregut)) || distancia.get(nextNode).equals(0.0))) {
			  				LinkedList<T> aux = new LinkedList<T>();
		  					aux.add(nodeAct);
		  					parent.put(nextNode, aux);
			  				distancia.put(nextNode, recorregut);
			  				lista.add(nextNode);
			  			}
		  			}
		  			if (!visitado.get(nextNode)) {
		  				if (!nextNode.equals(j))lista.push(nextNode);
		  				visitado.put(nextNode, true);  				
		  				distancia.put(nextNode, recorregut);
		  				LinkedList<T> aux = new LinkedList<T>();
	  					aux.add(nodeAct);
	  					parent.put(nextNode, aux);
		  			}
	  			}
	  		}
	  	};
	}
	
	
	/**
	 * Pre: -
	 * @param ini: Node on acaba la cerca d'aquest cami
	 * @param fin: Node on comença la cerca d'aquest cami
	 */
	void addEdges(T ini, T fin) {
		T nodeAct, nodeNext;
		boolean trobat = false;;
	  	LinkedList<T> lista = new LinkedList<T>();
		Map<T, Boolean> visitado = new HashMap<T, Boolean>();
	  	Iterator <T> itt = parent.keySet().iterator();
	  	while (itt.hasNext()) {
	  		visitado.put(itt.next(), false);
	  	}
	  	visitado.put(ini, false);
	  	visitado.put(fin, true);
		lista.add(fin);
		while (!lista.isEmpty() && !trobat) {
			nodeAct = lista.pollFirst();	
			LinkedList<T> adj = new LinkedList<T>(); 
			if (parent.containsKey(nodeAct)){
				adj = parent.get(nodeAct);
			}
			HashMap<T,Double> aux = new HashMap<>();
			HashMap<T,Double> auxExt = new HashMap<>();
			LinkedList<T> auxSet = new LinkedList<T>();
			while(!adj.isEmpty() && !trobat) {
				nodeNext = adj.pollFirst();
				auxSet.add(nodeNext);
				if (!visitado.get(nodeNext)) {
					visitado.put(nodeNext, true);			
					if (edges.containsKey(nodeAct)) {
						aux = edges.get(nodeAct);
						if (aux.containsKey(nodeNext)) {
							Double pes = aux.get(nodeNext);
							pes = pes + 1.0;
							pes = (double)Math.round(pes * 1000) / 1000;
							aux.put(nodeNext, pes);
							edges.put(nodeAct, aux);
							if (edges.containsKey(nodeNext)) {
								auxExt = edges.get(nodeNext);
								auxExt.put(nodeAct, pes);
								edges.put(nodeNext, auxExt);
							}
							else {
								auxExt.put(nodeAct, pes);
								edges.put(nodeNext, auxExt);
							}
							
						}
						else {
							aux.put(nodeNext, 1.0);
							edges.put(nodeAct, aux);
							if (edges.containsKey(nodeNext)) {
								auxExt = edges.get(nodeNext);
								auxExt.put(nodeAct, 1.0);
								edges.put(nodeNext, auxExt);
							}
							else {
								auxExt.put(nodeAct, 1.0);
								edges.put(nodeNext, auxExt);
							}
							
						}
					}
					else {
						aux.put(nodeNext, 1.0);
						edges.put(nodeAct, aux);
						if (edges.containsKey(nodeNext)) {
							auxExt = edges.get(nodeNext);
							auxExt.put(nodeAct, 1.0);
							edges.put(nodeNext, auxExt);
						}
						else {
							auxExt.put(nodeAct, 1.0);
							edges.put(nodeNext, auxExt);
						}
					}
					if (!nodeNext.equals(ini)) {
						lista.add(nodeNext);
					}
					else trobat = true;
				}
			}
			parent.put(nodeAct, auxSet);
		}
	}
	
	/**
	 * Pre: -
	 * @param graf: Graf on s'ha d'aplicar la supressio d'arestes
	 * @return Retorna el graf que li arriva amb la/es aresta/es eliminades
	 */
	Graf<T> removeEdge(Graf<T> graf) {
		Double max = 0.0;
		T nodeAct, nodeNext;
		Set<T> nodos, nodos2;
		AtoR.clear(); 
		nodos = edges.keySet();
		Iterator<T> it = nodos.iterator();
		while (it.hasNext()) {
			HashMap<T,Double> aresta = new HashMap<>();
			nodeAct = it.next();
			aresta = edges.get(nodeAct);
			nodos2 = aresta.keySet();
			Iterator<T> it2 = nodos2.iterator();
				while (it2.hasNext()) {
					nodeNext = it2.next();
					LinkedList<T> listaAux = new LinkedList<T>();
					if (aresta.get(nodeNext) > max) {
						AtoR.clear();
						listaAux.add(nodeNext);
						AtoR.put(nodeAct, listaAux);
						max = aresta.get(nodeNext);
					}
					else if (aresta.get(nodeNext).equals(max)) {
						if (AtoR.containsKey(nodeAct)) {
							listaAux = AtoR.get(nodeAct);
							listaAux.add(nodeNext);
							AtoR.put(nodeAct, listaAux);
						}
						else {
							listaAux.add(nodeNext);
							AtoR.put(nodeAct, listaAux);
							max = aresta.get(nodeNext);
						}
					}
				}
		}		
		nodos = AtoR.keySet();
		it = nodos.iterator();
		while (it.hasNext()) {
			nodeAct = it.next();
			LinkedList<T> removed = new LinkedList<T>();
			LinkedList<T> aux = new LinkedList<T>(); 
			aux = AtoR.get(nodeAct);
			while(!aux.isEmpty()) {
				nodeNext = aux.pollFirst();
				removed.add(nodeNext);
				try {
					graf.eliminarAresta(nodeAct, nodeNext);
					edges.get(nodeAct).remove(nodeNext);
					edges.get(nodeNext).remove(nodeAct);
				} catch (Exception e) {	}
			}
			AtoR.put(nodeAct, removed);
		}
		threshold = getTH(graf);
		return graf;
	}
	
	/**
	 * Pre: -
	 * @param graf: Graf on es calcula el treshold
	 * @return Retorna el numero de componentes connexes que te el graf d'entrada
	 */
	Integer getTH(Graf<T> graf) {
		Integer ncom = 0;
		T nodeAct, nextNode;
		Set<T> nodes = graf.getNodes();
		Iterator<T> it = nodes.iterator();
		HashMap<T, Boolean> visitado = new HashMap<>();
	  	while (it.hasNext()) {
	  		visitado.put(it.next(), false);
	  	}
	  	it = nodes.iterator();
		while (it.hasNext()) {
			LinkedList<T> lista = new LinkedList<T>();
			nodeAct = it.next();
			if (!visitado.get(nodeAct)) {
				lista.add(nodeAct);
				++ncom;
			}
			while (!lista.isEmpty()) {
		  		nodeAct = lista.pollFirst();
		  		visitado.put(nodeAct, true);
		  		Map<T, Double> adj = null;
				try {
					adj = graf.getAdjacencia(nodeAct);
				} catch (Exception e) {
				}
		  		Set<T> nodesNext = adj.keySet();
		  		Iterator<T> it2 = nodesNext.iterator();
		  		while (it2.hasNext()) {
		  			nextNode = it2.next();
		  			if (!visitado.get(nextNode)) {
		  				lista.add(nextNode);
		  				visitado.put(nextNode, true);
		  			}
		  		}
			}	
		}
		return ncom;
	}
}