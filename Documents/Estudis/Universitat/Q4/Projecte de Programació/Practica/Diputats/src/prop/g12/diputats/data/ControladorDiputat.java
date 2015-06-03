package prop.g12.diputats.data;

import java.util.ArrayList;

public class ControladorDiputat {
	
	/**
	 * Creadora de la classe
	 */
	public ControladorDiputat() {}
	
	/**
	 * @return: Nova instancia de la classe Diputat
	 */
	public Diputat creaDiputat() {
		return new Diputat();
	}

	/**
	 * 
	 * @param nom: Nom del diputat a crear
	 * @param ideologia: Ideologia del diputat a crear
	 * @param procedencia: Procedencia del diputat
	 * @return: Instancia del diputat creat
	 */
	public Diputat creaDiputat(String nom, String ideologia, String procedencia) {
		return new Diputat(nom, ideologia, procedencia);
	}
	
	/**
	 * 
	 * @param diputat: Diputat el nom del qual volem obtenir
	 * @return: Nom del diputat
	 */
	public String getNom(Diputat diputat) {
		return diputat.getNom();
	}
	
	/**
	 * 
	 * @param diputat: Diputat el nom del qual volem modificar
	 * @param nom: Nou valor del nom del diputat
	 */
	public void setNom(Diputat diputat, String nom) {
		diputat.setNom(nom);
	}
	
	/**
	 * 
	 * @param diputat: Diputat la ideologia del qual volem obtenir
	 * @return: Ideologia del diputat
	 */
	public TIdeologia getIdeologia(Diputat diputat) {
		return diputat.getIdeologia();
	}	
	
	/**
	 * 
	 * @param diputat: Diputat la ideologia del qual volem modificar
	 * @param ideologia: Nou valor de la ideologia del diputat
	 * @throws Exception
	 */
	public void setIdeologia(Diputat diputat, String ideologia) throws Exception {
		diputat.setIdeologia(ideologia);
	}
	
	/**
	 * 
	 * @param diputat: Diputat la procedencia del qual volem obtenir
	 * @return: Procedencia del diputat
	 */
	public String getProcedencia(Diputat diputat) {
		return diputat.getProcedencia();
	}	
	
	/**
	 * 
	 * @param diputat: Diputat la procedencia del qual volem modificar
	 * @param procedencia: Nou valor de la procedencia del diputat
	 */
	public void setProcedencia(Diputat diputat, String procedencia){
		diputat.setProcedencia(procedencia);
	}
	
	/**
	 * 
	 * @param diputat: Diputat l'empresa del qual volem obtenir
	 * @return: Empresa on treballa el diputat
	 */
	public Empresa getEmpresa(Diputat diputat){
		return diputat.getEmpresa();
	}
	
	/**
	 * 
	 * @param diputat: Diputat l'empresa del qual volem modificar.
	 * @param empresa: Nou valor per l'empresa on treballa el diputat
	 */
	public void setEmpresa(Diputat diputat, Empresa empresa){
		diputat.setEmpresa(empresa);
	}
	
	/**
	 * 
	 * @param diputat: Diputat el llistat d'esdeveniments del qual volem obtenir
	 * @return: Llistat d'esdeveniments on participa el diputat
	 */
	public ArrayList<Esdeveniment> getEsdeveniments(Diputat diputat) {
		return diputat.getEsdeveniments();
	}
	
	/**
	 * 
	 * @param diputat: Diputat al qual volem afegir l'esdeveniment
	 * @param esdeveniment: Esdeveniment a afegir
	 * @throws Exception
	 */
	public void afegirEsdeveniment(Diputat diputat, Esdeveniment esdeveniment) throws Exception{
		diputat.afegirEsdeveniment(esdeveniment);
		ControladorEsdeveniment ctrlEsdev = new ControladorEsdeveniment();
		ctrlEsdev.afegirDiputat(esdeveniment, diputat);
	}
	
	/**
	 * 
	 * @param diputat: Diputat que volem saber si participa a la votacio amb codi codi
	 * @param codi: Codi de la votacio
	 * @return: True si el diputat hi participa, false sino
	 */
	public Boolean votacioExisteix(Diputat diputat, int codi) {
		return diputat.votacioExisteix(codi);
	}
	
