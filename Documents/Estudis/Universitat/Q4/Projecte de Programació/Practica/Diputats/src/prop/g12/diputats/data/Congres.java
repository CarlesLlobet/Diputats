package prop.g12.diputats.data;

import java.util.ArrayList;

import prop.g12.common.Graf;

public class Congres {
	
	/**
	 * Instancia del congres
	 */	
	private static Congres congres = new Congres();
	
	/**Pre -
	 * @return: Retorna la instancia del congres
	 */
	public static Congres getInstance() {
		return congres;
	}

	/**
	 * Llista amb els diputats que conformen el congrés que representa el nostre projecte.
	 */
	private static ArrayList<Diputat> diputats;
	
	/**
	 * Llistat d'esdeveniments
	 */
	private static ArrayList<Esdeveniment> esdeveniments;
	
	/**
	 * Llistat d'empreses
	 */
	private static ArrayList<Empresa> empreses;
	
	/**
	 * Graf que representa el congres
	 */
	private static Graf<Diputat> graf;
	
	
	/**
	 * Creadora de la classe Congres
	 * Pre: -
	 * Post: Crea una instància buida de la classe Congres.
	 */
	public Congres() {
		diputats = new ArrayList<Diputat>();
		esdeveniments = new ArrayList<Esdeveniment>();
		empreses = new ArrayList<Empresa>();
	}
	
	/**
	 * Pre: -
	 * Post: Retorna la llista que conte tots els diputats del congres.
	 */
	public static ArrayList<Diputat> getCongres() {return diputats;}
	
	/**
	 * Pre: -
	 * Post: Retorna la llista que conté tots els esdeveniments del congrés.
	 */
	public static ArrayList<Esdeveniment> getEsdeveniments() {return esdeveniments;}
	
	/**
	 * Pre: -
	 * Post: Retorna la llista que conté totes les empreses del congrés.
	 */
	public static ArrayList<Empresa> getEmpreses() {return empreses;}
		
	/**
	 * Pre: -
	 * @param dips: Nova llista de diputats
	 * Post: Assigna a la llista de diputats el parametre dips
	 */
	public static void setDiputats(ArrayList<Diputat> dips) {diputats = dips;}
	
	/**
	 * Pre: -
	 * @param empr: Nova llista d'empreses
	 * Post: Assigna a la llista d'empreses el parametre empr
	 */
	public static void setEmpreses(ArrayList<Empresa> empr) {empreses = empr;}
	
	/**
	 * Pre: -
	 * @param dips: Nova llista d'esdeveniments
	 * Post: Assigna a la llista d'esdeveniments el parametre esdv
	 */
	public static void setEsdeveniments(ArrayList<Esdeveniment> esdv) {esdeveniments = esdv;}
	
	/**
	 * Pre: -
	 * @return: Retorna el nombre de diputats del congres
	 */
	public static int getNumDiputats() {
		return diputats.size();
	}
	
	/**
	 * 
	 * @return la instancia del graf del congres
	 */
	public static Graf<Diputat> getGraf() {
		return graf;
	}
	
	/**
	 * Pre:-
	 * @param graf: nou graf del congres
	 * Post: Assigna el graf al congres
	 */
	public static void setGraf(Graf<Diputat> g) {
		graf = g;
	}
	
	/**
	 * Pre: -
	 * @param diputat: Diputat que volem afegir al congres.
	 * @throws Exception
	 * Post: Afegeix el diputat diputat al congres en cas que aquest no hi sigui.
	 * 		 Si el diputat ja hi és, retorna una excepció.
	 */
	public static void altaDiputat(Diputat diputat) throws Exception { 
		if(!diputats.contains(diputat)) diputats.add(diputat);
		else throw new Exception("El diputat ja existeix");
	}
	
	/**
	 * Pre: -
	 * @param Empresa: empresa a donar d'alta al congres
	 * Post: En cas que l'empresa empresa no existeixi al congres, l'afegeix
	 */
	public static void altaEmpresa(Empresa empresa) {
		if(!empreses.contains(empresa)) empreses.add(empresa);
	}
	
	/**
	 * Pre: -
	 * @param conferencia: Conferencia a afegir al llistat d'esdeveniments
	 * Post: Afegeix la conferencia al llistat d'esdeveniments en cas que no hi fos
	 */
	/*public static void altaConferencia(Conferencia conferencia) {
		if(!esdeveniments.contains(conferencia)) esdeveniments.add(conferencia);		
	}*/
	
	/**
	 * Pre: -
	 * @param votacio: Votacio a afegir al llistat d'esdeveniments
	 * Post: Afegeix la votacio al llistat d'esdeveniments en cas que no hi fos
	 */
	/*public static void altaVotacio(Votacio votacio) {
		if(!esdeveniments.contains(votacio)) esdeveniments.add(votacio);		
	}*/
	
	/**
	 * Pre: -
	 * @param reunio: Reunio a afegir al llistat d'esdeveniments
	 * Post: Afegeix la reunio al llistat d'esdeveniments en cas que no hi fos
	 */
	/*public static void altaReunio(Reunio reunio) {
		if(!esdeveniments.contains(reunio)) esdeveniments.add(reunio);		
	}*/
	
	public static void altaEsdeveniment(Esdeveniment esdeveniment) {
		if(!esdeveniments.contains(esdeveniment)) esdeveniments.add(esdeveniment);
	}
	
