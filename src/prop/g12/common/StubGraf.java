package prop.g12.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class StubGraf<T> {
	
	Integer[][] adjacencia;
	Integer numNodes;
	ArrayList<T> nodes;
	int c;

	public StubGraf() {
		Random r = new Random();
		numNodes = 3;
		adjacencia = new Integer[3][3];
		for (int i = 0; i < numNodes; ++i) {
			for (int j = 0; j < numNodes; ++j) {
				adjacencia[i][j] = (int) (Math.random()*2);
			}
		}
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
