package prop.g12.diputats;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	public static Map<Integer,Diputat> Congres;
	
	public Map<Integer, Diputat> getCongres() {
		return Congres;
	}
	
	//Set de Congres?	
	//Afegir Diputats al nostre Congres
	public static void setCongres(Integer id, Diputat dip) {
		Congres.put(id, dip);
	}
	
	public static void main(String[] args) {
		File file = new File("Diputats.txt");
		PrintWriter out = null;
		try {
			out = new PrintWriter("output.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Scanner input = null;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Congres = new HashMap<Integer,Diputat>();
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
			setCongres(i,dip);
		}
		out.close();
	}
	
}
