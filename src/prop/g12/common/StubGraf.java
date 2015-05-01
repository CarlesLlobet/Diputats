package prop.g12.common;

import java.util.ArrayList;
import java.util.Arrays;


public class StubGraf<T> {
	
	Integer[][] adjacencia;
	Integer numNodes;
	ArrayList<T> nodes;
	int c;

	public StubGraf() {
		numNodes = 5;
		adjacencia = new Integer[5][5];
		Integer[] pesos = new Integer[] {0,2,1,1,-1};
		for (int i = 0; i < numNodes; ++i) {
			for (int j = i; j < numNodes; ++j) {
				if (i == j) adjacencia[i][j] = -1;
				else adjacencia[i][j] = pesos[j];
			}
		}
		nodes = new ArrayList<T> (5);
		c = 5;
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
	
	public Integer[][] GetGraf() {
		return adjacencia;
	}

}
