package prop.g12.diputats.domain;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;

import prop.g12.common.Graf;
import prop.g12.common.Solucio;
import prop.g12.diputats.data.ControladorCongres;
import prop.g12.diputats.data.ControladorIO;
import prop.g12.diputats.data.Diputat;
import prop.g12.diputats.mxgraph.util.mxCellRenderer;
import prop.g12.diputats.mxgraph.util.mxConstants;
import prop.g12.diputats.mxgraph.view.mxGraph;
import prop.g12.diputats.mxgraph.view.mxStylesheet;

public class RepresentarGraf{

	String[] colors = {"red", "purple", "orange", "yellow", "green", "white", "blue",
			"beige", "brown", "coral", "aliceblue", "indigo ","honeydew","gold",
			"dodgerblue","lemonchiffon","lightsalmon","lime","mediumseagreen",
			"mediumturquoise","olive","salmon"};
	
	public RepresentarGraf(){}
	
	public void crearGrafImatge(Solucio<Diputat> s) throws IOException {
		
		ControladorCongres ctrlCongres = new ControladorCongres();
		Graf<Diputat> G = ctrlCongres.getGraf();
		
		ControladorIO ctrlIO = new ControladorIO();
		try {
			ctrlIO.escriureAdjacencia(G);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		final mxGraph graph = new mxGraph();
		
		mxStylesheet stylesheet = graph.getStylesheet();
		Hashtable<String, Object> style = new Hashtable<String, Object>();
		style.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_RECTANGLE);
		style.put(mxConstants.STYLE_OPACITY, 50);
		style.put(mxConstants.STYLE_FONTCOLOR, "color=white");
		stylesheet.putCellStyle("ROUNDED", style);
		
		graph.getModel().beginUpdate();
		
		HashMap<Diputat, Object> mapa = new HashMap<Diputat, Object>();
		int n = s.getNumComunitats();
		int y = 0;
		int x = 0;
		int ymax = 0;
		int xmax = 0;
		boolean parell = false;
		boolean senar = true;
		for (int i = 0; i < n; ++i) {
			ArrayList<Diputat> aux = s.getComunitat(i);
			y = ymax;
			x = xmax;
			if (parell) ymax += 70;
			else xmax += 70;
			for (int j = 0; j < aux.size(); ++j) {	
				Diputat dip = aux.get(j);
				int xx = (dip.getNom().length())*10;
				Object v1 = graph.insertVertex(null, null, dip.getNom(), x, y, xx, 20,"ROUNDED;strokeColor=red;fillColor="+colors[i]);
				mapa.put(dip,v1);
				if (parell) {
					x += 50;
					if (x >= 1600) {
						x = xmax;
						y = ymax;
						ymax += 70;
					}
					if (senar) y += 20;
					else y -= 20;
				}
				else {
					y += 50;
					if (y >= 650) {
						y = ymax;
						x = xmax;
						xmax += 70;
					}
					if (senar) x += 20;
					else x -= 20;
				}
				senar = !senar;
			}			
			parell = !parell;
		}
		
		Set<Diputat> set = G.getNodes();
		int n2 = set.size();
		Iterator<Diputat> it = set.iterator();
		while (it.hasNext()) {
			Diputat nodeAct = it.next();
			Map<Diputat, Double> map = null;
			try {
				map = G.getAdjacencia(nodeAct);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Iterator<Diputat> it2 = map.keySet().iterator();
			while (it2.hasNext()) {
				Diputat nodeNext = it2.next();
				graph.insertEdge(null, null, null, mapa.get(nodeAct), mapa.get(nodeNext));
			}
		}
		
		if (n == 0 && n2 == 0) {
			ArrayList<Diputat> dips = ControladorCongres.getDiputats();
			x = 0;
			y = 0;
			for(int j = 0; j < dips.size(); j++) {
				Diputat dip = dips.get(j);				
				graph.insertVertex(null, null, dip.getNom(), x, y, 100, 20,"ROUNDED;strokeColor=red;fillColor="+colors[j]);
				x += 150;
				if (x >= 500) {
					x = 0;
					y += 50;
				}
			}
		}
		graph.getModel().endUpdate();
		BufferedImage image = mxCellRenderer.createBufferedImage(graph, null, 1, Color.WHITE, true, null);
		ImageIO.write(image, "PNG", new File("io/graf.png"));
	}
}


