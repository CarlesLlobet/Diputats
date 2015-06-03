package prop.g12.diputats.data;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class Conferencia extends Esdeveniment {

		/**
		 * Creadora de la clase Conferencia
		 */
		public Conferencia(){
			this.diputats = new ArrayList<Diputat>();
		}
		
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
			this.diputats = new ArrayList<Diputat>();
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
			super.setData(d);
		}
		
		/**
		 * Afegeix un diputat a la llista
		 * @param d: Diputat a posar a la llista
		 */
		public void afegirDiputat(Diputat d) {
			super.afegirDiputat(d);
		}
		/**
		 * @param nom: Nom del diputat a donar de baixa
		 * @throws Exception
		 * Post: El diputat amb nom nom deixa de participar a la conferencia
		 */
		public void baixaDiputat(String nom) throws Exception {
			boolean find = false;
	        for(int i = 0; i < diputats.size() && !find; i++) {
	            Diputat d = diputats.get(i);
	            if ((d.getNom()).equals(nom)) {
	            	diputats.remove(i);
	            	find = true;
	            }
	        }
	        if (!find) throw new Exception("El diputat no ha participat en aquest esdeveniment");
		}
}