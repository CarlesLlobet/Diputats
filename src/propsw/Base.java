/*
 * @Author: Marcos P�rez Rubio
 * Grup 44 - 9.1
 */


package propsw;

import java.io.IOException;

public class Base {
	
	//Nom de la base
	private String nom = null;
	
	//Galaxia a la qual esta associada la base
	private Galaxia g;
	
	/**
	 * Constructor d'un objecte Capita.
	 * @param g Galaxia a la que pertany
	 */
	public Base(Galaxia g) throws IOException{
		this.g = g;
		g.afegirNode(this);
	}

	/**
	 * Constructor d'un objecte Capita.
	 * @param nom Nom de la base
	 * @param g Galaxia a la que pertany
	 * @throws IOException
	 */
	public Base(String nom, Galaxia g) throws IOException{
		this.nom = nom;
		this.g = g;
		g.afegirNode(this);
	}
	

	/**
	 * Consulta el nom de la base.
	 * @return Retorna el nom de la base
	 */
	public String getNom(){
		return this.nom;
	}
	

	/**
	 * Canvia el nom de la base
	 * @param nom Nom de la base
	 */
	public boolean setNom(String nom){
		this.nom=nom;
		return true;
	}


	/**
	 * Prepara un string amb la informacio de la base
	 * @return Retorna un string que correspon a la informacio de la base.
	 */
	@Override
	public String toString() {
		String res = new String();
		try {
			 res = nom + "\t-\t" + Integer.toString(getId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * Consulta la id de la base
	 * @return Retorna la id de la base
	 * @throws IOException
	 */
	public int getId() throws IOException{
		int toRet=-1;
		for (int i = 0; i < g.getNSize(); i++) {
			if(g.getNode(i)==this){
				toRet = i;
			}
		}
		return toRet;
	}
	
}
