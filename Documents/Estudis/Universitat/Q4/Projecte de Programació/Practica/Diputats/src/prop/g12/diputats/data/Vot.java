package prop.g12.diputats.data;


public class Vot {
	
	/**
	 * Tipus de vot
	 */
	private TVot vot;
	
	/**
	 * Diputat que el vota
	 */
	private Diputat diputat;
	
	/**
	 * Votació a la que pertany el vot
	 */
	private Votacio votacio;
	
	/**
	 * Pre: -
	 * Post: Crea un vot sense atributs
	 */
	public Vot() {
	}
	
	/**
	 * Pre: v es un tipus de Vot Diputat d i Votacio vota existeixen
	 * @param v: Tipus de vot
	 * @param d: Diputat que el vota
	 * @param vota: Votacio a la que pertany el vot
	 * Post: Es crea un vot amb tipus v, diputat d i votacio vota
	 * @throws Exception
	 */
	
	public Vot(String v, Diputat d, Votacio vota) throws Exception{
		this.vot = stringToVot(v);
		this.diputat = d;
		this.votacio = vota;
	}
	
	/**
	 * Pre: -
	 * @return Retorna el tipus de vot del Vot
	 */
	    
	public TVot getVot() {
		return vot;
	}
	
	/**
	 * Pre: a = favor/a favor/contra/en contra/abstencio
	 * 
	 * @return Retorna Tvot amb el tipus de vot que especificava l'string
	 * @throws Exception
	*/
	
	private TVot stringToVot(String a) throws Exception {
		if (a.equals("favor") || a.equals("a favor"))return TVot.favor;				
		else if (a.equals("contra") || a.equals("en contra")) return TVot.contra;
		else if (a.equals("abstencio"))	return TVot.abstencio;
		else throw new Exception("No existeix el vot amb tipus "+ vot +"\n");
	}
	
	/**
	 * Pre: vot = favor/a favor/contra/en contra/abstencio
	 * 
	 * Post: Posa el tipus de vot que especificava l'string a l'objecte de Vot
	*/
	
	public void setVot(String vot) throws Exception {
		this.vot = stringToVot(vot);	
	}
	
	/**
	 * Pre: -
	 * 
	 * @return Retorna el diputat associat a l'objecte
	*/

	public Diputat getDiputat() {
		return diputat;
	}
	
	/**
	 * Pre: El Diputat diputat existeix
	 * 
	 * Post: assigna el diputat paràmetre al objecte de vot
	*/

	public void setDiputat(Diputat diputat) {
		this.diputat = diputat;
	}
	
	/**
	 * Pre: -
	 * 
	 * @return Retorna la votacio associada a l'objecte
	*/

	public Votacio getVotacio() {
		return votacio;
	}
	
	/**
	 * Pre: Votacio votacio existeix
	 * 
	 * Post: Assigna la votacio paràmetre al objecte de vot
	*/

	public void setVotacio(Votacio votacio) {
		this.votacio = votacio;
	}
}
