package prop.g12.diputats.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JTree;

import prop.g12.common.Graf;
import prop.g12.common.Solucio;
import prop.g12.diputats.domain.ControladorEstadistica;
import prop.g12.diputats.domain.ControladorSolucio;

public class ControladorIO {
	
	private ControladorCongres ctrlCongres;
	private ControladorEmpresa ctrlEmpresa;
	private ControladorEsdeveniment ctrlEsdev;
	private ControladorDiputat ctrlDiputat;
	private ControladorVot ctrlVot;
	private ControladorReunio ctrlReunio;
	private ControladorConferencia ctrlConferencia;
	private ControladorVotacio ctrlVotacio;
	private ControladorSolucio ctrlSolucio;
	private ControladorEstadistica ctrlEstadistica;
	
	public ControladorIO() {
		ctrlCongres = new ControladorCongres();
		ctrlDiputat = new ControladorDiputat();
		ctrlEsdev = new ControladorEsdeveniment();
		ctrlEmpresa = new ControladorEmpresa();
		ctrlVot = new ControladorVot();
		ctrlReunio = new ControladorReunio();
		ctrlConferencia = new ControladorConferencia();
		ctrlVotacio = new ControladorVotacio();
		ctrlSolucio = new ControladorSolucio();
		ctrlEstadistica = new ControladorEstadistica();
	}
	
