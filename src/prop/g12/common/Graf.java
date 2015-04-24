package prop.g12.common;

public class Graf {
	Integer[][] adjacencia;
	Integer numNodes;
	Object[] nodes;
	int c;
	
	public void crearGraf(int n) {
		numNodes = n;
		adjacencia = new Integer[numNodes][numNodes];
		nodes = new Object[numNodes];
		c = 0;
	}
	
	public void afegirNode(Object node) {
		nodes[c] = node;
		++c;
	}
	
	public void afegirAresta(Integer idNode1, Integer  idNode2, Integer pes) {
		adjacencia[idNode1][idNode2] = pes;
		adjacencia[idNode2][idNode1] = pes;
	}
	
	public int getNumNodes() {
		return numNodes; 
	}
	
	public Object getNode(Integer idNode) {
		return nodes[idNode];
	}
	
	public Object[] getNodes() {
		return nodes;
	}
	
	public Integer getAresta(int idNode1, int idNode2) {
		return adjacencia[idNode1][idNode2];
	}

}