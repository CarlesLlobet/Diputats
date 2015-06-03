package prop.g12.diputats.ui;

import java.awt.CardLayout;
import java.awt.Component;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JTree;

import prop.g12.diputats.data.ControladorCongres;
import prop.g12.diputats.data.ControladorDiputat;
import prop.g12.diputats.data.ControladorEsdeveniment;
import prop.g12.diputats.data.ControladorIO;
import prop.g12.diputats.domain.ControladorAlgorisme;
import prop.g12.diputats.domain.ControladorSolucio;
import prop.g12.diputats.ui.congressos.Congressos_Activity;
import prop.g12.diputats.ui.congressos.EditarCongres_Activity;
import prop.g12.diputats.ui.congressos.ExportCongres_Activity;
import prop.g12.diputats.ui.congressos.ImportCongres_Activity;
import prop.g12.diputats.ui.congressos.VeureCongres_Activity;
import prop.g12.diputats.ui.diputats.AfegirDiputat_Activity;
import prop.g12.diputats.ui.diputats.BuscarDiputat_Activity;
import prop.g12.diputats.ui.diputats.Diputats_Activity;
import prop.g12.diputats.ui.diputats.EditarDiputat_Activity;
import prop.g12.diputats.ui.diputats.VeureDiputat_Activity;
import prop.g12.diputats.ui.esdeveniments.AfegirEsdeveniment_Activity;
import prop.g12.diputats.ui.esdeveniments.BuscarEsdeveniment_Activity;
import prop.g12.diputats.ui.esdeveniments.EditarEsdeveniment_Activity;
import prop.g12.diputats.ui.esdeveniments.Esdeveniments_Activity;
import prop.g12.diputats.ui.esdeveniments.VeureEsdeveniment_Activity;

public class ControladorPrincipal {
	
	//Contenedores
	private static Ventana window = new Ventana();
	private static JPanel container = new JPanel();
	private static CardLayout card = new CardLayout();

	private static ControladorIO io = new ControladorIO();
	private static ControladorAlgorisme ca = new ControladorAlgorisme();
	private static ControladorCongres cc = new ControladorCongres();
	public static ControladorDiputat cd = new ControladorDiputat();
	public static ControladorEsdeveniment ce = new ControladorEsdeveniment();
	public static ControladorSolucio cs = new ControladorSolucio();
	
	
	//Configuramos la ventana y cargamos la vista de Login
	private static void init(){
		container.setLayout(card);
		window.add(container);
		loadMenu();
	}

	public static void main(String[] args){
		init();
	}
	
	/* Funciones "load..."
	 * Funcionamiento: se declara una instancia de la vista
	 * 				   se carga en el cardlayout y se muestra 
	 * 				   Se llama a la función config para configurar diferentes aspectos
	 * 				   como puede ser el elemento al que se le hará focus, el botón asociado
	 * 				   por defecto con la tecla intro...
	 */
	
	public static void loadMenu(){
		Menu_Activity m = new Menu_Activity();
		container.add(m,"menu");
		card.show(container,"menu");
		window.setVisible(true);
		m.config();
	}
	
	public static void loadEscollirParametres(){
		Parametres_Activity p = new Parametres_Activity();
		container.add(p,"parametres");
		card.show(container,"parametres");
		window.setVisible(true);
		p.config();
	}
	
	public static void loadImportComunitat(){
		ImportComunitats_Activity c = new ImportComunitats_Activity();
		container.add(c,"comunitat");
		card.show(container,"comunitat");
		window.setVisible(true);
		c.config();
	}
	
	public static void loadEditarComunitats(JTree tree, String nomF){
		EditarComunitats_Activity ec = new EditarComunitats_Activity(tree, nomF);
		container.add(ec,"editarComunitats");
		card.show(container,"editarComunitats");
		window.setVisible(true);
		ec.config();
	}
	
	public static void loadEstadisticaNodes() throws IOException{
		EstadisticaNodes_Activity n = new EstadisticaNodes_Activity();
		container.add(n,"estadistiques");
		card.show(container,"estadistiques");
		window.setVisible(true);
		n.config();
	}
	
	public static void loadEstadisticaSolucions() throws IOException{
		EstadisticaSolucions_Activity s = new EstadisticaSolucions_Activity();
		container.add(s,"estadistiques");
		card.show(container,"estadistiques");
		window.setVisible(true);
		s.config();
	}

	public static void loadCongressos(){
		Congressos_Activity c = new Congressos_Activity();
		container.add(c,"congressos");
		card.show(container,"congressos");
		window.setVisible(true);
		c.config();
	}
	
	public static void loadDiputats(){
		Diputats_Activity ed = new Diputats_Activity();
		container.add(ed,"editarDiputats");
		card.show(container,"editarDiputats");
		window.setVisible(true);
		ed.config();
	}
	
	public static void loadEsdeveniments(){
		Esdeveniments_Activity ees = new Esdeveniments_Activity();
		container.add(ees,"editarEsdeveniments");
		card.show(container,"editarEsdeveniments");
		window.setVisible(true);
		ees.config();
	}
	
	public static void loadEditarCongres(){
		EditarCongres_Activity ec = new EditarCongres_Activity();
		container.add(ec,"editarCongres");
		card.show(container,"editarCongres");
		window.setVisible(true);
		ec.config();
	}
	
