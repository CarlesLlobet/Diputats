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
	 */
	public Votacio(){}

	/**
	 * Creadora de la clase Votacio amb parametres
	 * @param codi: Codi de votacio, descripcio: Tema de la votacio, data: Data de la votacio
	 * @throws ParseException 
	 */
	public Votacio(int codi, String descripcio, String d) throws ParseException {
		this.codi = codi;
		this.descripcio = descripcio;
		setData(d);
		this.data = getData();
	}
	
	/**
	 * Codi, descripcio i data de Votacio agafada de la superclase Esdeveniment
	 * @param e: Esdeveniment relacionat amb votacio
	 */
	public Votacio(Esdeveniment e) {
		this.codi = e.codi;
		this.descripcio = e.descripcio;
		this.data = e.data;
	}
	
	/**
	 * Retorna el codi de Votacio
	 */
	public int getCodi(){
		return super.getCodi();
	}
	
	/**
	 * Retorna la descripcio de Votacio
	 */
	public String getDescripcio() {
		return super.getDescripcio();
	}
	
	/**
	 * Retorna la data de Votacio
	 */
	public Date getData() {
		return super.getData();
	}

	/**
	 * Posa codi a la Votacio
	 * @param int codi: Codi a posar a la Votacio
	 */
	public void setCodi(int codi) {
		super.setCodi(codi);
	}
	
	/**
	 * Posa descripcio a la Votacio
	 * @param String descripcio: descripcio a posar a la Votacio
	 */
	public void setDescripcio(String descripcio) {
		super.setDescripcio(descripcio);
	}
	
	/**
	 * Posa data a la Votacio
	 * @param Date data: data a posar a la Votacio
	 * @throws ParseException 
	 */
	public void setData(String d) throws ParseException {
		super.setDate(d);
	}
	
	/**
	 * Afegeix un Vot v al Diputat d
	 * @param Vot v: Vot efectuat per un Diputat d, Diputat d: Diputat que efectua el Vot v
	 * @throws Exception 
	 */
	public void afegirVot(Vot v, Diputat d) throws Exception {
		if (v.equals(TVot.contra) && v.equals(TVot.favor) && v.equals(TVot.abstencio)) {
			throw new Exception("El Vot no es correcta. Nomes pot ser contra, favor o abstencio");
		}
		for (int i = 0; i < super.dip.size(); ++i) {
			if (dip.get(i).equals(d)) throw new Exception("El diputat ja ha votat a la votacio");
		}
		vots.put(d, v);
	}
	
	/**
	 * Retorna la llista dels vots efectuats pels diputats
	 */
	public Map<Diputat,Vot> getVots() {
		return vots;
	}	
	
}
