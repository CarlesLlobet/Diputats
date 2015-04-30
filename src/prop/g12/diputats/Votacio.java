package prop.g12.diputats;
import java.util.*;


public class Votacio extends Esdeveniment{
	
	protected Map<Diputat,Vot> vots;
	
	public Votacio(){}

	public Votacio(int codi, String descripcio, Date data) {
		this.codi = codi;
		this.descripcio = descripcio;
		this.data = data;
	}
	
	public Votacio (Esdeveniment e) {
		this.codi = e.codi;
		this.descripcio = e.descripcio;
		this.data = e.data;
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
	
	public void setData(Date data) {
		super.setData(data);
	}
	
	public void afegirVot(Vot v, Diputat d) {
		vots.put(d, v);
	}
	
	public Map<Diputat,Vot> getVots() {
		return vots;
	}
	
}
