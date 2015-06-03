package prop.g12.diputats;

public class Main {
	
	public static final int ANCHO_GRAFICA = 800;
	public static final int ALTO_GRAFICA = 600;
	
	public static void main(String[] args) throws Exception {
		ControladorIO ctrlIO = new ControladorIO();
		ControladorAlgorisme ctrlAlgorisme = new ControladorAlgorisme();
		int random = 1; //modificar per provar random o no
		if (random == 0) {
			ctrlIO.llegirCongres("congres");
			ctrlIO.escriureCongres("congres");
		}
		if(random == 1) {
			ctrlIO.generarRandom(10, 10);
			ctrlIO.escriureCongres("random");
		}
		ctrlAlgorisme.selectAlgorisme("newman", "newman", 25, 25, 25, 25);
		ctrlAlgorisme.selectAlgorisme("louvain", "louvain", 25, 25, 25, 25);
		ctrlAlgorisme.selectAlgorisme("clique", "clique", 25, 25, 25, 25);
	}
}
