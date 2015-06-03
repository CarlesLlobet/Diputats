package prop.g12.diputats.ui.congressos;

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
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import prop.g12.diputats.ui.JPanelFondo;
import prop.g12.diputats.ui.ControladorPrincipal;

public class VeureCongres_Activity extends JPanelFondo{
	
	private static final long serialVersionUID = 1L;
	private JButton button;
	private JButton enrere;
	private JLabel titol;
	private Component verticalGlue;
	private Component verticalGlue_2;
	private Component verticalGlue_5;
	private JLabel lblOK;
	private Component verticalGlue_1;
	
	public VeureCongres_Activity(JTree congres) {
		//Preparamos la vista
		setBounds(100, 100, 793, 499);
		setFocusTraversalPolicyProvider(true);
		setAutoscrolls(true);
        setImage("../images/background.jpg");
        
        enrere = new JButton("Enrere");
		enrere.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(enrere);
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		verticalGlue = Box.createVerticalGlue();
		verticalGlue.setMaximumSize(new Dimension(0, 22767));
		add(verticalGlue);
		
		titol = new JLabel("Veure Congrés");
		titol.setForeground(Color.WHITE);
		titol.setFocusable(false);
		titol.setFont(new Font("Tahoma", Font.BOLD, 24));
		titol.setAlignmentX(Component.CENTER_ALIGNMENT);
		titol.setMaximumSize(new Dimension(175, 23));
		add(titol);
		
		verticalGlue_1 = Box.createVerticalGlue();
		verticalGlue_1.setMaximumSize(new Dimension(0, 12267));
		add(verticalGlue_1);
		
		congres.setRootVisible(false);
		JScrollPane scrollPane = new JScrollPane(congres);
		scrollPane.setMaximumSize(new Dimension(250, 32767));
		add(scrollPane);
		
		verticalGlue_5 = Box.createVerticalGlue();
		add(verticalGlue_5);
		
		lblOK = new JLabel("");
		add(lblOK);
	
		button = new JButton("Editar");
		button.setSelected(true);
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setMinimumSize(new Dimension(150, 23));
		button.setMaximumSize(new Dimension(150, 23));
		this.add(button);

		verticalGlue_2 = Box.createVerticalGlue();
		verticalGlue_2.setMaximumSize(new Dimension(0, 42767));
		this.add(verticalGlue_2);
		
		//LOGICA DE LA VISTA
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteView();
				ControladorPrincipal.loadEditarCongres();
					
			}
		});
		
		enrere.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		deleteView();
        		ControladorPrincipal.loadCongressos();
        	}
        });
	}

	public void config(){		
		//Asociamos la tecla intro con el botón de Generar Comunidades
		JRootPane rootPane = SwingUtilities.getRootPane(button); 
		rootPane.setDefaultButton(button);
	}
}
