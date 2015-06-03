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
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.TextField;
import java.io.IOException;

public class Parametres_Activity extends JPanelFondo{
	
	private static final long serialVersionUID = 1L;
	private JButton button;
	private JButton enrere;
	private JLabel titol;
	private Component verticalGlue;
	private Component verticalGlue_1;
	private Component verticalGlue_3;
	private Component verticalGlue_4;
	private Component verticalGlue_5;
	private JRadioButton rdbtnNewmangirvan;
	private JRadioButton rdbtnCliqupercolation;
	private JRadioButton rdbtnLouvain;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Box horizontalBox;
	private JLabel lblEmpresa;
	private JSpinner spinner;
	private Box horizontalBox_1;
	private JLabel lblIdeologia;
	private JSpinner spinner_1;
	private Box horizontalBox_2;
	private JLabel lblProcedencia;
	private JSpinner spinner_2;
	private Box horizontalBox_3;
	private JLabel lblEsdeveniments;
	private JSpinner spinner_3;
	private TextField textField;
	private JLabel lblNomDeLarxiu;
	private Box horizontalBox_4;
	private Box verticalBox_1;
	private Box verticalBox_2;
	private Box verticalBox;
	private JLabel lblAlgorisme;
	private JLabel lblPercentatgeDimportncia;
	private Component horizontalGlue;
	private Component verticalGlue_2;
	private Component horizontalGlue_1;
	private Component horizontalGlue_2;
	private Component horizontalGlue_3;
	private Component horizontalGlue_4;
	private Component verticalStrut;
	
	public Parametres_Activity() {
		
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
		
		horizontalBox_4 = Box.createHorizontalBox();
		horizontalBox_4.setAlignmentY(Component.CENTER_ALIGNMENT);
		add(horizontalBox_4);
		
		verticalBox_1 = Box.createVerticalBox();
		horizontalBox_4.add(verticalBox_1);
		
		lblPercentatgeDimportncia = new JLabel("Percentatge d'import\u00E0ncia:");
		lblPercentatgeDimportncia.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPercentatgeDimportncia.setHorizontalTextPosition(SwingConstants.LEFT);
		lblPercentatgeDimportncia.setHorizontalAlignment(SwingConstants.LEFT);
		lblPercentatgeDimportncia.setForeground(Color.WHITE);
		verticalBox_1.add(lblPercentatgeDimportncia);
		
		verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setMinimumSize(new Dimension(0, 0));
		verticalStrut.setMaximumSize(new Dimension(0, 50));
		verticalBox_1.add(verticalStrut);
		
		horizontalBox = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox);
		
		lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresa.setPreferredSize(new Dimension(75, 14));
		lblEmpresa.setMinimumSize(new Dimension(100, 14));
		lblEmpresa.setMaximumSize(new Dimension(100, 14));
		horizontalBox.add(lblEmpresa);
		lblEmpresa.setForeground(Color.WHITE);
		
		horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalGlue_4.setMaximumSize(new Dimension(10, 0));
		horizontalBox.add(horizontalGlue_4);
		
		spinner = new JSpinner();
		spinner.setPreferredSize(new Dimension(40, 20));
		spinner.setMinimumSize(new Dimension(40, 20));
		spinner.setModel(new SpinnerNumberModel(25, 0, 100, 1));
		spinner.setToolTipText("");
		horizontalBox.add(spinner);
		spinner.setMaximumSize(new Dimension(40, 20));
		
