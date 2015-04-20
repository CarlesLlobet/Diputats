package prop.g12.diputats;
import java.util.*;

public abstract class Esdeveniment {
	protected int codi;
	protected String descripcio;
	protected Date data;
	
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
	
	public void setData(Date data) {
		this.data = data;
	}
	
}

	

