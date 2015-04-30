package prop.g12.diputats;

public class StubEmpresa {

	private String nom;
	private TAmbit ambit;
	
	public StubEmpresa() {
		nom = "Cacaolat";
		ambit =TAmbit.industria;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getIdeologia() {
		return "industria";
	}

}
