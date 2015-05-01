package prop.g12.common;

import java.util.Arrays;
import java.util.LinkedList;


public class NewmannGirvan {
	
	Integer[][] grafSol;
	static Integer[][] edges;
	static Integer[][] caminos;
	static Integer[][] path;
	static Integer col;
	static int nSize;
	static int threshold;
	int maximActual;
	boolean first;
	
	/**
	 * Creadora per defecte: Crea una instancia buida de la classe NewmanGirvan
	 */
	public NewmannGirvan() {}
	
	/**
	 * Pre: La funci� que aplica l'algorisme NewmanGirvain sobre un graf
	 * @param graf: Matriu d'adjacencies inicial
	 * @return Retorna una matriu d'Integers amb l'algorisme NewmanGirvain aplicat
	 */
	public Integer[][] NewmanGirvainSOL(Integer[][] graf) {
		first = true;
		nSize = graf[0].length;
		edges = new Integer[nSize][nSize];
		Arrays.fill(edges,0);
		grafSol = graf;
		for (Integer i = 0; i < nSize; ++i) {
			path = null;
			for (Integer j = i; j < nSize; ++j) {
				if (!(i.equals(j))) {
					path = SearchAlg(grafSol,i,j); // arestas con los caminos mas cortos
					edges = addEdges(path,i,j);
				}
			}
		}
		grafSol = removeEdge(edges); //Eliminada/es aresta/es m�s grans
		if (maximActual > threshold) NewmanGirvainSOL(grafSol); //Necesitem mes supresions
		return grafSol; // Acabat!
	}
	
	/**
	 * Pre: 0 <= i,j <= nSize
	 * @param mat: matriu d'adjacencies
	 * @param i: node inicial des d'on l'algorisme comen�a
	 * @param j: node final on l'algorisme acaba
	 * @return Retorna una matriu amb les arestes dels camins curts entre els nodes i-j
	 */
	static Integer[][] SearchAlg (Integer[][]mat, Integer i, Integer j) {
		LinkedList<Integer> lista = new LinkedList<Integer>();
		Integer nodeAct, nextNode;
		caminos = null;
		Integer[][] padre = new Integer[nSize][];
		
		/* Vector de distancias */
	  	Integer[] distancia = new Integer[nSize];
	  	Arrays.fill(distancia, -1);
		
		/* Vector de vistats */
	  	Boolean[] visitado = new Boolean[nSize];
	  	Arrays.fill(visitado, Boolean.FALSE);
	  	
	  	/* preparamos el nodo inicial */
	  	lista.add(i);
	  	visitado[i]=true;
	  	distancia[i]=0;
	  	/* */
	  	while (!lista.isEmpty()) {
	  		nodeAct = lista.pollFirst();
	  		//if (nodeAct.equals(j));
	  		Integer[]adj = adjMat(mat,nodeAct);
	  		int nAdj = adj.length; // puede no haber adyacencias
	  		for (int k = 0; k < nAdj; ++k) {
	  			nextNode = adj[k];
	  			if (visitado[nextNode] && (distancia[nextNode].equals(distancia[nodeAct]+mat[nodeAct][nextNode]))) {
	  				int s = padre[nextNode].length;
	  				padre[nextNode][s]=nodeAct;
	  			}
	  			else if (visitado[nextNode] && (distancia[nextNode]>(distancia[nodeAct]+mat[nodeAct][nextNode]))) {
	  				int s = padre[nextNode].length;
	  				for (int aux = 0; aux < s; ++aux) {
	  					padre[nextNode][aux]=null;
	  				}
	  				padre[nextNode][0]=nodeAct;
	  				distancia[nextNode]=distancia[nodeAct]+mat[nodeAct][nextNode];
	  			}
	  			if (!visitado[nextNode]) {
	  				lista.add(nextNode);
	  				visitado[nextNode] = true;
	  				distancia[nextNode] = distancia[nodeAct]+mat[nodeAct][nextNode];
	  				/* esto no se si funciona */
	  				int s = padre[nextNode].length;
	  				padre[nextNode][s]=nodeAct;
	  			}
	  		}
	  	}
	  	return padre;
	}
	
	/**
	 * Pre: Pre: 0 <= n <= nSize
	 * @param m: matriu d'adjacencies
	 * @param n: node on trobar les adjacencies
	 * @return Retorna un vector d'identificadors dels nodes adjacents a n
	 */
	private static Integer[] adjMat(Integer[][] m, Integer n) {
		Integer[] ret = null;
		int i = 0;
		for (int j = 0; j < nSize; ++j) {
			if (m[n][j] >= 0) {
				ret[i]=j;
				++i;
			}
		}
		return ret;		
	}
	
	/**
	 * Pre: 0 <= i,j <= nSize
	 * @param p: Matriu d'adjacencies
	 * @param ini: Identificar del node on acaba la cerca
	 * @param fin: Identificador del node on comen�a la cerca
	 * @return Retorna una matriu amb la betweeness de cada aresta
	 */
	static Integer[][] addEdges(Integer[][]p, Integer ini, Integer fin) {
		int s = 0;
		Boolean[] v = new Boolean[nSize];
	  	Arrays.fill(v, Boolean.FALSE);
	  	//Miramos cuantos caminos cortos existen
		for (int ii = 0; ii < nSize; ++ii) {
			if (p[ii].length > s) s = p[ii].length;
		}
		LinkedList<Integer> lista = new LinkedList<Integer>();
		lista.add(fin);
		Integer nodeAct = fin;
		v[nodeAct]=true;
		if (s!=0) { // Si s == 0, significa que no hay caminos entre i y j
			while (!nodeAct.equals(ini)) {
				nodeAct = lista.pollFirst();
				int size = p[nodeAct].length;
				for (int i = 0; i < size; ++i) {
					edges[nodeAct][p[nodeAct][i]] = edges[nodeAct][p[nodeAct][i]]+(1/s);
					if (!v[p[nodeAct][i]]) {
						lista.add(p[nodeAct][i]);
						v[p[nodeAct][i]]=true;
					}
				}
			}
		}
		return edges;
	}
	
	/**
	 * Pre: -
	 * @param ed: Matriu d'Integers on estan tots els valors dels betweeness de les arestes
	 * @return Retorna una matriu amb la eliminacio de l'aresta amb m�s betweeness
	 */
	Integer[][] removeEdge(Integer[][] ed) {
		Integer max = 0;
		Integer[] vecF = null;
		Integer[] vecC = null;
		Integer k = 0;
		for (int i = 0; i < nSize; ++i) {
			for (int j = 0; j < i; ++j) {
				if (ed[i][j]>max) {
					vecF = null; vecC = null;
					vecF[0]=i; vecC[0]=j;
					k=1;
				}
				else if (ed[i][j].equals(max)) {
					vecF[k]=i; vecC[k]=j;
					++k;
				}
			}
		}
		if (first) {
			threshold = getTH(ed);
			first = false;
		}
		maximActual = max;
		int n = vecF.length;
		for (int i = 0; i < n; ++i) {
			grafSol[vecF[i]][vecC[i]] = -1;
		}
		return grafSol;
	}
	
	/**
	 * Pre: -
	 * @param ed: Matriu d'Integers on estan tots els valors dels betweeness de les arestes
	 * @return Retorna la mitja aritmetica del sumatori betweeness de totes les arestes
	 */
	int getTH(Integer[][] ed) {
		int suma = 0;
		for (int i = 0; i < nSize; ++i) {
			for (int j = 0; j < nSize; ++j) {
				suma = ed[i][j];
			}
		}
		return suma/nSize;
	}
	
}

