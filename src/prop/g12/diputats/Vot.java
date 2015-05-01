//A la creadora de Vot comprovem i fem excepcio si no existeixen el diputat i el vot? (ineficiencia?)
//I a setDiputat i/o setVotacio ??
package prop.g12.diputats;

public class Vot {
	private TVot vot;
	private Diputat diputat;
	private Votacio votacio;
	
	/* void Vot():
	 * 
	 * Crea un vot buit
	 * 
	 * Pre:
	 * 
	 * Post:
	 * 
	 * Existeix un objecte buit de Vot
	*/
	
	public Vot() {
	}
	
	/* void Vot(String v, Diputat d, Votacio vota):
	 * 
	 * Crea un objecte vot amb el tipus de vot, el diputat 
	 * que vota, i la votacio a on vota aquest vot
	 * 
	 * Pre:
	 * 
	 * Diputat i Votacio existeixen
	 * 
	 * Post:
	 * 
	 * vot = v
	 * diputat = d;
	 * votacio = v;
	*/
	
	public Vot(String v, Diputat d, Votacio vota) throws Exception{
		this.vot = stringToVot(v);
		this.diputat = d;
		this.votacio = vota;
	}
	
	/* void getVot():
	 * 
	 * Mètode usat per veure el tipus de vot de l'objecte
	 * que crida a la funció
	 * 
	 * Pre:
	 * 
	 * Post:
	 * 
	 * retorna l'enumeration TVot vot.
	*/
	    
	public TVot getVot() {
		return vot;
	}
	
	/* TVot stringToVot(String a):
	 * 
	 * Mètode privat per a transformar Strings
	 * en enumerations TVot
	 * 
	 * Pre:
	 * 
	 * a = favor/a favor/contra/en contra/abstencio
	 * 
	 * Post:
	 * 
	 * Retorna Tvot amb el tipus de vot que especificava l'string
	*/
	
	private TVot stringToVot(String a) throws Exception {
		if (a.equals("favor") || vot.equals("a favor"))return TVot.favor;				
		else if (a.equals("contra") || vot.equals("en contra")) return TVot.contra;
		else if (a.equals("abstencio"))	return TVot.abstencio;
		else throw new Exception("No existeix el vot amb tipus "+ vot +"\n");
	}
	
	/* TVot setVot(String a):
	 * 
	 * Mètode que permet donar tipus a un vot
	 * 
	 * Pre:
	 * 
	 * vot = favor/a favor/contra/en contra/abstencio
	 * 
	 * Post:
	 * 
	 * posa el tipus de vot que especificava l'string a l'objecte de Vot
	*/
	
	public void setVot(String vot) throws Exception {
		this.vot = stringToVot(vot);	
	}
	
	/* TVot getDiputat():
	 * 
	 * Mètode que retorna la informació del
	 * Diputat que ha votat aquest vot
	 * 
	 * Pre:
	 * 
	 * Post:
	 * 
	 * retorna el diputat associat a l'objecte
	*/

	public Diputat getDiputat() {
		return diputat;
	}
	
	/* TVot setDiputat(Diputat diputat):
	 * 
	 * Mètode que permet assignar diputat a un vot
	 * 
	 * Pre:
	 * 
	 * diputat existeix
	 * 
	 * Post:
	 * 
	 * assigna el diputat paràmetre al objecte de vot
	*/

	public void setDiputat(Diputat diputat) {
		this.diputat = diputat;
	}
	
	/* TVot getVotacio():
	 * 
	 * Mètode que retorna la informació de la
	 * Votacio on s'ha votat aquest vot
	 * 
	 * Pre:
	 * 
	 * Post:
	 * 
	 * retorna la votacio associada a l'objecte
	*/

	public Votacio getVotacio() {
		return votacio;
	}
	
	/* TVot setVotacio(Votacio votacio):
	 * 
	 * Mètode que permet assignar la votacio a la que
	 * pertany un vot
	 * 
	 * Pre:
	 * 
	 * votacio existeix
	 * 
	 * Post:
	 * 
	 * assigna la votacio paràmetre al objecte de vot
	*/

	public void setVotacio(Votacio votacio) {
		this.votacio = votacio;
	}
}
