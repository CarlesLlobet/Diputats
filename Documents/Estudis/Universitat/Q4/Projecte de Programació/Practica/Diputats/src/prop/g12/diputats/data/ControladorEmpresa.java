package prop.g12.diputats.data;

import java.util.ArrayList;

public class ControladorEmpresa {
	
	/**
	 * Creadora de la classe
	 * Retorna una nova instancia de la classe
	 */
	public ControladorEmpresa() {}
	
	/**
	 * Pre: -
	 * @return: Nova instancia de la classe Empresa
	 */
	public Empresa creaEmpresa() {
		return new Empresa();
	}

	/**
	 * Pre: -
	 * @param nom: Nom de la nova empresa
	 * @param ambit: Ambit de la nova empresa
	 * @return Empresa nova amb nom nom i ambit ambit
	 */
	public Empresa creaEmpresa(String nom, String ambit) {
		return new Empresa(nom, ambit);
	}
	
	/**
	 * Pre: -
	 * @param empresa: Empresa de la qual volem obtenir el nom
	 * @return Nom de l'empresa empresa
	 */
	public String getNom(Empresa empresa) {
		return empresa.getNom();
	}
	
	/**
	 * Pre: -
	 * @param empresa: Empresa a la qual volem canviar el nom
	 * @param nom: Nou nom que volem donar a l'empresa
	 * Post: L'empresa empresa passa a tenir el parametre nom com a nom
	 */
	public void setNom(Empresa empresa, String nom) {
		empresa.setNom(nom);
	}
	
	/**
	 * Pre: -
	 * @param empresa: Empresa de la qual volem obtenir l'ambit
	 * @return Ambit de l'empresa empresa
	 */
	public TAmbit getAmbit(Empresa empresa) {
		return empresa.getAmbit();
	}	
	
	/**
	 * Pre: -
	 * @param empresa: Empresa a la qual volem canviar l'ambit
	 * @param ambit: Ambit nou de l'empresa
	 * @throws Exception en cas que l'ambit sigui incorrecte
	 * Post: L'empresa empresa passa a tenir el parametre ambit com a ambit
	 */
	public void setAmbit(Empresa empresa, String ambit) throws Exception {
		empresa.setAmbit(ambit);
	}
	
	/**
	 * Pre: -
	 * @param empresa: Empresa a la qual volem afegir el diputat
	 * @param diputat: Diputat que es vol afegir a l'empresa
	 * @throws Exception
	 */
	public void afegirDiputat(Empresa empresa, Diputat diputat) throws Exception{
		empresa.afegirDiputat(diputat);
	}
	
	/**
	 * Pre: -
	 * @param empresa: Empresa de la qual volem obtenir els diputats que hi treballen
	 * @return Llista de diputats que treballen a l'empresa
	 */
	public ArrayList<Diputat> getDiputats(Empresa empresa) {
		return empresa.getDiputats();
	}
	
	/**
	 * Pre: -
	 * @param empresa: Empresa a la qual volem canviar els diputats que hi treballen
	 * @param dips: Nova llista de treballadors de l'empresa
	 * Post: Els diputats que treballen a l'empresa passen a ser els de dips
	 */
	public void setDiputats(Empresa empresa, ArrayList<Diputat> dips) {
		empresa.setDiputats(dips);
	}
	
	/**
	 * Pre: -
	 * @param nom: Nom de l'empresa a donar de baixa
	 * @throws Exception si l'empresa no existeix
	 * Post: La instancia de l'empresa passa a ser null.
	 */
	public void baixaEmpresa(String nom) throws Exception {
		ControladorCongres ctrlCongres = new ControladorCongres();
		ControladorDiputat ctrlDiputat = new ControladorDiputat();
		Empresa empresa = ctrlCongres.cercaEmpresa(nom);
		ArrayList<Diputat> diputats = empresa.getDiputats();
		for(int i = 0; i < diputats.size(); i++) {
			ctrlDiputat.baixaEmpresa(diputats.get(i));
		}
		ctrlCongres.baixaEmpresa(nom);
		empresa = null;
	}
	
	/**
	 * Pre: -
	 * @param empresa: Empresa a la qual volem donar de baixa un diputat
	 * @param nom: Nom del diputat que volem donar de baixa
	 * Post: Es dona de baixa el diputat amb nom nom de l'empresa
	 */
	public void baixaDiputat(Empresa empresa, String nom) {
		empresa.baixaDiputat(nom);
	}
}
