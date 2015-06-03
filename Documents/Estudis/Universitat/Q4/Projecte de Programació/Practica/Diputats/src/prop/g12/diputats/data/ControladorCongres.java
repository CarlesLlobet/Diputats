package prop.g12.diputats.data;

import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import prop.g12.common.Graf;

public class ControladorCongres {
	
	private ControladorEmpresa ctrlEmpresa;
	private ControladorDiputat ctrlDiputat;
	private ControladorEsdeveniment ctrlEsdeveniment;
	
	/**
	 * Pre: -
	 * Post: Crea una nova instancia de ControladorCongres
	 */
	public ControladorCongres() {
		ctrlDiputat = new ControladorDiputat();
		ctrlEsdeveniment = new ControladorEsdeveniment();
		ctrlEmpresa = new ControladorEmpresa();
	}
	
	/**
	 * Pre: -
	 * Post: Crea la instancia de congres
	 */
	public void creaCongres() {
		new Congres();
	}
	
	/**
	 * Pre: -
	 * @return: Retorna la instancia del congres
	 */
	public static Congres getCongres() {
		return Congres.getInstance();
	}
	
	/**
	 * Pre: -
	 * @return: Retorna la llista de diputats del congres
	 */
	public static ArrayList<Diputat> getDiputats() {
		return Congres.getCongres();
	}
	
	/**
	 * Pre: -
	 * @return: Retorna la llista d'esdeveniments del congres
	 */
	public static ArrayList<Esdeveniment> getEsdeveniments() {
		return Congres.getEsdeveniments();
	}
	
	/**
	 * Pre: -
	 * @return: Retorna la llista d'empreses del congres
	 */
	public static ArrayList<Empresa> getEmpreses() {
		return Congres.getEmpreses();
	}
	
	/**
	 * Pre: -
	 * @param diputats: Nova llista de diputats
	 * Post: La llista de diputats del congres passa a ser diputats
	 */
	public void setDiputats(ArrayList<Diputat> diputats) {
		Congres.setDiputats(diputats);
	}
	
	/**
	 * Pre: -
	 * @param empreses: Nova llista d'empreses
	 * Post: La llista d'empreses del congres passa a ser empreses
	 */
	public void setEmpreses(ArrayList<Empresa> empreses) {
		Congres.setEmpreses(empreses);
	}
	
	/**
	 * Pre: -
	 * @param esdeveniments: Nova llista d'esdeveniments
	 * Post: La llista d'esdeveniments del congres passa a ser esdeveniments
	 */
	public void setEsdeveniments(ArrayList<Esdeveniment> esdeveniments) {
		Congres.setEsdeveniments(esdeveniments);
	}
	
	/**
	 * Pre: -
	 * @param diputat: Diputat a afegir al congres
	 * @throws Exception
	 * Post: Afegeix el diputat al congres en cas que no hi fos.
	 */
	public void altaDiputat(Diputat diputat) throws Exception{ 
		Congres.altaDiputat(diputat);
	}
	
	/**
	 * Pre: -
	 * @param empresa: Empresa a afegir al congres
	 * Post: Afegeix l'empresa al congres en cas que no hi fos.
	 */
	public void altaEmpresa(Empresa empresa) {
		Congres.altaEmpresa(empresa);
	}
	
	/*public void altaConferencia(Conferencia conferencia) {
		Congres.altaConferencia(conferencia);		
	}
	
	public void altaVotacio(Votacio votacio) {
		Congres.altaVotacio(votacio);		
	}*/
	/**
	 * Pre: -
	 * @param esdeveniment
	 * Post: Afegeix l'esdeveniment al congres en cas que no hi fos
	 */
	public void altaEsdeveniment(Esdeveniment esdeveniment) {
		Congres.altaEsdeveniment(esdeveniment);
	}
	
	/*public void altaReunio(Reunio reunio) {
		Congres.altaReunio(reunio);		
	}*/
	
	/**
	 * Pre: El diputat amb nom nom es al congres
	 * @param nom: Nom del diputat a buscar
	 * @return Retorna el diputat amb nom nom
	 */
	public Diputat cercaDiputat(String nom) {
		return Congres.cercaDiputat(nom);
	}
	
