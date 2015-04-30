package prop.g12.diputats;

import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DriverVot {
	Scanner sc = new Scanner(System.in);
	System.out.println("Introdueix 0 per provar el constructor de la classe Vot\n"
			+ "Introdueix 1 per provar getVot\n "
			+ "Introdueix 2 per provar getDiputat\n"
			+ "Introdueix 3 per provar getVotacio\n"
			+ "Introdueix -1 per a finalitzar l'execucio\n");
	int opt = sc.nextInt();
	sc.nextLine();
	
	Vot vot;
	SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	
	boolean b = true;
	boolean correcte = true;
	while(b) {
		switch(opt) {
		case 0: 
			System.out.println("Introdueix el tipus de vot (favor/contra/abstencio)");
		}
		
		
		
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
		votacio.SetVot("abstenció");
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
		votacio2 = new Votacio(3,"Votació contra els politics", d2);
		votacio.SetVotacio(votacio2);
	}
}
