package prop.g12.diputats;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DriverConferencia {

	Conferencia c;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public void testConstructor() throws ParseException {
		Integer codiConfConstr = 10;
		Date dataConfConstr = sdf.parse("1/1/2015");
		c = new Conferencia(codiConfConstr, "descripcioTestConstr", dataConfConstr);
	}
	
	public void testGetCodi() {
		c.getCodi();
	}
	
	public void testGetDescripcio() {
		c.getDescripcio();
	}
	
	public void testGetData() {
		c.getData();
	}
	
	public void testSetCodi() {
		Integer codiConf = 11;
		c.setCodi(codiConf);
	}
	
	public void testSetDescripcio() {
		c.setDescripcio("descripcioTest");
	}
	
	public void testSetProcedencia() throws ParseException {
		Date dataConf = sdf.parse("1/2/2015");
		c.setData(dataConf);
	}
	
}
