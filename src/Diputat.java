
public class Diputat {

	public String nom;
	public TIdeologia ideologia;
	public String procedencia;
	
	public Diputat(String n, TIdeologia i, String p) {
		nom = n;
		ideologia = i;
		procedencia = p;
	}
	
	public String getNom() {
		return nom;
	}

	public String getIdeologia() {
		switch (ideologia) {
			case esquerra: return "esquerra";
				
			case dreta: return "dreta";
				
			default: return "centre";
		}
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
		//else excepció			
	}
	
	public void setProcedencia(String p) {
		procedencia = p;
	}
}
