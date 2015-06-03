package prop.g12.diputats.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import java.io.File;
import java.io.IOException;

public class VeureGraf_Activity extends JPanelFondo{
	
	private static final long serialVersionUID = 1L;
	
	private JButton button;
	private JButton enrere;
	private JLabel titol;
	private Component verticalGlue;
	private Component verticalGlue_1;
	private Component verticalGlue_2;
	private Component verticalGlue_5;
	private JLabel lblGraf;
	
	public VeureGraf_Activity(JTree tree, String nomF) throws IOException {
		
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
		verticalGlue.setMaximumSize(new Dimension(0, 5767));
		add(verticalGlue);
		
		titol = new JLabel("Paràmetres de la nova solució");
		titol.setHorizontalAlignment(SwingConstants.CENTER);
		titol.setForeground(Color.WHITE);
		titol.setFocusable(false);
		titol.setFont(new Font("Tahoma", Font.BOLD, 14));
		titol.setAlignmentX(Component.CENTER_ALIGNMENT);
		titol.setMaximumSize(new Dimension(245, 23));
		add(titol);
		
		verticalGlue_5 = Box.createVerticalGlue();
		add(verticalGlue_5);
		
		File imageFile = new File("io/graf.png");
		Image imatge = ImageIO.read(imageFile);  
        
        lblGraf = new JLabel(new ImageIcon(imatge));
        lblGraf.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(lblGraf);
		
		verticalGlue_1 = Box.createVerticalGlue();
		add(verticalGlue_1);
		
		button = new JButton("Arbre de comunitats");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(button);
		
		verticalGlue_2 = Box.createVerticalGlue();
		add(verticalGlue_2);
		
		//Logica de la vista
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Generar Solucio
				deleteView();
				Principal.loadVeureComunitats(tree,nomF);	
			}
		});
		
		enrere.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		deleteView();
        		Principal.loadEscollirParametres();
        	}
        });
	}

	public void config(){		
		//Asociamos la tecla intro con el botón de Generar Comunidades
		JRootPane rootPane = SwingUtilities.getRootPane(button); 
		rootPane.setDefaultButton(button);
	}
}
