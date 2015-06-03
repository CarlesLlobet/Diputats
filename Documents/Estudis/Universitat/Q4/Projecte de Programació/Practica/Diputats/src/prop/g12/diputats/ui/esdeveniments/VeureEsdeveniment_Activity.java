package prop.g12.diputats.ui.esdeveniments;

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
import prop.g12.diputats.ui.Principal;

public class VeureEsdeveniment_Activity extends JPanelFondo{
	
	private static final long serialVersionUID = 1L;
	private JButton button;
	private JButton button1;
	private JButton enrere;
	private JLabel titol;
	private Component verticalGlue;
	private Component verticalGlue_2;
	private Component verticalGlue_5;
	private JLabel txtCodi;
	private Component verticalGlue_3;
	private JLabel txtDescripcio;
	private JLabel txtData;
	private Component verticalGlue_4;
	private Component verticalGlue_6;
	private JLabel lblOK;
	private Component verticalGlue_8;
	private Component verticalGlue_1;
	private Box horizontalBox;
	private Box horizontalBox_1;
	private Box horizontalBox_2;
	private JLabel lblNom;
	private JLabel lblEmpresa;
	private JLabel lblNewLabel;
	
	public VeureEsdeveniment_Activity(int codi, String descripcio, String data, JTree participants) {
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
		
		titol = new JLabel("Veure Esdeveniment");
		titol.setForeground(Color.WHITE);
		titol.setFocusable(false);
		titol.setFont(new Font("Tahoma", Font.BOLD, 24));
		titol.setAlignmentX(Component.CENTER_ALIGNMENT);
		titol.setMaximumSize(new Dimension(250, 23));
		add(titol);
		
		verticalGlue_3 = Box.createVerticalGlue();
		verticalGlue_3.setMaximumSize(new Dimension(0, 22767));
		add(verticalGlue_3);
		
		horizontalBox = Box.createHorizontalBox();
		add(horizontalBox);
		
		lblNom = new JLabel("Codi:");
		lblNom.setForeground(Color.WHITE);
		horizontalBox.add(lblNom);
		
		txtCodi = new JLabel();
		horizontalBox.add(txtCodi);
		txtCodi.setForeground(Color.WHITE);
		txtCodi.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodi.setMaximumSize(new Dimension(217, 100));
		txtCodi.setText(String.valueOf(codi));
		
		verticalGlue_4 = Box.createVerticalGlue();
		verticalGlue_4.setMaximumSize(new Dimension(0, 7267));
		add(verticalGlue_4);
		
		horizontalBox_1 = Box.createHorizontalBox();
		add(horizontalBox_1);
		
		lblEmpresa = new JLabel("Descripció:");
		lblEmpresa.setForeground(Color.WHITE);
		horizontalBox_1.add(lblEmpresa);
		
		txtDescripcio = new JLabel();
		horizontalBox_1.add(txtDescripcio);
		txtDescripcio.setForeground(Color.WHITE);
		txtDescripcio.setText(descripcio);
		txtDescripcio.setMaximumSize(new Dimension(217, 100));
		txtDescripcio.setHorizontalAlignment(SwingConstants.CENTER);
		
		verticalGlue_6 = Box.createVerticalGlue();
		verticalGlue_6.setMaximumSize(new Dimension(0, 7267));
		add(verticalGlue_6);
		
		horizontalBox_2 = Box.createHorizontalBox();
		add(horizontalBox_2);
		
		lblNewLabel = new JLabel("Data");
		lblNewLabel.setForeground(Color.WHITE);
		horizontalBox_2.add(lblNewLabel);
		
		txtData = new JLabel();
		horizontalBox_2.add(txtData);
		txtData.setForeground(Color.WHITE);
		txtData.setText(data);
		txtData.setMaximumSize(new Dimension(217, 100));
		txtData.setHorizontalAlignment(SwingConstants.CENTER);
		
		verticalGlue_1 = Box.createVerticalGlue();
		verticalGlue_1.setMaximumSize(new Dimension(0, 7267));
		add(verticalGlue_1);
		
		JScrollPane scrollPane = new JScrollPane(participants);
		scrollPane.setMaximumSize(new Dimension(200, 32767));
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
				Principal.loadEditarEsdeveniment(codi,descripcio,data, participants);
					
			}
		});
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Principal.getCE().baixaEsdeveniment(codi);
				} catch (Exception e) {
					e.printStackTrace();
				}
				deleteView();
				Principal.loadEsdeveniments();
					
			}
		});
		
		enrere.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		deleteView();
        		Principal.loadBuscarEsdeveniment();
        	}
        });
	}

	public void config(){		
		//Asociamos la tecla intro con el botón de Generar Comunidades
		JRootPane rootPane = SwingUtilities.getRootPane(button1); 
		rootPane.setDefaultButton(button1);
	}
}
