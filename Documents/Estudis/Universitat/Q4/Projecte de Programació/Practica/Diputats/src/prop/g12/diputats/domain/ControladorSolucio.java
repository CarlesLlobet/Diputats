package prop.g12.diputats.domain;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JTree;

import prop.g12.common.Solucio;
import prop.g12.diputats.data.ControladorCongres;
import prop.g12.diputats.data.ControladorDiputat;
import prop.g12.diputats.data.ControladorIO;
import prop.g12.diputats.data.Diputat;

public class ControladorSolucio {

	public ControladorSolucio() {}
	
	public Solucio<Diputat> creaSolucio() {
		return new Solucio<Diputat>();
	}
	
	public boolean afegirComunitat(Solucio<Diputat>sol, int n) {
		return sol.afegirComunitat(n);
	}
	
	public boolean afegirNode(Solucio<Diputat>sol, Diputat d, int n) {
		return sol.afegirNode(d, n);
	}
	
	public double getTempsExec(Solucio<Diputat>sol) {
		return sol.getTempsExec();
	}
	
	public JTree generarArbre(Solucio<Diputat> s, String nomF) {
		JTree tree;
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(nomF);
		DefaultMutableTreeNode comunitat, diputat, ideologia, procedencia;
		Diputat dip = null;
		ControladorDiputat cDip = new ControladorDiputat();
		for (int i = 0; i < s.getNumComunitats(); ++i) {
			ArrayList<Diputat> aux = s.getComunitat(i);
			comunitat = new DefaultMutableTreeNode("Comunitat " + i);
			root.add(comunitat);
			for (int j = 0; j < aux.size(); ++j) {
				dip = aux.get(j);
				diputat = new DefaultMutableTreeNode(cDip.getNom(dip));
				comunitat.add(diputat);
				ideologia = new DefaultMutableTreeNode(cDip.getIdeologia(dip));
				diputat.add(ideologia);
				procedencia = new DefaultMutableTreeNode(cDip.getProcedencia(dip));
				diputat.add(procedencia);
			}
		}
		tree = new JTree(root);
		return tree;
	}
	
	public JTree modificarSolucio(String nomD, String idCom, String nomF, JTree tree) throws Exception {
		ControladorDiputat ctrlDiputat = new ControladorDiputat();
		ControladorIO ctrlIO = new ControladorIO();
		ControladorCongres ctrlCongres = new ControladorCongres();
		Solucio<Diputat> solucio = creaSolucio();
		Object root = tree.getModel().getRoot();
		int nComunitats = tree.getModel().getChildCount(root);
		int comunitatActual = 0;
		for(int i = 0; i < nComunitats; i++) {
			Object nodeComunitat = tree.getModel().getChild(root, i);
			String stringNode = nodeComunitat.toString();
			String scodi = stringNode.substring(stringNode.length() - 1);
			int codi = Integer.parseInt(scodi);
			solucio.afegirComunitat(codi);
			int nDiputats = tree.getModel().getChildCount(nodeComunitat);
			for(int j = 0; j < nDiputats; j++) {
				Object nodeDiputat = tree.getModel().getChild(nodeComunitat, j);
				String nom = nodeDiputat.toString();
				if(!nom.equals(nomD)) {
					Object nodeIdeologia = tree.getModel().getChild(nodeDiputat, 0);
					Object nodeProcedencia = tree.getModel().getChild(nodeDiputat, 1);
					String ideologia = nodeIdeologia.toString();
					String procedencia = nodeProcedencia.toString();
					Diputat diputat = ctrlDiputat.creaDiputat(nom, ideologia, procedencia);
					solucio.afegirNode(diputat, i);
				}
				else comunitatActual = i;
			}		
		}
		Diputat diputat = ctrlCongres.cercaDiputat(nomD);
		int id = Integer.parseInt(idCom);
		if(comunitatActual == id) throw new Exception("Origen = Desti");
		solucio.afegirNode(diputat, id);
		JTree ret = generarArbre(solucio, nomF);
		ctrlIO.escriureSolucio(solucio, nomF);
		
		RepresentarGraf rg = new RepresentarGraf();
		
		rg.crearGrafImatge(solucio);
		
		return ret;
	}	
}
