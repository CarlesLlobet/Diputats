package prop.g12.diputats;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DriverVotacio {

	Votacio v;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public void TestVotacio() throws ParseException {
		Date d = sdf.parse("21/12/2012");
		v = new Votacio(11,"prova",d);
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
	
	public void testsetData() throws ParseException {
		Date d2 = sdf.parse("21/12/2012");
		v.setData(d2);
	}
	
	public void testafegirVot() {
		Diputat d = new Diputat("SrProva","centre","LA");
		Vot vot = new Vot();
		v.afegirVot(vot, d);
	}
	
}