	/**
	 * Pre: -
	 * @param nom: Nom de l'empresa a buscar
	 * @return Retorna l'empresa amb nom nom.
	 * @throws Exception: Si no troba l'empresa
	 */
	public Empresa cercaEmpresa(String nom) throws Exception {
		return Congres.cercaEmpresa(nom);
	}
	
	/**
	 * Pre: L'esdeveniment amb codi codi es al congres
	 * @param codi: Codi de l'esdeveniment a buscar
	 * @return Retorna l'esdeveniment amb codi codi.
	 */
	public Esdeveniment cercaEsdeveniment(int codi) {
		return Congres.cercaEsdeveniment(codi);
	}
	
	/**
	 * Pre: -
	 * @param nom: Nom del diputat a donar de baixa
	 * @throws Exception: Si el diputat no existeix
	 * Post: El diputat deixa de ser al congres
	 */
	public void baixaDiputat(String nom) throws Exception {
		Congres.baixaDiputat(nom);
	}
	
	/**
	 * Pre: -
	 * @param nom: Nom de l'empresa a donar de baixa
	 * @throws Exception: Si l'empresa no existeix
	 * Post: L'empresa deixa de ser al congres
	 */
	public void baixaEmpresa(String nom) throws Exception {
		Congres.baixaEmpresa(nom);
	}
	
	/**
	 * Pre: -
	 * @param codi: Codi de l'esdeveniment a donar de baixa
	 * @throws Exception: Si l'esdeveniment no existeix
	 * Post: L'esdeveniment deixa de ser al congres
	 */
	public void baixaEsdeveniment(int codi) throws Exception {
		Congres.baixaEsdeveniment(codi);
	}
	
	/**
	 * Pre: -
	 * @param nom: Nom del diputat a buscar
	 * @return: True si el diputat es al congres, fals sino.
	 */
	public boolean existeixDiputat(String nom) {
		return Congres.existeixDiputat(nom);
	}
	
	/**
	 * Pre: -
	 * @param nom: Nom de l'empresa a buscar
	 * @return: True si l'empresa es al congres, fals sino.
	 */
	public boolean existeixEmpresa(String nom) {
		return Congres.existeixEmpresa(nom);
	}
	/**
	 * 
	 * @param codi: Codi de l'esdeveniment a buscar
	 * @return True si l'esdeveniment es al congres, fals sino
	 */
	public boolean existeixEsdeveniment(int codi) {
		return Congres.existeixEsdeveniment(codi);
	}
	
	/**
	 * Pre: -
	 * @return: Nombre de diputats del congres.
	 */
	public int getNumDiputats() {
		return Congres.getNumDiputats();
	}
	
	public Graf<Diputat> getGraf() {
		return Congres.getGraf();
	}
	
	public void setGraf(Graf<Diputat> graf) {
		Congres.setGraf(graf);
	}
	
	/**
	 * Pre: -
	 * @param nom: Nom del diputat a cercar
	 * @return: Retorna la procedencia, la ideologia, l'empresa i l'ambit de treball del diputat amb nom nom
	 */
	public ArrayList<String> getDiputat(String nom) {
		ArrayList<String> diputat = new ArrayList<String>();
		boolean find = existeixDiputat(nom);
		if(find) {
			diputat.add(0, "true");
			Diputat D = cercaDiputat(nom);
			diputat.add(1, ctrlDiputat.getProcedencia(D));
			diputat.add(2, ctrlDiputat.getIdeologia(D).toString());
			Empresa E = ctrlDiputat.getEmpresa(D);
			diputat.add(3, ctrlEmpresa.getNom(E));
			diputat.add(4, ctrlEmpresa.getAmbit(E).toString());
		}
		else diputat.add(0, "false");
		return diputat;
	}
	
	/**
	 * Pre: -
	 * @param codi: Codi de l'esdeveniment que volem buscar
	 * @return: Retorna un ArrayList<String> que conte la descripcio i la data
	 * 			de l'esdeveniment amb codi codi
	 */
	public ArrayList<String> getEsdeveniment(int codi) {
		ArrayList<String> esdeveniment = new ArrayList<String>();
		boolean find = existeixEsdeveniment(codi);
		if(find) {
			esdeveniment.add(0, "true");
			Esdeveniment esdev = cercaEsdeveniment(codi);
			esdeveniment.add(1, ctrlEsdeveniment.getDescripcio(esdev));
			esdeveniment.add(2, ctrlEsdeveniment.getStringData(esdev));
		}
		else esdeveniment.add(0, "false");
		return esdeveniment;
	}
	
