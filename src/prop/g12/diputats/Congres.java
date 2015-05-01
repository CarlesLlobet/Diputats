package prop.g12.diputats;

import java.util.*;

import prop.g12.common.Graf;

public class Congres {

	private ArrayList<Diputat> congres;
	private Graf<Diputat> graf;
	
	public Congres() {}
	
	public ArrayList<Diputat> getCongres() {return congres;};
	
	public void setCongres(ArrayList<Diputat> congres) {this.congres = congres;}
	
	
	public void altaDiputat(Diputat d) { 
		if(!congres.contains(d)) congres.add(d);
	}
	
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
	
	public void baixaDiputat(String nom) {
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
        if (!find) System.out.print("No existeix el diputat amb nom"+ nom);
	}
	
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
	
	private void afinitatProcedencia(int i, int j, double a) {
		Diputat d1 = congres.get(i);
		Diputat d2 = congres.get(j);
		if(d1.getProcedencia().equals(d2.getProcedencia())) a += 0.1;
		else a -= 0.1;
	}
	
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