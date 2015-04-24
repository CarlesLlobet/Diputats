package prop.g12.diputats;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
	
	private static File file;
	private static PrintWriter out;
	private static Scanner input;
	
	public static void io() {
		file = new File("Diputats.txt");
		out = null;
		try {
			out = new PrintWriter("output.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		input = null;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void afegirDiputats() {
		Map<Integer, Diputat> congres;
		congres = new HashMap<Integer,Diputat>();
		String N2 = input.nextLine();
		Integer N = Integer.parseInt(N2);
		for (Integer i = 0; i < N; ++i) {
			String nom = input.nextLine();
			out.println("El seu nom es "+ nom);
			String idea = input.nextLine();
			out.println("La seva ideologia es "+ idea);
			String procedencia = input.nextLine();
			out.println("La seva procedencia es "+ procedencia);
			Diputat dip = new Diputat(nom, idea, procedencia);
			congres.put(i, dip);
		}
		ConjuntDades.getInstance().setCongres(congres);
	}
	
	
	
	public static void main(String[] args) {
		io();
		afegirDiputats();
		//afegirEmpreses();
		//afegirVots();
		out.close();
	}
	
}
