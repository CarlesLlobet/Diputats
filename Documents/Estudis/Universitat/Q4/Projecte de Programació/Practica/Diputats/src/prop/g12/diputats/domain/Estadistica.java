package prop.g12.diputats.domain;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
 
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
 
public class Estadistica {
       
        private static Estadistica estadistica = new Estadistica();
       
        /**
         * HashMap de NewmanGirvan amb els nodes i el temps d'execució obtinguts al utilitzar aquest algoritme
         */
        private static HashMap<Integer,Double> mapNGNodes;
        /**
         * HashMap de Louvain amb els nodes i el temps d'execució obtinguts al utilitzar aquest algoritme
         */
        private static HashMap<Integer,Double> mapLouvainNodes;
        /**
         * HashMap de CliquePercolation amb els nodes i el temps d'execució obtinguts al utilitzar aquest algoritme
         */
        private static HashMap<Integer,Double> mapCliqueNodes;
       
        /**
         * ArrayList de NewmanGirvan amb el temps d'execució obtinguts al utilitzar aquest algoritme
         */
        private static ArrayList<Double> ArrayNGSol;
        /**
         * ArrayList de Louvain amb el temps d'execució obtinguts al utilitzar aquest algoritme
         */
        private static ArrayList<Double> ArrayLSol;
        /**
         * ArrayList de Clique amb el temps d'execució obtinguts al utilitzar aquest algoritme
         */
        private static ArrayList<Double> ArrayCSol;
              
    	/**
    	 * Colors de la Grafica
    	 */
        private static Color COLOR_SERIE_1 = new Color(255, 128, 64);
     
        private static Color COLOR_SERIE_2 = new Color(28, 84, 140);
       
        private static Color COLOR_SERIE_3 = new Color(255, 67, 14);
     
        private static Color COLOR_RECUADRE_GRAFICA = new Color(31, 87, 4);
     
        private static Color COLOR_FONDO_GRAFICA = Color.white;
     
        /**
         * Creadora buida d'Estadistica que inicialitza els maps i ArrayList de la classe
         */
        public Estadistica(){
                mapNGNodes = new HashMap<Integer,Double>();
                mapLouvainNodes = new HashMap<Integer,Double>();
                mapCliqueNodes = new HashMap<Integer,Double>();
                ArrayNGSol = new ArrayList<Double>();
                ArrayLSol = new ArrayList<Double>();
                ArrayCSol = new ArrayList<Double>();
                
        }
       
        /**
         * Creadora de la grafica lineal
         * @param dataset: Coleccio de solucions
         * @param Max: Màxim rang de la gràfica
         * @param Min: Mínim rang de la gràfica
         * @param Int: Boolea que determina si serà de tipus nodes o de tipus solucions
         * @return
         */
        public static JFreeChart crearGrafica(XYSeriesCollection dataset, double Max, boolean Int) {
            JFreeChart chart;
            String titol;
            String condicio;
            if (Max == 0) Max = 5.0;
            if (Int){ titol = "Temps d'execució entre algoritmes"; condicio = "Nombre de Diputats";}
            else{ titol = "Temps d'execucio de les solucions"; condicio = "Solucions";}
            chart = ChartFactory.createXYLineChart(titol, condicio, "Temps (milisegons)",
                dataset,
                PlotOrientation.VERTICAL,
                true, // us de leyenda
                false, // us de tooltips  
                false // us de urls
                );
            // color de fondo de la gràfica
            chart.setBackgroundPaint(COLOR_FONDO_GRAFICA);
            final XYPlot plot = (XYPlot) chart.getPlot();
            configurarPlot(plot);
           
            if (Int){
                        final NumberAxis domainAxis = (NumberAxis)plot.getDomainAxis();
                        configurarDomainAxisInt(domainAxis);
            }
            else{
                        final NumberAxis domainAxis = (NumberAxis)plot.getDomainAxis();
                        configurarDomainAxisSol(domainAxis);
            }
           
            final NumberAxis rangeAxis = (NumberAxis)plot.getRangeAxis();
            configurarRangeAxis(rangeAxis, Max);
           
            final XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer)plot.getRenderer();
            configurarRendered(renderer);
           
