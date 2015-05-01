package prop.g12.diputats;
import java.text.ParseException;
import java.util.*;


public class Votacio extends Esdeveniment{
	
	/**
	 * Llista de dos valors no repetibles. Un diputat (Key) ha executat un unic vot (Valor).
	 */
	protected Map<Diputat,Vot> vots;
	
	/**
	 * Creadora de la clase Votacio
	 * Post: Crea una instancia de la classe Votacio sense atributs
	 */
	public Votacio(){}

	/**
	 * Creadora de la clase Votacio amb parametres
	 * @param codi: Codi de votacio 
	 * @param descripcio: Tema de la votacio 
	 * @param data: Data la votacio
	 * @throws ParseException
	 * Pos: Crea una instancia de Votació amb els atributs que es pasen per parametre 
	 */
	public Votacio(int codi, String descripcio, String d) throws ParseException {
		this.codi = codi;
		this.descripcio = descripcio;
		setData(d);
		this.data = getData();
	}
	
	/**
	 * Pre: -
	 * @param e: Esdeveniment existent
	 * Post: Crea una instancia de Votació amb les mateixes dades que l'esdeveniment
	 */
	public Votacio(Esdeveniment e) {
		this.codi = e.codi;
		this.descripcio = e.descripcio;
		this.data = e.data;
	}
	
	/**
	 * Pre: -
	 * @return Retorna el codi de Votacio
	 */
	public int getCodi(){
		return super.getCodi();
	}
	
	/**
	 * Pre: -
	 * @return Retorna la descripcio de Votacio
	 */
	public String getDescripcio() {
		return super.getDescripcio();
	}
	
	/**
	 * Pre: -
	 * @return Retorna la data de Votacio
	 */
	public Date getData() {
		return super.getData();
	}

	/**
	 * Pre: -
	 * @param int codi: Codi a posar a la Votacio
	 * Post: El codi de la votacio passa a ser el codi del parametre
	 */
	public void setCodi(int codi) {
		super.setCodi(codi);
	}
	
	/**
	 * Pre: -
	 * @param String descripcio: descripcio a posar a la Votacio
	 * Post: La descripcio de la votacio passa a ser la descripcio del parametre
	 */
	public void setDescripcio(String descripcio) {
		super.setDescripcio(descripcio);
	}
	
	/**
	 * Pre: -
	 * @param d: data a posar a la Votacio
	 * @throws ParseException 
	 * Post: La data de la votacio passa a ser la data del parametre
	 */
	public void setData(String d) throws ParseException {
		super.setDate(d);
	}
	
	/**
	 * Pre: -
	 * @param v: Vot efectuat per el diputat d
	 * @param d: Diputat que ha votat a la votacio
	 * @throws Exception 
	 * Post: Afegeix un vot de un diputat en una votacio
	 */
	public void afegirVot(Vot v, Diputat d) throws Exception {
		if (!v.equals(TVot.contra) && !v.equals(TVot.favor) && !v.equals(TVot.abstencio)) {
			throw new Exception("El Vot no es correcta. Nomes pot ser contra, favor o abstencio");
		}
		for (int i = 0; i < vots.size(); ++i) {
			if (vots.get(i).equals(d)) throw new Exception("El diputat ja ha votat a la votacio");
		}
		vots.put(d, v);
	}
	
	/**
	 * Pre: -
	 * @return Retorna la llista dels vots efectuats pels diputats
	 */
	public Map<Diputat,Vot> getVots() {
		return vots;
	}	
	
}