	/**
	 * Pre: El diputat amb nom nom es al congres
	 * @param nom: Nom del diputat a cercar dins la llista.
	 * @throws Exception
	 * @return: Diputat amb nom nom
	 */
	public static Diputat cercaDiputat(String nom) {
		Diputat diputat = null;
		boolean find = false;
		for(int i = 0; i < diputats.size() && !find; i++) {
            diputat = diputats.get(i);
            if ((diputat.getNom()).equals(nom)) find = true;
		}
		if(find) return diputat;
		else return null;
	}
	
	/**
	 * Pre: L'esdeveniment amb codi codi es al congres
	 * @param codi: Codi de l'esdeveniment a buscar dins la llista d'esdeveniments.
	 * @return: Retorna l'esdeveniment amb codi codi.
	 */
	public static Esdeveniment cercaEsdeveniment(int codi) {
		Esdeveniment esdeveniment = null;
		boolean find = false;
		for(int i = 0; i < esdeveniments.size() && !find; i++) {
			esdeveniment = esdeveniments.get(i);
			if ((esdeveniment.getCodi() == codi)) find = true;
		}
		if(find) return esdeveniment;
		else return null;
	}
	
	/**
	 * Pre: -
	 * @param nom: Nom de l'empresa a buscar dins la llista d'empreses.
	 * @throws Exception
	 * Post: Retorna l'empresa amb nom nom en cas que aquest es trobi
	 * 		 dins la llista d'empreses del congres.
	 * 		 En cas contrari, retorna una excepcio.
	 */
	public static Empresa cercaEmpresa(String nom) throws Exception {
		Empresa empresa = new Empresa();
		boolean find = false;
		for(int i = 0; i < empreses.size() && !find; i++) {
            empresa = empreses.get(i);
            if ((empresa.getNom()).equals(nom)) find = true;
		}
		if(!find) throw new Exception("El diputat no existeix");
		else return empresa;		
	}
	
	/**
	 * Pre: -
	 * @param nom: Nom del diputat a donar de baixa.
	 * @throws Exception
	 * Post: Elimina el diputat amb nom nom del congres sempre que el trobi
	 * 		 a la llista de diputats. 
	 * 		 En cas contrari, retorna una excepció.
	 */
	public static void baixaDiputat(String nom) throws Exception {
		boolean find = false;
        for(int i = 0; i < diputats.size() && !find; i++) {
            Diputat diputat = diputats.get(i);
            if ((diputat.getNom()).equals(nom)) {
            	diputats.remove(i);
            	find = true;
            }
        }
        if (!find) throw new Exception("No existeix el diputat " + nom);
	}
	
	/**
	 * Pre: -
	 * @param nom: Nom de l'empresa a donar de baixa.
	 * @throws Exception
	 * Post: Elimina l'empresa amb nom nom del congres sempre que la trobi
	 * 		 a la llista d'empreses. 
	 * 		 En cas contrari, retorna una excepció.
	 */
	public static void baixaEmpresa(String nom) throws Exception {
		boolean find = false;
        for(int i = 0; i < empreses.size() && !find; i++) {
            Empresa empresa = empreses.get(i);
            if ((empresa.getNom()).equals(nom)) {
            	diputats.remove(i);
            	find = true;
            }
        }
        if (!find) throw new Exception("No existeix l'empresa " + nom);
	}
	/**Pre: -
	 * @param codi: Codi de l'esdeveniment a donar de baixa
	 * @throws Exception
	 * Post: Elimina l'esdeveniment amb codi codi del congres sempre que el
	 * 		 trobi a la llista d'esdeveniments.
	 * 		 En cas contrari, retorna excepcio.
	 */
	public static void baixaEsdeveniment(int codi) throws Exception {
		boolean find = false;
        for(int i = 0; i < esdeveniments.size() && !find; i++) {
            Esdeveniment esdeveniment = esdeveniments.get(i);
            if (esdeveniment.getCodi() == codi) {
            	esdeveniments.remove(i);
            	find = true;
            }
        }
        if (!find) throw new Exception("No existeix l'esdeveniment amb codi " + codi);
	}
	
	/**
	 * Pre: -
	 * @param nom: Nom del diputat a buscar dins el congres
	 * @return: Retorna true si el troba al congres, i fals si no el troba
	*/
	public static boolean existeixDiputat(String nom) {
		boolean find = false;
		for(int i = 0; i < diputats.size() && !find; i++) {
            if (diputats.get(i).getNom().equals(nom)) find = true;
		}
		return find;
	}
	
	/**
	 * Pre: -
	 * @param nom: Nom de l'empresa a buscar dins el congres
	 * @return: Retorna true si la troba al congres, i fals si no la troba
	*/
	public static boolean existeixEmpresa(String nom) {
		boolean find = false;
		for(int i = 0; i < empreses.size() && !find; i++) {
            if (empreses.get(i).getNom().equals(nom)) find = true;
		}
		return find;
	}
	
	/**
	 * Pre: -
	 * @param codi: Codi de l'esdeveniment a buscar dins el congres
	 * @return: Retorna true si el troba al congres, i fals si no el troba
	*/
	public static boolean existeixEsdeveniment(int codi) {
		boolean find = false;
		for(int i = 0; i < esdeveniments.size() && !find; i++) {
            if (esdeveniments.get(i).getCodi() == codi) find = true;
		}
		return find;
	}


	
}