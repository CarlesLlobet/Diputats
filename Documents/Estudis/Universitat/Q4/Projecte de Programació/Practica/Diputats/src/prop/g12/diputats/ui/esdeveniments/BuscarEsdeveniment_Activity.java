package prop.g12.diputats.ui.esdeveniments;

import prop.g12.diputats.ui.JPanelFondo;
import prop.g12.diputats.ui.ControladorPrincipal;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;

import javax.swing.UIManager;

public class BuscarEsdeveniment_Activity extends JPanelFondo{

	private static final long serialVersionUID = 1L;
	private JButton enrere;
	private JButton acceptar;
	private JTextField codiEmpresa;
	private JLabel titol;
	private JLabel warning;
	private Component verticalGlue;
	private Component verticalGlue_1;
	private Component verticalGlue_2;
	private Component verticalGlue_5;
	private Component verticalGlue_3;
	
	public BuscarEsdeveniment_Activity() {
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
		verticalGlue.setMaximumSize(new Dimension(0, 12767));
		add(verticalGlue);
		
		titol = new JLabel("Buscar Esdeveniment");
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
	
		codiEmpresa = new JTextField();
		codiEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		codiEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		codiEmpresa.setToolTipText("");
		codiEmpresa.setName("Usuario");
		codiEmpresa.setMinimumSize(new Dimension(100, 23));
		codiEmpresa.setMaximumSize(new Dimension(200, 2));
		this.add(codiEmpresa);
		codiEmpresa.setColumns(10);

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
		
		codiEmpresa.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {	
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				codiEmpresa.setText("");
			}
		});
			
		enrere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteView();
				ControladorPrincipal.loadEsdeveniments();
					
			}
		});
		
		acceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ce = Integer.parseInt(codiEmpresa.getText());
				ArrayList<String> info = ControladorPrincipal.getCC().getEsdeveniment(ce);
				if (info.get(0).equals("true")){
					JTree esdev = null;
					try {
						esdev = ControladorPrincipal.getCC().getArbreParticipants(ce);
					} catch (Exception e) {
						e.printStackTrace();
					}
					deleteView();
					ControladorPrincipal.loadVeureEsdeveniments(ce, info.get(1), info.get(2), esdev);
				}else warning.setText("L'esdeveniment amb codi " + ce + " no existeix!");
			}
		});
	}

	public void config(){		
		//Asociamos la tecla intro con el botón de Generar Comunidades
		JRootPane rootPane = SwingUtilities.getRootPane(acceptar); 
		rootPane.setDefaultButton(acceptar);
	}
}
