package propsw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GalaxiaControladorDriver {
	
	private static void intro()
	{
	System.out.println("------------------------");
	System.out.println("| Driver de Controlador de Galaxia |");
	System.out.println("------------------------");
	}
	private static void menu()
	{
	System.out.println("Opcions:");
	System.out.println("1) Crear una gal�xia");
	System.out.println("2) Resetejar la Gal�xia");
	System.out.println("3) Afegir una base");
	System.out.println("4) Esborrar una base");
	System.out.println("5) Modificar una base");
	System.out.println("6) Llistar totes les bases");
	System.out.println("7) Crear una adjac�ncia");
	System.out.println("8) Modificar els valors d'una adjac�ncia");
	System.out.println("9) Eliminar una adjac�ncia");
	System.out.println("10) Obtenir una adjac�ncia");
	//System.out.println("11) Login");
	System.out.println("0) exit");
	}
	public static void main(String[] args) throws IOException {
	
	//Es crea un capit� a trav�s de la gal�xia del qual es far�n totes les operacions
	//Es crea una inst�ncia de classe Galaxia
	
	GalaxiaControlador gControl=new GalaxiaControlador();
	
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader (isr);
	String s;
	Integer i;
	int from,to,capacitat,fluxe;
	double cost;
	intro();
	menu();
	int op = Integer.parseInt(br.readLine());
	while (op != 0) {
		switch(op)
		{
			case 1:
					if(gControl.createGalaxia()!=null){
						System.out.println("S'ha creat una nova gal�xia satisfact�riament.");
					}
					else{
						System.out.println("Hi ha hagut algun problema creant una nova gal�xia.");
					}
					break;
			case 2:
					if(gControl.resetGalaxia()!=null){
						System.out.println("S'ha resetejat la Gal�xia satisfact�riament.");
					}
					else{
						System.out.println("Hi ha hagut algun problema resetejant la gal�xia.");
					}
					break;
			case 3:
					System.out.println("Introdueix el nou nom per a la base: ");
					s = br.readLine();
					try{
						gControl.addBase(s);
					}
					catch(IOException e){
						System.out.println(e);
					}
					break;
			case 4:
					System.out.println("Introdueix la ID de la base que es vol eliminar: ");
					s = br.readLine();
					i=Integer.valueOf(s);
					if(gControl.deleteBase(i)){
						System.out.println("La base s'ha eliminat correctament.");
					}
					else{
						System.out.println("HI ha hagut algun problema eliminant la base demanada.");
					}
					break;
			case 5:
					System.out.println("Introdueix la ID de la base a modificar:");
					s = br.readLine();
					i=Integer.valueOf(s);
					System.out.println("Introdueix el nou nom:");
					s = br.readLine();
					if(gControl.setBase(i, s)){
						System.out.println("S'ha editat la Base correctament.");
					}
					else{
						System.out.println("Hi ha hagut algun problema editant la Base.");
					}
					break;
			case 6:
					System.out.println("Bases existents:");
					System.out.println(gControl.listBases());
					break;
			case 7:
					System.out.println("Introdueix l'ID de la Base A (inici tram)");
					s = br.readLine();
					from=Integer.valueOf(s);
					System.out.println("Introdueix l'ID de la Base B (final tram)");
					s = br.readLine();
					to=Integer.valueOf(s);
					System.out.println("Introdueix la capacitat del tram:");
					s = br.readLine();
					capacitat=Integer.valueOf(s);
					System.out.println("Introdueix el cost del tram:");
					s = br.readLine();
					cost=Double.parseDouble(s);
					
					try{
						gControl.createAdjacency(from, to, capacitat, cost);
						System.out.println("L'adjac�ncia s'ha creat correctament.");
					}
					catch(IOException e){
						System.out.println(e);
					}
					break;
			case 8:
					System.out.println("Introdueix l'ID de la Base A (inici tram)");
					s = br.readLine();
					from=Integer.valueOf(s);
					System.out.println("Introdueix l'ID de la Base B (final tram)");
					s = br.readLine();
					to=Integer.valueOf(s);
					System.out.println("Introdueix la capacitat del tram:");
					s = br.readLine();
					capacitat=Integer.valueOf(s);
					System.out.println("Introdueix el cost del tram:");
					s = br.readLine();
					cost=Double.parseDouble(s);
					
					try{
						gControl.setAdjacency(from, to, capacitat, cost);
						System.out.println("L'adjac�ncia s'ha actualitzat correctament.");
					}
					catch(IOException e){
						System.out.println(e);
					}
					break;
					
			case 9:
					System.out.println("Introdueix l'ID de la Base A (inici tram)");
					s = br.readLine();
					from=Integer.valueOf(s);
					System.out.println("Introdueix l'ID de la Base B (final tram)");
					s = br.readLine();
					to=Integer.valueOf(s);
					try{
						gControl.deleteAdjacencia(from, to);
						System.out.println("L'adjac�ncia s'ha eliminat correctament.");
					}
					catch(IOException e){
						System.out.println(e);
					}
					break;
			case 10:
					System.out.println("Introdueix l'ID de la Base A (inici tram)");
					s = br.readLine();
					from=Integer.valueOf(s);
					System.out.println("Introdueix l'ID de la Base B (final tram)");
					s = br.readLine();
					to=Integer.valueOf(s);
					try{
						Galaxia.Aresta ar=new Galaxia.Aresta();
						ar=gControl.getAdjacency(from, to);
						int idAresta=gControl.getGalaxia().getIDAresta(from,to);
						capacitat=gControl.getGalaxia().getCapacidadAresta(idAresta);
						cost=gControl.getGalaxia().getCosteAresta(idAresta);
						fluxe=gControl.getGalaxia().getFlujoAresta(idAresta);
						System.out.println("S'ha obtingut l'aresta satisfact�riament.");
						System.out.println("ID :"+idAresta);
						System.out.println("Capacitat: "+capacitat);
						System.out.println("Cost: "+cost);
						System.out.println("Fluxe: "+fluxe);
					}
					catch(IOException e){
						System.out.println(e);
					}
					break;
				
			default:
					System.out.println("No existeix aquesta opci�");
					break;
	}
		menu();
	op = Integer.parseInt(br.readLine());
	}
	}
}