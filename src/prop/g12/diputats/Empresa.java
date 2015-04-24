package prop.g12.diputats;

import java.util.ArrayList;

public class Empresa {
	
	private String nom, ambit;
	private ArrayList<Diputat> diputats;

	public Empresa(String nom, String ambit) {
		this.nom = nom;
		this.ambit = ambit;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getAmbit() {
		return ambit;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setAmbit(String ambit) {
		this.ambit = ambit;
	}
	
	public void afegirDiputat(Diputat d) {
		if(!diputats.contains(d)) diputats.add(d);
	}

}
