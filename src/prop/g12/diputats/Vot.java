package prop.g12.diputats;

public class Vot {
	private TVot vot;
	private Diputat diputat;
	private Votacio votacio;
	
	public Vot(String vot) {
	    this.vot = stringToVot(vot);
	}
	    
	public TVot getVot() {
		return vot;
	}
	
	public TVot stringToVot(String a) {
		if (a.equals("favor"))return TVot.favor;				
		else if (a.equals("contra")) return TVot.contra;
		else return TVot.abstencio;
	}
	
	public void setVot(String vot) {
		if (vot.equals("favor"))this.vot = TVot.favor;				
		else if (vot.equals("contra")) this.vot = TVot.contra;
		else this.vot = TVot.abstencio;
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