	public void llegirCongres(String string) throws Exception {
		File file = new File("io/" + string + ".txt");
		Scanner input;
		input = null;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			try {
				file.createNewFile();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			try {
				input = new Scanner(file);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		Diputat D;
		Empresa E;
		String nomD, votD;
		Vot vot;
		int assistents;
		ctrlCongres.creaCongres();
		int nDip = input.nextInt();
		input.nextLine();
		for (int i = 0; i < nDip; i++) {
			nomD = input.nextLine();
			String ideologia = input.nextLine();
			String procedencia = input.nextLine();
			D = ctrlDiputat.creaDiputat(nomD, ideologia, procedencia);
			ctrlCongres.altaDiputat(D);
			String nomE = input.nextLine();
			String ambit = input.nextLine();
			E = ctrlEmpresa.creaEmpresa(nomE, ambit);
			ctrlDiputat.setEmpresa(D, E);
			ctrlEmpresa.afegirDiputat(E, D);
			input.nextLine();
		}
		int nEsd = input.nextInt();
		input.nextLine();
		for(int j = 0; j < nEsd; j++) {
			int codi = input.nextInt();
			input.nextLine();
			String desc = input.nextLine();
			String data = input.nextLine();
			if(desc.equals("votacio")) {
				Votacio v = ctrlVotacio.creaVotacio(codi, desc, data);
				ctrlCongres.altaEsdeveniment(v);
				assistents = input.nextInt();
				input.nextLine();
				for(int k = 0; k < assistents; k++) {
					nomD = input.nextLine();
					votD = input.nextLine();
					D = ctrlCongres.cercaDiputat(nomD);
					ctrlDiputat.afegirEsdeveniment(D, v);
					vot = ctrlVot.Vot(votD, D, v);
					ctrlVotacio.afegirVot(v, vot, D);
				}
			}
			else if(desc.equals("reunio")) {
				Reunio r = ctrlReunio.Reunio(codi, desc, data);
				ctrlCongres.altaEsdeveniment(r);
				assistents = input.nextInt();
				input.nextLine();
				for(int k = 0; k < assistents; k++) {
					nomD = input.nextLine();
					D = ctrlCongres.cercaDiputat(nomD);
					ctrlReunio.afegirDiputat(r, D);
					ctrlDiputat.afegirEsdeveniment(D, r);
				}
			}
			else if(desc.equals("conferencia")) {
				Conferencia c = ctrlConferencia.creaConferencia(codi, desc, data);
				ctrlCongres.altaEsdeveniment(c);
				assistents = input.nextInt();
				input.nextLine();
				for(int k = 0; k < assistents; k++) {
					nomD = input.nextLine();
					D = ctrlCongres.cercaDiputat(nomD);
					ctrlConferencia.afegirDiputat(c, D);
					ctrlDiputat.afegirEsdeveniment(D, c);
				}
			}
			if (j != nEsd - 1) input.nextLine();
		}
		input.close();
	}
	
	public void generarRandom(int nDip, int nEsd) throws Exception {
		File procs = new File("io/procedencia.txt");
		Scanner input;
		input = null;
		try {
			input = new Scanner(procs);
		} catch (FileNotFoundException e) {
			try {
				procs.createNewFile();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			try {
				input = new Scanner(procs);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		File empr = new File("io/empreses.txt");
		Scanner input2;
		input2 = null;
		try {
			input2 = new Scanner(empr);
		} catch (FileNotFoundException e) {
			try {
				empr.createNewFile();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			try {
				input2 = new Scanner(empr);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		//DIPUTATS - CORRECTE
		ArrayList<String> estats = new ArrayList<String>();
		while(input.hasNext()) estats.add(input.nextLine());
		ArrayList<String> empreses = new ArrayList<String>();
		while(input2.hasNext()) empreses.add(input2.nextLine());
		List<TIdeologia> ideologies = TIdeologia.getIdeologies();
		List<TAmbit> ambits = TAmbit.getAmbits();
		List<TVot> vots = TVot.getVots();
		String[] descripcions = {"reunio", "conferencia", "votacio"};
		ctrlCongres.creaCongres();
		ArrayList<Diputat> diputats = new ArrayList<Diputat>(nDip);
		Boolean part[] = new Boolean[nDip];
		Random rand = new Random();
		for (int i = 0; i < nDip; i++) {
			String nomD = "D" + i;
		    int randProc = rand.nextInt(estats.size());
		    int randIde = rand.nextInt(ideologies.size());
		    int randEmp = rand.nextInt(empreses.size());
		    int randAmbit = rand.nextInt(ambits.size());
		    String procedencia = estats.get(randProc);
		    String ideologia = ideologies.get(randIde).toString();
			Diputat D = ctrlDiputat.creaDiputat(nomD, ideologia, procedencia);
			String nomE = empreses.get(randEmp);
			String ambit = ambits.get(randAmbit).toString();
			Empresa E = ctrlEmpresa.creaEmpresa(nomE, ambit);
			ctrlDiputat.setEmpresa(D, E);
			ctrlEmpresa.afegirDiputat(E, D);
			ctrlCongres.altaDiputat(D);
			diputats.add(i, D);
			part[i] = false;
		}
		//ESDEVENIMENTS
		Conferencia c = null;
		Reunio r = null;
		Votacio v = null;
		for(int j = 0; j < nEsd; j++) {
			int mes = rand.nextInt(12) + 1;
			int maxDia = 31;
			if (mes == 2) maxDia = 28;
			else if(mes == 4 || mes == 6 || mes == 9 || mes == 11) maxDia = 30;
			int dia = rand.nextInt(maxDia) + 1;
			int h = rand.nextInt(17) + 8;
			String hora = null;
			if (h < 10) hora = "0" + h;
			else hora = String.valueOf(h);
			String d = dia + "/" + mes + "/2015-" + hora + ":00:00";
			int desc = rand.nextInt(3);
			String descripcio = descripcions[desc];
			switch(descripcio) {
			case "conferencia":
				c = ctrlConferencia.creaConferencia(j, descripcio, d);
				//ctrlCongres.altaConferencia(c);
				ctrlCongres.altaEsdeveniment(c);
				break;
		
			case "reunio":
				r = ctrlReunio.Reunio(j, descripcio, d);
				//ctrlCongres.altaReunio(r);
				ctrlCongres.altaEsdeveniment(r);
				break;
			
			case "votacio":
				v = ctrlVotacio.creaVotacio(j, descripcio, d);
				//ctrlCongres.altaVotacio(v);
				ctrlCongres.altaEsdeveniment(v);
				break;
			}			
			int randDip = rand.nextInt(diputats.size()); //nombre diputats que hi participen
			if(randDip < 2) randDip = 2;
			int k = 0;
			while(k < randDip) {				
				int randDip2 = rand.nextInt(diputats.size());
				if (!part[randDip2]) {
					part[randDip2] = true;
					Diputat D = diputats.get(randDip2);
					switch(descripcio) {
					case "conferencia":
						ctrlConferencia.afegirDiputat(c, D);
						ctrlDiputat.afegirEsdeveniment(D, c);
						break;
				
					case "reunio":
						ctrlReunio.afegirDiputat(r, D);
						ctrlDiputat.afegirEsdeveniment(D, r);
						break;
					
					case "votacio":
						int randVot = rand.nextInt(vots.size());
						String votD = vots.get(randVot).toString();
						Vot vot = ctrlVot.Vot(votD, D, v);
						ctrlVotacio.afegirVot(v, vot, D);
						ctrlDiputat.afegirEsdeveniment(D, v);
						break;
					}
					++k;
				}
			}
			for(int l = 0; l < nDip; l++) {
				if(part[l]) part[l] = false;
			}
		}
		input.close();
		input2.close();
	}
	
	public void escriureCongres(String s) {
		File out = new File("io/" + s + ".txt");
		PrintWriter output = null;
		try {
			output = new PrintWriter(out);
		} catch (FileNotFoundException e1) {
			try {
				out.createNewFile();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			try {
				output = new PrintWriter(out);
			} catch (IOException e11) {
				e11.printStackTrace();
			}
		}
		ArrayList<Diputat> diputats = ControladorCongres.getDiputats();
		output.println(diputats.size());
		for(int i = 0; i < diputats.size(); i++) {
			Diputat D = diputats.get(i);
			output.println(ctrlDiputat.getNom(D));
			output.println(ctrlDiputat.getIdeologia(D));
			output.println(ctrlDiputat.getProcedencia(D));
			Empresa E = ctrlDiputat.getEmpresa(D);
			output.println(ctrlEmpresa.getNom(E));
			output.println(ctrlEmpresa.getAmbit(E));
			output.println("");			
		}
		ArrayList<Esdeveniment> esdeveniments = ControladorCongres.getEsdeveniments();
		output.println(esdeveniments.size());
		for(int j = 0; j < esdeveniments.size(); j++) {
			Esdeveniment e = esdeveniments.get(j);
			output.println(ctrlEsdev.getCodi(e));
			output.println(ctrlEsdev.getDescripcio(e));
			output.println(ctrlEsdev.getStringData(e));
			if(e.getDescripcio().equals("votacio")) {
				Votacio v = (Votacio)esdeveniments.get(j);
				Map<Diputat, Vot> vots = ctrlVotacio.getVots(v);
				output.println(vots.size());
				Iterator<Map.Entry<Diputat, Vot>> it = vots.entrySet().iterator();
				while(it.hasNext()) {
					Map.Entry<Diputat, Vot> entry = it.next();
					output.println(ctrlDiputat.getNom(entry.getKey()));
					output.println(ctrlVot.getVot(entry.getValue()));
				}
			}
			else {
				ArrayList<Diputat> dips = ctrlEsdev.getDiputats(e);
				output.println(dips.size());
				for(int k = 0; k < dips.size(); k++) {
					output.println(ctrlDiputat.getNom(dips.get(k)));
				}
			}
			output.println("");
		}
		output.close();
	}
	
	public void escriureAdjacencia(Graf<Diputat> G) throws Exception {
		File file = new File("io/graf.txt");
		PrintWriter output = null;
		try {
			output = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			try {
				file.createNewFile();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			try {
				output = new PrintWriter(file);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		output.println(G.getNumNodes());
		Set<Diputat> nodes = G.getNodes();
		Iterator<Diputat> it = nodes.iterator();
		while (it.hasNext()) {
			Diputat dip = it.next();
			output.println(dip.getNom());
			Map<Diputat, Double> adj = G.getAdjacencia(dip);
			output.println(adj.size());
			Iterator<HashMap.Entry<Diputat, Double>> it2 = adj.entrySet().iterator();
			while (it2.hasNext()) {
				Map.Entry<Diputat, Double> entry2 = it2.next();
				output.println(entry2.getKey().getNom());
				output.println(entry2.getValue().doubleValue());
			}
			output.println("");
		}
	}
	
	public Graf<Diputat> llegirAdjacencia() throws Exception {
		File file = new File("io/graf.txt");
		Scanner input = null;
		String nom, nom2;
		double pes;
		Diputat diputat, diputat2;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			try {
				file.createNewFile();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			try {
				input = new Scanner(file);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		int numNodes = input.nextInt();
		Graf<Diputat> G = new Graf<Diputat>(numNodes);
		for(int i = 0; i < numNodes; i++) {
			nom = input.nextLine();
			if(ctrlCongres.existeixDiputat(nom)) {
				diputat = ctrlCongres.cercaDiputat(nom);
				int numAdj = input.nextInt();
				for(int j = 0; j < numAdj; j++) {
					nom2 = input.nextLine();
					if(ctrlCongres.existeixDiputat(nom2)) {
						diputat2 = ctrlCongres.cercaDiputat(nom2);
						pes = input.nextDouble();
						G.afegirAresta(diputat, diputat2, pes);
					}
				}
			}
			input.nextLine();
		}
		input.close();
		return G;
	}
	
	public JTree llegirSolucio(String nomF) {
		JTree tree = null;
		Solucio<Diputat> sol = ctrlSolucio.creaSolucio();		
		File solucio = new File("io/" + nomF + ".txt");
		Scanner input = null;
		try {
			input = new Scanner(solucio);
		} catch (FileNotFoundException e) {
			try {
				solucio.createNewFile();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			try {
				input = new Scanner(solucio);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		int numCom = input.nextInt();
		input.nextLine();
		for(int i = 0; i < numCom; i++) {
			input.nextLine();
			String next = input.nextLine();
			int midaCom = Integer.parseInt(next);
			ctrlSolucio.afegirComunitat(sol, i);
			for(int j = 0; j < midaCom; j++) {
				String nom = input.nextLine();
				String ideologia = input.nextLine();
				String procedencia = input.nextLine();
				Diputat d = ctrlDiputat.creaDiputat(nom, ideologia, procedencia);
				ctrlSolucio.afegirNode(sol, d, i);
				input.nextLine();
			}
			input.nextLine();
		}
		tree = ctrlSolucio.generarArbre(sol, nomF);
		input.close();
		return tree;		
	}
	
	public void escriureSolucio(Solucio<Diputat> solucio, String nomF) {
		File file = new File("io/" + nomF + ".txt");
		Diputat diputat = null;
		PrintWriter output = null;
		try {
			output = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			try {
				file.createNewFile();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			try {
				output = new PrintWriter(new FileWriter(file, true));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		output.println(solucio.getNumComunitats());
		for (int i = 0; i < solucio.getNumComunitats(); ++i) {
			ArrayList<Diputat> aux = solucio.getComunitat(i);
			output.println("Comunitat "+ i);
			output.println(aux.size());
			for (int j = 0; j < aux.size(); ++j) {
				diputat = aux.get(j);
				output.println(ctrlDiputat.getNom(diputat));
				output.println(ctrlDiputat.getIdeologia(diputat));
				output.println(ctrlDiputat.getProcedencia(diputat));
				output.println();
			}
			output.println();
		}
		output.close();
	}
	
	public ArrayList<Double> llegirEstadistica(String algorisme) {
		File file = new File("io/historial" + algorisme + ".txt");
		ArrayList<Double> temps = new ArrayList<Double>();
		Scanner input = null;
		double maxN = 0.0;
		double maxC = 0.0;
		double maxL = 0.0;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			try {
				file.createNewFile();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			try {
				input = new Scanner(file);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		int i = -1;
		while(input.hasNext()) {
			double t = Double.parseDouble(input.nextLine());
			temps.add(i + 1, t);
			++i;
			switch(algorisme) {
			case "louvain":
				if(t > maxL) maxL = t;
				break;
			case "newman":
				if(t > maxN) maxN = t;
				break;
			case "clique":
				if(t > maxC) maxC = t;
				break;
			}
		}
		switch(algorisme) {
		case "louvain":
			ctrlEstadistica.setMaxL(maxL);
			break;
		case "newman":
			ctrlEstadistica.setMaxN(maxN);
			break;
		case "clique":
			ctrlEstadistica.setMaxC(maxC);
			break;
		}
		input.close();
		return temps;
	}
	
	public HashMap<Integer,Double> llegirEstadisticaAlg(String opt) {
		File file = new File("io/historial.txt");
		Scanner input = null;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			try {
				file.createNewFile();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			try {
				input = new Scanner(file);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		HashMap<Integer, Double> map = new HashMap<>();
		String algorisme;
		int numNodes;
		double temps;
		double maxL = 0;
		double maxN = 0;
		double maxC = 0;
		while(input.hasNext()) {
			algorisme = input.nextLine();
			numNodes = input.nextInt();
			input.nextLine();
			temps =  Double.parseDouble(input.nextLine());
			if(algorisme.equals(opt)) map.put(numNodes, temps);
			switch(algorisme) {
			case "louvain":
				if(temps > maxL) {
					maxL = temps;
					ctrlEstadistica.setMaxL(maxL);
				}
				break;
			case "newman":
				if(temps > maxN) {
					maxN = temps;
					ctrlEstadistica.setMaxN(maxN);
				}
				break;
			case "clique":
				if(temps > maxC) {
					maxC = temps;
					ctrlEstadistica.setMaxC(maxC);
				}
				break;
			}
			input.nextLine();
		}
		input.close();
		return map;
	}
	
	public void escriureEstadistica(String algorisme, double temps) {
		File file = new File("io/historial" + algorisme + ".txt");
		PrintWriter output = null;
		try {
			output = new PrintWriter(new FileWriter(file, true));
		} catch (IOException e) {
			try {
				file.createNewFile();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			try {
				output = new PrintWriter(new FileWriter(file, true));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		output.println(temps);
		output.close();
	}
	
	public void escriureEstadistica(String algorisme, int numNodes, double temps) {
		File file = new File("io/historial.txt");
		PrintWriter output = null;
		try {
			output = new PrintWriter(new FileWriter(file, true));
		} catch (IOException e) {
			try {
				file.createNewFile();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			try {
				output = new PrintWriter(new FileWriter(file, true));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		output.println(algorisme);
		output.println(numNodes);
		output.println(temps);
		output.println();
		output.close();
	}

}
