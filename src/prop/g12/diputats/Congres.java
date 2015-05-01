package prop.g12.diputats;

import java.util.*;

import prop.g12.common.Graf;

public class Congres {

	/**
	 * Llista amb els diputats que conformen el congrés que representa el nostre projecte.
	 */
	private ArrayList<Diputat> congres;
	
	/**
	 * Graf que representa les afinitats entre els diputats del congrés.
	 */
	private Graf<Diputat> graf;
	
	
	
	/**
	 * Creadora de la classe Congrés
	 * Pre: -
	 * Post: Crea una instància buida de la classe Congrés.
	 */
	public Congres() {}
	
	/**
	 * Pre: -
	 * Post: Retorna la llista que conté tots els diputats del congrés.
	 */
	public ArrayList<Diputat> getCongres() {return congres;};
		
	/**
	 * Pre: -
	 * @param congres: Llista de diputats
	 * Post: Assigna a la llista congres de l'instància el paràmetre congres.
	 */
	public void setCongres(ArrayList<Diputat> congres) {this.congres = congres;}
	
	/**
	 * Pre: -
	 * @param d: Diputat que volem afegir al congres.
	 * @throws Exception
	 * Post: Afegeix el diputat d al congres en cas que aquest no hi sigui.
	 * 		 Si el diputat ja hi és, retorna una excepció.
	 */
	public void altaDiputat(Diputat d) throws Exception{ 
		if(!congres.contains(d)) congres.add(d);
		else throw new Exception("El diputat ja existeix");
	}
	
	/**
	 * Pre: -
	 * @param nom: Nom del diputat a cercar dins la llista.
	 * @throws Exception
	 * Post: Retorna del diputat amb nom nom en cas que el trobi al congres.
	 * 		 En cas contrari, retorna una excepció.
	 */
	public Diputat cercaDiputat(String nom) throws Exception {
		Diputat dip = new Diputat();
		boolean find = false;
		for(int i = 0; i < congres.size() && !find; i++) {
            dip = congres.get(i);
            if ((dip.getNom()).equals(nom)) find = true;
		}
		if(!find) throw new Exception("El diputat no existeix");
		else return dip;		
	}
	
	/**
	 * Pre: -
	 * @param nom: Nom del diputat a donar de baixa.
	 * @throws Exception
	 * Post: Elimina el diputat amb nom nom del congres i elimina la seva instancia de la
	 * 		 llista de diputats que té l'empresa en la qual treballava, ambdues coses sempre
	 * 		 que trobi el diputat al congrés.
	 * 		 En cas contrari, retorna una excepció.
	 */
	public void baixaDiputat(String nom) throws Exception {
        boolean find = false;
        for(int i = 0; i < congres.size() && !find; i++) {
            Diputat dip = congres.get(i);
            if ((dip.getNom()).equals(nom)) {
            	congres.remove(i);
            	find = true;
            	Empresa e = dip.getEmpresa();
        		ArrayList<Diputat> dips = e.getDiputats();
        		boolean find2 = false;
        		for(int j = 0; j < dips.size() && !find2; j++) {
        			if(dips.get(j).getNom().equals(nom)) {
        				dips.remove(j);
        				find2 = true;
        			}
        		}
            }
        }
        if (!find) throw new Exception("No existeix el diputat amb nom "+ nom);
	}
	
	/**
	 * Pre: -
	 * @param i: Posicio dins el congres del primer diputat.
	 * @param j: Posicio dins el congres del segon diputat.
	 * @param a: Valor de l'afinitat entre els diputats calculada previament.
	 * Post: Calcula l'afinitat que hi ha entre els diputats de les posicions i i j segons
	 * 	 	 les empreses on treballen.
	 */
	private void afinitatEmpresa(int i, int j, double a) {
		Diputat d1 = congres.get(i);
		Diputat d2 = congres.get(j);
		Empresa e1 = d1.getEmpresa();
		Empresa e2 = d2.getEmpresa();
		if(e1.getNom().equals(e2.getNom())) {
			a += 0.3;
		}
		else if(e1.getAmbit().equals(e2.getAmbit())) {
			a += 0.1;
		}
		else a -= 0.1;		
	}
	
