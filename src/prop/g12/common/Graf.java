package prop.g12.common;

import java.util.ArrayList;

public class Graf<T> {
	Integer[][] adjacencia;
	Integer numNodes;
	ArrayList<T> nodes;
	int c;
	
	public void crearGraf(int n) {
		numNodes = n;
		adjacencia = new Integer[numNodes][numNodes];
		nodes = new ArrayList<T>(numNodes);
		c = 0;
	}
	
	public void afegirNode(T node) {
		nodes.add(c, node);
		++c;
	}
	
	public void afegirAresta(Integer idNode1, Integer  idNode2, Integer pes) {
		if (pes >= 0) {
			adjacencia[idNode1][idNode2] = pes;
			adjacencia[idNode2][idNode1] = pes;
		}
	}
	
	public int getNumNodes() {
		return numNodes; 
	}
	
	public T getNode(Integer idNode) {
		return nodes.get(idNode);
	}
	
	public ArrayList<T> getNodes() {
		return nodes;
	}
	
	public Integer getAresta(int idNode1, int idNode2) {
		return adjacencia[idNode1][idNode2];
	}

}