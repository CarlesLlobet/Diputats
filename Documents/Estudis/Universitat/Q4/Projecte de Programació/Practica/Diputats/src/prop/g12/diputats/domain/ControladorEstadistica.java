package prop.g12.diputats.domain;
 
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeriesCollection;

import prop.g12.diputats.data.ControladorIO;
 

 
public class ControladorEstadistica {
	
		private double MaxL;
		private double MaxNG;
		private double MaxC;
       
        public ControladorEstadistica() {}
 
        public Estadistica creaEstadistica() {
                return new Estadistica();
        }
       
        public static Estadistica getEstadistica() {
                return Estadistica.getInstance();
        }
       
        public HashMap<Integer, Double> getEstNGNodes() {
                return Estadistica.getMapNGNodes();
        }
       
        public HashMap<Integer, Double> getEstLouvainNodes() {
                return Estadistica.getMapLouvainNodes();
        }
       
        public HashMap<Integer, Double> getEstCliqueNodes() {
                return Estadistica.getMapCliqueNodes();
        }
        
        public void setMaxN(double maxN) {
        	MaxNG = maxN;
        }
        
        public void setMaxC(double maxC) {
        	MaxC = maxC;
        }
        
        public void setMaxL(double maxL) {
        	MaxL = maxL;
        }
       
       
        /**
         * Pre: -
         * @return: Retorna la llista ambs les Solucio<Diputat>ns de NewmanGirvan
         */
        public static void setMapNGNodes(HashMap<Integer,Double> m) {
                Estadistica.setMapNGNodes(m);
        }
       
        /**
         * Pre: -
         * @return: Retorna la llista ambs les Solucio<Diputat>ns de Louvain
         */
        public static void setMapLouvainNodes(HashMap<Integer,Double> m) {
                Estadistica.setMapLouvainNodes(m);
        }
       
        /**
         * Pre: -
         * @return: Retorna la llista ambs les Solucio<Diputat>ns de CliquePercolation
         */
        public static void setMapCliqueNodes(HashMap<Integer,Double> m) {
                Estadistica.setMapCliqueNodes(m);
        }
       
       
       
        public ArrayList<Double> getEstNGSol() {
                return Estadistica.getArrayNGSol();
        }
       
        public ArrayList<Double> getEstLouvainSol() {
                return Estadistica.getArrayLSol();
        }
       
        public ArrayList<Double> getEstCliqueSol() {
                return Estadistica.getArrayCSol();
        }
       
        /**
         * Pre: -
         * @return: Retorna la llista ambs les Solucio<Diputat>ns de NewmanGirvan
         */
        public static void setArrayNGSol(ArrayList<Double> m) {
                Estadistica.setArrayNGSol(m);
        }
       
        /**
         * Pre: -
         * @return: Retorna la llista ambs les Solucio<Diputat>ns de Louvain
         */
        public static void setArrayLSol(ArrayList<Double> m) {
                Estadistica.setArrayLSol(m);
        }
       
        /**
         * Pre: -
         * @return: Retorna la llista ambs les Solucio<Diputat>ns de CliquePercolation
         */
        public static void setArrayCSol(ArrayList<Double> m) {
                Estadistica.setArrayCSol(m);
        }      
       
       
       
       
        public JFreeChart crearGrafica(XYSeriesCollection dataset, double Max, boolean Int) {
                return Estadistica.crearGrafica(dataset, Max, Int);
        }
       
        public void incloureSolucionsNGNodes(XYSeriesCollection coleccio) {
                Estadistica.incloureSolucionsNGNodes(coleccio);
        }
       
        public void incloureSolucionsLouvainNodes(XYSeriesCollection coleccio) {
                Estadistica.incloureSolucionsLouvainNodes(coleccio);
        }
       
        public void incloureSolucionsCliqueNodes(XYSeriesCollection coleccio) {
                Estadistica.incloureSolucionsCliqueNodes(coleccio);
        }
       
        public void incloureSolucionsNGSol(XYSeriesCollection coleccio) {
                Estadistica.incloureSolucionsNGSol(coleccio);
        }
       
        public void incloureSolucionsLSol(XYSeriesCollection coleccio) {
                Estadistica.incloureSolucionsLSol(coleccio);
        }
       
        public void incloureSolucionsCSol(XYSeriesCollection coleccio) {
                Estadistica.incloureSolucionsCSol(coleccio);
        }
       
       
       
       
       
