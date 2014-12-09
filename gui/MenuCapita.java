package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

public class MenuCapita extends JPanelBg {
	
	private JComboBox<String> box;
	private JButton btnAcceder;
	private JButton btnNewButton;
	//private MenuCapita view;
	/**
	 * Create the panel.
	 */
	public MenuCapita() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setImage("/images/bg.jpg");
        
        box = new JComboBox<String>();
        box.setPreferredSize(new Dimension(28, 48));
        box.setRequestFocusEnabled(false);
        box.setFont(new Font("Tahoma", Font.PLAIN, 14));
        box.setMaximumRowCount(10);
        box.addItem("Gestionar rebeldes");
        box.addItem("Gestionar galaxia");
        box.addItem("Gestionar �xodos");
        box.addItem("Ejecutar �xodo");
        box.addItem("A�adir capit�n");
        box.addItem("Cambiar contrase�a");
        box.addItem("Borrar este capit�n");

        Dimension d = new Dimension(150,23);
        
        Component verticalGlue = Box.createVerticalGlue();
        add(verticalGlue);
        box.setMinimumSize(new Dimension(150, 48));
        box.setMaximumSize(new Dimension(150, 48));
        add(box);
        
        Component verticalStrut = Box.createVerticalStrut(20);
        add(verticalStrut);
        
        btnAcceder = new JButton("Acceder");
        btnAcceder.setPreferredSize(new Dimension(71, 48));
        btnAcceder.setMinimumSize(new Dimension(100, 48));
        btnAcceder.setMaximumSize(new Dimension(100, 48));
        btnAcceder.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if (box.getSelectedIndex() == 1){
        			System.out.println("To gestio galaxia");
        			deleteView();
        			Principal.loadGestioGalaxia();
        		}
        		else System.out.println("Seleccionado: " + String.valueOf(box.getSelectedItem()));
        		Principal.llistarcomponents();
        	}
        });
        btnAcceder.setRequestFocusEnabled(false);
        btnAcceder.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAcceder.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(btnAcceder);
        
        Component verticalGlue_1 = Box.createVerticalGlue();
        add(verticalGlue_1);
        
        Box verticalBox = Box.createVerticalBox();
        verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(verticalBox);
        
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager()
		  .addKeyEventDispatcher(new KeyEventDispatcher() {
		      @Override
		      public boolean dispatchKeyEvent(KeyEvent e) {
		    	if (isVisible()) System.out.println("TECLADO EN MENUCAPITAN");
		        return false;
		      }
		});
        
        btnNewButton = new JButton("Cerrar sesi�n");
        btnNewButton.setPreferredSize(new Dimension(120, 48));
        btnNewButton.setMinimumSize(new Dimension(120, 48));
        btnNewButton.setMaximumSize(new Dimension(120, 48));
        btnNewButton.setRequestFocusEnabled(false);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        verticalBox.add(btnNewButton);
        
        Component verticalStrut_1 = Box.createVerticalStrut(20);
        verticalBox.add(verticalStrut_1);

        btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Principal.removeMenuCapita();
				System.out.println("To login");
				deleteView();
				Principal.loadLogin();
			}
		});
	}
	
	public void focus(){
		box.requestFocusInWindow();
		
		//Seleccionamos el bot�n de acceder como acci�n principal al pulsar intro
		JRootPane rootPane = SwingUtilities.getRootPane(btnAcceder); 
		rootPane.setDefaultButton(btnAcceder);
	}
}