	/**
	 * Pre: -
	 * @param i: Posicio dins el congres del primer diputat.
	 * @param j: Posicio dins el congres del segon diputat.
	 * @param a: Valor de l'afinitat entre els diputats calculada previament.
	 * Post: Calcula l'afinitat que hi ha entre els diputats de les posicions i i j segons
	 * 	 	 les seves ideologies.
	 */
	private void afinitatIdeologia(int i, int j, double a) {
		Diputat d1 = congres.get(i);
		Diputat d2 = congres.get(j);
		TIdeologia i1 = d1.getIdeologia();
		TIdeologia i2 = d2.getIdeologia();
		if(i1.equals(i2)) a += 0.2;
		else if(i1.equals(TIdeologia.centre) && (i2.equals(TIdeologia.esquerra) || i2.equals(TIdeologia.dreta))) a -= 0.1;
		else if(i2.equals(TIdeologia.centre) && (i1.equals(TIdeologia.esquerra) || i1.equals(TIdeologia.dreta))) a -= 0.1;
		else if(i1.equals(TIdeologia.dreta) && i2.equals(TIdeologia.esquerra)) a -= 0.2;
		else if(i2.equals(TIdeologia.dreta) && i1.equals(TIdeologia.esquerra)) a -= 0.2;
	}
	
	/**
	 * Pre: -
	 * @param i: Posicio dins el congres del primer diputat.
	 * @param j: Posicio dins el congres del segon diputat.
	 * @param a: Valor de l'afinitat entre els diputats calculada previament.
	 * Post: Calcula l'afinitat que hi ha entre els diputats de les posicions i i j segons
	 * 	 	 la seva procedencia.
	 */
	private void afinitatProcedencia(int i, int j, double a) {
		Diputat d1 = congres.get(i);
		Diputat d2 = congres.get(j);
		if(d1.getProcedencia().equals(d2.getProcedencia())) a += 0.1;
		else a -= 0.1;
	}
	
	/**
	 * Pre: -
	 * @param i: Posicio dins el congres del primer diputat.
	 * @param j: Posicio dins el congres del segon diputat.
	 * @param a: Valor de l'afinitat entre els diputats calculada previament.
	 * Post: Calcula l'afinitat que hi ha entre els diputats de les posicions i i j segons
	 * 	 	 els esdeveniments que atenen.
	 */
	private void afinitatEsdeveniment(int i, int j, double a) {
		Diputat d1 = congres.get(i);
		Diputat d2 = congres.get(j);
		ArrayList<Esdeveniment> e1 = d1.getEsdeveniments();
		ArrayList<Esdeveniment> e2 = d2.getEsdeveniments();
		ArrayList<Esdeveniment> inter = new ArrayList<Esdeveniment>(e1);
		inter.retainAll(e2);
		for(int k = 0; k < inter.size(); k++) {
			Esdeveniment esd = inter.get(k);
			if(esd.getClass().getName().equals("Votacio")) {
				Votacio votacio = new Votacio(esd);
				TVot v1 = votacio.getVots().get(d1).getVot();
				TVot v2 = votacio.getVots().get(d2).getVot();
				if(v1.equals(v2)) {
					if(!(v1.equals(TVot.abstencio))) a += 0.3;
				}
				else if((v1.equals(TVot.favor) && v2.equals(TVot.abstencio)) || (v2.equals(TVot.favor) && v1.equals(TVot.abstencio))) a -= 0.2;
				else if((v1.equals(TVot.contra) && v2.equals(TVot.abstencio)) || (v2.equals(TVot.contra) && v1.equals(TVot.abstencio))) a -= 0.2;
				else if((v1.equals(TVot.favor) && v2.equals(TVot.contra)) || (v2.equals(TVot.favor) && v1.equals(TVot.contra))) a -= 0.3;
			}
			else a += 0.1;
		}
		Set<Esdeveniment> diff = new HashSet<Esdeveniment>();
		HashSet<Esdeveniment> set1 = new HashSet<Esdeveniment>(e1);
		HashSet<Esdeveniment> set2 = new HashSet<Esdeveniment>(e2);
		diff.addAll(set1);
		diff.addAll(set2);
		diff.removeAll(inter);
		double x = diff.size()*0.1;
		a -= x;
	}
	
	/**
	 * Pre: -
	 * @throws Exception
	 * Post: Calcula l'afinitat que hi ha entre tots els parells de diputats del congres
	 * 	 	 tenint en compte diversos aspectes, tractats individualment amb la crida d'altres
	 * 		 funcions.
	 * 		 Un cop calculada cadascuna de les afinitats les afegeix a la matriu d'adjacencia
	 * 		 del graf de diputats que fa servir. 
	 */
	public void calculAfinitat() throws Exception {
		graf.crearGraf(congres.size());
		congres = graf.getNodes();
		for (int i = 0; i < congres.size(); i++) {			
			for(int j = i; j < congres.size(); j++) {
				if(i != j) {
					double a = 0.0;
					afinitatEmpresa(i, j, a);
					afinitatIdeologia(i, j, a);
					afinitatProcedencia(i, j, a);
					afinitatEsdeveniment(i, j, a);
					graf.afegirAresta(i, j, a);
				}				
			}
		}
	}
}