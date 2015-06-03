package prop.g12.diputats.ui;

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
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class EditarComunitats_Activity extends JPanelFondo{
	
	private static final long serialVersionUID = 1L;
	private JButton button;
	private JButton enrere;
	private JLabel titol;
	private Component verticalGlue;
	private Component verticalGlue_1;
	private Component verticalGlue_2;
	private Component verticalGlue_5;
	private Box horizontalBox;
	private Box verticalBox;
	private Box verticalBox_1;
	private JLabel lblNewLabel;
	private JTextField txtjuanitoPrez;
	private JLabel lblNewLabel_1;
	private JTextField txtcomunitatX;
	private Component verticalGlue_3;
	private Box horizontalBox_1;
	private Box horizontalBox_2;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private Box horizontalBox_3;
	private Box horizontalBox_4;
	private Component horizontalStrut_2;
	private Component horizontalStrut_3;
	
	public EditarComunitats_Activity(JTree tree, String nomF) {
		
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
		add(verticalGlue);
		
		titol = new JLabel("Comunitats de " + tree.getModel().getRoot().toString());
		titol.setHorizontalAlignment(SwingConstants.CENTER);
		titol.setForeground(Color.WHITE);
		titol.setFocusable(false);
		titol.setFont(new Font("Tahoma", Font.BOLD, 14));
		titol.setAlignmentX(Component.CENTER_ALIGNMENT);
		titol.setMaximumSize(new Dimension(245, 23));
		add(titol);
		
		verticalGlue_5 = Box.createVerticalGlue();
		verticalGlue_5.setMaximumSize(new Dimension(0, 12767));
		add(verticalGlue_5);
		
		tree.setRootVisible(false);
		tree.setDragEnabled(true);
		JScrollPane scrollPane = new JScrollPane(tree);
		scrollPane.setMaximumSize(new Dimension(200, 12767));
		add(scrollPane);
		
		verticalGlue_1 = Box.createVerticalGlue();
		verticalGlue_1.setMaximumSize(new Dimension(0, 12767));
		add(verticalGlue_1);
		
		horizontalBox = Box.createHorizontalBox();
		horizontalBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		add(horizontalBox);
		
		verticalBox = Box.createVerticalBox();
		verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalBox.add(verticalBox);
		
		horizontalBox_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3);
		
		horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setMaximumSize(new Dimension(20, 27));
		horizontalBox_3.add(horizontalStrut_2);
		
		lblNewLabel = new JLabel("Nom del Diputat: ");
		horizontalBox_3.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		horizontalBox_4 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_4);
		
		horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalStrut_3.setMaximumSize(new Dimension(20, 27));
		horizontalBox_4.add(horizontalStrut_3);
		
		txtjuanitoPrez = new JTextField("\"Juanito P\u00E9rez\"");
		horizontalBox_4.add(txtjuanitoPrez);
		txtjuanitoPrez.setForeground(Color.BLACK);
		txtjuanitoPrez.setHorizontalAlignment(SwingConstants.CENTER);
		txtjuanitoPrez.setMaximumSize(new Dimension(200, 20));
		txtjuanitoPrez.setColumns(10);
		
		verticalBox_1 = Box.createVerticalBox();
		horizontalBox.add(verticalBox_1);
		
		horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setAlignmentY(Component.CENTER_ALIGNMENT);
		verticalBox_1.add(horizontalBox_1);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setMaximumSize(new Dimension(20, 27));
		horizontalBox_1.add(horizontalStrut);
		
		lblNewLabel_1 = new JLabel("Comunitat dest\u00ED: ");
		horizontalBox_1.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		horizontalBox_2 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_2);
		
		horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setMaximumSize(new Dimension(20, 27));
		horizontalBox_2.add(horizontalStrut_1);
		
		txtcomunitatX = new JTextField();
		horizontalBox_2.add(txtcomunitatX);
		txtcomunitatX.setForeground(Color.BLACK);
		txtcomunitatX.setText("2");
		txtcomunitatX.setHorizontalAlignment(SwingConstants.CENTER);
		txtcomunitatX.setMaximumSize(new Dimension(200, 20));
		txtcomunitatX.setColumns(10);
		
		verticalGlue_3 = Box.createVerticalGlue();
		verticalGlue_3.setMaximumSize(new Dimension(0, 12767));
		add(verticalGlue_3);
		
		button = new JButton("Guardar");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(button);
		
		verticalGlue_2 = Box.createVerticalGlue();
		add(verticalGlue_2);
		
		//Logica de la vista
		
		txtjuanitoPrez.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {	
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txtjuanitoPrez.setText("");
			}
		});
		
		txtcomunitatX.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {	
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txtcomunitatX.setText("");
			}
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nd = txtjuanitoPrez.getText();
				String cd = txtcomunitatX.getText();
				JTree aux = null;
				try {
					aux = Principal.getCS().modificarSolucio(nd, cd, nomF, tree);
				} catch (Exception e) {
					e.printStackTrace();
				}
				deleteView();
				if (aux != null) Principal.loadVeureComunitats(aux, nomF);
				else Principal.loadVeureComunitats(tree, nomF);
			}
		});
		
		enrere.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		deleteView();
        		Principal.loadVeureComunitats(tree,nomF);
        	}
        });
	}

	public void config(){		
		//Asociamos la tecla intro con el botón de Generar Comunidades
		JRootPane rootPane = SwingUtilities.getRootPane(button); 
		rootPane.setDefaultButton(button);
	}
}
