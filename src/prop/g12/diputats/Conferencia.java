package prop.g12.diputats;
import java.text.ParseException;
import java.util.Date;

public class Conferencia extends Esdeveniment {

		/**
		 * Creadora de la clase Conferencia
		 */
		public Conferencia(){}
		
		/**
		 * Creadora de la clase Conferencia amb parametres
		 * @param codi: Codi de Conferencia
		 * @param descripcio: Tema de la Conferencia
		 * @param d: Data de la conferencia
		 * @throws ParseException 
		 */
		public Conferencia(int codi, String descripcio, String d) throws ParseException {
			this.codi = codi;
			this.descripcio = descripcio;
			setData(d);
			this.data = getData();
		}
		
		/**
		 * @return Retorna el codi de Conferencia
		 */
		public int getCodi(){
			return super.getCodi();
		}
		
		/**
		 * @return Retorna la descripcio de Conferencia
		 */
		public String getDescripcio() {
			return super.getDescripcio();
		}
		
		/**
		 * @return Retorna la data de Conferencia
		 */
		public Date getData() {
			return super.getData();
		}
		
		/**
		 * Posa el codi a la Conferencia
		 * @param codi: Codi a posar a la Conferencia
		 */
		public void setCodi(int codi) {
			super.setCodi(codi);
		}
		
		/**
		 * Posa la descripcio a la Conferencia
		 * @param descripcio: Descripcio a posar a la Conferencia
		 */
		public void setDescripcio(String descripcio) {
			super.setDescripcio(descripcio);
		}
		
		/**
		 * Posa la data a la Conferencia
		 * @param d: Data a posar a la Conferencia
		 */
		public void setData(String d) throws ParseException {
			super.setDate(d);
		}
		
		/**
		 * Afegeix un diputat a la llista
		 * @param d: Diputat a posar a la llista
		 */
		public void afegirDiputat(Diputat d) {
			super.afegirDiputat(d);
		}
}