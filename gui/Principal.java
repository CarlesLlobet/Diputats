package gui;

import gui.gestiogalaxia.GalGest;

import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Principal {
	/**
	 * Launch the application.
	 */
	
	//contenedores
	private static Ventana window = new Ventana();
	private static JPanel container = new JPanel();
	private static CardLayout card = new CardLayout();
	private static int cont = 0;
	
	
	private static void init(){
		//Configurem la finestra
		container.setLayout(card);
		window.add(container);
		//carreguem el login
		loadLogin();
	}

	
	public static void main(String[] args) {
		init();
	}
	
	public static void loadLogin(){
		//Creem una nova instancia, ja que sempre necessitarem partir desde 0
		Login l = new Login();
		container.add(l,"login");
		card.show(container,"login");
		window.setVisible(true);
		l.focus();
	}
	
	public static void loadGestioGalaxia(){
		GalGest g = new GalGest();
		container.add(g,"gestiog");
		card.show(container,"gestiog");
		window.setVisible(true);
		g.focus();
	}
	
	public static void removeView(Component c){
		container.remove(c);
	}
	
	public static void loadMenuCapita(){
		MenuCapita mc = new MenuCapita();
		container.add(mc,"menucap");
		card.show(container,"menucap");
		window.setVisible(true);
		mc.focus();
	}
	
	public static Ventana getWindow(){
		return window;
	}
	
	public static void llistarcomponents(){
		Component[] comp = container.getComponents();
		for (int i = 0; i < comp.length; ++i){
			System.out.println("Component : " + i + comp[i].toString());
		}	
	}

	public static int getCont(){
		//funcio de prova per testejar si es recalcula cada cop que es "show" una carta del cardlayout
		// tambe cal comprovar si no ha estat aix�, si el efecte de revalidate / repaint funciona. Si no caldra crear panel cada cop que es vulgui.
		// ^^al switch
		++cont;
		return cont;
	}
}
