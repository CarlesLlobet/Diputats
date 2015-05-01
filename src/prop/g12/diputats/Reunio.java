package prop.g12.diputats;
import java.text.ParseException;
import java.util.Date;


public class Reunio extends Esdeveniment {
	
	/**
	 * Creadora de la clase Reunio
	 */
	public Reunio(){}
	
	/**
	 * Creadora de la clase Reunio amb parametres
	 * @param codi: Codi de Reunio
	 * @param descripcio: Tema de la Reunio 
	 * @param d: Data de la Reunio
	 * @throws ParseException 
	 */
	public Reunio(int codi, String descripcio, String d) throws ParseException {
		this.codi = codi;
		this.descripcio = descripcio;
		setData(d);
		this.data = getData();
	}
	
	/**
	 * @return Retorna el codi de Reunio
	 */
	public int getCodi(){
		return super.getCodi();
	}
	
	/**
	 * @return Retorna la descripcio de Reunio
	 */
	public String getDescripcio() {
		return super.getDescripcio();
	}
	
	/**
	 * @return Retorna la data de Reunio
	 */
	public Date getData() {
		return super.getData();
	}
	
	/**
	 * Posa el codi a la Reunio
	 * @param codi: Codi a posar a la Reunio
	 */
	public void setCodi(int codi) {
		super.setCodi(codi);
	}
	
	/**
	 * Posa la descripcio a la Reunio
	 * @param descripcio: Descripcio a posar a la Reunio
	 */
	public void setDescripcio(String descripcio) {
		super.setDescripcio(descripcio);
	}
	
	/**
	 * Posa la data a la Reunio
	 * @param d: Data a posar a la Reunio
	 */
	public void setData(String d) throws ParseException {
		super.setDate(d);
	}
	
	/**
	 * Afegeix un diputat a la llista
	 * @param d: Diputat a posar a la Llista
	 */
	public void afegirDiputat(Diputat d) {
		super.afegirDiputat(d);
	}
}