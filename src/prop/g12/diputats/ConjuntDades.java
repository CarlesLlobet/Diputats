package prop.g12.diputats;

import java.util.*;

public class ConjuntDades {
	private ArrayList<Diputat> diputats;
	private ArrayList<Empresa> empreses;
	private ArrayList<Vot> vots;
	private Map<Integer,Diputat> congres;
	
	public ArrayList<Diputat> getDiputats() {return diputats;}
	
	public void setDiputats(ArrayList<Diputat> diputats) {this.diputats = diputats;}

	public ArrayList<Empresa> getEmpreses() {return empreses;}

	public void setEmpreses(ArrayList<Empresa> empreses) {this.empreses = empreses;}

	public ArrayList<Vot> getVots() {return vots;}

	public void setVots(ArrayList<Vot> vots) {this.vots = vots;}
	
	public Map<Integer, Diputat> getCongres() {return congres;};
	
	public void setCongres(Map<Integer,Diputat> congres) {this.congres = congres;}
	
	private static final ConjuntDades conjuntDades = new ConjuntDades();
	
	public static ConjuntDades getInstance() {return conjuntDades;}
	
	/*Codi del Victor M.
	 * 
	 * public void Baixa_Congres(String nom) {
        java.util.Iterator<Integer> it = Congres.keySet().iterator();
        boolean find = false;
        while(it.hasNext() && !find){
            Integer K = it.next();
            Diputat dip = Congres.get(K);
            if ((dip.getNom()).equals(nom)) {Congres.remove(K); find = true;}
        }
        if (!find) {
        	System.out.print("No existeix el diputat amb nom"+ nom);
        }
	}*/
	
	//per accedir a les dades, des de la classe que sigui:
	//(per exemple)
	//ConjuntDades c = ConjuntDades.getInstance();
	//ArrayList<Diputat> d = ConjuntDades.getInstance().getDiputats();

}
