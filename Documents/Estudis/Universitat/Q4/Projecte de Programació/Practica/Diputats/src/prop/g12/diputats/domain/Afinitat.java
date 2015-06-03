package prop.g12.diputats.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import prop.g12.diputats.data.Diputat;
import prop.g12.diputats.data.Empresa;
import prop.g12.diputats.data.Esdeveniment;
import prop.g12.diputats.data.TIdeologia;
import prop.g12.diputats.data.TVot;
import prop.g12.diputats.data.Votacio;

public class Afinitat {
	
	public Afinitat() {}
	
	/**
	 * Calcul d'afinitats entre dos diputats segons empresa
	 * @param diputat1: Primer diputat
	 * @param diputat2: Segon diputat
	 * @param percent: Percentatge d'importancia que es dona a l'afinitat
	 * @return: Afinitat segons les empreses
	 */
	private double afinitatEmpresa(Diputat diputat1, Diputat diputat2, double percent) {
		double afinitat = 0.0;
		Empresa empresa1 = diputat1.getEmpresa();
		Empresa empresa2 = diputat2.getEmpresa();
		if(empresa1 != null && empresa2 != null) {
			if(empresa1.getNom().equals(empresa2.getNom())) {
				afinitat += 0.8;
			}
			else if(empresa1.getAmbit().equals(empresa2.getAmbit())) {
				afinitat += 0.6;
			}
			else afinitat -= 0.4;
		}
		else afinitat -= 0.4;
		return afinitat * percent;
	}
	
	/**
	 * Calcul d'afinitats entre dos diputats segons ideologia
	 * @param diputat1: Primer diputat
	 * @param diputat2: Segon diputat
	 * @param percent: Percentatge d'importancia que es dona a l'afinitat
	 * @return: Afinitat segons les ideologies
	 */
	private double afinitatIdeologia(Diputat diputat1, Diputat diputat2, double percent) {
		double afinitat = 0.0;
		TIdeologia ideologia1 = diputat1.getIdeologia();
		TIdeologia ideologia2 = diputat2.getIdeologia();
		if(ideologia1.equals(ideologia2)) afinitat += 0.7;
		else if(ideologia1.equals(TIdeologia.centre) && (ideologia2.equals(TIdeologia.esquerra) || ideologia2.equals(TIdeologia.dreta))) afinitat -= 0.4;
		else if(ideologia2.equals(TIdeologia.centre) && (ideologia1.equals(TIdeologia.esquerra) || ideologia1.equals(TIdeologia.dreta))) afinitat -= 0.4;
		else if(ideologia1.equals(TIdeologia.dreta) && ideologia2.equals(TIdeologia.esquerra)) afinitat -= 0.5;
		else if(ideologia2.equals(TIdeologia.dreta) && ideologia1.equals(TIdeologia.esquerra)) afinitat -= 0.5;
		return afinitat * percent;
	}
	
	/**
	 * Calcul d'afinitats entre dos diputats segons procedencia
	 * @param diputat1: Primer diputat
	 * @param diputat2: Segon diputat
	 * @param percent: Percentatge d'importancia que es dona a l'afinitat
	 * @return: Afinitat segons les procedencies
	 */
	private double afinitatProcedencia(Diputat diputat1, Diputat diputat2, double percent) {
		double afinitat = 0.0;
		if(diputat1.getProcedencia().equals(diputat2.getProcedencia())) afinitat += 0.6;
		else afinitat -= 0.4;
		return afinitat * percent;
	}
	
