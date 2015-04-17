package prop.g12.diputats;

public class Vot {
	TVot vot;
	
	public Vot(TVot vot) {
	    this.vot = vot;
	}
	    
	public String get_vot() {
		String resultat = "El vot encara no està definit";
	        
		switch (vot) {
	        case favor:
	        	resultat = "El vot és a favor";
	            break;
	                    
	        case contra:
	        	resultat = "El vot és en contra";
	            break;
	                     
	        case abstencio:
	        	resultat = "El vot és una blanc";
	            break;
	                        
	        default:
	            resultat = "El vot encara no està definit";
	            break;
	    }
		return resultat;
	}
	
	public void set_vot(TVot vot_nou) {
		vot = vot_nou;
	}
}
