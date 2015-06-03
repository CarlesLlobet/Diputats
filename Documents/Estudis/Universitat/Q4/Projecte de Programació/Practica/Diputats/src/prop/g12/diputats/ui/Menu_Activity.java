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
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class Menu_Activity extends JPanelFondo{

	private static final long serialVersionUID = 1L;
	private JButton button;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JLabel titol;
	private Component verticalGlue;
	private Component verticalGlue_1;
	private Component verticalGlue_2;
	private Component verticalGlue_3;
	private Component verticalGlue_4;
	private Component verticalGlue_5;
	
	public Menu_Activity() {
		//Preparamos la vista
		setBounds(100, 100, 793, 499);
		setFocusTraversalPolicyProvider(true);
		setAutoscrolls(true);
        setImage("images/background.jpg");
        
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		verticalGlue = Box.createVerticalGlue();
		add(verticalGlue);
		
		titol = new JLabel("Diputats dels EUA");
		titol.setForeground(Color.WHITE);
		titol.setHorizontalAlignment(SwingConstants.CENTER);
		titol.setFocusable(false);
		titol.setFont(new Font("Tahoma", Font.BOLD, 24));
		titol.setAlignmentX(Component.CENTER_ALIGNMENT);
		titol.setMaximumSize(new Dimension(415, 23));
		add(titol);
		
		verticalGlue_5 = Box.createVerticalGlue();
		add(verticalGlue_5);
	
		button = new JButton("Generar Comunitats");
		button.setSelected(true);
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setMinimumSize(new Dimension(160, 23));
		button.setMaximumSize(new Dimension(160, 23));
		this.add(button);

		verticalGlue_1 = Box.createVerticalGlue();
		this.add(verticalGlue_1);
		
		button1 = new JButton("Obrir Solució");
		button1.setSelected(true);
		button1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button1.setAlignmentX(Component.CENTER_ALIGNMENT);
		button1.setMinimumSize(new Dimension(150, 23));
		button1.setMaximumSize(new Dimension(150, 23));
		this.add(button1);

		verticalGlue_2 = Box.createVerticalGlue();
		this.add(verticalGlue_2);
		
		button2 = new JButton("Estadístiques");
		button2.setSelected(true);
		button2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button2.setAlignmentX(Component.CENTER_ALIGNMENT);
		button2.setMinimumSize(new Dimension(160, 23));
		button2.setMaximumSize(new Dimension(160, 23));
		this.add(button2);

		verticalGlue_3 = Box.createVerticalGlue();
		this.add(verticalGlue_3);
		
		button3 = new JButton("Congressos");
		button3.setSelected(true);
		button3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button3.setAlignmentX(Component.CENTER_ALIGNMENT);
		button3.setMinimumSize(new Dimension(130, 23));
		button3.setMaximumSize(new Dimension(130, 23));
		this.add(button3);
		verticalGlue_4 = Box.createVerticalGlue();
		this.add(verticalGlue_4);
		
		//LOGICA DE LA VISTA
			
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteView();
				ControladorPrincipal.loadEscollirParametres();
					
			}
		});
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteView();
				ControladorPrincipal.loadImportComunitat();
					
			}
		});
		
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteView();
				ControladorPrincipal.loadTriarEstadistica();
					
			}
		});
		
		button3.addActionListener(new ActionListener() {
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
