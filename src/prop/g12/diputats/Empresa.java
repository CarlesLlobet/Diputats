package prop.g12.diputats;

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
	 * Post: Crea una empresa sense atributs
	 */
	public Empresa() {};
	
	/**
	 * Pre: -
	 * @param nom: Nom de l'empresa a crear
	 * @param a: Ambit de l'empresa a crear
	 * Post: Es crea una empresa amb nom i ambit iguals als nom i a
	 */
	public Empresa(String nom, String a) {
		this.nom = nom;
		this.ambit = stringToAmbit(a);
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
	 * @param nom: El nom de l'empresa passa a ser nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Pre: -
	 * @param a: Ambit de l'empresa
	 * @return Passa el String ambit al tipus TAmbit
	 */
	private TAmbit stringToAmbit(String a) {
		if (a.equals("industria"))return TAmbit.industria;				
		else if (a.equals("comercial")) return TAmbit.comercial;
		else return TAmbit.serveis;
	}
	
	/**
	 * Pre: -
	 * @param a: Ambit de l'empresa
	 * @return Passa el Tambit de l'empresa a un string 
	 */
	private String ambitToString(TAmbit a) {
		if (a.equals(TAmbit.industria))return "industria";				
		else if (a.equals(TAmbit.comercial)) return "comercial";
		else return "serveis";
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
	 * @param a: Ambit de l'empresa
	 * @throws Exception
	 * Post: L'ambit de l'empresa passa a ser a
	 */
	public void setAmbit(String a) throws Exception {
		if (a.equals("industria")) ambit = TAmbit.industria;
		else if (a.equals("comercial")) ambit = TAmbit.comercial;
		else if (a.equals("serveis")) ambit = TAmbit.serveis;
		else throw new Exception("No existeix el sector amb nom "+ a +"\n");	
	}
	
	/**
	 * Pre: -
	 * @param d: Diputat que treballa a la empresa
	 * Post: El diputat es afegit a la empresa
	 */
	public void afegirDiputat(Diputat d) {
		if(!diputats.contains(d)) diputats.add(d);
	}
	
	/**
	 * Pre: -
	 * @return Retorna els diputats que treballen a la empresa
	 */
	public ArrayList<Diputat> getDiputats() {
		return diputats;
	}
}