import java.util.Date;

public class Solucio {
	
	String nom;
	Date data;
	double tempsExec;
	String solucio; //Inacabado, txt
	
	//Falten les clases CrearComunitats i EliminarComunitats, SON OPCIONALS
	
	public Solucio(String nom, Date data, double tempsExec, String solucio){
		this.nom = nom;
		this.data = data;
		this.tempsExec = tempsExec;
		this.solucio = solucio;
	}
	
	public String getNom() {
		return nom;
	}
	
	public Date getData() {
		return data;
	}
	
	public double getTempsExec() {
		return tempsExec;
	}
	
	public String getSolucio() {
		return solucio;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public void setTempsExec(double tempsExec) {
		this.tempsExec = tempsExec;
	}
	
	public void setSolucio(String solucio) {
		this.solucio = solucio;
	}
	
	public void ModificarSolucio(String nom, Date data, double tempsExec, String solucio){
		
	}
	
	public void ExportarSolucio(Solucio solucio){
		
	}
	
	public void ImportarSolucio(Solucio solucio){
		
	}
	
	public void ConsultarSolucio(Solucio solucio){
		
	}
}
