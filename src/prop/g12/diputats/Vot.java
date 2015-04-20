package prop.g12.diputats;

public class Vot {
	private TVot vot;
	
	public Vot(TVot vot) {
	    this.vot = vot;
	}
	    
	public TVot getVot() {
		return vot;
	}
	
	public void setVot(TVot vot_nou) {
		this.vot = vot_nou;
	}
}
