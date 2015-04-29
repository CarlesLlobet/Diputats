package prop.g12.diputats;

import java.util.Date;

public class DriverVotacio {

	Votacio v;
	
	public void TestVotacio() {
		v.Votacio(11,"prova",12:10:10);
	}
	
	public void testgetCodi(){
		v.getCodi();
	}
	
	public void testgetDescripcio() {
		v.getDescripcio();
	}
	
	public void testgetData() {
		v.getData();
	}
	
	public void testsetCodi() {
		v.setCodi(111);
	}
	
	public void testsetDescripcio() {
		v.setDescripcio("prova2");
	}
	
	public void testsetData() {
		v.setData("23:00:00");
	}
	
	public void testafegirVot() {
		Diputat d = new Diputat("SrProva","centre","LA");
		Vot vot = new Vot("favor");
		v.afegirVot(vot, d);
	}
	
}
