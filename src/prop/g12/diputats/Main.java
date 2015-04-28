package prop.g12.diputats;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

//Provant si em funciona el push/pull desde eclipse

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
	
	public static class Ventana3D extends JFrame{
		JPanel panel;
	    public Ventana3D() throws IOException{
	        setTitle("Como Hacer Graficos con Java");
	        setSize(800,600);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setVisible(true);
	        init();
	    }
	 
	    private void init() throws IOException {
	        panel = new JPanel();
	        getContentPane().add(panel);
	        // Fuente de Datos
	        DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
	        defaultpiedataset.setValue("Programacion", new Double(41.200000000000003D));
	        defaultpiedataset.setValue("Electronica", new Double(11D));
	        defaultpiedataset.setValue("Hacking", new Double(19.5D));
	        defaultpiedataset.setValue("SEO", new Double(30.5D));
	        defaultpiedataset.setValue("Redes", new Double(2.0D));
	 
	        // Creando el Grafico
	        JFreeChart chart = ChartFactory.createPieChart3D("Tematicas Blog", defaultpiedataset, true, true, false);
	        PiePlot3D pieplot3d = (PiePlot3D)chart.getPlot();
	        pieplot3d.setDepthFactor(0.2);
	        pieplot3d.setStartAngle(290D);
	        pieplot3d.setDirection(Rotation.CLOCKWISE);
	        pieplot3d.setForegroundAlpha(0.5F);
	        
	        // Mostrar Grafico
	        ChartPanel chartPanel = new ChartPanel(chart);
	        panel.add(chartPanel);
	        
	        //Guardar grafica
	        ChartUtilities.saveChartAsJPEG(new File("grafica3D.jpg"), chart, 1000, 600);
	    }
	}
	
	public static class VentanaLinear extends JFrame{
	    JPanel panel;
	    public VentanaLinear() throws IOException{
	        setTitle("Como Hacer Graficos con Java");
	        setSize(800,600);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setVisible(true);
	        init();
	    }
	 
	    private void init() throws IOException {
	        panel = new JPanel();
	        getContentPane().add(panel);
	        // Fuente de Datos
	        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
	        line_chart_dataset.addValue(80, "visitas", "Julio");
	        line_chart_dataset.addValue(300, "visitas", "Agosto");
	        line_chart_dataset.addValue(600, "visitas", "Septiembre");
	        line_chart_dataset.addValue(1200, "visitas", "Octubre");
	        line_chart_dataset.addValue(2400, "visitas", "Noviembre");  
	 
	        // Creando el Grafico
	        JFreeChart chart=ChartFactory.createLineChart("Trafico en el Blog",
	                "Mes","Visitas",line_chart_dataset,PlotOrientation.VERTICAL,
	                true,true,false);  
	        
	        // Mostrar Grafico
	        ChartPanel chartPanel = new ChartPanel(chart);
	        panel.add(chartPanel);
	        
	      //Guardar grafica
	        ChartUtilities.saveChartAsJPEG(new File("grafica_linial.jpg"), chart, 1000, 600);
	    }
	}
	
	
	public static void main(String[] args) throws IOException {
		io();
		afegirDiputats();
		//afegirEmpreses();
		//afegirVots();
		out.close();
		
		//Si cliques el boto de la estadistica de temps en funcio del nombre de diputats
		new VentanaLinear().setVisible(true);		
		
	}
}
