package prop.g12.diputats;

import java.util.*;

public class Diputat {

	/**
	 * Llista d'Esdeveniments on participa el Diputat
	 */
	private ArrayList<Esdeveniment> esdv;
	/**
	 * Llista de Votacions on participa el Diputat
	 */
	private ArrayList<Votacio> vot;
	/**
	 * Empresa on treballa el Diputat
	 */
	private Empresa empr;
	/**
	 * Nom del Diputat
	 */
	private String nom;
	/**
	 * Ideologia del Diputat
	 */
	private TIdeologia ideologia;
	/**
	 * Procedencia del Diputat
	 */
	private String procedencia;	
	
	/**
	 * Creadora de la clase Diputat
	 */
	public Diputat() {}
	
	/**
	 * Creadora de la clase Diputat amb parametres
	 * @param n: Nom del Diputat 
	 * @param i: Ideologia del Diputat 
	 * @param p: Procedencia del diputat
	 * @throws Exception: En cas de que ideologia no sigui correcte, Exception
	 */
	public Diputat(String n, String i, String p) {
		nom = n;
		try {
			ideologia = stringToIdeologia(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		procedencia = p;
	}
	
	/**
	 * @return: Retorna el nom del Diputat
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return: Retorna la ideologia del Diputat
	 */
	public TIdeologia getIdeologia() {
		return ideologia;
	}
	
	/**
	 * @return: Transforma un String en un objecte de clase TIdeologia
	 * @param s: String a transformar en Ideologia (centre, esquerra, dreta)
	 * @return esquerra: ideologia d'esquerra, dreta: ideologia de dreta, centre: ideologia de centre
	 * @throws Exception: Si no es cap dels anteriors, exception
	 */
	public TIdeologia stringToIdeologia(String s) throws Exception {
		if (s.equals("esquerra"))return TIdeologia.esquerra;				
		else if (s.equals("dreta")) return TIdeologia.dreta;
		else if (s.equals("centre")) return TIdeologia.centre;
		else throw new Exception("No existeix la ideologia amb nom "+ s +"\n");	
	}
	
	/**
	 * @return: Transforma un TIdeologia en un String
	 * @param a: Ideologia a transformar en String (centre, esquerra, dreta)
	 * @return esquerra: ideologia d'esquerra, dreta: ideologia de dreta, centre: ideologia de centre
	 * @throws Exception: Si no es cap dels anteriors, exception
	 */
	public String ideologiaToString(TIdeologia a) throws Exception {
		if (a.equals(TIdeologia.esquerra))return "esquerra";				
		else if (a.equals(TIdeologia.dreta)) return "dreta";
		else if (a.equals(TIdeologia.centre)) return "centre";
		else throw new Exception("No existeix la ideologia amb nom "+ a +"\n");	
	}
	
	/**
	 * @return: Retorna la procedencia del Diputat
	 */
	public String getProcedencia() {
		return procedencia;
	}
	
	/**
	 * Posa nom al Diputat
	 * @param n: Nom a posar al Diputat
	 */
	public void setNom(String n) {
		nom = n;
	}
	
	/**
	 * Posa ideologia al Diputat
	 * @param i: Ideologia a posar al Diputat
	 * @throws Exception: Si no es esquerra, dreta o centre, exception
	 */
	public void setIdeologia(String i) throws Exception {
		if (i.equals("esquerra")) ideologia = TIdeologia.esquerra;
		else if (i.equals("dreta")) ideologia = TIdeologia.dreta;
		else if (i.equals("centre")) ideologia = TIdeologia.centre;
		else throw new Exception("No existeix la ideologia amb nom "+ i +"\n");		
	}
	
	/**
	 * Posa procedencia al Diputat
	 * @param p: Procedencia a posar al Diputat
	 */
	public void setProcedencia(String p) {
		procedencia = p;
	}
	
	/**
	 * @return: Retorna la empresa on treballa el Diputat
	 */
	public Empresa getEmpresa() { return empr;}
	
	/**
	 * @return: Retorna la llista d'Esdeveniments on participa el Diputat
	 */
	public ArrayList<Esdeveniment> getEsdeveniments() { return esdv;}
	
	/**
	 * @return: Retorna la llista de Votacions on participa el Diputat
	 */
	public ArrayList<Votacio> getVotacions() { return vot;}
	
	/**
	 * Determina la empresa on treballa el Diputat
	 * @param empr: Empresa a posar al Diputat
	 */
	public void setEmpresa(Empresa empr) { 
		this.empr = empr;
	}
}