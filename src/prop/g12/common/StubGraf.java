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
		adjacencia[0][0] = -1;
		adjacencia[0][1] = 0;
		adjacencia[0][2] = -1;
		adjacencia[0][3] = 2;
		adjacencia[0][4] = -1;
		
		adjacencia[1][0] = 0;
		adjacencia[1][1] = -1;
		adjacencia[1][2] = 1;
		adjacencia[1][3] = 1;
		adjacencia[1][4] = -1;
		
		adjacencia[2][0] = -1;
		adjacencia[2][1] = 1;
		adjacencia[2][2] = -1;
		adjacencia[2][3] = -1;
		adjacencia[2][4] = 1;
		
		adjacencia[3][0] = 2;
		adjacencia[3][1] = 1;
		adjacencia[3][2] = -1;
		adjacencia[3][3] = -1;
		adjacencia[3][4] = 1;
		
		adjacencia[4][0] = -1;
		adjacencia[4][1] = -1;
		adjacencia[4][2] = 1;
		adjacencia[4][3] = 1;
		adjacencia[4][4] = -1;
		
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