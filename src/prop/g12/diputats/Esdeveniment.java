package prop.g12.diputats;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Esdeveniment {
	protected int codi;
	protected String descripcio;
	protected Date data;
	protected ArrayList<Diputat> dip;
	
	public int getCodi() {
		return codi;
	}
	
	public String getDescripcio() {
		return descripcio;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setCodi(int codi) {
		this.codi = codi;
	}
	
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}
	
	/**
	 * Posa data a la Votacio
	 * @param Date data: data a posar a la Votacio
	 * @throws ParseException 
	 */
	public void setDate(String d) throws ParseException {
		StringToData(d);
	}
	
	public void StringToData(String d) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d2 = sdf.parse(d);
		this.data = d2;
	}
	
	public void afegirDiputat(Diputat d) {
		dip.add(d);
	}
	
	public ArrayList<Diputat> getDiputats() {
		return dip;
	}
}

	

