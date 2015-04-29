package prop.g12.diputats;

public class DriverDiputat {

	Diputat d;
	
	public void testConstructor() {
		d = new Diputat("nomTestConstr", "ideologiaTestConstr", "procedenciaTestConstr");
	}
	
	public void testGetNom() {
		d.getNom();
	}
	
	public void testGetIdeologia() {
		d.getIdeologia("ideologiaGetTest");
	}
	
	public void testGetProcedencia() {
		d.getProcedencia();
	}
	
	public void testSetNom() {
		d.setNom("nomTest");
	}
	
	public void testSetIdeologia() {
		d.setIdeologia("ideologiaSetTest");
	}
	
	public void testSetProcedencia() {
		d.setIdeologia("procedenciaTest");
	}

}
