package prop.g12.diputats;
import java.text.ParseException;
import java.util.Date;

public class Conferencia extends Esdeveniment {

		public Conferencia(int codi, String descripcio, Date data) {
			this.codi = codi;
			this.descripcio = descripcio;
			this.data = data;
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
