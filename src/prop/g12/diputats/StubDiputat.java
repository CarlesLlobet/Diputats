package prop.g12.diputats;

public class StubDiputat {
	
	private String nom;
	private TIdeologia ideologia;
	private String procedencia;
	
	public StubDiputat() {
		nom = "Joan Perez";
		ideologia = TIdeologia.centre;
		procedencia = "Los Angeles";
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getIdeologia() {
		return "centre";
	}
	
	public String getProcedencia() {
		return procedencia;
	}
}