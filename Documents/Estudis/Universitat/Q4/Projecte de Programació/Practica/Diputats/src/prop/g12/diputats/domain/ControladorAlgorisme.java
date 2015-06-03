package prop.g12.diputats.domain;
 
import java.io.IOException;
import java.util.ArrayList;
 


import javax.swing.JTree;
 


import prop.g12.common.CliquePercolation;
import prop.g12.common.Graf;
import prop.g12.common.Louvain;
import prop.g12.common.NewmanGirvan;
import prop.g12.common.Solucio;
import prop.g12.diputats.data.ControladorCongres;
import prop.g12.diputats.data.ControladorIO;
import prop.g12.diputats.data.Diputat;
import prop.g12.diputats.domain.Afinitat;
import prop.g12.diputats.domain.ControladorAfinitat;
import prop.g12.diputats.domain.ControladorEstadistica;
import prop.g12.diputats.domain.RepresentarGraf;
 
 
public class ControladorAlgorisme {
       
        private ControladorAfinitat ctrlAfinitat;
        private Solucio<Diputat> s;
        
        private Graf<Diputat> g = null;
        
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
                        break;
                       
                case "clique":
                        CliquePercolation<Diputat> alg2 = new CliquePercolation<Diputat>(3,0.1);
                        s = alg2.generarSolucio(G);
                        temps = ctrlSol.getTempsExec(s);
                        break;
                       
                case "newman":
                        NewmanGirvan<Diputat> alg3 = new NewmanGirvan<Diputat>();
                        s = alg3.generarSolucio(G);
                        temps = ctrlSol.getTempsExec(s);
                        break;
                }
                
                ctrlEst.crearGrafiquesNodes();
                ctrlEst.crearGrafiquesSol();
                
                ctrlIO.escriureEstadistica(opt, temps);
                ctrlIO.escriureEstadistica(opt, numNodes, temps);
               
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
}