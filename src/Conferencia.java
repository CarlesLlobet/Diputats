import java.util.Date;

public class Conferencia extends Esdeveniments {

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
		
		public void setData(Date data) {
			super.setData(data);
		}
}
