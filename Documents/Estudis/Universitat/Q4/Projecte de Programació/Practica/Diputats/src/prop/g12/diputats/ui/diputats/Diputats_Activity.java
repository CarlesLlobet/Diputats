package prop.g12.diputats.ui.diputats;

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
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import prop.g12.diputats.ui.JPanelFondo;
import prop.g12.diputats.ui.ControladorPrincipal;

public class Diputats_Activity extends JPanelFondo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton button;
	private JButton button1;
	private JButton enrere;
	private JLabel titol;
	private Component verticalGlue;
	private Component verticalGlue_1;
	private Component verticalGlue_2;
	private Component verticalGlue_5;
	
	public Diputats_Activity() {
		//Preparamos la vista
		setBounds(100, 100, 793, 499);
		setFocusTraversalPolicyProvider(true);
		setAutoscrolls(true);
        setImage("../images/background.jpg");
        
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        enrere = new JButton("Enrere");
		enrere.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(enrere);
		
		verticalGlue = Box.createVerticalGlue();
		add(verticalGlue);
		
		titol = new JLabel("Editar Diputats");
		titol.setForeground(Color.WHITE);
		titol.setFocusable(false);
		titol.setFont(new Font("Tahoma", Font.BOLD, 24));
		titol.setAlignmentX(Component.CENTER_ALIGNMENT);
		titol.setMaximumSize(new Dimension(185, 23));
		add(titol);
		
		verticalGlue_5 = Box.createVerticalGlue();
		add(verticalGlue_5);
	
		button = new JButton("Afegir Diputat");
		button.setSelected(true);
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setMinimumSize(new Dimension(120, 23));
		button.setMaximumSize(new Dimension(120, 23));
		this.add(button);

		verticalGlue_1 = Box.createVerticalGlue();
		verticalGlue_1.setMaximumSize(new Dimension(0, 22767));
		this.add(verticalGlue_1);
		
		button1 = new JButton("Veure Diputat");
		button1.setSelected(true);
		button1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button1.setAlignmentX(Component.CENTER_ALIGNMENT);
		button1.setMinimumSize(new Dimension(150, 23));
		button1.setMaximumSize(new Dimension(150, 23));
		this.add(button1);

		verticalGlue_2 = Box.createVerticalGlue();
		verticalGlue_2.setMaximumSize(new Dimension(0, 42767));
		this.add(verticalGlue_2);
		
		//LOGICA DE LA VISTA
			
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteView();
				ControladorPrincipal.loadAfegirDiputat();
					
			}
		});
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteView();
				ControladorPrincipal.loadBuscarDiputat();
					
			}
		});
		
		enrere.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		deleteView();
        		ControladorPrincipal.loadEditarCongres();
        	}
        });
	}

	public void config(){		
		//Asociamos la tecla intro con el botón de Generar Comunidades
		JRootPane rootPane = SwingUtilities.getRootPane(button); 
		rootPane.setDefaultButton(button);
	}
}
