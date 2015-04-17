package prop.g12.diputats;

public class Vot {
	TVot vot;
	
	public Vot(TVot vot) {
	    this.vot = vot;
	}
	    
	public TVot get_vot() {
		return vot;
	}
	
	public void set_vot(TVot vot_nou) {
		vot = vot_nou;
	}
}
