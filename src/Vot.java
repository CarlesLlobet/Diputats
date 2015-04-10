
public class Vot {
	TVot vot;
	
	public Vot(TVot vot) {
	    this.vot = vot;
	}
	    
	public String get_vot() {
		String resultat = "El vot encara no est� definit";
	        
		switch (vot) {
	        case favor:
	        	resultat = "El vot �s a favor";
	            break;
	                    
	        case contra:
	        	resultat = "El vot �s en contra";
	            break;
	                     
	        case abstencio:
	        	resultat = "El vot �s una blanc";
	            break;
	                        
	        default:
	            resultat = "El vot encara no est� definit";
	            break;
	    }
		return resultat;
	}
	
	public void set_vot(TVot vot_nou) {
		vot = vot_nou;
	}
}
