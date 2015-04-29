package prop.g12.diputats;

public class Vot {
	private TVot vot;
	private Diputat diputat;
	private Votacio votacio;
	
	public Vot(String vot) {
	    this.vot = getVot(vot);
	}
	    
	public TVot getVot(String vot) {
		if (vot.equals("favor"))return TVot.favor;				
		else if (vot.equals("dreta")) return TVot.contra;
		else return TVot.abstencio;
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
