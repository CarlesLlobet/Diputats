package prop.g12.diputats.data;
import java.text.ParseException;
import java.util.*;


public class Votacio extends Esdeveniment{
	
	/**
	 * Llista de dos valors no repetibles. Un diputat (Key) ha executat un unic vot (Valor).
	 */
	
	/**
	 * Creadora de la clase Votacio
	 * Post: Crea una instancia de la classe Votacio sense atributs
	 */
	public Votacio(){
		this.diputats = new ArrayList<Diputat>();
		this.vots = new HashMap<Diputat, Vot>();
	}

	/**
	 * Creadora de la clase Votacio amb parametres
	 * @param codi: Codi de votacio 
	 * @param descripcio: Tema de la votacio 
	 * @param data: Data la votacio
	 * @throws ParseException
	 * Pos: Crea una instancia de Votació amb els atributs que es pasen per parametre 
	 */
	public Votacio(int codi, String descripcio, String data) throws ParseException {
		this.codi = codi;
		this.descripcio = descripcio;
		setData(data);
		this.data = getData();
		this.diputats = new ArrayList<Diputat>();
		this.vots = new HashMap<Diputat, Vot>();
	}
	
	/**
	 * Pre: -
	 * @param e: Esdeveniment existent
	 * Post: Crea una instancia de Votació amb les mateixes dades que l'esdeveniment
	 */
	public Votacio(Esdeveniment esdeveniment) {
		this.codi = esdeveniment.codi;
		this.descripcio = esdeveniment.descripcio;
		this.data = esdeveniment.data;
		this.diputats = esdeveniment.diputats;
		this.vots = new HashMap<Diputat, Vot>();
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
	 * @param data: data a posar a la Votacio
	 * @throws ParseException 
	 * Post: La data de la votacio passa a ser la data del parametre
	 */
	public void setData(String data) throws ParseException {
		super.setData(data);
	}
	
	/**
	 * Pre: -
	 * @param vot: Vot efectuat per el diputat d
	 * @param diputat: Diputat que ha votat a la votacio
	 * @throws Exception 
	 * Post: Afegeix un vot de un diputat en una votacio
	 */
	public void afegirVot(Vot vot, Diputat diputat) throws Exception {
		TVot tvot = vot.getVot();
		if (!tvot.equals(TVot.contra) && !tvot.equals(TVot.favor) && !tvot.equals(TVot.abstencio)) {
			throw new Exception("El Vot no es correcte. Nomes pot ser contra, favor o abstencio");
		}
		Iterator<Map.Entry<Diputat, Vot>> it = vots.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<Diputat, Vot> entry = it.next();
			if (entry.getValue().equals(diputat)) throw new Exception("El diputat ja ha votat a la votacio");
		}
		vots.put(diputat, vot);
	}
	
	/**
	 * Pre: -
	 * @return Retorna la llista dels vots efectuats pels diputats
	 */
	public Map<Diputat,Vot> getVots() {
		return super.getVots();
	}
	
	/**
	 * @param nom: Nom del diputat
	 * @return Vot del diputat amb nom nom a la votacio
	 * @throws Exception
	 */
	public TVot getVot(String nom) throws Exception {
		Iterator<Map.Entry<Diputat, Vot>> it = vots.entrySet().iterator();
		TVot vot = null;
		while(it.hasNext()) {
			Map.Entry<Diputat, Vot> entry = it.next();
			if (entry.getKey().getNom().equals(nom)) vot = entry.getValue().getVot();
		}
		if(vot == null) throw new Exception("El diputat no ha votat en la votacio");
		return vot;
	}
	/**
	 * Pre: -
	 * @param nom: nom del diputat a eliminar de la votacio
	 * @throws Exception: Si el diputat no existeix
	 * Post: El diputat deixa de ser a la llista de participants, així com a la de votants
	 */
	public void baixaDiputat(String nom) throws Exception {
		boolean list = false;
		for(int i = 0; i < diputats.size() && list; i++) {
            Diputat d = diputats.get(i);
            if ((d.getNom()).equals(nom)) {
            	diputats.remove(i);
            	list = true;
            }
        }
		boolean map = false;
		Iterator<Map.Entry<Diputat, Vot>> it = vots.entrySet().iterator();
		while(it.hasNext() && !map) {
			Map.Entry<Diputat, Vot> entry = it.next();
			if(entry.getKey().getNom().equals(nom)) {
				vots.remove(entry);
				map = true;
			}
		}
		if (!list && !map) throw new Exception("El diputat no ha participat en aquest esdeveniment");
	}
	
}