	/**
	 * Calcul d'afinitats entre dos diputats segons esdeveniments
	 * @param diputat1: Primer diputat
	 * @param diputat2: Segon diputat
	 * @param percent: Percentatge d'importancia que es dona a l'afinitat
	 * @return: Afinitat segons els esdeveniments
	 */
	private double afinitatEsdeveniment(Diputat diputat1, Diputat diputat2, double percent) throws Exception {
		double afinitat = 0.0;
		boolean participa1 = false;
		boolean participa2 = false;
		ArrayList<Esdeveniment> esdeveniments1 = diputat1.getEsdeveniments();
		ArrayList<Esdeveniment> esdeveniments2 = diputat2.getEsdeveniments();
		ArrayList<Esdeveniment> interseccio = new ArrayList<Esdeveniment>(esdeveniments1);
		interseccio.retainAll(esdeveniments2);
		for(int k = 0; k < interseccio.size(); k++) {
			Esdeveniment esdeveniment = interseccio.get(k);
			if(esdeveniment.getClass().getName().equals("prop.g12.diputats.Votacio")) {
				Votacio votacio = new Votacio(interseccio.get(k));
				if(votacio.getVots().containsKey(diputat1)) participa1 = true;
				if(votacio.getVots().containsKey(diputat2)) participa2 = true;
				if(participa1 && participa2) {
					TVot vot1 = votacio.getVots().get(diputat1).getVot();				
					TVot vot2 = votacio.getVots().get(diputat2).getVot();
					if(vot1.equals(vot2)) {
						if(!(vot1.equals(TVot.abstencio))) afinitat += 0.8;
					}
					else if((vot1.equals(TVot.favor) && vot2.equals(TVot.abstencio)) || (vot2.equals(TVot.favor) && vot1.equals(TVot.abstencio))) afinitat -= 0.5;
					else if((vot1.equals(TVot.contra) && vot2.equals(TVot.abstencio)) || (vot2.equals(TVot.contra) && vot1.equals(TVot.abstencio))) afinitat -= 0.5;
					else if((vot1.equals(TVot.favor) && vot2.equals(TVot.contra)) || (vot2.equals(TVot.favor) && vot1.equals(TVot.contra))) afinitat -= 0.6;
				}
				else afinitat -= 0.4;
			}
			else afinitat += 0.6;
		}
		Set<Esdeveniment> diferencia = new HashSet<Esdeveniment>();
		HashSet<Esdeveniment> set1 = new HashSet<Esdeveniment>(esdeveniments1);
		HashSet<Esdeveniment> set2 = new HashSet<Esdeveniment>(esdeveniments2);
		diferencia.addAll(set1);
		diferencia.addAll(set2);
		diferencia.removeAll(interseccio);
		for(int l = 0; l < diferencia.size(); l++) {
			afinitat -= 0.4;
		}
		return afinitat * percent;
	}
	
	/**
	 * Calcul de l'afinitat entre dos diputats tenint en compte tots els parametres possibles
	 * @param opt: String per detectar si l'algorisme des d'on es calcula l'afinitat es Clique-Percolation
	 * @param diputat1: Primer diputat
	 * @param diputat2: Segon diputat
	 * @param pEmp: Percentatge d'importancia de les empreses
	 * @param pIde: Percentatge d'importancia de les ideologies
	 * @param pPro: Percentatge d'importancia de les procedencies
	 * @param pEsd: Percentatge d'importancia dels esdeveniments
	 * @return: Retorna el calcul de l'afinitat entre els dos diputats
	 * @throws Exception
	 */
	public double calculAfinitat(String opt, Diputat diputat1, Diputat diputat2, double pEmp, double pIde, double pPro, double pEsd) throws Exception {
		double afinitat = 0.0;
		afinitat += afinitatEmpresa(diputat1, diputat2, pEmp);
		afinitat += afinitatIdeologia(diputat1, diputat2, pIde);
		afinitat += afinitatProcedencia(diputat1, diputat2, pPro);
		afinitat += afinitatEsdeveniment(diputat1, diputat2, pEsd);
		if (afinitat > 0.0 && opt.equals("clique")) {
			afinitat = 1.0 + afinitat;
			afinitat = (1.0/afinitat);
			afinitat = 1.0 - afinitat;
		}
		afinitat = (double)Math.round(afinitat * 100000) / 100000;
		return afinitat;
	}				
}
