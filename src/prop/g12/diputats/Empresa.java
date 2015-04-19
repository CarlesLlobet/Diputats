package prop.g12.diputats;

public class Empresa {
	
	private String nom, ambit;	

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

}
