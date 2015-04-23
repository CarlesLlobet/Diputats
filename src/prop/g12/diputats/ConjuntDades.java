package prop.g12.diputats;

import java.util.ArrayList;

public class ConjuntDades {
	private ArrayList<Diputat> diputats;
	private ArrayList<Empresa> empreses;
	private ArrayList<Vot> vots;
	
	public ArrayList<Diputat> getDiputats() {return diputats;}
	
	public void setDiputats(ArrayList<Diputat> diputats) {this.diputats = diputats;}

	public ArrayList<Empresa> getEmpreses() {return empreses;}

	public void setEmpreses(ArrayList<Empresa> empreses) {this.empreses = empreses;}

	public ArrayList<Vot> getVots() {return vots;}

	public void setVots(ArrayList<Vot> vots) {this.vots = vots;}
	
	private static final ConjuntDades conjuntDades = new ConjuntDades();
	
	public static ConjuntDades getInstance() {return conjuntDades;}
	
	public void afegirDiputat(Diputat d) {diputats.add(d);}
	
	public void afegirEmpresa(Empresa e) {empreses.add(e);}
	
	public void afegirVot(Vot v) {vots.add(v);}	
	
	//per accedir a les dades, des de la classe que sigui:
	//(per exemple)
	//ConjuntDades c = ConjuntDades.getInstance();
	//ArrayList<Diputat> d = ConjuntDades.getInstance().getDiputats();

}
