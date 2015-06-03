package prop.g12.diputats.data;

import java.util.ArrayList;

public class Empresa {
	
	/**
	 * Nom de l'empresa
	 */
	private String nom;
	
	/**
	 * Ambit de l'empresa
	 */
	private TAmbit ambit;
	
	/**
	 * Diputats que treballen a l'empresa
	 */
	private ArrayList<Diputat> diputats;
	
	/**
	 * Pre: -
	 * Post: Crea una empresa sense assignar atributs
	 */
	public Empresa() {
		this.diputats = new ArrayList<Diputat>();
	}
	
	/**
	 * Pre: -
	 * @param nom: Nom de l'empresa a crear
	 * @param a: Ambit de l'empresa a crear
	 * Post: Es crea una empresa amb nom i ambit iguals als nom i a
	 */
	public Empresa(String nom, String ambit) {
		this.nom = nom;
		this.ambit = stringToAmbit(ambit);
		this.diputats = new ArrayList<Diputat>();
	}
	
	/**
	 * Pre: -
	 * @return Retorna el nom de l'empresa
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Pre: -
	 * @param nom: Nou nom que se li dona a l'empresa
	 * Post: El nom de l'empresa passa a ser el parametre nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Pre: -
	 * @param ambit: Ambit de l'empresa
	 * @return Retorna l'ambit equivalent al parametre ambit
	 */
	private TAmbit stringToAmbit(String ambit) {
		if (ambit.equals("industria"))return TAmbit.industria;				
		else if (ambit.equals("comercial")) return TAmbit.comercial;
		else return TAmbit.serveis;
	}
	
	/**
	 * Pre: -
	 * @return Retorna l'ambit de l'empresa
	 */
	public TAmbit getAmbit() {
		return ambit;
	}	
	
	/**
	 * Pre: -
	 * @param ambit: Ambit a assignar a l'empresa
	 * @throws Exception
	 * Post: L'ambit de l'empresa passa a ser ambit
	 */
	public void setAmbit(String ambit) throws Exception {
		if (ambit.equals("industria")) this.ambit = TAmbit.industria;
		else if (ambit.equals("comercial")) this.ambit = TAmbit.comercial;
		else if (ambit.equals("serveis")) this.ambit = TAmbit.serveis;
		else throw new Exception("No existeix l'ambit amb nom "+ ambit +"\n");	
	}
	
	/**
	 * Pre: -
	 * @param d: Diputat que passa a treballar a la empresa
	 * Post: El diputat es afegit a la empresa
	 */
	public void afegirDiputat(Diputat diputat) throws Exception{
		if(!diputats.contains(diputat)) diputats.add(diputat);
		else throw new Exception("El diputat ja treballa a l'empresa.");
	}
	
	/**
	 * Pre: -
	 * @return Retorna els diputats que treballen a la empresa
	 */
	public ArrayList<Diputat> getDiputats() {
		return diputats;
	}
	
	/**
	 * Pre: -
	 * @param diputats: Nova llista de diputats de l'empresa
	 * Post: La llista dels diputats de l'empresa passa a ser la que es passa per parametre
	 */
	public void setDiputats(ArrayList<Diputat> diputats) {
		this.diputats = diputats;
	}
	
	/**
	 * Pre: -
	 * @param nom: Nom del diputat a donar de baixa de l'empresa
	 * Post: Es dona de baixa el diputat amb nom nom de l'empresa
	 */
	public void baixaDiputat(String nom) {
		boolean find = false;
		for(int i = 0; i < diputats.size() && !find; i++) {
			Diputat diputat = diputats.get(i);
			if(diputat.getNom().equals(nom)) {
				diputats.remove(i);
				find = true;
			}
		}
	}
}