import java.util.Date;
	public abstract class Esdeveniments {
		int codi;
		String descripcio;
		Date data;
		
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

	

