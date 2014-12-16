/*
 * @Author: Marc Ronquillo Gonz�lez
 * Grup 44 - 9.1
 */ 

package propsw;
import java.io.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;

public class GalaxiaControlador{
	
	CapitaControlador capiControl;
	
	/**
	 * Constructor d'un objecte GalaxiaControlador.
	 */
	public GalaxiaControlador(CapitaControlador capi){
		capiControl=capi;
	}
	
	
	/*
	/**
	 * Crea un objecte de la classe Galaxia.
	 * @return Objecte Galaxia instanciat
	 */
	/*
	public Galaxia createGalaxia() {
		new CapitaControlador();
		Galaxia g=new Galaxia(getCapita());
		return g;
	}   */

	/**
	 * Es borren tots els camps de l'objecte Galaxia actual.
	 * @return Objecte de la classe Galaxia resetejat
	 */
	public void resetGalaxia() {
		
		Galaxia g = new Galaxia(getCapita());
		getCapita().setGalaxia(g);
	
	}
	
	//AFEGIT
	public void resetGalaxia(String idCapi) {
		
		Galaxia g = new Galaxia(getCapita());
		capiControl.getCapita(idCapi).setGalaxia(g);
	}

	/**
	 * Afegeix una Base a la Galaxia
	 * @param nom nom de la Base afegida
	 * @throws IOException
	 */
	public void addBase(String nom) throws IOException{
		new Base(nom,getGalaxia());
	}
	
	//AFEGIT
	public void addBase(String nom, String idCap) throws IOException{
		new Base(capiControl.getGalaxia(idCap));
	}

	/**
	 * S'esborra la base amb la id indicada al par�metre
	 * @param idBase id de la Base a esborrar
	 * @return Boole� que indica si l'identificador de la base es correspon amb una base existent.
	 * @throws IOException si id no existeix
	 */
	public void deleteBase(int idBase) throws IOException{
		
			getGalaxia().removeBase(idBase);
		
	}

	/**
	 * Es canvia el nom a la Base indicada
	 * @param idBase identificador de la Base a editar
	 * @param nom Nou nom que prendr� la base
	 * @return Boole� que indica si l'identificador de la base es correspon amb una base existent.
	 * @throws IOException si id no existeix
	 */
	public void setBase(int idBase, String nom) throws IOException{
		
			getGalaxia().getBase(idBase).setNom(nom);
		
	}
	
	public void setBase(String idCapita, int idBase, String nom) throws IOException{
		
		capiControl.getGalaxia(idCapita).getBase(idBase).setNom(nom);
	
}

	/**
	 * Llistat de totes les bases de la Gal�xia
	 * @return String que cont� l'id i el nom de totes les bases de la Gal�xia actual.
	 * @throws IOException si id no existeix
	 */
	public String listBases() throws IOException{
		
		String str;
		ArrayList <Base> bases=getGalaxia().getBaseArray();
		str=bases.toString();
		return str;
	}
	
	public String getNomBase(String idCapita, int idBase) throws IOException{
		if(capiControl.getGalaxia(idCapita).getBase(idBase).getNom()==null)throw new IOException("La base no te nom");
		return capiControl.getGalaxia(idCapita).getBase(idBase).getNom();
	}

	/**
	 * Crea una aresta entre dues bases
	 * @param from identificador de la Base de la qual ha de partir l'adjac�ncia.
	 * @param to identificador de la Base a la qual ha d'anar a parar l'adjac�ncia.
	 * @param capacitat Valor de capacitat que prendr� 
	 * @param cost
	 * @throws IOException si id no existeix
	 */
	public void createAdjacency(int from, int to, int capacitat, double cost) throws IOException{
		
		getGalaxia().conectarNodes(from,to,capacitat,cost);
	}
	
	//AFEGIT
	public void createAdjacency(int from, int to, int capacitat, double cost, String idCapi) throws IOException{
		
		capiControl.getGalaxia(idCapi).conectarNodes(from,to,capacitat,cost);
	}
	
