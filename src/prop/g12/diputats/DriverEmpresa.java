package prop.g12.diputats;

public class DriverEmpresa {
	
	Empresa e;
	
	public DriverEmpresa() {}
	
	public void testConstructor() {
		e = new Empresa("nomTestConstr", "ambitTestConstr");
	}
	
	public void testGetNom() {
		e.getNom();
	}
	
	public void testGetAmbit() {
		e.getAmbit();
	}
	
	public void testSetNom() {
		e.setNom("nomTest");
	}
	
	public void testSetAmbit() {
		e.setAmbit("ambitTest");
	}
	
	public void testAfegirDiputat() {
		Diputat d = new Diputat("nomDTest", "centre", "procTest");
		e.afegirDiputat(d);
	}
	
	public void testGetDiputats() {
		e.getDiputats();
	}

}
