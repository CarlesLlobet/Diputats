/*
 * Autor: Marcos P�rez
 * Grup 44 - 9.1
 */

package propsw;

public class Capita {

	private int id;
	private String pass = "admin";
	private Galaxia gal; 
	private ArrayList<Rebels> ContReb; //hashtable?
	
	public Capita(int id){
		//pre: el valor de id �s donat pel controlador principal
		//post: Es crea un capit� per defecte amb id: id i contrasenya: admin 
		this.id = id;
	}
	public int get_id(){
		//pre: 
		//post: es retorna l'id del capita
		return this.id;
	}
	
	public void set_password(String pass){
		//pre: 
		//post: La contrasenya associada al capit� s'ha canviat al valor de pass
		this.pass = pass;
	}
			
	//GalaxiaCtrl	
	public void associar_galaxia(Galaxia g){
		//pre: g �s una galaxia v�lida i les dades son consistents
		//post: gal = g
		this.gal = g;
	}
	
	public void exportar_galaxia(){
		//pre:
		//post:	gal �s exportada a un fitxer de text
	}
	
	public void esborrar_galaxia(){
		//pre:
		//post: el contingut de gal �s esborrat
		this.gal = new Galaxia();
	}
	
	public void afegir_rebel(Rebel r){
		//pre: r �s un Rebel v�lid
		//post: r �s insertat a ContReb
	}
	
	public void esborrar_rebel(int rebelId){
		//pre:
		//post: r �s esborrat de ContReb
	}
	
	public void llistar_rebels(){
		//pre: 
		//post: Es llisten tots els rebels que estan a ContReb
		
	}
	
	public void importar_rebels(ArrayList<Rebels> cr){
		//pre: cr �s un conjunt de de rebels consistents amb les dades que hi ha a ContReb
		//post: Es s'inserten a ContReb els rebels que hi ha cr
	}
	
	public void exportar_rebels(){
		//pre: 
		//post: S'exporten a un arxiu txt totes les dades dels rebels a ContReb
	}
}