	/**
	 * Modifica els valors de cost i capacitat d'un tram entre dues bases.
	 * @param from identificador de la Base de la qual ha de partir l'adjac�ncia.
	 * @param to identificador de la Base a la qual ha d'anar a parar l'adjac�ncia.
	 * @param capacitat Valor actualitzat de capacitat del tram
	 * @param cost valor actualitzat de cost del tram 
	 * @throws IOException si id no existeix
	 */
	public void setAdjacency(int from, int to, int capacitat, double cost)throws IOException{
		
		int idAresta=getGalaxia().getIDAresta(from,to);
		getGalaxia().substituirAresta(idAresta, capacitat, cost);
	}

	/**
	 * S'elimina un tram entre dues bases.
	 * @param from identificador de la Base de la qual ha de partir l'adjac�ncia.
	 * @param to identificador de la Base a la qual ha d'anar a parar l'adjac�ncia.
	 * @throws IOException si id no existeix
	 */
	public void deleteAdjacencia(int from, int to) throws IOException{
		
		getGalaxia().removeAresta(from,to);
	}

	/**
	 * Retorna la aresta demanada del graf
	 * @param from identificador de la Base de la qual ha de partir l'adjac�ncia.
	 * @param to identificador de la Base a la qual ha d'anar a parar l'adjac�ncia.
	 * @return objecte aresta demanat
	 * @throws IOException si id no existeix
	 */
	public Galaxia.Aresta getAdjacency(int from, int to) throws IOException {
		
		int idAresta=getGalaxia().getIDAresta(from,to);
		int capacitat=getGalaxia().getCapacidadAresta(idAresta);
		double cost=getGalaxia().getCosteAresta(idAresta);
		int fluxe=getGalaxia().getFlujoAresta(idAresta);
		
		Galaxia.Aresta aresta= new Galaxia.Aresta(capacitat,cost);
		getGalaxia().setFlujoAresta(idAresta,fluxe);

		return aresta;
	}
	
	//AFEGIT
	public boolean existsAdjacency(int from, int to, String idCapi) {
		try {
			return capiControl.getGalaxia(idCapi).adjacents(from,to);
		} catch (IOException e) {
			return false;
		}
	}
	
	//AFEGIT
	public int getCapacitatAdjacency(int from, int to, String idCapi) throws IOException{
		int idAresta=capiControl.getGalaxia(idCapi).getIDAresta(from,to);
		return capiControl.getGalaxia(idCapi).getCapacidadAresta(idAresta);
	}
	
	//AFEGIT
	public double getCostAdjacency(int from, int to, String idCapi) throws IOException{
		int idAresta=capiControl.getGalaxia(idCapi).getIDAresta(from,to);
		return capiControl.getGalaxia(idCapi).getCosteAresta(idAresta);
	}
	
	/**
	 * 
	 *  Genera un ArrayList de les bases que hi ha a la galaxia
	 * @return ArrayList de les bases de la galaxia
	 * @throws IOException
	 */
	public ArrayList<Base> getBaseArray() throws IOException{
		return getGalaxia().getBaseArray();
	}
	
	//retorna un arraylist de string de les bases, ordenats
	public ArrayList<String> arrayBaseOrd() throws IOException{
		ArrayList<Base> bases = getBaseArray();
		ArrayList<String> toRet = new ArrayList<String>();
		ArrayList<Integer> aux = new ArrayList<Integer>();
		for(Base b : bases){
			aux.add(b.getId());
		}
		Collections.sort(aux);
		for (Integer i: aux){
			toRet.add(String.valueOf(i));
		}
		return toRet;
	}
	
	/**
	 * Llista els exodes existents per la Gal�xia
	 * @return un string amb els ids dels �xodes
	 */
	public String listExodes(){
		String sRet=getGalaxia().getExodes().toString();
		return sRet;
	}
	
	
	public Galaxia getGalaxia(){
		return capiControl.getGalaxia();
	}
	
	 
	public Capita getCapita(){
		return capiControl.getCapita();
	}
	
	
}