		horizontalBox_1 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_1);
		
		lblIdeologia = new JLabel("Ideolog\u00EDa");
		lblIdeologia.setMaximumSize(new Dimension(100, 14));
		lblIdeologia.setMinimumSize(new Dimension(100, 14));
		lblIdeologia.setPreferredSize(new Dimension(75, 14));
		lblIdeologia.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdeologia.setForeground(Color.WHITE);
		horizontalBox_1.add(lblIdeologia);
		
		horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalGlue_3.setMaximumSize(new Dimension(10, 0));
		horizontalBox_1.add(horizontalGlue_3);
		
		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(25, 0, 100, 1));
		spinner_1.setPreferredSize(new Dimension(40, 20));
		spinner_1.setMinimumSize(new Dimension(40, 20));
		spinner_1.setMaximumSize(new Dimension(40, 20));
		horizontalBox_1.add(spinner_1);
		
		horizontalBox_2 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_2);
		
		lblProcedencia = new JLabel("Proced\u00E8ncia");
		lblProcedencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblProcedencia.setMinimumSize(new Dimension(100, 14));
		lblProcedencia.setMaximumSize(new Dimension(100, 14));
		lblProcedencia.setPreferredSize(new Dimension(75, 14));
		lblProcedencia.setForeground(Color.WHITE);
		horizontalBox_2.add(lblProcedencia);
		
		horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalGlue_2.setMaximumSize(new Dimension(10, 0));
		horizontalBox_2.add(horizontalGlue_2);
		
		spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(25, 0, 100, 1));
		spinner_2.setPreferredSize(new Dimension(40, 20));
		spinner_2.setMinimumSize(new Dimension(40, 20));
		spinner_2.setMaximumSize(new Dimension(40, 20));
		horizontalBox_2.add(spinner_2);
		
		horizontalBox_3 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_3);
		
		lblEsdeveniments = new JLabel("Esdeveniments");
		lblEsdeveniments.setHorizontalAlignment(SwingConstants.CENTER);
		lblEsdeveniments.setPreferredSize(new Dimension(75, 14));
		lblEsdeveniments.setMinimumSize(new Dimension(100, 14));
		lblEsdeveniments.setMaximumSize(new Dimension(100, 14));
		lblEsdeveniments.setForeground(Color.WHITE);
		horizontalBox_3.add(lblEsdeveniments);
		
		horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalGlue_1.setMaximumSize(new Dimension(10, 0));
		horizontalBox_3.add(horizontalGlue_1);
		
		spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(25, 0, 100, 1));
		spinner_3.setPreferredSize(new Dimension(40, 20));
		spinner_3.setMinimumSize(new Dimension(40, 20));
		spinner_3.setMaximumSize(new Dimension(40, 20));
		horizontalBox_3.add(spinner_3);
		
		horizontalGlue = Box.createHorizontalGlue();
		horizontalGlue.setMaximumSize(new Dimension(50, 0));
		horizontalBox_4.add(horizontalGlue);
		
		verticalBox_2 = Box.createVerticalBox();
		horizontalBox_4.add(verticalBox_2);
		
		lblAlgorisme = new JLabel("Algorisme:");
		lblAlgorisme.setForeground(Color.WHITE);
		verticalBox_2.add(lblAlgorisme);
		
		verticalGlue_2 = Box.createVerticalGlue();
		verticalGlue_2.setMaximumSize(new Dimension(0, 50));
		verticalBox_2.add(verticalGlue_2);
		
		rdbtnNewmangirvan = new JRadioButton("Newman-Girvan");
		verticalBox_2.add(rdbtnNewmangirvan);
		buttonGroup.add(rdbtnNewmangirvan);
		rdbtnNewmangirvan.setMaximumSize(new Dimension(150, 23));
		rdbtnNewmangirvan.setMinimumSize(new Dimension(111, 23));
		rdbtnNewmangirvan.setPreferredSize(new Dimension(111, 23));
		rdbtnNewmangirvan.setSelected(true);
		
		rdbtnCliqupercolation = new JRadioButton("Cliqu\u00E9-Percolation");
		rdbtnCliqupercolation.setMaximumSize(new Dimension(150, 23));
		verticalBox_2.add(rdbtnCliqupercolation);
		buttonGroup.add(rdbtnCliqupercolation);
		
		rdbtnLouvain = new JRadioButton("Louvain");
		verticalBox_2.add(rdbtnLouvain);
		buttonGroup.add(rdbtnLouvain);
		rdbtnLouvain.setPreferredSize(new Dimension(111, 23));
		rdbtnLouvain.setMinimumSize(new Dimension(111, 23));
		rdbtnLouvain.setMaximumSize(new Dimension(150, 23));

		verticalGlue_1 = Box.createVerticalGlue();
		verticalGlue_1.setMaximumSize(new Dimension(0, 12767));
		this.add(verticalGlue_1);
		
		verticalBox = Box.createVerticalBox();
		verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(verticalBox);
		
		lblNomDeLarxiu = new JLabel("Nom de l'arxiu:");
		lblNomDeLarxiu.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(lblNomDeLarxiu);
		lblNomDeLarxiu.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNomDeLarxiu.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomDeLarxiu.setForeground(Color.WHITE);
		
		textField = new TextField();
		verticalBox.add(textField);
		textField.setMaximumSize(new Dimension(200, 100));

		verticalGlue_3 = Box.createVerticalGlue();
		this.add(verticalGlue_3);
		
		button = new JButton("Generar Solució");
		button.setSelected(true);
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setMinimumSize(new Dimension(130, 23));
		button.setMaximumSize(new Dimension(130, 23));
		this.add(button);
		
		verticalGlue_4 = Box.createVerticalGlue();
		this.add(verticalGlue_4);
		
		//Logica de la vista
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pEmp = (int) spinner.getValue();
				int pIde = (int) spinner_1.getValue();
				int pPro = (int) spinner_2.getValue();
				int pEsd = (int) spinner_3.getValue();
				String nomF = textField.getText();
				String opt = null;
				if (rdbtnNewmangirvan.isSelected()) opt = "newman";
				else if (rdbtnLouvain.isSelected()) opt = "louvain";
				else if (rdbtnCliqupercolation.isSelected()) opt = "clique";
				JTree tree = null;
				try {
					tree = Principal.getCA().selectAlgorisme(opt,nomF,pEmp,pIde,pPro,pEsd);
				} catch (IOException e) {
					e.printStackTrace();
				}
				deleteView();
				Principal.loadVeureComunitats(tree,nomF);
			}
		});
		
		enrere.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		deleteView();
        		Principal.loadMenu();
        	}
        });
	}

	public void config(){		
		//Asociamos la tecla intro con el botón de Generar Comunidades
		JRootPane rootPane = SwingUtilities.getRootPane(button); 
		rootPane.setDefaultButton(button);
	}
}
