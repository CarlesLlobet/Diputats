package prop.g12.diputats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Diputat {

	public String nom;
	public TIdeologia ideologia;
	public String procedencia;	
	
	public Diputat(String n, String i, String p) {
		nom = n;
		ideologia = getIdeologia(i);
		procedencia = p;
	}
	
	public String getNom() {
		return nom;
	}

	public TIdeologia getIdeologia(String s) {
		if (s.equals("esquerra"))return TIdeologia.esquerra;				
		else if (s.equals("dreta")) return TIdeologia.dreta;
		else return TIdeologia.centre;
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
		//else excepci�			
	}
	
	public void setProcedencia(String p) {
		procedencia = p;
	}
	
	
}
