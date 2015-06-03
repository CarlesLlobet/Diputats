package prop.g12.diputats.data;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

public class ControladorVotacio {
	
	/**
	 * Creadora de la classe
	 */
	public ControladorVotacio() {}
	
	/**
	 * @return nova instancia de Votacio
	 */
	public Votacio creaVotacio() {
		return new Votacio();
	}
	
	/**
	 * 
	 * @param codi: Codi de la votacio a crear
	 * @param descripcio: Descripcio de la votacio a crear
	 * @param data: Data de la votacio a crear
	 * @return nova Votacio amb codi codi, descripcio descripcio i data data
	 * @throws ParseException
	 */
	public Votacio creaVotacio(int codi, String descripcio, String data) throws ParseException {
		return new Votacio(codi, descripcio, data);
	}
	
	/**
	 * 
	 * @param esdeveniment: Esdeveniment a partir del qual volem
	 * 						crear una votacio
	 * @return Votacio creada
	 */
	public Votacio creaVotacio(Esdeveniment esdeveniment) {
		return new Votacio(esdeveniment);
	}
	
	/**
	 * 
	 * @param votacio: Votacio de la qual volem obtenir el codi
	 * @return Codi de la votacio
	 */
	public int getCodi(Votacio votacio) {
		return votacio.getCodi();
	}
	
	/**
	 * 
	 * @param votacio: Votacio de la qual volem obtenir la descripcio
	 * @return Descripcio de la votacio
	 */
	public String getDescripcio(Votacio votacio) {
		return votacio.getDescripcio();
	}
	
	/**
	 * @param votacio: Votacio de la qual volem obtenir la data
	 * @return Data de la votacio
	 */
	public Date getData(Votacio votacio) {
		return votacio.getData();
	}
	
	/**
	 * 
	 * @param votacio: Votacio a la qual volem canviar el codi
	 * @param codi: Codi nou de la votacio
	 */
	public void setCodi(Votacio votacio, int codi) {
		votacio.setCodi(codi);
	}
	
	/**
	 * @param votacio: Votacio a la qual volem canviar la descripcio
	 * @param descripcio: Descripcio nova de la votacio
	 */
	public void setDescripcio(Votacio votacio, String descripcio) {
		votacio.setDescripcio(descripcio);
	}
	
	/**
	 * 
	 * @param votacio: Votacio a la qual volem canviar la data
	 * @param data: Data nova de la votacio
	 * @throws ParseException
	 */
	public void setData(Votacio votacio, String data) throws ParseException {
		votacio.setData(data);
	}
	
	/**
	 * 
	 * @param votacio: Votacio de la qual volem obtenir el mapa de Diputats amb els seus vots
	 * @return Mapa de diputat-vot
	 */
	public Map<Diputat,Vot> getVots(Votacio votacio) {
		return votacio.getVots();
	}
	
	/**
	 * 
	 * @param votacio: Votacio a la qual volem afegir el vot
	 * @param vot: Vot que es vol afegir a la votacio
	 * @param diputat: Diputat que ha votat el vot vot en la votacio
	 * @throws Exception
	 */
	public void afegirVot(Votacio votacio, Vot vot, Diputat diputat) throws Exception {
		votacio.afegirVot(vot, diputat);
	}
	
	/**
	 * @param votacio: Votacio a la qual volem buscar un vot
	 * @param nom: Nom del diputat que ha efectuat el vot
	 * @return: Vot del diputat en la votacio
	 * @throws Exception
	 */
	public TVot getVot(Votacio votacio, String nom) throws Exception {
		return votacio.getVot(nom);
	}
}
