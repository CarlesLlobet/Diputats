package prop.g12.common;

import java.util.*;

import prop.g12.common.GrafLouvain;

/**
 * Clase que ejecuta el algoritmo de Louvain sobre un grafo, devolviendo una solucion
 * @author Cristhian Rivera
 * 
 * @param <T> Parametrizacion, corresponde con la parametrizacion del grafo.
 */
public class Louvain<T> {
	/**
	 * Suma de todos los pesos de las aristas del grafo
	 */
	private double m;

	/**
	 * Clase privada, representa una comunidad
	 * @author Cristhian Rivera
	 * 
	 */
	private class Community {

		/**
		 * Grafo al que pertenece la comunidad
		 */
		@SuppressWarnings("rawtypes")
		private GrafLouvain g;
		
		/**
		 * Identificadores de los nodos que forman parte de la comunidad
		 */
		private ArrayList<Integer> nodes;
		
		/**
		 * Cada posicion contiene un id del nodo como key, y la suma de todas las aristas adjacentes a este como value
		 */
		private Map<Integer, Double> ki;
		
		/**
		 * Cada posicion contiene un id del nodo como key, y el la ganancia de modularidad en el ultimo cambio de comunidad como value
		 */
		private Map<Integer, Double> nodesMod;
		
		/**
		 * Suma de los pesos de las aristas internas de la comunidad
		 */
		private double inSum;

		/**
		 * Constructor de la comunidad
		 * @param g Grafo del que la comunidad forma parte
		 */
		public Community(@SuppressWarnings("rawtypes") GrafLouvain g) {
			this.nodes = new ArrayList<Integer>();
			this.ki = new HashMap<Integer, Double>();
			this.nodesMod = new HashMap<Integer, Double>();
			this.g = g;
			inSum = 0.0;
		}

		/**
		 * Permite calcular la suma de los pesos de las aristas entre el nodo "node" y los nodos de esta comunidad
		 * @param node Nodo del que se quiere calcular la suma de los pesos de las aristas
		 * @return la suma de los pesos de las aristas entre "node" y los nodos de esta comunidad
		 */
		private double calculate_kiIn(int node) {
			double sum = 0.0;
			for (Integer i : this.nodes) {
				Double res = 0.0;
				try {
					res = g.getAresta(i, node);
				} catch (Exception e) {
				}
				if (res != null)
					sum += res;
			}
			return sum;
		}

		/**
		 * Permite calcular la ganancia o perdida de la suma de los pesos de las aristas internas de la comunidad, al anadir o eliminar un nodo
		 * @param node Nodo a anadir o eliminar de la comunidad
		 * @param add true: Si se desea anadir el nodo, false: Si se desea eliminar el nodo
		 */
		private void calculate_in(int node, boolean add) {
			double sum = 0.0;
			try {
				sum = g.getAresta(node, node);
			} catch (Exception e) {}
			for (Integer i : this.nodes) {
				Double res = 0.0;
				try {
					res = g.getAresta(i, node);
				} catch (Exception e) {}
				if (res != null)
					sum += res;
			}
			if (add)
				this.inSum += sum;
			else
				this.inSum -= sum;
		}

		/**
		 * Permite calcular la ganancia de modularidad, que se produciria entre un nodo y la comunidad, en caso de que el nodo se moviera a esta comunidad
		 * @param node Nodo que se quiere comprobar
		 * @param ki Suma de todas las aristas adjacentes a "node"
		 * @return La ganancia que se produciria
		 */
		private double modularity_gain(int node, double ki) {
			double kiIn = calculate_kiIn(node);
			@SuppressWarnings("unused")
			double inSum = this.getIn();
			double totSum = this.getTot();
			double m2 = 2 * m;
			double x = kiIn/m2;
			double y = (2*totSum*ki)/(m2*m2);

			return x - y;
		}

		/**
		 * Permite obtener la suma de los pesos de las aristas internas de la comunidad
		 * @return La suma de los pesos de las aristas internas de la comunidad
		 */
		private double getIn() {
			return this.inSum;
		}
		
