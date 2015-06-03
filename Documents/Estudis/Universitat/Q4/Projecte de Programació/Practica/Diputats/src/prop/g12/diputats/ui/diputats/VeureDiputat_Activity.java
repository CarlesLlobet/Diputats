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
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import prop.g12.diputats.ui.JPanelFondo;
import prop.g12.diputats.ui.ControladorPrincipal;

public class VeureDiputat_Activity extends JPanelFondo{
	
	private static final long serialVersionUID = 1L;
	private JButton button;
	private JButton button1;
	private JButton enrere;
	private JLabel titol;
	private Component verticalGlue;
	private Component verticalGlue_2;
	private Component verticalGlue_5;
	private JLabel txtNom;
	private Component verticalGlue_3;
	private JLabel txtNomEmpresa;
	private JLabel txtAmbitEmpresa;
	private JLabel txtIdeologa;
	private JLabel txtProcedncia;
	private JLabel lblOK;
	private Component verticalGlue_8;
	private Component verticalGlue_1;
	private Box horizontalBox;
	private JLabel lblNom;
	private JLabel lblEmpresa;
	private JLabel lblNewLabel;
	private JLabel lblIdeologa;
	private JLabel lblProcedncia;
	private Box verticalBox;
	private Box verticalBox_1;
	
	public VeureDiputat_Activity(String nom, String procedencia, String ideologia, String nomEmpresa, String ambitEmpresa, JTree esdeveniments) {
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
		
		titol = new JLabel("Veure Diputat");
		titol.setForeground(Color.WHITE);
		titol.setFocusable(false);
		titol.setFont(new Font("Tahoma", Font.BOLD, 24));
		titol.setAlignmentX(Component.CENTER_ALIGNMENT);
		titol.setMaximumSize(new Dimension(175, 23));
		add(titol);
		
		verticalGlue_3 = Box.createVerticalGlue();
		verticalGlue_3.setMaximumSize(new Dimension(0, 22767));
		add(verticalGlue_3);
		
		horizontalBox = Box.createHorizontalBox();
		add(horizontalBox);
		
		verticalBox = Box.createVerticalBox();
		horizontalBox.add(verticalBox);
		
		lblNom = new JLabel("Nom:");
		verticalBox.add(lblNom);
		lblNom.setForeground(Color.WHITE);
		
		lblEmpresa = new JLabel("Empresa:");
		verticalBox.add(lblEmpresa);
		lblEmpresa.setForeground(Color.WHITE);
		
		lblNewLabel = new JLabel("\u00C0mbit Empresa: ");
		verticalBox.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		
		lblIdeologa = new JLabel("Ideolog\u00EDa: ");
		verticalBox.add(lblIdeologa);
		lblIdeologa.setForeground(Color.WHITE);
		
		lblProcedncia = new JLabel("Proced\u00E8ncia: ");
		verticalBox.add(lblProcedncia);
		lblProcedncia.setForeground(Color.WHITE);
		
		verticalBox_1 = Box.createVerticalBox();
		horizontalBox.add(verticalBox_1);
		
		txtNom = new JLabel();
		txtNom.setHorizontalAlignment(SwingConstants.CENTER);
		verticalBox_1.add(txtNom);
		txtNom.setForeground(Color.WHITE);
		txtNom.setMaximumSize(new Dimension(150, 100));
		txtNom.setText(nom);
		
		txtNomEmpresa = new JLabel();
		txtNomEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		verticalBox_1.add(txtNomEmpresa);
		txtNomEmpresa.setForeground(Color.WHITE);
		txtNomEmpresa.setText(nomEmpresa);
		txtNomEmpresa.setMaximumSize(new Dimension(150, 100));
		
		txtAmbitEmpresa = new JLabel();
		txtAmbitEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		verticalBox_1.add(txtAmbitEmpresa);
		txtAmbitEmpresa.setForeground(Color.WHITE);
		txtAmbitEmpresa.setText(ambitEmpresa);
		txtAmbitEmpresa.setMaximumSize(new Dimension(150, 100));
		
		txtIdeologa = new JLabel();
		txtIdeologa.setHorizontalAlignment(SwingConstants.CENTER);
		verticalBox_1.add(txtIdeologa);
		txtIdeologa.setForeground(Color.WHITE);
		txtIdeologa.setText(ideologia);
		txtIdeologa.setMaximumSize(new Dimension(150, 100));
		
		txtProcedncia = new JLabel();
		txtProcedncia.setHorizontalAlignment(SwingConstants.CENTER);
		verticalBox_1.add(txtProcedncia);
		txtProcedncia.setForeground(Color.WHITE);
		txtProcedncia.setText(procedencia);
		txtProcedncia.setMaximumSize(new Dimension(150, 100));
		
		verticalGlue_1 = Box.createVerticalGlue();
		verticalGlue_1.setMaximumSize(new Dimension(0, 7267));
		add(verticalGlue_1);
		
		JScrollPane scrollPane = new JScrollPane(esdeveniments);
		scrollPane.setMaximumSize(new Dimension(250, 32767));
		add(scrollPane);
		
		verticalGlue_5 = Box.createVerticalGlue();
		add(verticalGlue_5);
		
		lblOK = new JLabel("");
		add(lblOK);
		
		verticalGlue_8 = Box.createVerticalGlue();
		verticalGlue_8.setMaximumSize(new Dimension(0, 7267));
		add(verticalGlue_8);
	
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
		
		button1 = new JButton("Eliminar");
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
				ControladorPrincipal.loadEditarDiputat(nom, procedencia, ideologia, nomEmpresa, ambitEmpresa, esdeveniments);
					
			}
		});
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ControladorPrincipal.getCD().baixaDiputat(nom);
				} catch (Exception e) {
					e.printStackTrace();
				}
				deleteView();
				ControladorPrincipal.loadDiputats();
					
			}
		});
		
		enrere.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		deleteView();
        		ControladorPrincipal.loadBuscarDiputat();
        	}
        });
	}

	public void config(){		
		//Asociamos la tecla intro con el botón de Generar Comunidades
		JRootPane rootPane = SwingUtilities.getRootPane(button1); 
		rootPane.setDefaultButton(button1);
	}
}
