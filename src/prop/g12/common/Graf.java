package prop.g12.common;

import java.util.ArrayList;
import java.util.Arrays;

public class Graf<T> {
	Double[][] adjacencia;
	Integer numNodes;
	ArrayList<T> nodes;
	int c;
	
	/* void crearGraf(int n):
	 * 
	 * Mètode usat per crear grafs, passant com a paràmetre un enter per
	 * representar el graf com una matriu d’adjacències de nxn
	 * 
	 * Pre:
	 * 
	 * n > 0
	 * 
	 * Post:
	 * 
	 * numNodes = n
	 * ajacencia es una matriu nxn inicialitzada a 0
	 * nodes es una array list de tamany n
	 * c (identificador de node T) val 0.
	*/
	public void crearGraf(int n) throws Exception {
		if (n>0){
			numNodes = n;
			adjacencia = new Double[numNodes][numNodes];
			Arrays.fill(adjacencia,0);
			nodes = new ArrayList<T>(numNodes);
			c = 0;
		}
		else throw new Exception("N ha de ser un valor positiu que indiqui el nombre de nodes" +"\n");
	}
	
	/* void afegirNode(T node):
	 * 
	 * Mètode usat per afegir un node “node” ja existent a un graf ja
	 * existent. És un mètode void, no retorna res.
	 * 
	 * Pre:
	 * 
	 * Post:
	 * 
	 * s'afegeix a nodes el node atribut, amb identificador c.
	 * c incrementa en 1
	*/
	
	public void afegirNode(T node) {
		nodes.add(c, node);
		++c;
	}
	
	/* void afegirAresta(Integer idNode1, Integer  idNode2, Double pes):
	 * 
	 *Mètode usat per afegir una aresta de
	 *pes “pes” entre els nodes “node1” i “node2” del graf. 
	 *És un mètode void, no retorna res.
	 * 
	 * Pre:
	 * 
	 * Post:
	 * 
	 * adjacencia entre els dos nodes a la matriu val "pes"
	*/
	
	public void afegirAresta(Integer idNode1, Integer  idNode2, Double pes) {
			adjacencia[idNode1][idNode2] = pes;
			adjacencia[idNode2][idNode1] = pes;
	}
	
	/* void int getNumNodes():
	 * 
	 *Mètode que retorna el nombre de nodes que conté el graf.
	 * 
	 * Pre:
	 * 
	 * Post:
	 * 
	 * retorna el nombre de nodes del graf
	*/
	
	public int getNumNodes() {
		return numNodes; 
	}
	
	/* void T getNode(Integer idNode):
	 * 
	 *Mètode que retorna el node tipus T identificat per “idNode” 
	 *en cas que aquest existeixi.
	 * 
	 * Pre:
	 * 
	 * idNode existeix al graf
	 * 
	 * Post:
	 * 
	 * retorna el node amb id=idNode
	*/
	
	public T getNode(Integer idNode) throws Exception {
		if (idNode < c && idNode >= 0){
			return nodes.get(idNode);
		}
		else throw new Exception("idNode ha d'existir i tenir valor entre 0 i els nodes de graf" +"\n");
		
	}
	
	/* void ArrayList<T> getNodes():
	 * 
	 *Mètode per retornar el llistats de tots els nodes que hi ha en el graf.
	 *Retornarà un vector de Nodes, de mida N, on N es el numero de nodes 
	 *especificat previament.
	 * 
	 * Pre:
	 * 
	 * Post:
	 * 
	 * retorna un Array de tipus T amb tots els nodes del graf
	*/
	
	public ArrayList<T> getNodes() {
		return nodes;
	}
	
	/* Double getAresta(int idNode1, int idNode2):
	 * 
	 *Mètode que retorna l’aresta entre els nodes identificats 
	 *per “idNode1” i ”idNode2” respectivament, en cas que aquesta existeixi. 
	 *Retornarà un enter que equival al pes entre aquests dos nodes.
	 * 
	 * Pre:
	 * 
	 * idNode1 i idNode2 existeixen
	 * 
	 * Post:
	 * 
	 * retorna el pes entre els dos nodes
	*/
	
	public Double getAresta(int idNode1, int idNode2) throws Exception {
		if (idNode1 < c && idNode1 >= 0 && idNode2 < c && idNode2 >= 0){
			return adjacencia[idNode1][idNode2];
		}
		else throw new Exception("Els idNode han d'existir i tenir valor entre 0 i els nodes de graf" +"\n");
	}

}