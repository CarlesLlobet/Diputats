package prop.g12.diputats;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StubEsdeveniment {

	private int codi;
	private String descripcio;
	private Date data;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public StubEsdeveniment() throws ParseException {
		codi = 123;
		descripcio = "Reunio sobre la corrució";
		data = sdf.parse("1/1/2015");
	}

	public int getCodi() {
		return codi;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public Date getData() {
		return data;
	}

}
