package prop.g12.diputats.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class ImportComunitats_Activity extends JPanelFondo{

	private static final long serialVersionUID = 1L;
	private JButton enrere;
	private JButton acceptar;
	private JTextField nomArxiu;
	private JLabel titol;
	private JLabel warning;
	private Component verticalGlue;
	private Component verticalGlue_1;
	private Component verticalGlue_2;
	private Component verticalGlue_5;
	private Component verticalGlue_3;
	
	public ImportComunitats_Activity() {
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
		verticalGlue.setMaximumSize(new Dimension(0, 12767));
		add(verticalGlue);
		
		titol = new JLabel("Importar Solució");
		titol.setHorizontalAlignment(SwingConstants.CENTER);
		titol.setForeground(Color.WHITE);
		titol.setFocusable(false);
		titol.setFont(new Font("Tahoma", Font.BOLD, 24));
		titol.setAlignmentX(Component.CENTER_ALIGNMENT);
		titol.setMaximumSize(new Dimension(415, 23));
		add(titol);
		
		verticalGlue_5 = Box.createVerticalGlue();
		verticalGlue_5.setMaximumSize(new Dimension(0, 52767));
		add(verticalGlue_5);
	
		nomArxiu = new JTextField();
		nomArxiu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nomArxiu.setHorizontalAlignment(SwingConstants.CENTER);
		nomArxiu.setToolTipText("");
		nomArxiu.setName("Usuario");
		nomArxiu.setMinimumSize(new Dimension(100, 23));
		nomArxiu.setMaximumSize(new Dimension(200, 2));
		this.add(nomArxiu);
		nomArxiu.setColumns(10);

		verticalGlue_1 = Box.createVerticalGlue();
		verticalGlue_1.setMaximumSize(new Dimension(0, 1767));
		this.add(verticalGlue_1);
		
		warning = new JLabel("");
		warning.setHorizontalAlignment(SwingConstants.CENTER);
		warning.setForeground(UIManager.getColor("ToolBar.dockingForeground"));
		warning.setFocusable(false);
		warning.setMaximumSize(new Dimension(350, 23));
		warning.setFont(new Font("Tahoma", Font.BOLD, 14));
		warning.setAlignmentX(0.5f);
		add(warning);
		
		verticalGlue_2 = Box.createVerticalGlue();
		verticalGlue_2.setMaximumSize(new Dimension(0, 12767));
		this.add(verticalGlue_2);
		
		acceptar = new JButton("Acceptar");
		acceptar.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(acceptar);
		
		verticalGlue_3 = Box.createVerticalGlue();
		add(verticalGlue_3);
		
		
		//LOGICA DE LA VISTA
			
		enrere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteView();
				ControladorPrincipal.loadMenu();
					
			}
		});
		
		acceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String na = nomArxiu.getText();
				File aux = new File("io/" + na + ".txt");
				if (aux.exists()){
					JTree tree = null;
					try {
						tree = ControladorPrincipal.getIO().llegirSolucio(na);
					} catch (Exception e) {
						e.printStackTrace();
					}
					deleteView();
					ControladorPrincipal.loadVeureComunitats(tree, na);
				} else warning.setText("L'arxiu " + na + " no existeix!");
			}
		});
	}

	public void config(){		
		//Asociamos la tecla intro con el botón de Generar Comunidades
		JRootPane rootPane = SwingUtilities.getRootPane(acceptar); 
		rootPane.setDefaultButton(acceptar);
	}
}
