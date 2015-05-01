package prop.g12.diputats;
import java.text.ParseException;
import java.util.Date;


public class Reunio extends Esdeveniment {

	public Reunio(int codi, String descripcio, String d) throws ParseException {
		this.codi = codi;
		this.descripcio = descripcio;
		setData(d);
		this.data = getData();
	}
	
	public int getCodi(){
		return super.getCodi();
	}
	
	public String getDescripcio() {
		return super.getDescripcio();
	}
	
	public Date getData() {
		return super.getData();
	}
	
	public void setCodi(int codi) {
		super.setCodi(codi);
	}
	
	public void setDescripcio(String descripcio) {
		super.setDescripcio(descripcio);
	}
	
	public void setData(String d) throws ParseException {
		super.setDate(d);
	}
}
