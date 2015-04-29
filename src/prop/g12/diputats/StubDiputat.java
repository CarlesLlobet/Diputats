package prop.g12.diputats;

import java.util.ArrayList;

public class StubDiputat {
	
	private Diputat d = new Diputat("Joan Lopez", "esquerra", "LA");
	private Diputat d2 = new Diputat("Maria Perez", "centre", "Texas");
	private ArrayList<Diputat> diputats;
	
	public ArrayList<Diputat> getDiputats() {
		return diputats;
	}
	
	public void afegirDiputats() {
		diputats.add(d);
		diputats.add(d2);
	}
}
