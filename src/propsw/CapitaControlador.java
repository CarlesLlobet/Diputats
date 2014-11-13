package propsw;

//@author Toni Mart�nez

import java.lang.String;
import java.util.ArrayList;
import java.util.Iterator;


public class CapitaControlador {
	
	//Contenidor de capitans
	private ContenidorCapitans contCap;
	//id del capita que ha iniciat la sessio
	private String idCap = "";


	public CapitaControlador(){
		contCap = new ContenidorCapitans();
	}
	
	//M�tode per implementar de moment implementaci� trivial
	//Ha de chekejar si el username i el password pertanyen a un capit�. Aquesta
	//informaci� estar� en un fitxer. Per fer aquesta implementaci� es necessita
	//tenir acc�s a la capa de dades que no est� implementada en aquesta versi�.
	public void login(String nom, String password) {
		Capita c = new Capita("Luke Skywalker");
		contCap.addCapita(c);
		idCap = c.getId();
	}

	
	//Get galaxia d'un capit� en concret.
	public Galaxia getGalaxia(String idCapita) {
		return contCap.getCapita(idCapita).getGalaxia();
	}
	//Get galaxia del capit� que ha iniciat sessi�
	public Galaxia getGalaxia() {
		return contCap.getCapita(idCap).getGalaxia();
	}

	//Llista de tots els rebels que estan sota les ordres d'un capita
	public ArrayList<Rebel> llistarRebels(String idCapita) {
		return new ArrayList<Rebel>(contCap.getCapita(idCapita).getRebels().values());
	}
	
	//Llista tots els rebels que estan sota les ordres del capita que ha iniciat la sessi�
	public ArrayList<Rebel> llistarRebels() {
		return new ArrayList<Rebel>(contCap.getCapita(idCap).getRebels().values());
	}

	//Crear un rebel a les ordres del capita que ha iniciat sessi�
	public void crearRebel(String nomRebel) {
		Rebel r = new Rebel(nomRebel);
		contCap.getCapita(idCap).getRebels().put(r.getId(), r);
	}
	
	//Crear un rebel a les ordres d'un capit�
	public void crearRebel(String nomRebel, String idCapita) {
		Rebel r = new Rebel(nomRebel);
		contCap.getCapita(idCapita).getRebels().put(r.getId(), r);
	}

	//Retorna l'objecte Rebel a les ordres del capit� que ha iniciat sessi�
	//que t� el idRebel passat per parametre. Retorna null si aquell rebel no existeix
	//o si que existeix pero no est� a les ordres del capita que ha iniciat la sessi�.
	public Rebel getRebel(String idRebel) {
		return contCap.getCapita(idCap).getRebels().get(idRebel);
	}
	
	//Retorna l'objecte Rebel a les ordres del capit� que ha iniciat sessi�
	//que t� el idRebel passat per parametre. Retorna null si aquell rebel no existeix
	//o si que existeix pero no est� a les ordres del capita que ha iniciat la sessi�.
	public Rebel getRebel(String idRebel, String idCapita) {
		return contCap.getCapita(idCap).getRebels().get(idRebel);
	}

	
	//Crear un exode a la galaxia que cont� el capit� que ha iniciat la sessi�
	public void crearExode(int idBaseInici) {
		Exode e = new Exode();
		e.setidBaseInici(idBaseInici); 								//Posem la base d'inici, on comen�a l'�xode
		getGalaxia().addExode(e);									//Assignem l'�xode a la galaxia del capit� que ha inicat sessi�
	}

	//Crear un exode a la galaxia que cont� un capit� en concret
	public void crearExode(int idBaseInici, String idCapita) {
		Exode e = new Exode();
		e.setidBaseInici(idBaseInici); 									//Posem la base d'inici, on comen�a l'�xode
		getGalaxia(idCapita).addExode(e);								//Assignem l'�xode a la galaxia del capit�.
	}

	
	//Elimina un rebel dels assignats a un capit�. L'elimina tb de tots els �xodes als que ha estat afegit. 
	//Retorna false si aquell rebel no ha estat assignat al capita que ha iniciat sessi� 
	public boolean eliminarRebel(String idRebel) {
		Rebel j = contCap.getCapita(idCap).getRebels().remove(idRebel);		//M�tode remove de un hashmap retorna null 
																			//si no hi ha cap Rebel associat amb el seu id
		if((j!=null)){
			ArrayList<String> exodes = getGalaxia(idCap).getExodes();									
			int size = exodes.size();
			//Per a cada exode de la galaxia es borra el rebel que tenia assignat.
			for (int i = 0; i < size; i++) {
				getGalaxia(idCap).getExode(exodes.get(i)).getrebels().remove(j);
			}
			
		}
		
		return (j!=null);
	}
	
	
	//Elimina un rebel dels assignats a un capit�. L'elimina tb de tots els �xodes als que ha estat afegit. 
	//Retorna false si aquell rebel no ha estat assignat al capita que ha iniciat sessi� 
	public boolean eliminarRebel(String idRebel, String idCapita) {
		Rebel j = contCap.getCapita(idCapita).getRebels().remove(idRebel);		//M�tode remove de un hashmap retorna null 
																				//si no hi ha cap Rebel associat amb el seu id
		if((j!=null)){
			ArrayList<String> exodes = getGalaxia(idCapita).getExodes();									
			int size = exodes.size();
			//Per a cada exode de la galaxia es borra el rebel que tenia assignat.
			for (int i = 0; i < size; i++) {
				getGalaxia(idCapita).getExode(exodes.get(i)).getrebels().remove(j);
			}
		}
		
		return (j!=null);
	}
	

	//Elimina l' �xode de la galaxia del capita que ha iniciat la sessi� i actualitza el llistat  
	//de exodes de cada rebel que estaba assignat a l'�xode.
	public boolean eliminarExode(String idExode) {
		
		//Per a cada rebel se li elimina el exode si el tenia assignat
		Exode e = getGalaxia().getExode(idExode);
		if(e!=null){
			ArrayList<Rebel> laTropa = e.getrebels();
			int size = getGalaxia().getExode(idExode).getrebels().size();
			for (int i = 0; i < size; i++) {
				laTropa.get(i).getExodes().remove(idExode);							
			}
			
			getGalaxia().removeExode(idExode);								//Eliminem l'exode de la galaxia del capita que ha iniciat la sessi�
			return true;
		}else{
			return false;
		}
	}

	
	//Elimina l' �xode de la galaxia del capita que ha iniciat la sessi� i actualitza el llistat 
	//de exodes de cada rebel que estaba assignat a l'�xode.
	public boolean eliminarExode(String idExode, String idCapita) {
		
		//Per a cada rebel se li elimina el exode si el tenia assignat
		Exode e = getGalaxia(idCapita).getExode(idExode);
		if(e!=null){
			ArrayList<Rebel> laTropa = e.getrebels();
			int size = getGalaxia(idCapita).getExode(idExode).getrebels().size();
			for (int i = 0; i < size; i++) {
				laTropa.get(i).getExodes().remove(idExode);						
			}
			
			getGalaxia().removeExode(idExode);								//Eliminem l'exode de la galaxia del capita que ha iniciat la sessi�
			return true;
		}else{
			return false;
		}
	}

	//Retorna l'objecte Capita que t� l'identificador idCapita.
	public Capita getCapita(String idCapita) {
		return contCap.getCapita(idCapita);
	}

	//Retorna l'objecte Capita del capita que ha inicat la sessi�.
	public Capita getCapita() {
		return contCap.getCapita(idCap);
	}
}