            return chart;
        }
             
        // Configurem contingut gràfic (color a les linees que serveixen de guia)
        private static void configurarPlot (XYPlot plot) {
            plot.setDomainGridlinePaint(COLOR_RECUADRE_GRAFICA);
            plot.setRangeGridlinePaint(COLOR_RECUADRE_GRAFICA);
        }
         
        // Configurem eix x de la gràfica CAS NODES (numeros enters de 10 en 10 en el cas de nodes, per la seva visualització)
        private static void configurarDomainAxisInt (NumberAxis domainAxis) {
            domainAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
            domainAxis.setTickUnit(new NumberTickUnit(10));
        }
         
        // Configurem eix x de la gràfica CAS SOLUCIONS (numeros enters de 1 en 1, una posició per Solucio)
        private static void configurarDomainAxisSol (NumberAxis domainAxis) {
            domainAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
            domainAxis.setTickUnit(new NumberTickUnit(1));
        }
       
        // Configurem eix y de la gràfica (numeros enters de 10 en 10 i rang entre Min i Max)
        private static void configurarRangeAxis (NumberAxis rangeAxis, double Max) {
            rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
            rangeAxis.setTickUnit(new NumberTickUnit(10));
            rangeAxis.setRange(0, Max);
        }
         
        // Configurem les linees de les series (afegim una marca als punts i asignem el color de cada serie)
        private static void configurarRendered (XYLineAndShapeRenderer renderer) {
            renderer.setSeriesShapesVisible(0, true);
            renderer.setSeriesShapesVisible(1, true);
            renderer.setSeriesShapesVisible(2, true);
            renderer.setSeriesPaint(0, COLOR_SERIE_1);
            renderer.setSeriesPaint(1, COLOR_SERIE_2);
            renderer.setSeriesPaint(2, COLOR_SERIE_3);
        }
        
        /**
         * Assigna el conjunt de nodes,temps de NewmanGirvan a la gràfica a mostrar de tipus Nodes
         * @param coleccio: Paràmetre que recull el conjunt de nodes,temps
         */
        public static void incloureSolucionsNGNodes(XYSeriesCollection coleccio) {
                final XYSeries serie1 = new XYSeries("Newman Girvan");
                int eneAct;
                double temps;
                Set<Integer> ksNG = mapNGNodes.keySet();
                java.util.Iterator<Integer> it = ksNG.iterator();
                while (it.hasNext()) {
                        eneAct = it.next();
                        temps = mapNGNodes.get(eneAct);
                serie1.add(eneAct, temps);
                }
            coleccio.addSeries(serie1);
        }
       
        /**
         * Assigna el conjunt de nodes,temps de Louvain a la gràfica a mostrar de tipus Nodes
         * @param coleccio: Paràmetre que recull el conjunt de nodes,temps
         */
        public static void incloureSolucionsLouvainNodes(XYSeriesCollection coleccio) {
            final XYSeries serie2 = new XYSeries("Louvain");
            int eneAct;
                double temps;
                Set<Integer> ksNG = mapLouvainNodes.keySet();
                java.util.Iterator<Integer> it = ksNG.iterator();
                while (it.hasNext()) {
                        eneAct = it.next();
                        temps = mapLouvainNodes.get(eneAct);
                serie2.add(eneAct, temps);
                }
            coleccio.addSeries(serie2);
        }
       
        /**
         * Assigna el conjunt de nodes,temps de Clique a la gràfica a mostrar de tipus Nodes
         * @param coleccio: Paràmetre que recull el conjunt de nodes,temps
         */
        public static void incloureSolucionsCliqueNodes(XYSeriesCollection coleccio) {
            final XYSeries serie3 = new XYSeries("Clique");
            int eneAct;
                double temps;
                Set<Integer> ksNG = mapCliqueNodes.keySet();
                java.util.Iterator<Integer> it = ksNG.iterator();
                while (it.hasNext()) {
                        eneAct = it.next();
                        temps = mapCliqueNodes.get(eneAct);
                        serie3.add(eneAct, temps);
                }
            coleccio.addSeries(serie3);
        }  
 
        /**
         * Assigna el conjunt de temps d'execució de NewmanGirvan a la gràfica a mostrar de tipus Solució
         * @param coleccio: Paràmetre que recull el conjunt de temps d'execució
         */
	    public static void incloureSolucionsNGSol(XYSeriesCollection coleccio) {
	        final XYSeries serie = new XYSeries("Newman Girvan");
	            double temps;
	            int n = ArrayNGSol.size();
	            for (int i = 1; i <= n; ++i) {
                    temps = ArrayNGSol.get(i-1);
                    serie.add(i, temps);
	            }
	            coleccio.addSeries(serie);
	    }
	       
        /**
         * Assigna el conjunt de temps d'execució de Louvain a la gràfica a mostrar de tipus Solució
         * @param coleccio: Paràmetre que recull el conjunt de temps d'execució
         */
	    public static void incloureSolucionsLSol(XYSeriesCollection coleccio) {
            final XYSeries serie = new XYSeries("Louvain");
            double temps;
            int n = ArrayLSol.size();
            for (int i = 1; i <= n; ++i) {
                 temps = ArrayLSol.get(i-1);
                 serie.add(i, temps);
            }
            coleccio.addSeries(serie);
	    }
	       
        /**
         * Assigna el conjunt de temps d'execució de Clique a la gràfica a mostrar de tipus Solució
         * @param coleccio: Paràmetre que recull el conjunt de temps d'execució
         */
	    public static void incloureSolucionsCSol(XYSeriesCollection coleccio) {
            final XYSeries serie = new XYSeries("Clique");
			double temps;
			int n = ArrayCSol.size();
			for (int i = 1; i <= n; ++i) {
		        temps = ArrayCSol.get(i-1);
	            serie.add(i, temps);
			}
			coleccio.addSeries(serie);
        }
               
               
        /**
         * Pre: -
         * @return: Retorna un HashMap<Integer,Double> amb els nodes i el temps d'execució de les Solucions de NewmanGirvan
         */
        public static HashMap<Integer,Double> getMapNGNodes() {
                return mapNGNodes;
        }
       
        /**
         * Pre: -
         * @return: Retorna un HashMap<Integer,Double> amb els nodes i el temps d'execució de les Solucions de Louvain
         */
        public static HashMap<Integer,Double> getMapLouvainNodes() {
                return mapLouvainNodes;
        }
       
        /**
         * Pre: -
         * @return: Retorna un HashMap<Integer,Double> amb els nodes i el temps d'execució de les Solucions de Clique
         */
        public static HashMap<Integer,Double> getMapCliqueNodes() {
                return mapCliqueNodes;
        }
       
        /**
         * Assigna un nou conjunt de parells de nodes,temps al HashMap<Integer,Double> ja existent de NewmanGirvan
         * @param m: Nou HashMap a assignar
         */
        public static void setMapNGNodes(HashMap<Integer,Double> m) {
                mapNGNodes = m;
        }
       
        /**
         * Assigna un nou conjunt de parells de nodes,temps al HashMap<Integer,Double> ja existent de Louvain
         * @param m: Nou HashMap a assignar
         */
        public static void setMapLouvainNodes(HashMap<Integer,Double> m) {
                mapLouvainNodes = m;
        }
       
        /**
         * Assigna un nou conjunt de parells de nodes,temps al HashMap<Integer,Double> ja existent de Clique
         * @param m: Nou HashMap a assignar
         */
        public static void setMapCliqueNodes(HashMap<Integer,Double> m) {
                mapCliqueNodes = m;
        }
       
       
 
        /**
         * Pre: -
         * @return: Retorna un ArrayList<Double> amb els temps d'execució de les Solucions de NewmanGirvan
         */
        public static ArrayList<Double> getArrayNGSol() {
                return ArrayNGSol;
        }
       
        /**
         * Pre: -
         * @return: Retorna un ArrayList<Double> amb els temps d'execució de les Solucions de Louvain
         */
        public static ArrayList<Double> getArrayLSol() {
                return ArrayLSol;
        }
       
        /**
         * Pre: -
         * @return: Retorna un ArrayList<Double> amb els temps d'execució de les Solucions de Clique
         */
        public static ArrayList<Double> getArrayCSol() {
                return ArrayCSol;
        }
       
        /**
         * Assigna un nou conjunt de temps a la ArrayList<Double> ja existent de NewmanGirvan
         * @param m: Nou HashMap a assignar
         */
        public static void setArrayNGSol(ArrayList<Double> m) {
                ArrayNGSol = m;
        }
       
        /**
         * Assigna un nou conjunt de temps a la ArrayList<Double> ja existent de Louvain
         * @param m: Nou HashMap a assignar
         */
        public static void setArrayLSol(ArrayList<Double> m) {
                ArrayLSol = m;
        }
       
        /**
         * Assigna un nou conjunt de temps a la ArrayList<Double> ja existent de Clique
         * @param m: Nou HashMap a assignar
         */
        public static void setArrayCSol(ArrayList<Double> m) {
                ArrayCSol = m;
        }
       
        /**
         * Pre: -
         * @return: Retorna la propia instancia actual d'Estadistica
         */
        public static Estadistica getInstance() {
                return estadistica;
        }
 
}