	/**
	 * Pre: -
	 * @param nom: Nom del diputat els esdeveniments del qual volem representar
	 * @return: Retorna l'arbre que representa els esdeveniments del diputat
	 */
	public JTree getArbreEsdeveniments(String nom) {
		Diputat D = cercaDiputat(nom);
		ArrayList<Esdeveniment> esdeveniments = ctrlDiputat.getEsdeveniments(D);
		JTree tree;
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Esdeveniments");
		DefaultMutableTreeNode esdeveniment, descripcio, data;
		for (int i = 0; i < esdeveniments.size(); ++i) {
			Esdeveniment e = esdeveniments.get(i);
			esdeveniment = new DefaultMutableTreeNode("Esdeveniment " + ctrlEsdeveniment.getCodi(e));
			root.add(esdeveniment);
			descripcio = new DefaultMutableTreeNode("Descripcio: " + ctrlEsdeveniment.getDescripcio(e));
			esdeveniment.add(descripcio);
			data = new DefaultMutableTreeNode("Data: " + ctrlEsdeveniment.getStringData(e));
			esdeveniment.add(data);
		}
		tree = new JTree(root);
		return tree;
	}
	
	/*public JTree getArbreDiputats(int codi) throws Exception {
		Esdeveniment esdeveniment = cercaEsdeveniment(codi);
		ArrayList<Diputat> diputats = ctrlEsdeveniment.getDiputats(esdeveniment);
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Esdeveniments");
		DefaultMutableTreeNode nodeDiputat, ideologia, procedencia, nomEmpresa,
		   ambitEmpresa;
		Diputat diputat;
		Empresa empresa;
		for(int i = 0; i < diputats.size(); i++) {
			diputat = diputats.get(i);
			nodeDiputat = new DefaultMutableTreeNode(ctrlDiputat.getNom(diputat));
			ideologia = new DefaultMutableTreeNode(ctrlDiputat.getIdeologia(diputat));
			nodeDiputat.add(ideologia);
			procedencia = new DefaultMutableTreeNode(ctrlDiputat.getProcedencia(diputat));
			nodeDiputat.add(procedencia);
			empresa = diputat.getEmpresa();
			nomEmpresa = new DefaultMutableTreeNode(ctrlEmpresa.getNom(empresa));
			nodeDiputat.add(nomEmpresa);
			ambitEmpresa = new DefaultMutableTreeNode(ctrlEmpresa.getAmbit(empresa));
			nodeDiputat.add(ambitEmpresa);
			JTree esdeveniments = getArbreEsdeveniments(ctrlDiputat.getNom(diputat));
			nodeDiputat.add((MutableTreeNode) esdeveniments.getModel().getRoot());				
			root.add(nodeDiputat);			
		}
		JTree tree = new JTree(root);
		return tree;
	}*/
	
	/**
	 * 
	 * @param codi: Codi de l'esdeveniment l'arbre de participants del qual volem representar
	 * @return: Retorna l'arbre de participants de l'esdeveniment amb codi codi
	 * @throws Exception: Si l'esdeveniment no existeix
	 */
	public JTree getArbreParticipants(int codi) throws Exception {
		Esdeveniment E = cercaEsdeveniment(codi);
		ArrayList<Diputat> participants = ctrlEsdeveniment.getDiputats(E);
		JTree tree;
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Participants");
		DefaultMutableTreeNode participant;
		for (int i = 0; i < participants.size(); ++i) {
			Diputat d = participants.get(i);
			participant = new DefaultMutableTreeNode("Participant " + ctrlDiputat.getNom(d));
			root.add(participant);
		}
		tree = new JTree(root);
		return tree;
	}
	