		/**
		 * Permite obtener la suma de todas las aristas adjacentes a "node"
		 * @param node Nodo del cual se quiere obtener la suma de todas las aristas adjacentes
		 * @return La suma de todas las aristas adjacentes a node
		 */
		private double getKi(int node) {
			return this.ki.get(node);
		}

		/**
		 * Permite obtener la suma de los pesos de todas las aristas incidentes a nodos de la comunidad
		 * @return La suma de los pesos de todas las aristas incidentes a nodos de la comunidad
		 */
		private double getTot() {
			double sum = 0.0;
			for (Double i : this.ki.values())
				sum += i;
			return sum;
		}

		/**
		 * Permite verificar si una comunidad esta vacia
		 * @return true: Si la comunidad esta vacia, false: Si no esta vacia
		 */
		private boolean isEmpty() {
			if (nodes.size() == 0)
				return true;
			return false;
		}

		/**
		 * Permite anadir un nodo a esta comunidad
		 * @param node Nodo que se quiere anadir a la comunidad
		 * @param ki Suma de todas las aristas adjacentes a "node"
		 * @param actualMod Modularidad que proporciona este cambio
		 */
		private void addNode(int node, double ki, double actualMod) {
			this.nodes.add(node);
			this.ki.put(node, ki);
			this.nodesMod.put(node, actualMod);
			this.calculate_in(node, true);
		}

		/**
		 * Permite eliminar la informacion relativa a un nodo de esta comunidad
		 * @param node Nodo del que se quiere eliminar la informacion
		 */
		private void removeInfoNode(int node) {
			this.ki.remove(node);
			this.nodesMod.remove(node);
			this.calculate_in(node, false);
		}
		
		/**
		 * Permite obtener la modularidad que proporciono el mover el nodo "node" a esta comunidad
		 * @param node Nodo del que se quiere obtener la modularidad
		 * @return La modularidad proporcionada por este nodo en la comunidad
		 */
		private double getModNode(int node) {
			return this.nodesMod.get(node);
		}

		/**
		 * Permite obtener los nodos que pertenecen a esta comunidad
		 * @return Los nodos que pertenecen a esta comunidad
		 */
		private ArrayList<Integer> getNodes() {
			return this.nodes;
		}		 

	}

	/**
	 * Permite ejecutar el algoritmo sobre el grafo al que pertenecen las comunidades. El algoritmo
	 * calcula las mejoras de modularidad que se producirian cambiando a los nodos de comunidades con el 
	 * objetivo de conseguir las comunidades con la mayor modularidad posible 
	 * @param com Array con todas las comunidades que contiene el grafo
	 * @return true: Si se ha producido una mejora en la modularidad de alguna comunidad, false: Si no se a producido mejora
	 */
	private boolean executeAlgorithm(ArrayList<Community> com) {

		boolean existGainAtLevel = false;
		boolean existGain = true;
		while (existGain) {
			existGain = false;
			Iterator<Community> it = com.iterator();
			while (it.hasNext()) {
				Community c = it.next();
				int i = com.indexOf(c);
				ArrayList<Integer> tmpNodes = c.getNodes();
				Iterator<Integer> itNodes = tmpNodes.iterator();
				while (itNodes.hasNext()) {
					int n = itNodes.next();
					double maxMod = 0.0;
					int comunActual = i;
					int comunNew = comunActual;

					for (int k = 0; k < com.size(); k++) {
						if (comunActual != k) {
							double tmpMod = com.get(k).modularity_gain(n,
									c.getKi(n));
							if (tmpMod > maxMod) {
								if (tmpMod > c.getModNode(n)) {
									maxMod = tmpMod;
									comunNew = k;
								}
							}
						}
					}

					if (maxMod > 0.0) {
						existGain = true;
						existGainAtLevel = true;
						com.get(comunNew).addNode(n,
								com.get(comunActual).getKi(n), maxMod);
						itNodes.remove();
						c.removeInfoNode(n);
					}
				}
				
				if (c.isEmpty())
					it.remove();
			}
		}

		return existGainAtLevel;
	}

