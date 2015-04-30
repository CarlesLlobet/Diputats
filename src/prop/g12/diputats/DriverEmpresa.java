package prop.g12.diputats;

import java.util.Scanner;
import java.util.ArrayList;

public class DriverEmpresa {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introdueix 0 per provar el constructor de la classe Empresa\n"
				+ "Introdueix 1 per provar getNom\nIntrodueix 2 per provar getAmbit\n"
				+ "Introdueix 3 per provar afegirDiputat\nIntrodueix 4 per provar getDiputats\n"
				+ "Introdueix -1 per a finalitzar l'execucio\n");
		int opt = sc.nextInt();
		sc.nextLine();
		ArrayList<StubDiputat> d = new ArrayList<StubDiputat>();
		Empresa e = new Empresa();
		StubDiputat sd;
		String nomEmpresa, ambitEmpresa;
		boolean b = true;
		boolean correcte = true;
		while(b) {
			switch(opt) {
			case 0:
				System.out.println("Introdueix un nom per l'empresa");
				while(!sc.hasNext());
				nomEmpresa = sc.nextLine();
				e.setNom(nomEmpresa);
				System.out.println("Introdueix un ambit per l'empresa");
				while(!sc.hasNext());
				ambitEmpresa = sc.nextLine();
				try { e.setAmbit(ambitEmpresa); }
				catch (Exception ex) { 
					correcte = false;
					ex.printStackTrace(); }
				if(correcte) System.out.println("Empresa creada\n");
				break;
			case 1:
				System.out.println("El nom de l'empresa es: " + e.getNom());
				break;
			case 2:
				System.out.println("L'ambit de l'empresa es: " + e.getAmbit());
				break;
			case 3:
				sd = new StubDiputat();
				System.out.println("Creat el diputat " + sd.getNom() + " amb ideologia " + sd.getIdeologia() + " i procedencia " + sd.getProcedencia());
				d.add(sd);
				System.out.println("Diputat afegit a la llista\n");
				break;
			case 4:
				System.out.println("La mida de la llista es " + d.size());
				System.out.println("El contingut de la llista es:");
				while(d.size() != 0) {
					sd = d.get(d.size()-1);
					System.out.println(sd.getNom() +" " + sd.getIdeologia() + " " + sd.getProcedencia());
					d.remove(d.size()-1);
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