	/**
	 * 
	 * @param diputat: Diputat l'empresa del qual volem donar de baixa
	 */
	public void baixaEmpresa(Diputat diputat) {
		diputat.setEmpresa(null);
	}
	
	/**
	 * 
	 * @param nom: Nom del diputat a afegir al Congres
	 * @param ideologia: Ideologia del diputat a afegir al Congres
	 * @param procedencia: Procedencia del diputat a afegir al Congres
	 * @param empresa: Empresa del diputat a afegir al Congres
	 * @param ambit: Ambit de treball del diputat a afegir al Congres
	 * @throws Exception
	 */
	public void afegirDiputat(String nom, String ideologia, String procedencia, String empresa, String ambit) throws Exception{
		ControladorCongres ctrlCongres = new ControladorCongres();
		ControladorEmpresa ctrlEmpresa = new ControladorEmpresa();
		if (!ctrlCongres.existeixDiputat(nom)){
			Diputat d = new Diputat(nom, ideologia, procedencia);
			if(!empresa.equals(null)) {
				if (ctrlCongres.existeixEmpresa(empresa)){
					Empresa e = ctrlCongres.cercaEmpresa(empresa);
					d.setEmpresa(e);
					ctrlEmpresa.afegirDiputat(e, d);
				}
				else {
					Empresa e = ctrlEmpresa.creaEmpresa(empresa, ambit);
					d.setEmpresa(e);
					ctrlEmpresa.afegirDiputat(e, d);
				}
			}
			ctrlCongres.altaDiputat(d);
		}
	}
	
	/**
	 * 
	 * @param nom: Nom del diputat a modificar
	 * @param ideologia: Possible nou valor per la ideologia del diputat
	 * @param procedencia: Possible nou valor per la procedencia del diputat
	 * @param empresa: Possible nou valor pel nom de l'empresa on treballa el diputat
	 * @throws Exception
	 */
	public void modificarDiputat(String nom, String ideologia, String procedencia, String empresa) throws Exception{
		ControladorCongres ctrlCongres = new ControladorCongres();
		ControladorEmpresa ctrlEmpresa = new ControladorEmpresa();
		Diputat d = ctrlCongres.cercaDiputat(nom);
		if(!ideologia.equals(d.getIdeologia().toString())) d.setIdeologia(ideologia);
		if(!procedencia.equals(d.getProcedencia())) d.setProcedencia(procedencia);
		Empresa e = d.getEmpresa();
		if(!empresa.equals(ctrlEmpresa.getNom(e))) {
			ctrlEmpresa.baixaDiputat(e, d.getNom());
			baixaEmpresa(d);
			Empresa e2 = ctrlCongres.cercaEmpresa(empresa);
			d.setEmpresa(e2);
			ctrlEmpresa.afegirDiputat(e2, d);
		}
	}
	
	/**
	 * 
	 * @param nom: Nom del Diputat a donar de baixa
	 * @throws Exception
	 */
	public void baixaDiputat(String nom) throws Exception {
		ControladorCongres ctrlCongres = new ControladorCongres();
		ControladorEmpresa ctrlEmpresa = new ControladorEmpresa();
		ControladorEsdeveniment ctrlEsdeveniment = new ControladorEsdeveniment();
		ControladorDiputat ctrlDiputat = new ControladorDiputat();
		Diputat diputat = ctrlCongres.cercaDiputat(nom);
		Empresa empresa = diputat.getEmpresa();
		ctrlEmpresa.baixaDiputat(empresa, diputat.getNom());
		ArrayList<Esdeveniment> esdeveniments = diputat.getEsdeveniments();
		for(int i = 0; i < esdeveniments.size(); i++) {
			ctrlEsdeveniment.baixaDiputat(esdeveniments.get(i), ctrlDiputat.getNom(diputat));
		}
		ctrlCongres.baixaDiputat(nom);
		diputat = null;
	}
	
	/**
	 * 
	 * @param diputat: Diputat al qual volem donar de baixa l'esdeveniment amb codi codi
	 * @param codi: Codi de l'esdeveniment
	 * @throws Exception
	 */
	public void baixaEsdeveniment(Diputat diputat, int codi) throws Exception {
		diputat.baixaEsdeveniment(codi);
	}
}