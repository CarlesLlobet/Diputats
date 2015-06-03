package prop.g12.diputats.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import java.io.IOException;

public class VeureComunitats_Activity extends JPanelFondo{
	
	private static final long serialVersionUID = 1L;
	private JButton button;
	private JButton enrere;
	private JLabel titol;
	private Component verticalGlue;
	private Component verticalGlue_1;
	private Component verticalGlue_2;
	private Component verticalGlue_5;
	private Component verticalGlue_3;
	private JButton button_1;
	
	public VeureComunitats_Activity(JTree tree, String nomF) {
		
		//Preparamos la vista
		setBounds(100, 100, 793, 499);
		setFocusTraversalPolicyProvider(true);
		setAutoscrolls(true);
        setImage("images/background.jpg");
        
        enrere = new JButton("Enrere");
		enrere.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(enrere);
        
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		verticalGlue = Box.createVerticalGlue();
		add(verticalGlue);
		
		titol = new JLabel("Comunitats de " + tree.getModel().getRoot().toString());
		titol.setHorizontalAlignment(SwingConstants.CENTER);
		titol.setForeground(Color.WHITE);
		titol.setFocusable(false);
		titol.setFont(new Font("Tahoma", Font.BOLD, 14));
		titol.setAlignmentX(Component.CENTER_ALIGNMENT);
		titol.setMaximumSize(new Dimension(245, 23));
		add(titol);
		
		verticalGlue_5 = Box.createVerticalGlue();
		add(verticalGlue_5);
		
		tree.setRootVisible(false);
		JScrollPane scrollPane = new JScrollPane(tree);
		scrollPane.setMaximumSize(new Dimension(200, 32767));
		add(scrollPane);
		
		verticalGlue_1 = Box.createVerticalGlue();
		add(verticalGlue_1);
		
		button_1 = new JButton("Editar");
		button_1.setAlignmentX(0.5f);
		add(button_1);
		
		verticalGlue_3 = Box.createVerticalGlue();
		add(verticalGlue_3);
		
		button = new JButton("Graf de comunitats");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(button);
		
		verticalGlue_2 = Box.createVerticalGlue();
		add(verticalGlue_2);
		
		//Logica de la vista
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteView();
				try {
					ControladorPrincipal.loadVeureGraf(tree, nomF);
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteView();
				ControladorPrincipal.loadEditarComunitats(tree,nomF);	
			}
		});
		
		enrere.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		deleteView();
        		ControladorPrincipal.loadEscollirParametres();
        	}
        });
	}

	public void config(){		
		//Asociamos la tecla intro con el botón de Generar Comunidades
		JRootPane rootPane = SwingUtilities.getRootPane(button); 
		rootPane.setDefaultButton(button);
	}
}
