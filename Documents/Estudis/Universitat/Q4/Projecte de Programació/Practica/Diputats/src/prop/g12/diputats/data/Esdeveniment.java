package prop.g12.diputats.data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Esdeveniment {
	
	/**
	 * Codi de l'Esdeveniment
	 */
	protected int codi;
	
	/**
	 * Descripcio de l'Esdeveniment
	 */
	protected String descripcio;
	
	/**
	 * Data de l'Esdeveniment
	 */
	protected Date data;
	
	/**
	 * Llista de diputats relacionats amb esdeveniments
	 */
	protected ArrayList<Diputat> diputats;
	
	/**
	 * Relacio de Diputats i Vots (implementat unicament per Votacio)
	 */
	protected Map<Diputat,Vot> vots;
	
	/**
	 * @return Retorna el codi de l'Esdeveniment
	 */
	public int getCodi() {
		return codi;
	}
	
	/**
	 * @return Retorna la descripcio de l'Esdeveniment
	 */
	public String getDescripcio() {
		return descripcio;
	}
	
	/**
	 * @return Retorna la data de l'Esdeveniment
	 */
	public Date getData() {
		return data;
	}
	
	/**
	 * Posa el codi a l'Esdeveniment
	 * @param codi: Codi a posar a l'Esdeveniment
	 */
	public void setCodi(int codi) {
		this.codi = codi;
	}
	
	/**
	 * Posa la descripcio a l'Esdeveniment
	 * @param descripcio: Descripcio a posar a l'Esdeveniment
	 */
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}
	
	/**
	 * Posa data a la Data
	 * @param d: data a posar a l'Esdeveniment
	 * @throws ParseException 
	 */
	public void setData(String d) throws ParseException {
		stringToData(d);
	}
	
	/**
	 * Transforma un string a data
	 * @param d: string a transformar a data
	 * @throws ParseException 
	 */
	protected void stringToData(String d) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
		Date d2 = sdf.parse(d);
		this.data = d2;
	}
	/**
	 * Transforma la data de l'esdeveniment a String
	 * @return String de la data
	 */
	protected String dataToString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
		String s = sdf.format(data);
		return s;
	}
	
	/**
	 * Posa un Diputat a la llista de Diputats relacionats amb els Esdeveniments
	 * @param d: Diputat a afegir a la llista
	 */
	public void afegirDiputat(Diputat d) {
		if(!diputats.contains(d)) diputats.add(d);
	}
	
	/**
	 * Retorna la llista de Diputats relacionats amb els Esdeveniments
	 */
	public ArrayList<Diputat> getDiputats() {
		return diputats;
	}
	
	/**
	 * @return Map amb relacio Diputat-Vot per les Votacions
	 */
	public Map<Diputat,Vot> getVots() {
		return vots;
	}
	
	/**
	 * Pre: -
	 * @param dips: Llista de diputats
	 * Post: La llista de diputats que participen en aquest Esdeveniment passa a ser la que
	 * rebem per parametre.
	 */
	public void setDiputats(ArrayList<Diputat> dips) {
		diputats = dips;
	}
	/**
	 * Pre: -
	 * @param nom: Nom del diputat a donar de baixa
	 * @throws Exception
	 * Post: El diputat amb nom nom deixa de participar a l'esdeveniment
	 */
	public void baixaDiputat(String nom) throws Exception { }
}