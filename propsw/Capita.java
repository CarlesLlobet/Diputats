/*
 * @Author: Marcos P�rez Rubio
 * Grup 44 - 9.1
 */

package propsw;

import java.io.Serializable;
import java.util.HashMap;

public class Capita implements Serializable{
	//Contador que s'utiltiza per assignar la id al capita
	private static Integer cont = 0;
	
	private Integer contador;
	
	//Id del capita
	private String id;
	
	//contrasenya del capit�
	private String pass = "admin";
	
	//Galaxia del capit�
	private Galaxia gal;
	
	//Nom del capit�
	private String nom;
	
	//HashMap que cont� tots els rebels del capit�: idRebel, Rebel
	private HashMap<String,Rebel> ContReb;
	
	/**
	 * Constructor d'un objecte Capita.
	 */
	public Capita(){
		++cont;
		this.id = cont.toString();
		this.nom = "admin";
		this.ContReb = new HashMap<String,Rebel>();
		this.gal = new Galaxia(this);
		setContador();
	}

	/**
	 * Constructor d'un objecte Capita amb el nom
	 * @param nom Nom assignat al capit�
	 */
	public Capita(String nom){
		++cont;
		this.id = cont.toString();
		this.nom = nom;
		this.ContReb = new HashMap<String,Rebel>();
		this.gal = new Galaxia(this);
		setContador();
	}

	/**
	 * Canvia la contrasenya del capit�
	 * @param pass Contrasenya que s'assigna al capita
	 * @return Retorna true al afegir la contrasenya
	 */
	public boolean setPassword(String pass){
		this.pass = pass;
		return true;
	}
	
	public String getPassword(){
		return pass;
		
	}
	
	/**
	 * Assigna un nom al capit�
	 * @param nom Nom que s'assigna al capit�
	 * @return Retorna true despr�s d'assignar el nom
	 */
	public boolean setNom(String nom){
		this.nom = nom;
		return true;
	}

	/**
	 * Substitueix el contenidor de rebels pel que es passa per par�metre
	 * @param cr Contenidor de rebels que s'assigna al capit�
	 * @return Retorna true despr�s d'assignar el contenidor de rebels
	 */
	public boolean setRebels(HashMap<String,Rebel> cr){
		this.ContReb = cr;
		return true;
	}

	/**
	 * Assigna una galaxia al capit�
	 * @param g Galaxia que s'ha d'assignar al capit�
	 * @return Retorna true despr�s d'assignar la galaxia al capita
	 */
	public boolean setGalaxia(Galaxia g){
		this.gal = g;
		return true;
	}
			
	/**
	 * Consulta la id del capit�
	 * @return Retorna la id del capit�
	 */
	public String getId(){
		return this.id;
	}
	
	/**
	 * Consulta el nom del capit�
	 * @return Retorna el nom del capit�
	 */
	public String getNom(){
		return this.nom;
	}
	
	/**
	 * Consulta el contenidor de rebels
	 * @return Retorna el HashMap Contenidor de rebels
	 */
	public HashMap<String,Rebel> getRebels(){
		return this.ContReb;
	}
	
	/**
	 * Consulta la galaxia del capit�
	 * @return Retorna la galaxia del capit�
	 */
	public Galaxia getGalaxia(){
		return this.gal;
	}
	
	/**
	 * Iguala el valor de la variable no est�tica contador al static cont
	 */
	public void setContador(){
		contador=cont;
	}
	
	/**
	 * Retorna la id del Capit� segons el contador no est�tic.
	 * @return String id del Capit�.
	 */
	public String getIdNoStatic(){
		return this.contador.toString();
	}
	
	/**
	 * Actualitza el contador de ids de Capitans.
	 * @param i valor enter al qual es posar� el contador de ids.
	 */
	public static void setCont(int i){
		cont=i;
	}
}
