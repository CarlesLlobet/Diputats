/*
 * Autor: Marcos P�rez
 * Grup 44 - 9.1
 */

package propsw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Galaxia extends Graf<Base>{
	private static Integer cont = 0;
	private String id;
	
	private HashMap<String,Exode> exodes;
	private Capita capita;
	
	private boolean checkExode(String id){
		//retorna true si hi ha un exode amb aquesta id, false altrament
		return exodes.containsKey(id);
	}
	
	//Constructor inicialitza les variables buides	
		public Galaxia(Capita c){
			++cont;
			this.id = cont.toString();
			this.exodes = new HashMap<String,Exode>();
			capita = c;
			
		}
	
		public Capita getCapita() {
			return capita;
		}

		//Possiblement prescindible?
		public void setCapita(Capita capita) {
			this.capita = capita;
		}

		public String getId(){
			return this.id;
		}

		//M�todes de control de les coleccions		
		//Afegeix un �xode a la galaxia
		public boolean addExode(Exode e){
			this.exodes.put(e.getIdExode(), e);
			return true;
			//operacio getId() a la classe exode
		}
		
		//Retorna un �xode abans guardat en la galaxia que t� assignat el ID en especial
		public Exode getExode(String s) {
			return this.exodes.get(s);
		}

		//Elimina un �xode abans guardat en la galaxia que t� assignat el ID en especial. Retorna el Exode eliminat
		public Exode removeExode(String s) throws IOException{
			if(! checkExode(s)) 
	    		throw new IOException("El exode no existeix.");
			else {
				Exode e = this.exodes.get(s);
				this.exodes.remove(s);
				return e;
			}
		}
	
		//Elimina una Base abans guardat en la galaxia que t� assignat el ID en especial. Retorna la Base eliminada
		public Base removeBase(int id) throws IOException{
			Base b = getNode(id);
			removeNode(id);
			return b;
		}

		//Retorna una Base abans guardada en la galaxia que t� assignada el ID en especial
		public Base getBase(int id) throws IOException{
			return this.getNode(id);
		}

		public int getBaseId(Base b) throws IOException{
			return getNodeId(b);
		}

		public HashMap<String,Exode> getExodesHash(){
			return this.exodes;
		}
		
		public ArrayList<Base> getBaseArray() throws IOException{
			ArrayList<Base> ab = new ArrayList<Base>();
			for (int i =0 ; i < this.getNSize(); ++i){
				ab.add(i,this.getNode(i));
			}
			return ab;
		}
		
		public ArrayList<String> getExodes(){
			return new ArrayList<String>(exodes.keySet());
		}

		
}