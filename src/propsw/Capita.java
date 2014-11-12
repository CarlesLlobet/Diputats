//@Autor: Marcos P�rez

package propsw;

import java.util.HashMap;

public class Capita {

	private static Integer cont = 0;
	private String id;
	private String pass = "admin";
	private Galaxia gal;
	private String nom;
	private HashMap<String,Rebel> ContReb;
	
	public Capita(){
		++cont;
		this.id = cont.toString();
		this.nom = null;
		this.ContReb = new HashMap<String,Rebel>();
		this.gal = new Galaxia();
	}
	
	public Capita(String nom){
		//pre: id es �nic
		//post: Es crea un capit� per defecte amb id: cont i contrasenya: admin
		++cont;
		this.id = cont.toString();
		this.nom = nom;
		this.ContReb = new HashMap<String,Rebel>();
		this.gal = new Galaxia();
	}
	
	
	//SETTERS
	public boolean setPassword(String pass){
		//pre: 
		//post: La contrasenya associada al capit� s'ha canviat al valor de pass
		this.pass = pass;
		return true;
	}
	
	public boolean setNom(String nom){
		this.nom = nom;
		return true;
	}

	
	//cal?
	public boolean setRebels(HashMap<String,Rebel> cr){
		//pre: Les dades a cr s�n consistents amb les que hi ha a ContReb
		//post: cr s'inserta a ContReb
		this.ContReb = cr;
		return true;
	}
	
	public boolean setGalaxia(Galaxia g){
		//pre:
		//post: Es sobreescriu gal amb g
		this.gal = g;
		return true;
	}
		
	//GETTERS
	
	
	public String getId(){
		//pre: 
		//post: es retorna l'id del capita
		return this.id;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	
	//cal?
	public HashMap<String,Rebel> getRebels(){
		//pre:
		//post: Es retorna el hashmap ContReb
		return this.ContReb;
	}
	
	
	
	public Galaxia getGalaxia(){
		//pre:
		//post: Es retorna la galaxia
		return this.gal;
	}
	

	
}
