package prop.g12.diputats.data;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class ControladorEsdeveniment {
	
	/**
	 * Creadora de la classe
	 */
	public ControladorEsdeveniment() {}
	
	/**
	 * @param esdeveniment: Esdeveniment del qual volem obtenir el codi
	 * @return Codi de l'esdeveniment
	 */
	public int getCodi(Esdeveniment esdeveniment) {
		return esdeveniment.getCodi();
	}
	
	/**
	 * @param esdeveniment: Esdeveniment del qual volem obtenir la descipcio
	 * @return Descripcio de l'esdeveniment
	 */
	public String getDescripcio(Esdeveniment esdeveniment) {
		return esdeveniment.getDescripcio();
	}
	
	/**
	 * @param esdeveniment: Esdeveniment del qual volem obtenir la data
	 * @return Data de l'esdeveniment
	 */
	public Date getData(Esdeveniment esdeveniment) {
		return esdeveniment.getData();
	}
	
	/**
	 * @param esdeveniment: Esdeveniment del qual volem obtenir la data
	 * @return String que representa la data de l'esdeveniment
	 */
	public String getStringData(Esdeveniment esdeveniment) {
		return esdeveniment.dataToString();
	}
	
	/**
	 * @param esdeveniment: Esdeveniment al qual volem modificar el codi
	 * @param codi: Nou codi de l'esdeveniment
	 * Post: El codi de l'esdeveniment passa a ser el parametre codi
	 */
	public void setCodi(Esdeveniment esdeveniment, int codi) {
		esdeveniment.setCodi(codi);
	}
	
	/**
	 * @param esdeveniment: Esdeveniment al qual volem canviar la descripcio
	 * @param descripcio: Nova descripcio per l'esdeveniment
	 * Post: La descripcio de l'esdeveniment passa a ser el parametre descripcio
	 */
	public void setDescripcio(Esdeveniment esdeveniment, String descripcio) {
		esdeveniment.setDescripcio(descripcio);
	}
	
	/**
	 * @param esdeveniment: Esdeveniment al qual volem canviar la data
	 * @param data: String que representa la nova data de l'esdeveniment
	 * @throws ParseException
	 */
	public void setData(Esdeveniment esdeveniment, String data) throws ParseException {
		esdeveniment.setData(data);
	}
	
	/**
	 * @param esdeveniment: Esdeveniment al qual volem afegir un diputat
	 * @param diputat: Diputat a afegir a l'esdeveniment
	 * Post: El diputat s'afegeix a l'esdeveniment
	 */
	public void afegirDiputat(Esdeveniment esdeveniment, Diputat diputat) {
		esdeveniment.afegirDiputat(diputat);
	}
	
	/**
	 * @param esdeveniment: Esdeveniment del qual volem obtenir la llista de diputats
	 * @return Llista de diputats de l'empresa
	 */
	public ArrayList<Diputat> getDiputats(Esdeveniment esdeveniment) {
		return esdeveniment.getDiputats();
	}
	
	/**
	 * @param esdeveniment: Esdeveniment al qual volem modificar la llista de diputats
	 * @param dips: Nova llista de diputats per l'empresa
	 */
	public void setDiputats(Esdeveniment esdeveniment, ArrayList<Diputat> dips) {
		esdeveniment.setDiputats(dips);
	}
	
	/**
	 * @param opt: Descripcio de l'esdeveniment a crear
	 * @param codi: Codi de l'esdeveniment a crear
	 * @param data: Data de l'esdeveniment a crear
	 * @throws Exception
	 */
	public void crearEsdeveniment(String opt, int codi, String data) throws Exception {
		ControladorCongres ctrlCongres = new ControladorCongres();
		switch (opt) {
		case "Reunio":
			ControladorReunio cr = new ControladorReunio();
			Reunio reunio = cr.Reunio(codi, "reunio", data);
			ctrlCongres.altaEsdeveniment(reunio);
			break;
		case "Votacio":
			ControladorVotacio cv = new ControladorVotacio();
			Votacio votacio = cv.creaVotacio(codi, "votacio ", data);
			ctrlCongres.altaEsdeveniment(votacio);
			break;
		case "Conferencia":
			ControladorConferencia cc = new ControladorConferencia();
			Conferencia conferencia = cc.creaConferencia(codi, "conferencia", data);
			ctrlCongres.altaEsdeveniment(conferencia);
			break;
		}
	}
	
	/**
	 * @param codi: Codi de l'esdeveniment a donar de baixa
	 * @throws Exception
	 */
	public void baixaEsdeveniment(int codi) throws Exception {
		ControladorCongres ctrlCongres = new ControladorCongres();
		ControladorDiputat ctrlDiputat = new ControladorDiputat();
		Esdeveniment esdeveniment = ctrlCongres.cercaEsdeveniment(codi);
		ArrayList<Diputat> diputats = esdeveniment.getDiputats();
		for(int i = 0; i < diputats.size(); i++) {
			ctrlDiputat.baixaEsdeveniment(diputats.get(i), codi);
		}
		Map<Diputat, Vot> vots = esdeveniment.getVots();
		Iterator<Map.Entry<Diputat, Vot>> it = vots.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<Diputat, Vot> entry = it.next();
			ctrlDiputat.baixaEsdeveniment(entry.getKey(), codi);
		}
		ctrlCongres.baixaEsdeveniment(codi);
		esdeveniment = null;
	}
	
	/**
	 * 
	 * @param esdeveniment: Esdeveniment al qual el diputat representat per nom deixa d'assistir
	 * @param nom: Nom del diputat que deixa d'assistir a l'esdeveniment
	 * @throws Exception
	 */
	public void baixaDiputat(Esdeveniment esdeveniment, String nom) throws Exception {
		esdeveniment.baixaDiputat(nom);
	}
	
	/**
	 * 
	 * @param codi: codi de l'esdeveniment a modificar
	 * @param descripcio: nova descripcio de l'esdeveniment
	 * @param data: nova data de l'esdeveniment
	 * @throws Exception
	 */
	public void modificarEsdeveniment(int codi, String descripcio, String data) throws Exception {
		ControladorCongres ctrlCongres = new ControladorCongres();
		Esdeveniment esdeveniment = ctrlCongres.cercaEsdeveniment(codi);
		setDescripcio(esdeveniment, descripcio);
		setData(esdeveniment, data);
	}
}
