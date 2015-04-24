package prop.g12.diputats;

public class Vot {
	private TVot vot;
	private Diputat diputat;
	private Votacio votacio;
	
	public Vot(TVot vot) {
	    this.vot = vot;
	}
	    
	public TVot getVot() {
		return vot;
	}
	
	public void setVot(TVot vot_nou) {
		this.vot = vot_nou;
	}

	public Diputat getDiputat() {
		return diputat;
	}

	public void setDiputat(Diputat diputat) {
		this.diputat = diputat;
	}

	public Votacio getVotacio() {
		return votacio;
	}

	public void setVotacio(Votacio votacio) {
		this.votacio = votacio;
	}
}
