package prop.g12.diputats;

import java.util.Scanner;
import java.util.ArrayList;

public class DriverEmpresa {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introdueix 0 per provar el constructor de la classe Empresa\n"
				+ "Introdueix 1 per provar getNom\n Introdueix 2 per provar getAmbit\n"
				+ "Introdueix 3 per provar afegirDiputat\n Introdueix 4 per provar getDiputats\n"
				+ "Introdueix -1 per a finalitzar l'execucio\n");
		int opt = sc.nextInt();
		ArrayList<StubDiputat> d = new ArrayList<StubDiputat>();
		Empresa e = new Empresa();
		StubDiputat sd;
		String nomEmpresa, ambitEmpresa;
		boolean b = true;
		while(b) {
			switch(opt) {
			case 0:
				System.out.print("Introdueix un nom per l'empresa\n");
				nomEmpresa = sc.nextLine();
				System.out.print("Introdueix un ambit per l'empresa\n");
				ambitEmpresa = sc.nextLine();
				e.setNom(nomEmpresa);
				e.setAmbit(ambitEmpresa);
				System.out.print("Empresa creada\n");
				break;
			case 1:
				System.out.print("El nom de l'empresa es: " + e.getNom() + "\n");
				break;
			case 2:
				System.out.print("L'ambit de l'empresa es: " + e.getAmbit() + "\n");
				break;
			case 3:
				sd = new StubDiputat();
				System.out.print("Creat el diputat " + sd.getNom() + "amb ideologia " + sd.getIdeologia() + "i procedencia " + sd.getProcedencia() + "\n");
				d.add(sd);
				System.out.print("Diputat afegit a la llista\n");
				break;
			case 4:
				System.out.print("La mida de la llista es " + d.size() + "\n");
				System.out.println("El contingut de la llista es\n");
				while(d.size() != 0) {
					sd = d.get(d.size()-1);
					System.out.print(sd.getNom() + sd.getIdeologia() + sd.getProcedencia() + "\n");
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
