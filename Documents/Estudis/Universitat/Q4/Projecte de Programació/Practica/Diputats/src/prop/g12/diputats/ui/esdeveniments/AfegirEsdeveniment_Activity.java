package prop.g12.diputats.ui.esdeveniments;

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

public class AfegirEsdeveniment_Activity extends JPanelFondo{

	private static final long serialVersionUID = 1L;
	private JButton button1;
	private JButton enrere;
	private JLabel titol;
	private Component verticalGlue;
	private Component verticalGlue_2;
	private JTextField txtCodi;
	private Component verticalGlue_3;
	private JTextField txtDescripcio;
	private JTextField txtData;
	private Component verticalGlue_4;
	private Component verticalGlue_6;
	private JLabel lblOK;
	private Component verticalGlue_8;
	
	public AfegirEsdeveniment_Activity() {
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
		
		titol = new JLabel("Afegir Esdeveniment");
		titol.setHorizontalAlignment(SwingConstants.CENTER);
		titol.setForeground(Color.WHITE);
		titol.setFocusable(false);
		titol.setFont(new Font("Tahoma", Font.BOLD, 24));
		titol.setAlignmentX(Component.CENTER_ALIGNMENT);
		titol.setMaximumSize(new Dimension(300, 23));
		add(titol);
		
		verticalGlue_3 = Box.createVerticalGlue();
		verticalGlue_3.setMaximumSize(new Dimension(0, 22767));
		add(verticalGlue_3);
		
		txtCodi = new JTextField();
		txtCodi.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodi.setMaximumSize(new Dimension(217, 100));
		txtCodi.setText("Codi");
		add(txtCodi);
		txtCodi.setColumns(10);
		
		verticalGlue_4 = Box.createVerticalGlue();
		verticalGlue_4.setMaximumSize(new Dimension(0, 7267));
		add(verticalGlue_4);
		
		txtDescripcio = new JTextField();
		txtDescripcio.setText("Descripció");
		txtDescripcio.setMaximumSize(new Dimension(217, 100));
		txtDescripcio.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescripcio.setColumns(10);
		add(txtDescripcio);
		
		verticalGlue_6 = Box.createVerticalGlue();
		verticalGlue_6.setMaximumSize(new Dimension(0, 7267));
		add(verticalGlue_6);
		
		txtData = new JTextField();
		txtData.setText("Data(dd/mm/aa-HH:mm:ss)");
		txtData.setMaximumSize(new Dimension(217, 100));
		txtData.setHorizontalAlignment(SwingConstants.CENTER);
		txtData.setColumns(10);
		add(txtData);
		
		lblOK = new JLabel("");
		add(lblOK);
		
		verticalGlue_8 = Box.createVerticalGlue();
		verticalGlue_8.setMaximumSize(new Dimension(0, 22267));
		add(verticalGlue_8);
	
		
		
		button1 = new JButton("Acceptar");
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
		
		txtCodi.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {	
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txtCodi.setText("");
			}
		});
		
		txtDescripcio.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {	
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txtDescripcio.setText("");
			}
		});
		
		txtData.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {	
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txtData.setText("");
			}
		});
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int c = Integer.parseInt(txtCodi.getText());
				String d = txtDescripcio.getText();
				String dat = txtData.getText();
				try {
					Principal.getCE().crearEsdeveniment(d, c, dat);
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
        		Principal.loadEsdeveniments();
        	}
        });
	}

	public void config(){		
		//Asociamos la tecla intro con el botón de Generar Comunidades
		JRootPane rootPane = SwingUtilities.getRootPane(button1); 
		rootPane.setDefaultButton(button1);
	}
}
