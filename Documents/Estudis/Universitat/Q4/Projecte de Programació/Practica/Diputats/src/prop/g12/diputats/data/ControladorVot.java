package prop.g12.diputats.data;


public class ControladorVot {
	
	/**
	 * Creadora de la classe
	 */
	public ControladorVot(){}
	
	/**
	 * @return Nova instancia de la classe Vot
	 */
	public Vot Vot() {
		return new Vot();
	}
	
	/**
	 * 
	 * @param vot: String que representa el vot del diputat
	 * @param diputat: Diputat que efectua el vot a la votacio
	 * @param votacio: Votacio on el diputat efectua el seu vot
	 * @return
	 * @throws Exception
	 */
	public Vot Vot(String vot, Diputat diputat, Votacio votacio) throws Exception {
		return new Vot(vot, diputat, votacio);
	}
	
	/**
	 * 
	 * @param vot: Vot del qual es vol obtenir el valor del que s'ha votat
	 * @return Valor del vot (favor, abstencio, contra)
	 */
	public TVot getVot(Vot vot) {
		return vot.getVot();
	}
	
	/**
	 * @param vot: Vot al qual se li vol canviar el valor del seu vot
	 * @param v: Nou valor pel vot
	 * @throws Exception
	 */
	public void setVot(Vot vot, String v) throws Exception {
		vot.setVot(v);	
	}
	
	/**
	 * 
	 * @param vot: Vot el diputat del qual volem obtenir
	 * @return: Diputat que ha efectuat aquell vot
	 */
	public Diputat getDiputat(Vot vot) {
		return vot.getDiputat();
	}
	
	/**
	 * 
	 * @param vot: Vot al qual volem modificar el diputat
	 * @param diputat: Diputat nou pel vot
	 */
	public void setDiputat(Vot vot, Diputat diputat) {
		vot.setDiputat(diputat);
	}
	
	/**
	 * 
	 * @param vot: Vot del qual volem obtenir la votacio on s'ha efectuat
	 * @return: Votacio on s'ha efectuat el vot
	 */
	public Votacio getVotacio(Vot vot) {
		return vot.getVotacio();
	}
	
	/**
	 * 
	 * @param vot: Vot al qual volem modificar la Votacio on s'ha efectuat
	 * @param votacio: Votacio nova pel vot
	 */
	public void setVotacio(Vot vot, Votacio votacio) {
		vot.setVotacio(votacio);
	}
}
