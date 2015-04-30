package prop.g12.diputats;

import java.util.*;

public class Diputat {

	private ArrayList<Esdeveniment> esdv;
	private ArrayList<Votacio> vot;
	private Empresa empr;
	private String nom;
	private TIdeologia ideologia;
	private String procedencia;	
	
	public Diputat() {}
	
	public Diputat(String n, String i, String p) {
		nom = n;
		ideologia = stringToIdeologia(i);
		procedencia = p;
	}
	
	public String getNom() {
		return nom;
	}

	public TIdeologia getIdeologia(String s) {
		return ideologia;
	}
	
	public TIdeologia stringToIdeologia(String s) {
		if (s.equals("esquerra"))return TIdeologia.esquerra;				
		else if (s.equals("dreta")) return TIdeologia.dreta;
		else return TIdeologia.centre;
	}
	
	public String ideologiaToString(TIdeologia a) {
		if (a.equals(TIdeologia.esquerra))return "esquerra";				
		else if (a.equals(TIdeologia.dreta)) return "dreta";
		else return "centre";
	}
	
	public String getProcedencia() {
		return procedencia;
	}
	
	public void setNom(String n) {
		nom = n;
	}
	
	public void setIdeologia(String i) {
		if (i.equals("esquerra")) ideologia = TIdeologia.esquerra;
		else if (i.equals("dreta")) ideologia = TIdeologia.dreta;
		else if (i.equals("centre")) ideologia = TIdeologia.centre;
		else System.out.print("No existeix la ideologia amb nom"+ i);		
	}
	
	public void setProcedencia(String p) {
		procedencia = p;
	}
	
	public Empresa getEmpresa() { return empr;}
	
	public ArrayList<Esdeveniment> getEsdeveniments() { return esdv;}
	
	public ArrayList<Votacio> getVotacions() { return vot;}
	
	
}