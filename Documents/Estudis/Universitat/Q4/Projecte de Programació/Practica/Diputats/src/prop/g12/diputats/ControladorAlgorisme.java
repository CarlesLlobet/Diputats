package prop.g12.diputats;
 
import java.io.IOException;
import java.util.ArrayList;
 

import javax.swing.JTree;
 

import prop.g12.common.CliquePercolation;
import prop.g12.common.Graf;
import prop.g12.common.Louvain;
import prop.g12.common.NewmanGirvan;
import prop.g12.common.Solucio;
import prop.g12.diputats.data.ControladorCongres;
import prop.g12.diputats.data.Diputat;
import prop.g12.diputats.domain.Afinitat;
import prop.g12.diputats.domain.ControladorAfinitat;
import prop.g12.diputats.domain.ControladorEstadistica;
import prop.g12.diputats.domain.RepresentarGraf;
 
 
public class ControladorAlgorisme {
       
        private ControladorAfinitat ctrlAfinitat;
        private Solucio<Diputat> s;
        
        private Graf<Diputat> g = null;
       
        private double MaxNG = 5;
        private double MinNG = 0;
        private double MaxL = 5;
        private double MinL = 0;
        private double MaxC = 5;
        private double MinC = 0;
        
        public ControladorAlgorisme(){
                ctrlAfinitat = new ControladorAfinitat();
        };
       
        public JTree selectAlgorisme(String opt, String nomF, int pEmp, int pIde, int pPro, int pEsd) throws IOException {
                
        		ControladorIO ctrlIO = new ControladorIO();
                ControladorEstadistica ctrlEst= new ControladorEstadistica();
                ControladorSolucio ctrlSol = new ControladorSolucio();
                ControladorCongres ctrlCongres = new ControladorCongres();
                Graf <Diputat> G = crearGraf(opt, pEmp, pIde, pPro, pEsd);
                ctrlCongres.setGraf(G);
                int numNodes = G.getNumNodes();
               
                double temps = 0;
                switch (opt) {
                case "louvain":
                        Louvain<Diputat> alg = new Louvain<Diputat>();
                        s = alg.generarSolucio(G);
                        temps = ctrlSol.getTempsExec(s);
                        //double MaxL = ctrlEst.getMaxL();
                        //double MinL = ctrlEst.getMinL();
                        if (MaxL < temps + 5){ MaxL = temps + 5; }
                        if (MinL > temps - 5){ MinL = temps - 5; }
                        break;
                       
                case "clique":
                        CliquePercolation<Diputat> alg2 = new CliquePercolation<Diputat>(3,0.2);
                        s = alg2.generarSolucio(G);
                        temps = ctrlSol.getTempsExec(s);
                        //double MaxC = ctrlEst.getMaxL();
                        //double MinC = ctrlEst.getMinL();
                        if (MaxC < temps + 5){ MaxC = temps + 5; }
                        if (MinC > temps - 5){ MinC = temps - 5; }
                        break;
                       
                case "newman":
                        NewmanGirvan<Diputat> alg3 = new NewmanGirvan<Diputat>();
                        s = alg3.generarSolucio(G);
                        temps = ctrlSol.getTempsExec(s);
                        //double MaxNG = ctrlEst.getMaxL();
                        //double MinNG = ctrlEst.getMinL();
                        if (MaxNG < temps + 5){ MaxNG = temps + 5; }
                        if (MinNG > temps - 5){ MinNG = temps - 5; }
                        break;
                }
                
                ctrlEst.crearGrafiquesSol();
                
                ctrlEst.crearGrafiquesNodes();
                
                ctrlIO.escriureEstadistica(opt, temps);
                ctrlIO.escriureEstadistica(opt, numNodes, temps);
               
                //G = crearGraf(opt, pEmp, pIde, pPro, pEsd);
                G = ctrlCongres.getGraf();
                
                
                RepresentarGraf rg = new RepresentarGraf();
                rg.crearGrafImatge(s);
               
                JTree tree = new JTree();
                ctrlIO.escriureSolucio(s, nomF);
                tree = ctrlSol.generarArbre(s,nomF);
                return tree;
        }
       
        Graf<Diputat> crearGraf(String opt, int pEmp, int pIde, int pPro, int pEsd) {
                Graf<Diputat> G = new Graf<Diputat>();
                Afinitat afinitat = ctrlAfinitat.creaAfinitat();
                ArrayList<Diputat> dips = ControladorCongres.getDiputats();
                for(int j = 0; j < dips.size(); j++) {
                        for(int k = 0; k < dips.size(); k++) {
                        		Diputat d1 = dips.get(j);
                                Diputat d2 = dips.get(k);
                                if(j != k) {
                                        double a = 0;
                                        try {
                                                a = ctrlAfinitat.calculAfinitat(opt, afinitat, d1, d2, pEmp, pIde, pPro, pEsd);
                                        } catch (Exception e) {
                                                e.printStackTrace();
                                        }
                                        if(a >= 0.0)
                                                try {
                                                        G.afegirAresta(d1, d2, a);
                                                } catch (Exception e) {
                                                        e.printStackTrace();
                                                }
                                }
                        }
                }
                return G;
        }
        
        public Graf<Diputat> getGraf(){
        	return g;
        }
       
        /*public void grafModificat(String sol) {
        	ControladorIO ctrlIO = new ControladorIO();
        	Graf<Diputat> G = ctrlIO.llegirAdjacencia();
        	JTree tree = new JTree();
        	tree = ctrlIO.llegirSolucio(sol);
        	Solucio<Diputat> s = ctrlIO.obtenirSolucio(tree);
        }*/
}