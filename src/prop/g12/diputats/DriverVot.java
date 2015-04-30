package prop.g12.diputats;

import java.util.Scanner;
import java.text.ParseException;

public class DriverVot {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introdueix 0 per provar el constructor de la classe Vot\n"
			+ "Introdueix 1 per provar getVot\n "
			+ "Introdueix 2 per provar getDiputat\n"
			+ "Introdueix 3 per provar getVotacio\n"
			+ "Introdueix -1 per a finalitzar l'execucio\n");
		int opt = sc.nextInt();
		sc.nextLine();
	
		Vot vot = new Vot();
		String tipusVot;
	
		boolean b = true;
		boolean correcte = true;
		while(b) {
			switch(opt) {
				case 0: 
					System.out.println("Introdueix el tipus de vot (favor/contra/abstencio):");
					while(!sc.hasNext());
					tipusVot = sc.nextLine();
					try {vot.setVot(tipusVot);}
					catch (Exception ex) { 
						correcte = false;
						ex.printStackTrace(); 
					}
					
					
					StubDiputat sd = new StubDiputat();
					
					Diputat d = new Diputat();
					d.setNom(sd.getNom());
					d.setIdeologia(sd.getIdeologia());
					d.setProcedencia(sd.getProcedencia());
					
					vot.setDiputat(d);
					
					StubVotacio sv = new StubVotacio();
					
					Votacio v = new Votacio();
					v.setCodi(sv.getCodi());
					v.setDescripcio(sv.getDescripcio());
					v.setData(sv.getData());
					
					vot.setVotacio(v);
					
					if(correcte) System.out.println("Creat el vot amb tipus " + tipusVot + " del Diputat " + sd.getNom() + " a la Votació  " + sv.getCodi());
					
					break;
				case 1:
					System.out.println("El vot ha estat: " + vot.votToString(vot.getVot()));
					break;
				case 2:
					System.out.println("El vot l'ha fet el diputat: " + vot.getDiputat().getNom());
					break;
				case 3:
					System.out.println("El vot ha sigut a la votacio amb codi: " + vot.getVotacio().getCodi());
					break;
				case -1:
					b = false;
					break;
				default: 
					System.out.println("\n Opció incorrecte.");
					System.out.println("Introdueix 0 per provar el constructor de la classe Vot\n"
							+ "Introdueix 1 per provar getVot\n "
							+ "Introdueix 2 per provar getDiputat\n"
							+ "Introdueix 3 per provar getVotacio\n"
							+ "Introdueix -1 per a finalitzar l'execucio\n");
					
					break;
			}
			if (b) opt = sc.nextInt();
		}
		sc.close();
	}
}