	public static void loadEditarDiputat(String nom, String procedencia, String ideologia, String nomEmpresa, String ambitEmpresa, JTree esdeveniments){
		EditarDiputat_Activity md = new EditarDiputat_Activity(nom, procedencia, ideologia, nomEmpresa, ambitEmpresa, esdeveniments);
		container.add(md,"modificarDiputat");
		card.show(container,"modificarDiputat");
		window.setVisible(true);
		md.config();
	}

	public static void loadEditarEsdeveniment(int codi, String descripcio, String data, JTree participants){
		EditarEsdeveniment_Activity ee = new EditarEsdeveniment_Activity(codi, descripcio, data, participants);
		container.add(ee,"editarEsdeveniment");
		card.show(container,"editarEsdeveniment");
		window.setVisible(true);
		ee.config();
	}
	
	public static void loadVeureCongres(JTree congres){
		VeureCongres_Activity vc = new VeureCongres_Activity(congres);
		container.add(vc,"veureCongres");
		card.show(container,"veureCongres");
		window.setVisible(true);
		vc.config();
	}
	
	public static void loadVeureDiputat(String nom, String procedencia, String ideologia, String nomEmpresa, String ambitEmpresa, JTree esdeveniments){
		VeureDiputat_Activity vd = new VeureDiputat_Activity(nom, procedencia, ideologia, nomEmpresa, ambitEmpresa, esdeveniments);
		container.add(vd,"veureDiputat");
		card.show(container,"veureDiputat");
		window.setVisible(true);
		vd.config();
	}

	public static void loadVeureEsdeveniments(int codi, String descripcio, String data, JTree participants){
		VeureEsdeveniment_Activity ve = new VeureEsdeveniment_Activity(codi,descripcio,data,participants);
		container.add(ve,"veureEsdeveniments");
		card.show(container,"veureEsdeveniments");
		window.setVisible(true);
		ve.config();
	}
	
	public static void loadBuscarDiputat(){
		BuscarDiputat_Activity bd = new BuscarDiputat_Activity();
		container.add(bd,"buscarDiputat");
		card.show(container,"buscarDiputat");
		window.setVisible(true);
		bd.config();
	}
	
	public static void loadBuscarEsdeveniment(){
		BuscarEsdeveniment_Activity be = new BuscarEsdeveniment_Activity();
		container.add(be,"buscarEsdeveniment");
		card.show(container,"buscarEsdeveniment");
		window.setVisible(true);
		be.config();
	}
	
	public static void loadAfegirDiputat(){
		AfegirDiputat_Activity ad = new AfegirDiputat_Activity();
		container.add(ad,"afegirDiputat");
		card.show(container,"afegirDiputat");
		window.setVisible(true);
		ad.config();
	}
	
	public static void loadAfegirEsdeveniment(){
		AfegirEsdeveniment_Activity ae = new AfegirEsdeveniment_Activity();
		container.add(ae,"afegirEsdeveniment");
		card.show(container,"afegirEsdeveniment");
		window.setVisible(true);
		ae.config();
	}

	public static void loadImportCongres(){
		ImportCongres_Activity ic = new ImportCongres_Activity();
		container.add(ic,"importCongres");
		card.show(container,"importCongres");
		window.setVisible(true);
		ic.config();
	}
	
	public static void loadExportCongres(){
		ExportCongres_Activity ec = new ExportCongres_Activity();
		container.add(ec,"exportCongres");
		card.show(container,"exportCongres");
		window.setVisible(true);
		ec.config();
	}
	
	public static void loadVeureGraf(JTree tree, String nomF) throws IOException{
		VeureGraf_Activity vg = new VeureGraf_Activity(tree, nomF);
		container.add(vg,"veureGraf");
		card.show(container,"veureGraf");
		window.setVisible(true);
		vg.config();
	}
	
	public static void loadTriarEstadistica(){
		TriarEstadistica_Activity te = new TriarEstadistica_Activity();
		container.add(te,"triarEstadistica");
		card.show(container,"triarEstadistica");
		window.setVisible(true);
		te.config();
	}
	
	public static void loadVeureComunitats(JTree tree, String nomF){
		VeureComunitats_Activity vc = new VeureComunitats_Activity(tree, nomF);
		container.add(vc,"veureComunitats");
		card.show(container,"veureComunitats");
		window.setVisible(true);
		vc.config();
	}
	
	//Retorna 
	public static ControladorIO getIO(){
		return io;
	}
	
	public static ControladorAlgorisme getCA(){
		return ca;
	}
	
	public static ControladorCongres getCC(){
		return cc;
	}
	
	public static ControladorDiputat getCD(){
		return cd;
	}
	public static ControladorEsdeveniment getCE(){
		return ce;
	}
	public static ControladorSolucio getCS(){
		return cs;
	}

	//Función que elimina del contenedor una vista c
	public static void removeView(Component c){
		card.removeLayoutComponent(c);
		container.remove(c);
	}
	
	
	//Conseguir la ventana nos ayuda para crear una alerta desde cualquier vista.
	public static Ventana getWindow(){
		return window;
	}
}