	/**
	 * Pre: -
	 * @return: Retorna l'arbre que representa el congres
	 * @throws Exception
	 */
	public JTree getArbreCongres() throws Exception {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Congres");
		ArrayList<Esdeveniment> esdeveniments = getEsdeveniments();
		ArrayList<Diputat> diputats = getDiputats();
		DefaultMutableTreeNode esd = new DefaultMutableTreeNode("Esdeveniments");
		DefaultMutableTreeNode dip = new DefaultMutableTreeNode("Diputats");
		DefaultMutableTreeNode nodeDiputat, nodeEsdeveniment, ideologia, procedencia,
							   nomEmpresa, ambitEmpresa, descripcio, data;
		Diputat diputat;
		Empresa empresa;
		Esdeveniment esdeveniment;
		for(int i = 0; i < diputats.size(); i++) {
			diputat = diputats.get(i);
			nodeDiputat = new DefaultMutableTreeNode(ctrlDiputat.getNom(diputat));
			ideologia = new DefaultMutableTreeNode(ctrlDiputat.getIdeologia(diputat));
			nodeDiputat.add(ideologia);
			procedencia = new DefaultMutableTreeNode(ctrlDiputat.getProcedencia(diputat));
			nodeDiputat.add(procedencia);
			empresa = diputat.getEmpresa();
			nomEmpresa = new DefaultMutableTreeNode(ctrlEmpresa.getNom(empresa));
			nodeDiputat.add(nomEmpresa);
			ambitEmpresa = new DefaultMutableTreeNode(ctrlEmpresa.getAmbit(empresa));
			nodeDiputat.add(ambitEmpresa);
			dip.add(nodeDiputat);
		}
		for(int j = 0; j < esdeveniments.size(); j++) {
			esdeveniment = esdeveniments.get(j);
			nodeEsdeveniment = new DefaultMutableTreeNode("Esdeveniment " + ctrlEsdeveniment.getCodi(esdeveniment));
			descripcio = new DefaultMutableTreeNode("Descripcio: " + ctrlEsdeveniment.getDescripcio(esdeveniment));
			nodeEsdeveniment.add(descripcio);
			data = new DefaultMutableTreeNode("Data: " + ctrlEsdeveniment.getStringData(esdeveniment));
			nodeEsdeveniment.add(data);
			esd.add(nodeEsdeveniment);
		}
		root.add(dip);
		root.add(esd);
		JTree tree = new JTree(root);
		return tree;
	}
	
	/**
	 * Pre: -
	 * @param tree: Arbre que representa l'esdeveniment que volem modificar
	 * @throws Exception
	 * Post: L'esdeveniment l'arbre del qual passem per parametre es modifica al congres
	 */
	public void modificarEsdeveniment(JTree tree) throws Exception {
		Object root = tree.getModel().getRoot();
		int nfills = tree.getModel().getChildCount(root);
		for(int i = 0; i < nfills; i++) {
			Object nodeEsdev = tree.getModel().getChild(root, i);
			String stringNode = nodeEsdev.toString();
			String scodi = stringNode.substring(stringNode.length() - 1);
			int codi = Integer.parseInt(scodi);
			Object nodeDesc = tree.getModel().getChild(nodeEsdev, 0);
			Object nodeData = tree.getModel().getChild(nodeEsdev, 1);
			String stringDesc = nodeDesc.toString();
			String stringData = nodeData.toString();
			String descripcioPost = stringDesc.substring(12);
			String dataPost = stringData.substring(6);
			Esdeveniment esdeveniment = cercaEsdeveniment(codi);
			String descripcioPre = ctrlEsdeveniment.getDescripcio(esdeveniment);
			String dataPre = ctrlEsdeveniment.getStringData(esdeveniment);
			if(!descripcioPost.equals(descripcioPre)) ctrlEsdeveniment.setDescripcio(esdeveniment, descripcioPost);
			if(!dataPost.equals(dataPre)) ctrlEsdeveniment.setData(esdeveniment, dataPost);			
		}
	}
	
	/**
	 * Pre: -
	 * @param nomD: Nom del diputat que deixa d'assistir a l'esdeveniment amb codi codi
	 * @param codi: Codi de l'esdeveniment on el diputat amb nom nomD deixa d'assistir
	 * @throws Exception: En cas que l'esdeveniment o el diputat no existeixin
	 */
	public void eliminarAssistencia(String nomD, int codi) throws Exception {
		Diputat diputat = cercaDiputat(nomD);
		Esdeveniment esdeveniment = cercaEsdeveniment(codi);
		ctrlDiputat.baixaEsdeveniment(diputat, codi);
		ctrlEsdeveniment.baixaDiputat(esdeveniment, nomD);
	}
}
