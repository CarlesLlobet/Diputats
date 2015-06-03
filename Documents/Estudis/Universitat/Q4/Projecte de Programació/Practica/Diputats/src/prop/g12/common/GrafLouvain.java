package prop.g12.common;

import java.util.ArrayList;

public class GrafLouvain<T> {
	private Double[][] adjacencia;
	private Integer numNodes;
	private ArrayList<T> nodes;


	public GrafLouvain(int n) {
		if (n > 0) {
			numNodes = n;
			adjacencia = new Double[numNodes][numNodes];
			nodes = new ArrayList<T>(numNodes);
		} else
			throw new IllegalArgumentException("N ha de ser un valor positiu "
					+ "que indiqui el nombre de nodes\n");
	}

	public GrafLouvain(Graf<T> g) {
		int n = g.getNumNodes();
		nodes = new ArrayList<T>(g.getNodes());

		adjacencia = new Double[n][n];
		numNodes = g.getNumNodes();

		for (int i = 0; i < n; ++i) {
			T nodo = nodes.get(i);
			for (int j = 0; j < n; ++j) {
				T nodo2 = nodes.get(j);
				try{
				afegirAresta(i, j, g.getAresta(nodo, nodo2));
				}
				catch(Exception e) {}
				
			}
		}

	}


	public void afegirNode(T node) {
		if (!nodes.contains(node))
			nodes.add(node);
		else
			throw new IllegalArgumentException("El node ja existeix" + "\n");

	}


	public void afegirAresta(Integer idNode1, Integer idNode2, Double pes) {
		if (idNode1 < nodes.size() && idNode1 >= 0 && idNode2 < nodes.size()
				&& idNode2 >= 0) {
			adjacencia[idNode1][idNode2] = pes;
			adjacencia[idNode2][idNode1] = pes;
		} else
			throw new IllegalArgumentException(
					"Els idNode han d'existir i tenir valor entre 0 i els nodes de graf"
							+ "\n");
	}


	public int getNumNodes() {
		return numNodes;
	}

	public T getNode(Integer idNode) {
		if (idNode < nodes.size() && idNode >= 0) {
			return nodes.get(idNode);
		} else
			throw new IllegalArgumentException(
					"idNode ha d'existir i tenir valor entre 0 i els nodes de graf"
							+ "\n");

	}


	public ArrayList<T> getNodes() {
		return nodes;
	}


	public Double getAresta(int idNode1, int idNode2) {
		if (idNode1 < nodes.size() && idNode1 >= 0 && idNode2 < nodes.size()
				&& idNode2 >= 0) {
			return adjacencia[idNode1][idNode2];
		} else
			throw new IllegalArgumentException(
					"Els idNode han d'existir i tenir valor entre 0 i els nodes de graf"
							+ "\n");
	}


	public Double[][] getAdjacencia() {
		return adjacencia;
	}


	public Boolean nodeExisteix(T node) {
		if (nodes.contains(node))
			return true;
		else
			return false;
	}
}