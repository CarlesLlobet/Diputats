package prop.g12.diputats;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StubVotacio {
	
	private int codi;
	private String descripcio;
	private Date data;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		public StubVotacio() throws ParseException {
			codi = 345;
			descripcio = "Votacio per la llei contra l'abus infantil";
			data = sdf.parse("21/12/2012");
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