        public void crearGrafiquesNodes(){
            ControladorIO ctrlIO = new ControladorIO();
            final XYSeriesCollection coleccio1 = new XYSeriesCollection();
            final XYSeriesCollection coleccio2 = new XYSeriesCollection();
            final XYSeriesCollection coleccio3 = new XYSeriesCollection();
            double auxMax;
            HashMap<Integer,Double> MNG = ctrlIO.llegirEstadisticaAlg("newman");
            setMapNGNodes(MNG);
            HashMap<Integer,Double> ML = ctrlIO.llegirEstadisticaAlg("louvain");
            setMapLouvainNodes(ML);
            HashMap<Integer,Double> MC = ctrlIO.llegirEstadisticaAlg("clique");
            setMapCliqueNodes(MC);
            
            MaxNG = 10.0;
            MaxL = 10.0;
            MaxC = 10.0;
            
            Iterator<Integer> it = MNG.keySet().iterator();
            while (it.hasNext()) {
            	double valor = MNG.get(it.next());
            	if (valor > MaxNG) MaxNG = valor;
            }
            MaxNG+=10;
            it = ML.keySet().iterator();
            while (it.hasNext()) {
            	double valor = ML.get(it.next());
            	if (valor > MaxL) MaxL = valor;
            }   
            MaxL+=10;
            it = MC.keySet().iterator();
            while (it.hasNext()) {
            	double valor = MC.get(it.next());
            	if (valor > MaxC) MaxC = valor;
            }       
            MaxC+=10;
            
            //Gràfica buida
            try {
                final JFreeChart grafica = Estadistica.crearGrafica(coleccio1, 10, true);
                ChartUtilities.saveChartAsJPEG(new File("io/"+"estadisticaNodes7"+".jpeg"), grafica, 1200, 600);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Gràfica NewmanGirvan
            incloureSolucionsNGNodes(coleccio1);
            try {
                final JFreeChart grafica = Estadistica.crearGrafica(coleccio1, MaxNG, true);
                ChartUtilities.saveChartAsJPEG(new File("io/"+"estadisticaNodes6"+".jpeg"), grafica, 1200, 600);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Gràfica Louvain
            incloureSolucionsLouvainNodes(coleccio2);
            try {
                final JFreeChart grafica = Estadistica.crearGrafica(coleccio2, MaxL, true);
                ChartUtilities.saveChartAsJPEG(new File("io/"+"estadisticaNodes5"+".jpeg"), grafica, 1200, 600);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Gràfica Clique
            incloureSolucionsCliqueNodes(coleccio3);
            try {
                final JFreeChart grafica = Estadistica.crearGrafica(coleccio3, MaxC, true);
                ChartUtilities.saveChartAsJPEG(new File("io/"+"estadisticaNodes3"+".jpeg"), grafica, 1200, 600);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Gràfica NewmanGirvan + Louvain
            incloureSolucionsLouvainNodes(coleccio1);
            try {
                if (MaxNG > MaxL) auxMax = MaxNG; 
                else auxMax = MaxL;
                final JFreeChart grafica = Estadistica.crearGrafica(coleccio1, auxMax, true);
                ChartUtilities.saveChartAsJPEG(new File("io/"+"estadisticaNodes4"+".jpeg"), grafica, 1200, 600);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Gràfica NewmanGirvan + Clique
            incloureSolucionsNGNodes(coleccio3);
            try {
                if (MaxNG > MaxC) auxMax = MaxNG; 
                else auxMax = MaxC;
                final JFreeChart grafica = Estadistica.crearGrafica(coleccio3, auxMax, true);
                ChartUtilities.saveChartAsJPEG(new File("io/"+"estadisticaNodes2"+".jpeg"), grafica, 1200, 600);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Gràfica Louvain + Clique
            incloureSolucionsCliqueNodes(coleccio2);
            try {
                if (MaxL > MaxC) auxMax = MaxL; 
                else auxMax = MaxC;
                final JFreeChart grafica = Estadistica.crearGrafica(coleccio2, auxMax, true);
                ChartUtilities.saveChartAsJPEG(new File("io/"+"estadisticaNodes1"+".jpeg"), grafica, 1200, 600);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Gràfica NewmanGirvan + Louvain + Clique
            incloureSolucionsCliqueNodes(coleccio1);
            try {
            	auxMax = MaxL;
                if (MaxNG > auxMax) auxMax = MaxNG; 
                if (auxMax < MaxC) auxMax = MaxC;

                final JFreeChart grafica = Estadistica.crearGrafica(coleccio1, auxMax, true);
                ChartUtilities.saveChartAsJPEG(new File("io/"+"estadisticaNodes"+".jpeg"), grafica, 1200, 600);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
       
       
       
        public void crearGrafiquesSol(){
            ControladorIO ctrlIO = new ControladorIO();
            final XYSeriesCollection coleccio1 = new XYSeriesCollection();
            final XYSeriesCollection coleccio2 = new XYSeriesCollection();
            final XYSeriesCollection coleccio3 = new XYSeriesCollection();
            ArrayList<Double> NG = ctrlIO.llegirEstadistica("newman");
            setArrayNGSol(NG);
            ArrayList<Double> L = ctrlIO.llegirEstadistica("louvain");
            setArrayLSol(L);
            ArrayList<Double> C = ctrlIO.llegirEstadistica("clique");
            setArrayCSol(C);
            //Gràfica CliquePercolation
            incloureSolucionsCSol(coleccio1);
            try {
                final JFreeChart grafica = Estadistica.crearGrafica(coleccio1, MaxC, false);
                ChartUtilities.saveChartAsJPEG(new File("io/"+"estadisticaSolucions"+".jpeg"), grafica, 1200, 600);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Gràfica Louvain
            incloureSolucionsLSol(coleccio2);
            try {
                final JFreeChart grafica = Estadistica.crearGrafica(coleccio2, MaxL, false);
                ChartUtilities.saveChartAsJPEG(new File("io/"+"estadisticaSolucions1"+".jpeg"), grafica, 1200, 600);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Gràfica NewmanGirvan
            incloureSolucionsNGSol(coleccio3);
            try {
                final JFreeChart grafica = Estadistica.crearGrafica(coleccio3, MaxNG, false);
                ChartUtilities.saveChartAsJPEG(new File("io/"+"estadisticaSolucions2"+".jpeg"), grafica, 1200, 600);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}