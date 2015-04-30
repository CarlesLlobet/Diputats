package prop.g12.diputats;

public class Vot {
	private TVot vot;
	private Diputat diputat;
	private Votacio votacio;
	
	public Vot() {
	}
	
	public Vot(TVot v, Diputat d, Votacio vota){
		this.vot = v;
		this.diputat = d;
		this.votacio = vota;
	}
	    
	public TVot GetVot() {
		return vot;
	}
	
	public TVot StringToVot(String a) {
		if (a.equals("favor") || vot.equals("a favor"))return TVot.favor;				
		else if (a.equals("contra") || vot.equals("en contra")) return TVot.contra;
		else return TVot.abstencio;
	}
	
	public String VotToString(TVot tvot) {
		if (tvot.equals(TVot.favor)) return "a favor";				
		else if (tvot.equals(TVot.contra)) return "en contra";
		else return "abstencio";
	}
	
	public void SetVot(String vot) throws Exception {
		if (vot.equals("favor") || vot.equals("a favor"))this.vot = TVot.favor;				
		else if (vot.equals("contra") || vot.equals("en contra")) this.vot = TVot.contra;
		else if (vot.equals("abstencio")) this.vot = TVot.abstencio;
		else throw new Exception("No existeix el vot amb tipus "+ vot +"\n");	
	}

	public Diputat GetDiputat() {
		return diputat;
	}

	public void SetDiputat(Diputat diputat) {
		this.diputat = diputat;
	}

	public Votacio GetVotacio() {
		return votacio;
	}

	public void SetVotacio(Votacio votacio) {
		this.votacio = votacio;
	}
}
