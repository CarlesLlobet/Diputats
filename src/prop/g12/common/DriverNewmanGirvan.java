package prop.g12.common;

import java.util.Scanner;

import prop.g12.diputats.StubDiputat;

public class DriverNewmanGirvan {

	public DriverNewmanGirvan() {}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introdueix 0 per consultar el graf a provar i seleccio de vertex per calcular la resta de opcions\n"
				+ "Introdueix 1 per provar la cerca de camins a un graf entre dos vertex\n"
				+ "Introdueix 2 per trobar les adjacencies de un vertex\n"
				+ "Introdueix 3 per provar l'aresta amb mes betweeness\n"
				+ "Introdueix 4 per provar el calcul del threshold\n"
				+ "Introdueix 5 per el graf final amb les arestes eliminades\n"
				+ "Introdueix -1 per a finalitzar l'execucio\n");
		int opt = sc.nextInt();
		sc.nextLine();
		NewmannGirvan ng = new NewmannGirvan();
		StubGraf sg = new StubGraf();
		Integer[][] graf = sg.GetGraf();
		int n = graf[0].length;
		boolean b = true;
		int iNode = 0, jNode = 1;
		Integer[][] sol = null;
		Integer[][] bet = null;
		Integer[][] sup = null;
		Integer max = 0;
		while(b) {
			switch(opt) {
			case 0:
				System.out.println("Aquest es el nostre graf de prova:");
				for (int i = 0; i < n; ++i) {
					System.out.println("\n");
					for (int j = i; j < n; ++j) {
						System.out.println(graf[i][j]);
					}
				}
				break;
			case 1:
				System.out.println("Introdueix el node inici i node final, no poden ser el mateix, els valors van entre [0,4]:");
				System.out.println("Introdueix node inicial:");
				sol = ng.SearchAlg(graf,iNode,jNode);
				for (int ii = 0; ii < n; ++ii) {
					System.out.println("\n");
					for (int jj = ii; jj < n; ++jj) {
						System.out.println(graf[ii][jj]+" ");
					}
				}	
				break;
			case 2:
				System.out.println("Adjacencies dels dos vertexs seleccionats:");
				for (int k = 0; k < n; ++k) {
					System.out.println(graf[iNode][k]+" ");
				}		
				System.out.println("\n");
				for (int kk = 0; kk < n; ++kk) {
					System.out.println(graf[jNode][kk]+" ");
				}	
				break;
			case 3:
				System.out.println("Maxim Betweeness de l'aresta/es");
				bet = ng.addEdges(sol,iNode,jNode);
				max = 0;
				for (int ii = 0; ii < n; ++ii) {
					for (int jj = ii; jj < n; ++jj) {
						if (max < bet[ii][jj]) max = bet[ii][jj];
					}
				}	
				System.out.println("L'aresta amb mes betweeness es: "+max);
				break;
			case 4:
				System.out.println("Threshold es: "+ng.getTH(bet));
				break;
			case 5:
				System.out.println("Graf solucio una vegada eliminada les arestes: ");
				System.out.println("\n");
				sup = ng.removeEdge(bet);
				for (int i = 0; i < n; ++i) {
					System.out.println("\n");
					for (int j = i; j < n; ++j) {
						System.out.println(sup[i][j]);
					}
				}
				break;
			case -1:
				b = false;
				break;
				
			default:
				System.out.println("Opcio incorrecta");
				System.out.println("Introdueix 0 per provar el constructor de la classe Empresa\n"
						+ "Introdueix 1 per provar getNom\n"
						+ "Introdueix 2 per provar getAmbit\n"
						+ "Introdueix 3 per provar afegirDiputat\n"
						+ "Introdueix 4 per provar getDiputats\n"
						+ "Introdueix -1 per a finalitzar l'execucio\n");
				break;
			}
			if (b) opt = sc.nextInt();
		}
		sc.close();
	}
}
