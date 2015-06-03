package prop.g12.diputats.data;

import java.text.ParseException;
import java.util.Date;


public class ControladorReunio {
	
	/**
	 * Creadora de la classe
	 */
	public ControladorReunio(){}
	
	/**
	 * @return nova instancia de Reunio
	 */
	public Reunio Reunio(){
		return new Reunio();
	}
	
	/**
	 * @param codi: Codi de la reunio a crear
	 * @param descripcio: Descripcio de la reunio a crear
	 * @param data: Data de la reunio a crear
	 * @return nova Reunio amb codi codi, descripcio descripcio i data data
	 * @throws ParseException
	 */
	public Reunio Reunio(int codi, String descripcio, String data) throws ParseException {
		return new Reunio(codi, descripcio, data);
	}
	
	/**
	 * 
	 * @param reunio: Reunio de la qual volem obtenir el codi
	 * @return Codi de la reunio
	 */
	public int getCodi(Reunio reunio){
		return reunio.getCodi();
	}
	
	/**
	 * 
	 * @param reunio: Reunio de la qual volem obtenir la descripcio
	 * @return Descripcio de la reunio
	 */
	public String getDescripcio(Reunio reunio) {
		return reunio.getDescripcio();
	}
	
	/**
	 * @param reunio: Reunio de la qual volem obtenir la data
	 * @return Data de la reunio
	 */
	public Date getData(Reunio reunio) {
		return reunio.getData();
	}
	
	/**
	 * 
	 * @param reunio: Reunio a la qual volem canviar el codi
	 * @param codi: Codi nou de la reunio
	 */
	public void setCodi(Reunio reunio, int codi) {
		reunio.setCodi(codi);
	}
	
	/**
	 * @param reunio: Reunio a la qual volem canviar la descripcio
	 * @param descripcio: Descripcio nova de la reunio
	 */
	public void setDescripcio(Reunio reunio, String descripcio) {
		reunio.setDescripcio(descripcio);
	}
	
	/**
	 * 
	 * @param reunio: Reunio a la qual volem canviar la data
	 * @param data: Data nova de la reunio
	 * @throws ParseException
	 */
	public void setData(Reunio reunio, String data) throws ParseException {
		reunio.setData(data);
	}
	
	/**
	 * @param reunio: reunio a la qual volem afegir el diputat
	 * @param diputat: Diputat a afegir a la reunio
	 */
	public void afegirDiputat(Reunio reunio, Diputat diputat) {
		reunio.afegirDiputat(diputat);
	}
}
