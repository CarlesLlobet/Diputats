package prop.g12.diputats;

import java.util.Date;

public class TestVotacio extends Votacio{

	public void TestVotacio(int codi, String descripcio, Date data) {
		super.Votacio(1,"prova",12:10:10);
	}
	
	public void testgetCodi(){
		super.getCodi();
	}
	
	public void testgetDescripcio() {
		super.getDescripcio();
	}
	
	public void testgetData() {
		super.getData();
	}
	
	public void testsetCodi(int codi) {
		super.setCodi(111);
	}
	
	public void testsetDescripcio(String descripcio) {
		super.setDescripcio("prova");
	}
	
	public void testsetData(Date data) {
		super.setData(data);
	}
	
	public void testafegirVot(Vot v) {
		Diputat d = new Diputat("SrProva","centre","LA");
		v = "favor";
		super.vots.put(d, v);
	}
	
}
