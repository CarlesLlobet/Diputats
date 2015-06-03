package prop.g12.common;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Clase, parametrizada, que representa la solucion obtenida a partir de un Graf y un Algorisme, esta formada por comunidades las cuales estan formadas por nodos con afinidad entre ellos.
 * @author Joel Acedo Delgado
 * @param <T> Tipo de nodos que utiliza la solucion
 */
public class Solucio<T> {

	/**
	 * Identificador de la solucion
	 */
	private int idSolucio;
	
	/**
	 * Numero de comunidades que forman la solucion
	 */
	private int numComunitats;
	
	/**
	 * Mapa que contiene las comunidades con sus respectivos nodos
	 */
	private Map<Integer, ArrayList<T>> comunitats;
	
	/**
	 * Tiempo de ejecucion que el algoritmo a tardado en generar la solucion, en milisegundos
	 */
	private double tempsExec;

	
	/**
	 * Grafo utilizado en la solucion
	 */
	@SuppressWarnings("rawtypes")
	private Graf graf;
	
	/**
	 * Algoritmo utilizado en la solucion
	 */
	@SuppressWarnings("rawtypes")
	private Algorisme algorisme;
	
	
	/**
	 * Comprueba si la comunidad con el idComunidad ya existe.
	 * @param idComunitat Identificador de la comunidad que se quiere comprobar
	 * @return true: Existe la comunidad con idComunitat, false: No existe una comunidad con idComunidad
	 */
	private boolean existeixComunitat(int idComunitat) {
		if (this.comunitats.containsKey(idComunitat))
			return true;

		return false;
	}

	/**
	 * Constructor de la clase solucion
	 */
	public Solucio() {
		this.comunitats = new TreeMap<Integer, ArrayList<T>>();
		this.numComunitats = 0;
	}

	/**
	 * Anade una comunidad, con el identificador idComunitat, a la solución si no existia previamente.
	 * @param idComunitat Identificador de la comunidad que se quiere anadir.
	 * @return true: La comunidad se ha anadido correctamente, false: La comunidad ya existe 
	 */
	public boolean afegirComunitat(int idComunitat) {
		if (!this.existeixComunitat(idComunitat)) {
			this.comunitats.put(idComunitat, new ArrayList<T>());
			++this.numComunitats;
			return true;
		}
		return false;
	}

	/**
	 * Elimina, si existe, la comunidad con el identificador idComunidad de la solución.
	 * @param idComunitat Identificador de la comunidad que se quiere eliminar
	 * @return true: La comunidad se ha eliminado correctamente, false: La comunidad no existia 
	 */
	public boolean eliminarComunitat(int idComunitat) {
		if (this.existeixComunitat(idComunitat)) {
			this.comunitats.remove(idComunitat);
			--this.numComunitats;
			return true;
		}
		return false;
	}

	/**
	 * Anade el nodo "node" a la comunidad con identificador idComunitat, siempre que esta exista.
	 * @param node Nodo a anadir
	 * @param idComunitat Identificador de la comunidad donde se quiere anadir el nodo
	 * @return true: El nodo se ha anadido correctamente, false: La comunidad donde con identificador idComunitat no existe 
	 */
	public boolean afegirNode(T node, int idComunitat) {
		if (this.existeixComunitat(idComunitat)) {
			ArrayList<T> tmpArray = this.comunitats.get(idComunitat);
			tmpArray.add(node);
			return true;
		}
		return false;
	}

	/**
	 * Elimina el nodo "node" de la comunidad con identificador idComunitat, siempre que esta exista.
	 * @param node Nodo que se quiere eliminar
	 * @param idComunitat Identificador de la comunidad de la cual se quiere eliminar el nodo
	 * @return true: El nodo se ha eliminado correctamente, false: La comunidad con identificador idComunitat no existe o el nodo no existe
	 */
	public boolean eliminarNode(T node, int idComunitat) {
		if (this.existeixComunitat(idComunitat)) {
			ArrayList<T> tmpArray = this.comunitats.get(idComunitat);
			if (tmpArray.remove(node))
				return true;
			return false;
		}
		return false;
	}

	/**
	 * Permite obtener todos los nodos que forman parte de la comunidad con identificador idComunitat.
	 * @param idComunitat Identificador de la comunidad de la que se quieren obtener los nodos
	 * @return ArrayList con todos los nodos de la comunidad, NULL si la comunidad no existe
	 */
	public ArrayList<T> getComunitat(int idComunitat) {
		if (this.existeixComunitat(idComunitat))
			return this.comunitats.get(idComunitat);

		return null;
	}

	/**
	 * Permite obtener todas las comunidades con todos los nodos que forman parte de cada una.
	 * @return Map(Integer, ArrayList(T)) con todas las comunidades, e identificadores, y sus respectivos nodos
	 */
	public Map<Integer, ArrayList<T>> getComunitats() {
		return comunitats;
	}

	/**
	 * Permite obtener el identificador de la solucion.
	 * @return int con el identificador de la solucion
	 */
	public int getIdSolucio() {
		return this.idSolucio;
	}

	/**
	 * Permite establecer el identificador de la solucion.
	 * @param idSolucio Identificador que se quiere asignar a la solucion
	 */
	public void setIdSolucio(int idSolucio) {
		this.idSolucio = idSolucio;
	}

	/**
	 * Permite obtener el numeros de comunidades que contiene la solucion.
	 * @return int con el numero de comunidades que contiene la solucion
	 */
	public int getNumComunitats() {
		return this.numComunitats;
	}

	/**
	 * Permite obtener el tiempo de ejecucion que el algoritmo a tardado en generar la solucion, en milisegundos.
	 * @return El tiempo de ejecucion que el algoritmo a tardado en generar la solucion
	 */
	public double getTempsExec() {
		return this.tempsExec;
	}

	/**
	 * Permite establecer el tiempo de ejecucion que el algoritmo a tardado en generar la solucion.
	 * @param temps Tiempo de ejecucion que el algoritmo tarda en generar la solucion
	 */
	public void setTempsExec(double temps) {
		this.tempsExec = temps;
	}
	
	
	/**
	 * Permite establecer el grafo que el algoritmo ha utilizado para generar la solucion.
	 * @param G Grafo que el algoritmo ha utilizado para generar la solucion
	 */
	public void setGraf(@SuppressWarnings("rawtypes") Graf G) {
		this.graf = G;
	}
	
	/**
	 * Permite obtener el grafo que el algoritmo ha utilizado para generar la solucion.
	 * @return El grafo que el algoritmo ha utilizado para generar la solucion
	 */
	@SuppressWarnings("rawtypes")
	public Graf getGraf() {
		return this.graf;
	}
	
	/**
	 * Permite establecer el algoritmo a partir del cual se ha generado la solucion.
	 * @param alg Algoritmo a partir del cual se ha generado la solucion
	 */
	public void setAlgorisme(@SuppressWarnings("rawtypes") Algorisme alg) {
		this.algorisme = alg;
	}
	
	/**
	 * Permite obtener el algoritmo a partir del cual se ha generado la solucion.
	 * @return El algoritmo a partir del cual se ha generado la solucion.
	 */
	@SuppressWarnings("rawtypes")
	public Algorisme getAlgorisme() {
		return this.algorisme;
	}

}