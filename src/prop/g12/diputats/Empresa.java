package prop.g12.diputats;

import java.util.ArrayList;

public class Empresa {
	
	private String nom;
	private TAmbit ambit;
	private ArrayList<Diputat> diputats;

	public Empresa(String nom, String a) {
		this.nom = nom;
		this.ambit = stringToAmbit(a);
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public TAmbit stringToAmbit(String a) {
		if (a.equals("industria"))return TAmbit.industria;				
		else if (a.equals("comercial")) return TAmbit.comercial;
		else return TAmbit.serveis;
	}
	
	public TAmbit getAmbit() {
		return ambit;
	}	
	
	public void setAmbit(String a) {
		if (a.equals("industria")) ambit = TAmbit.industria;
		else if (a.equals("comercial")) ambit = TAmbit.comercial;
		else if (a.equals("serveis")) ambit = TAmbit.serveis;
		else System.out.print("No existeix el sector amb nom"+ a);	
	}
	
	public void afegirDiputat(Diputat d) {
		if(!diputats.contains(d)) diputats.add(d);
	}
	
	public ArrayList<Diputat> getDiputats() {
		return diputats;
	}
}
