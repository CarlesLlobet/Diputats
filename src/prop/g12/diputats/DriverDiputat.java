package prop.g12.diputats;

import java.util.ArrayList;
import java.util.Scanner;

public class DriverDiputat {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introdueix 0 per provar el constructor de la classe Diputat\n"
				+ "Introdueix 1 per provar getNom\n "
				+ "Introdueix 2 per provar getIdeologia\n"
				+ "Introdueix 3 per provar getProcedencia\n"
				+ "Introdueix 4 per provar getEmpresa\n"
				+ "Introdueix 5 per provar getEsdeveniments\n"
				+ "Introdueix 6 per provar getVotacions\n"
				+ "Introdueix -1 per a finalitzar l'execucio\n");
		int opt = sc.nextInt();
		sc.nextLine();
		ArrayList<StubEsdeveniment> esd = new ArrayList<StubEsdeveniment>();
		ArrayList<StubVotacio> v = new ArrayList<StubVotacio>();
		Diputat d = new Diputat();
		StubEsdeveniment esdev;
		StubVotacio vot;
		String nomDiputat, ideologiaDiputat, procedenciaDiputat;
		boolean b = true;
		boolean correct = true;
		while(b) {
			switch(opt) {
			case 0:
				System.out.println("Introdueix un nom pel Diputat");
				while(!sc.hasNext());
				nomDiputat = sc.nextLine();
				d.setNom(nomDiputat);
				System.out.println("Introdueix la procedencia del Diputat");
				while(!sc.hasNext());
				procedenciaDiputat = sc.nextLine();
				d.setProcedencia(procedenciaDiputat);
				System.out.println("Introdueix la ideologia del Diputat");
				while(!sc.hasNext());
				ideologiaDiputat = sc.nextLine();
				try { d.setIdeologia(ideologiaDiputat); }
				catch (Exception ex) { 
					correct = false;
					ex.printStackTrace(); }
				if(correct) System.out.println("Diputat creat");
				break;
			case 1:
				System.out.println("El nom del diputat es: " + d.getNom());
				break;
			case 2:
				System.out.println("La ideologia del diputat es: " + d.getIdeologia());
				break;
			case 3:
				System.out.println("La procedencia del diputat es: " + d.getProcedencia());
				break;
			case 4:
				System.out.println("El nom de l'empresa en la qual treballa el diputat es: " + d.getEmpresa().getNom() + " amb ambit " + d.getEmpresa().getAmbit());
			case 5:
				System.out.println("La mida de la llista d'Esdeveniments es " + esd.size());
				System.out.println("El contingut de la llista es:");
				while(esd.size() != 0) {
					esdev = esd.get(esd.size()-1);
					System.out.println("Codi: " + esdev.getCodi() + ", Descripcio: " + esdev.getDescripcio() + " i Data: " + esdev.getData());
					esd.remove(esd.size()-1);
				}
				break;
			case 6:
				System.out.println("La mida de la llista de Votacio es " + v.size());
				System.out.println("El contingut de la llista es:");
				while(v.size() != 0) {
					vot = v.get(v.size()-1);
					System.out.println("Codi: " + vot.getCodi() + ", Descripcio: " + vot.getDescripcio() + " i Data: " + vot.getData());
					v.remove(v.size()-1);
				}
				break;
			case -1:
				b = false;
				break;
			}
			if (b) opt = sc.nextInt();
		}
		sc.close();
	}
}