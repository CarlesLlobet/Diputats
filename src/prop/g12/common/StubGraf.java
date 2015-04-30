package prop.g12.common;

import java.util.ArrayList;

public class StubGraf<T> {
	
	Integer[][] adjacencia;
	Integer numNodes;
	ArrayList<T> nodes;
	int c;

	public StubGraf() {
		numNodes = 3;
		adjacencia = new Integer[3][3];
		adjacencia = {1 , -1, 0, 0, 1, -1, 0, 1, -1};
		nodes = new ArrayList<T> (9);
		c = 9;
	}
	
	public int GetNumNodes() {
		return numNodes; 
	}
	
	public T GetNode(Integer idNode) {
		return nodes.get(idNode);
	}
	
	public ArrayList<T> GetNodes() {
		return nodes;
	}
	
	public Integer GetAresta(int idNode1, int idNode2) {
		return adjacencia[idNode1][idNode2];
	}

}
