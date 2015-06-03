package prop.g12.diputats.ui.diputats;

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
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import prop.g12.diputats.ui.JPanelFondo;
import prop.g12.diputats.ui.Principal;

import java.awt.SystemColor;

public class AfegirDiputat_Activity extends JPanelFondo{

	private static final long serialVersionUID = 1L;
	private JButton button1;
	private JButton enrere;
	private JLabel titol;
	private Component verticalGlue;
	private Component verticalGlue_2;
	private Component verticalGlue_5;
	private JTextField txtNom;
	private Component verticalGlue_3;
	private JTextField txtEmpresa;
	private JTextField txtIdeologia;
	private JTextField txtProcedencia;
	private Component verticalGlue_4;
	private Component verticalGlue_6;
	private Component verticalGlue_7;
	private JLabel lblOK;
	private Component verticalGlue_8;
	private Component verticalGlue_1;
	private JTextField txtAmbitEmpresa;
	private JLabel lblAmbitNomsSi;
	
	public AfegirDiputat_Activity() {
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
		
		titol = new JLabel("Afegir Diputat");
		titol.setForeground(Color.WHITE);
		titol.setFocusable(false);
		titol.setFont(new Font("Tahoma", Font.BOLD, 24));
		titol.setAlignmentX(Component.CENTER_ALIGNMENT);
		titol.setMaximumSize(new Dimension(175, 23));
		add(titol);
		
		verticalGlue_3 = Box.createVerticalGlue();
		verticalGlue_3.setMaximumSize(new Dimension(0, 22767));
		add(verticalGlue_3);
		
		txtNom = new JTextField();
		txtNom.setHorizontalAlignment(SwingConstants.CENTER);
		txtNom.setMaximumSize(new Dimension(217, 100));
		txtNom.setText("Nom");
		add(txtNom);
		txtNom.setColumns(10);
		
		verticalGlue_4 = Box.createVerticalGlue();
		verticalGlue_4.setMaximumSize(new Dimension(0, 7267));
		add(verticalGlue_4);
		
		txtEmpresa = new JTextField();
		txtEmpresa.setText("Empresa");
		txtEmpresa.setMaximumSize(new Dimension(217, 100));
		txtEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmpresa.setColumns(10);
		add(txtEmpresa);
		
		verticalGlue_1 = Box.createVerticalGlue();
		verticalGlue_1.setMaximumSize(new Dimension(0, 7267));
		add(verticalGlue_1);
		
		txtAmbitEmpresa = new JTextField();
		txtAmbitEmpresa.setText("\u00C0mbit Empresa");
		txtAmbitEmpresa.setMaximumSize(new Dimension(217, 100));
		txtAmbitEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		txtAmbitEmpresa.setColumns(10);
		add(txtAmbitEmpresa);
		
		verticalGlue_6 = Box.createVerticalGlue();
		verticalGlue_6.setMaximumSize(new Dimension(0, 7267));
		add(verticalGlue_6);
		
		txtIdeologia = new JTextField();
		txtIdeologia.setText("Ideología");
		txtIdeologia.setMaximumSize(new Dimension(217, 100));
		txtIdeologia.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdeologia.setColumns(10);
		add(txtIdeologia);
		
		verticalGlue_7 = Box.createVerticalGlue();
		verticalGlue_7.setMaximumSize(new Dimension(0, 7267));
		add(verticalGlue_7);
		
		txtProcedencia = new JTextField();
		txtProcedencia.setText("Procedència");
		txtProcedencia.setMaximumSize(new Dimension(217, 100));
		txtProcedencia.setHorizontalAlignment(SwingConstants.CENTER);
		txtProcedencia.setColumns(10);
		add(txtProcedencia);
		
		verticalGlue_5 = Box.createVerticalGlue();
		verticalGlue_5.setMaximumSize(new Dimension(0, 22767));
		add(verticalGlue_5);
		
		lblAmbitNomsSi = new JLabel("\u00C0mbit nom\u00E8s en cas que l'Empresa sigui nova");
		lblAmbitNomsSi.setForeground(SystemColor.inactiveCaptionBorder);
		lblAmbitNomsSi.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblAmbitNomsSi.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAmbitNomsSi.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblAmbitNomsSi);
		
		lblOK = new JLabel("");
		add(lblOK);
		
		verticalGlue_8 = Box.createVerticalGlue();
		verticalGlue_8.setMaximumSize(new Dimension(0, 12267));
		add(verticalGlue_8);
	
		
		
		button1 = new JButton("Afegir");
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
		
		txtNom.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {	
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txtNom.setText("");
			}
		});
		
		txtIdeologia.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {	
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txtIdeologia.setText("");
			}
		});
		
		txtProcedencia.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {	
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txtProcedencia.setText("");
			}
		});
		
		txtEmpresa.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {	
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txtEmpresa.setText("");
			}
		});
		
		txtAmbitEmpresa.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {	
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txtAmbitEmpresa.setText("");
			}
		});
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String n = txtNom.getText();
				String i = txtIdeologia.getText();
				String p = txtProcedencia.getText();
				String e = txtEmpresa.getText();
				String a = txtAmbitEmpresa.getText();
				try {
					Principal.getCD().afegirDiputat(n, i, p, e, a);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				deleteView();
        		Principal.loadDiputats();
			}
		});
		
		enrere.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		deleteView();
        		Principal.loadDiputats();
        	}
        });
	}

	public void config(){		
		//Asociamos la tecla intro con el botón de Generar Comunidades
		JRootPane rootPane = SwingUtilities.getRootPane(button1); 
		rootPane.setDefaultButton(button1);
	}
}
