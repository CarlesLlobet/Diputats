package prop.g12.common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Graf<T> {
	private Map<T, HashMap<T, Double>> adjacencia;

	/**
	 * Pre: - Post: ajacencia es un diccionari de node,diccionari(de Nodes i
	 * doubles) no inicialitzat
	 */
	public Graf() {
		adjacencia = new HashMap<T, HashMap<T, Double>>();
	}

	/**
	 * Pre: n > 0
	 * 
	 * @param n
	 *            : Numero de nodes que conte el graf Post: ajacencia es un
	 *            diccionari de n keys no inicialitzades
	 * @throws Exception
	 */
	public Graf(int n) throws Exception {
		if (n > 0) {
			adjacencia = new HashMap<T, HashMap<T, Double>>(n);
		} else
			throw new IllegalArgumentException("N ha de ser un valor positiu que indiqui el nombre de nodes"+ "\n");
	}

	/**
	 * Pre: -
	 * 
	 * @param N1
	 *            : Node 1 Post: es crea la key N1 amb una adjacencia a si
	 *            mateixa amb pes = 0.0
	 * @throws Exception
	 */

	public void afegirNode(T N1) throws Exception {
		if (!nodeExisteix(N1)) {
			HashMap<T, Double> aux = new HashMap<>();
			aux.put(N1, 1.0);
			adjacencia.put(N1, aux);
		} else
			throw new IllegalArgumentException("El node ja existeix"+ "\n");
	}

	/**
	 * Pre: Els nodes han d'existir
	 * 
	 * @param N1
	 *            : Node 1
	 * @param N2
	 *            : Node 2
	 * @param pes
	 *            : valor de l'aresta creada entre els dos nodes Post: el valor
	 *            a adjacencia de la key N1,N2 val "pes" Si la key no existeix,
	 *            la crea (afegeix la combinacio de nodes)
	 */

	public void afegirAresta(T N1, T N2, Double pes) throws Exception {
		if (nodeExisteix(N1) && nodeExisteix(N2)) {
			adjacencia.get(N1).put(N2, pes);
			adjacencia.get(N2).put(N1, pes);
		} else if (nodeExisteix(N1)) {
			adjacencia.get(N1).put(N2, pes);

			HashMap<T, Double> aux = new HashMap<>();
			aux.put(N1, pes);
			adjacencia.put(N2, aux);
		} else if (nodeExisteix(N2)) {
			adjacencia.get(N2).put(N1, pes);

			HashMap<T, Double> aux = new HashMap<>();
			aux.put(N2, pes);
			adjacencia.put(N1, aux);
		} else {
			HashMap<T, Double> aux1 = new HashMap<>();
			HashMap<T, Double> aux2 = new HashMap<>();
			aux1.put(N1, pes);
			aux2.put(N2, pes);
			adjacencia.put(N1, aux2);
			adjacencia.put(N2, aux1);
		}
	}

	/**
	 * Pre: -
	 * 
	 * @return Retorna el nombre de nodes del graf
	 */

	public int getNumNodes() {
		return adjacencia.size();
	}

	/**
	 * Pre: N1 i N2 existeixen i tenen adjacencia inicialitzada
	 * 
	 * @param N1
	 *            : Identidicador de un dels nodes que pertanyen a l'aresta a
	 *            obtenir
	 * @param N2
	 *            : Identificador de l'altre node que forma part de l'aresta
	 * @return: Retorna el pes entre els dos nodes
	 * @throws Exception
	 */

	public Double getAresta(T N1, T N2) throws Exception {
		if (nodeExisteix(N1) && nodeExisteix(N2)) {
			if (adjacencia.get(N1).containsKey(N2)
					&& adjacencia.get(N2).containsKey(N1)) {
				return adjacencia.get(N1).get(N2);
			} else
				throw new IllegalArgumentException("Els nodes han de tenir aresta entre ells"+ "\n");
		} else
			throw new IllegalArgumentException("Els dos nodes han d'existir" + "\n");
	}

	/**
	 * Pre: Node existeix
	 * 
	 * @return: Retorna un Map amb les adjacencies del node
	 */

	public Map<T, Double> getAdjacencia(T N1) throws Exception {
		if (nodeExisteix(N1))
			return Collections.unmodifiableMap(adjacencia.get(N1));
		else
			throw new IllegalArgumentException("El node no existeix"+ "\n");
	}
	
	/**
	 * Pre: N1 i N2 existeixen i tenen adjacencia inicialitzada
	 * 
	 * @param N1
	 *            : Identidicador de un dels nodes que pertanyen a l'aresta a
	 *            obtenir
	 * @param N2
	 *            : Identificador de l'altre node que forma part de l'aresta
	 * @return: Elimina l'aresta entre els dos nodes
	 * @throws Exception
	 */

	public void eliminarAresta(T N1, T N2) throws Exception {
		if (nodeExisteix(N1) && nodeExisteix(N2)) {
			if (adjacencia.get(N1).containsKey(N2) && adjacencia.get(N2).containsKey(N1)) {
				adjacencia.get(N1).remove(N2);
				adjacencia.get(N2).remove(N1);
			} else
				throw new IllegalArgumentException("Els nodes han de tenir aresta entre ells"+ "\n");
		} else
			throw new IllegalArgumentException("Els dos nodes han d'existir" + "\n");
	}

	/**
	 * Pre: -
	 * 
	 * @return: Retorna tots els nodes de Graf
	 */

	public Set<T> getNodes() {
		return adjacencia.keySet();
	}

	/**
	 * Pre: -
	 * 
	 * @param node
	 *            : Node que volem comprovar si esta afegit al graf o no
	 * @return: Retorna true si existeix, i fals si no
	 */
	public Boolean nodeExisteix(T node) {
		return adjacencia.containsKey(node);
			
	}
}