	/**
	 * Permite realizar un nuevo grafo a partir de las comunidades mejoradas del grafo "g", en este nuevo grafo, los nodos 
	 * pasan a ser las comunidades del grafo actual. Es decir, el nuevo grafo tendra un nodo por cada comunidad que hubiera 
	 * en el anterior. Una vez listo el grafo se vuelve a buscar posibles mejoras para este
	 * @param g Grafo del que se quiere optimizar las comunidades
	 * @param com Array de comunidades
	 * @param n2c Indica para cada nodo, a que comunidad pertenece
	 */
	private void nextLevel(@SuppressWarnings("rawtypes") GrafLouvain g, ArrayList<Community> com, Integer[] n2c) {

		m = 0.0;
		for (int i = 0; i < g.getNumNodes(); i++) {
			com.add(new Community(g));
			double sum = 0.0;
			for (int j = 0; j < g.getNumNodes(); j++) {
				Double tmpSum = 0.0;
				try {
					tmpSum = g.getAresta(i, j);
				} catch (Exception e) {
				}
				if (tmpSum != null) {
					sum += tmpSum;
					if (j > i)
						m += tmpSum;
				}
			}
			com.get(i).addNode(i, sum, 0.0);
		}

		if (executeAlgorithm(com)) {
			ArrayList<Community> tmpCom = new ArrayList<Community>();
			GrafLouvain<Community> tmpG = null;
			try {
				tmpG = new GrafLouvain<Community>(com.size());
			} catch (Exception e1) {
			}
			Integer[] tmpNodes = new Integer[com.size()];

			for (int i = 0; i < com.size(); i++) {
				try {
					tmpG.afegirNode(com.get(i));
				} catch (Exception e2) {}
				try {
					tmpG.afegirAresta(i, i, com.get(i).getIn());
				} catch (Exception e1) {}

				for (int j = 0; j < i; j++) {
					double between = 0.0;

					ArrayList<Integer> ci = com.get(i).getNodes();
					ArrayList<Integer> cj = com.get(j).getNodes();
					for (Integer ni : ci) {
						for (Integer nj : cj) {
							Double tmpSum = 0.0;
							try {
								tmpSum = g.getAresta(ni, nj);
							} catch (Exception e) {
							}
							if (tmpSum != null)
								between += tmpSum;
						}
					}

					try {
						tmpG.afegirAresta(i, j, between);
					} catch (Exception e) {}
				}
			}

			nextLevel(tmpG, tmpCom, tmpNodes);

			for (int i = 0; i < tmpNodes.length; i++) {
				ArrayList<Integer> nodes = com.get(i).getNodes();
				for (Integer node : nodes) {
					n2c[node] = tmpNodes[i];
				}
			}
		} else {
			for (int i = 0; i < com.size(); i++) {
				n2c[i] = i; 
			}
		}
	}

	/**
	 * Permite obtener una solucion formada por comunidades, a partir del grafo G
	 * @param G Grafo(T) del que se quieren obtener las comunidades
	 * @return La solucion con las comunidades obtenidas del grafo G
	 */
	public Solucio<T> generarSolucio(Graf<T> G) {

		Solucio<T> sol = new Solucio<T>();
		GrafLouvain<T> Grafo = new GrafLouvain<T>(G);
		
		long timeStart, timeFinish, totalTime;
		timeStart = System.currentTimeMillis();

		ArrayList<Community> com = new ArrayList<Community>();
		Integer[] n2c = new Integer[Grafo.getNumNodes()];
		this.nextLevel(Grafo, com, n2c);
		
		timeFinish = System.currentTimeMillis();
		totalTime = timeFinish - timeStart;

		for (int i = 0; i < n2c.length; i++) {
			sol.afegirComunitat(n2c[i]);
			T nod = null;
			try {
				nod = Grafo.getNode(i);
			} catch (Exception e) {
			}
			if (nod != null)
				sol.afegirNode(nod, n2c[i]);
		}
		sol.setTempsExec((double) totalTime);

		return sol;
	}
}
