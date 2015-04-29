package prop.g12.diputats;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DriverReunio {

	Reunio r;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public void testConstructor() throws ParseException {
		Integer codiReunioConstr = 10;
		Date dataReunioConstr = sdf.parse("1/1/2015");
		r = new Reunio(codiReunioConstr, "descripcioTestConstr", dataReunioConstr);
	}
	
	public void testGetCodi() {
		r.getCodi();
	}
	
	public void testGetDescripcio() {
		r.getDescripcio();
	}
	
	public void testGetData() {
		r.getData();
	}
	
	public void testSetCodi() {
		Integer codiReunio = 11;
		r.setCodi(codiReunio);
	}
	
	public void testSetDescripcio() {
		r.setDescripcio("descripcioTest");
	}
	
	public void testSetProcedencia() throws ParseException {
		Date dataReunio = sdf.parse("1/2/2015");
		r.setData(dataReunio);
	}
	
}
