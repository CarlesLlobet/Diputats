package prop.g12.diputats.data;

import java.text.ParseException;
import java.util.Date;

public class ControladorConferencia {
	
	/**
	 * Creadora de la classe
	 */
	public ControladorConferencia() {}
	
	/**
	 * @return nova instancia de Conferencia
	 */
	public Conferencia creaConferencia() {
		return new Conferencia();
	}
	
	/**
	 * @param codi: Codi de la conferencia a crear
	 * @param descripcio: Descripcio de la conferencia a crear
	 * @param data: Data de la conferencia a crear
	 * @return nova Conferencia amb codi codi, descripcio descripcio i data data
	 * @throws ParseException
	 */
	public Conferencia creaConferencia(int codi, String descripcio, String d) throws ParseException {
		return new Conferencia(codi, descripcio, d);
	}
	
	/**
	 * 
	 * @param conferencia: Conferencia de la qual volem obtenir el codi
	 * @return Codi de la conferencia
	 */
	public int getCodi(Conferencia conferencia) {
		return conferencia.getCodi();
	}
	
	/**
	 * 
	 * @param conferencia: Conferencia a la qual volem canviar el codi
	 * @param codi: Codi nou de la conferencia
	 */
	public void setCodi(Conferencia conferencia, int codi) {
		conferencia.setCodi(codi);
	}
	
	/**
	 * 
	 * @param conferencia: Conferencia de la qual volem obtenir la descripcio
	 * @return Descripcio de la conferencia
	 */
	public String getDescripcio(Conferencia conferencia) {
		return conferencia.getDescripcio();
	}	
	
	/**
	 * @param conferencia: Conferencia a la qual volem canviar la descripcio
	 * @param descripcio: Descripcio nova de la conferencia
	 */
	public void setDescripcio(Conferencia conferencia, String descripcio) {
		conferencia.setDescripcio(descripcio);
	}
	
	/**
	 * @param conferencia: Conferencia de la qual volem obtenir la data
	 * @return Data de la conferencia
	 */
	public Date getData(Conferencia conferencia) {
		return conferencia.getData();
	}	
	
	/**
	 * 
	 * @param conferencia: Conferencia a la qual volem canviar la data
	 * @param data: Data nova de la conferencia
	 * @throws ParseException
	 */
	public void setData(Conferencia conferencia, String d) throws ParseException{
		conferencia.setData(d);
	}
	
	/**
	 * @param conferencia: conferencia a la qual volem afegir el diputat
	 * @param diputat: Diputat a afegir a la conferencia
	 */
	public void afegirDiputat(Conferencia conferencia, Diputat d) {
		conferencia.afegirDiputat(d);
	}
}
