package prop.g12.diputats;

import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DriverVot {
	public static void main(String[] args) {
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
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	
		boolean b = true;
		boolean correcte = true;
		while(b) {
			switch(opt) {
				case 0: 
					System.out.println("Introdueix el tipus de vot (favor/contra/abstencio):");
					while(!sc.hasNext());
					tipusVot = sc.nextLine();
					vot.SetVot(tipusVot);
					
					StubDiputat sd = new StubDiputat();
					
					Diputat d = new Diputat();
					d.setNom(sd.getNom());
					d.setIdeologia(sd.getIdeologia());
					d.setProcedencia(sd.getProcedencia());
					
					vot.SetDiputat(d);
					
					StubVotacio sv = new StubDiputat();
					
					Votacio v = new Votacio();
					v.setIdeologia(sv.getCodi());
					v.setProcedencia(sv.getDescripcio());
					v.setData(sv.getData);
					
					vot.SetVotacio(v);
					
					System.out.println("Creat el vot amb tipus" + tipusVot + " del Diputat " + sd.getNom() + " a la Votaci�  " + sv.getCodi());
				case 1:;
				case 2:;
				case 3:;
				case -1:;
				default: 
			}
		}
	}
}
/*		
		
	public void testVot() {
		votacio = new Vot("favor");
	}
		    
	public void testGetVot() {
		votacio.GetVot();
	}
		
	public void testStringToVot() {
		votacio.StringToVot("prova");
	}
		
	public void testSetVot() {
		votacio.SetVot("abstenci�");
	}

	public void testGetDiputat() {
		votacio.GetDiputat();
	}

	public void testSetDiputat() {
		Diputat dip;
		dip = new Diputat("nom","ideologia","procedencia");
		votacio.SetDiputat(dip);
	}

	public void testGetVotacio() {
		votacio.GetVot();
	}

	public void testSetVotacio() throws ParseException {
		Votacio votacio2;
		Date d2 = sdf2.parse("21/12/2012");
		votacio2 = new Votacio(3,"Votaci� contra els politics", d2);
		votacio.SetVotacio(votacio2);
	}
}*/
