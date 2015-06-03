package prop.g12.diputats.domain;

import prop.g12.diputats.data.Diputat;

public class ControladorAfinitat {
	
	/**
	 * Creadora de la classe
	 */
	public ControladorAfinitat() {}
	
	/**
	 * @return: Nova instancia de la classe Afinitat
	 */
	public Afinitat creaAfinitat() {
		return new Afinitat();
	}
	
	/**
	 * Calcul de l'afinitat entre dos diputats tenint en compte tots els parametres possibles
	 * @param opt: String per detectar si l'algorisme des d'on es calcula l'afinitat es Clique-Percolation
	 * @param afinitat: Instancia de la classe Afinitat sobre la qual es calcula l'afinitat entre els diputats
	 * @param diputat1: Primer diputat
	 * @param diputat2: Segon diputat
	 * @param pEmp: Percentatge d'importancia de les empreses
	 * @param pIde: Percentatge d'importancia de les ideologies
	 * @param pPro: Percentatge d'importancia de les procedencies
	 * @param pEsd: Percentatge d'importancia dels esdeveniments
	 * @return: Retorna el calcul de l'afinitat entre els dos diputats
	 * @throws Exception
	 */
	public double calculAfinitat(String opt, Afinitat afinitat, Diputat diputat1, Diputat diputat2, int pEmp, int pIde, int pPro, int pEsd) throws Exception {
		double pEmpD = (double)pEmp/100;
		double pIdeD = (double)pIde/100;
		double pProD = (double)pPro/100;
		double pEsdD = (double)pEsd/100;
		return afinitat.calculAfinitat(opt, diputat1, diputat2, pEmpD, pIdeD, pProD, pEsdD);
	}

}
