package prop.g12.diputats.ui.congressos;

import prop.g12.diputats.ui.JPanelFondo;
import prop.g12.diputats.ui.Principal;

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
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Congressos_Activity extends JPanelFondo{

	private static final long serialVersionUID = 1L;
	private JButton button;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton enrere;
	private JLabel titol;
	private Component verticalGlue;
	private Component verticalGlue_1;
	private Component verticalGlue_2;
	private Component verticalGlue_3;
	private Component verticalGlue_4;
	private Component verticalGlue_5;
	private Box horizontalBox;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private Box verticalBox_1;
	private Box horizontalBox_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private Component horizontalGlue;
	private Component verticalGlue_6;
	private Component verticalGlue_7;
	private JButton btnVeureCongrs;
	
	public Congressos_Activity() {
		//Preparamos la vista
		setBounds(100, 100, 793, 499);
		setFocusTraversalPolicyProvider(true);
		setAutoscrolls(true);
        setImage("../images/background.jpg");
		
		enrere = new JButton("Enrere");
		enrere.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(enrere);
		
		Box verticalBox = Box.createVerticalBox();
        verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(verticalBox);

        
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        verticalGlue = Box.createVerticalGlue();
		add(verticalGlue);
		
		titol = new JLabel("Seleccionar Congrés");
		titol.setHorizontalAlignment(SwingConstants.CENTER);
		titol.setForeground(Color.WHITE);
		titol.setFocusable(false);
		titol.setFont(new Font("Tahoma", Font.BOLD, 24));
		titol.setAlignmentX(Component.CENTER_ALIGNMENT);
		titol.setMaximumSize(new Dimension(275, 23));
		add(titol);
		
		verticalGlue_5 = Box.createVerticalGlue();
		add(verticalGlue_5);
		
		btnVeureCongrs = new JButton("Veure Congr\u00E9s");
		btnVeureCongrs.setSelected(true);
		btnVeureCongrs.setMinimumSize(new Dimension(160, 23));
		btnVeureCongrs.setMaximumSize(new Dimension(160, 23));
		btnVeureCongrs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVeureCongrs.setAlignmentX(0.5f);
		add(btnVeureCongrs);
		
		verticalGlue_7 = Box.createVerticalGlue();
		verticalGlue_7.setMaximumSize(new Dimension(0, 22767));
		add(verticalGlue_7);
	
		button = new JButton("Editar Congrés");
		button.setSelected(true);
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setMinimumSize(new Dimension(160, 23));
		button.setMaximumSize(new Dimension(160, 23));
		this.add(button);

		verticalGlue_1 = Box.createVerticalGlue();
		verticalGlue_1.setMaximumSize(new Dimension(0, 22767));
		this.add(verticalGlue_1);
		
		button1 = new JButton("Importar Congrés");
		button1.setSelected(true);
		button1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button1.setAlignmentX(Component.CENTER_ALIGNMENT);
		button1.setMinimumSize(new Dimension(170, 23));
		button1.setMaximumSize(new Dimension(170, 23));
		this.add(button1);

		verticalGlue_2 = Box.createVerticalGlue();
		verticalGlue_2.setMaximumSize(new Dimension(0, 22767));
		this.add(verticalGlue_2);
		
		button2 = new JButton("Exportar Congrés");
		button2.setSelected(true);
		button2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button2.setAlignmentX(Component.CENTER_ALIGNMENT);
		button2.setMinimumSize(new Dimension(170, 23));
		button2.setMaximumSize(new Dimension(170, 23));
		this.add(button2);

		verticalGlue_3 = Box.createVerticalGlue();
		verticalGlue_3.setMaximumSize(new Dimension(0, 22767));
		this.add(verticalGlue_3);
		
		button3 = new JButton("Generar Congrés aleatori");
		add(button3);
		button3.setSelected(true);
		button3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button3.setAlignmentX(Component.CENTER_ALIGNMENT);
		button3.setMinimumSize(new Dimension(190, 23));
		button3.setMaximumSize(new Dimension(190, 23));
		
		verticalGlue_6 = Box.createVerticalGlue();
		verticalGlue_6.setMaximumSize(new Dimension(0, 6767));
		add(verticalGlue_6);
		
		verticalBox_1 = Box.createVerticalBox();
		add(verticalBox_1);
		
		horizontalBox = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox);
		
		lblNewLabel = new JLabel("Num. Diputats");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setMaximumSize(new Dimension(100, 14));
		horizontalBox.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Num. Esdeveniments");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		horizontalBox.add(lblNewLabel_1);
		
		horizontalBox_1 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_1);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(10), new Integer(1), null, new Integer(1)));
		horizontalBox_1.add(spinner);
		spinner.setMaximumSize(new Dimension(50, 100));
		
		horizontalGlue = Box.createHorizontalGlue();
		horizontalGlue.setMaximumSize(new Dimension(50, 0));
		horizontalBox_1.add(horizontalGlue);
		
		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(10), new Integer(1), null, new Integer(1)));
		horizontalBox_1.add(spinner_1);
		spinner_1.setMaximumSize(new Dimension(50, 100));

		verticalGlue_4 = Box.createVerticalGlue();
		verticalGlue_4.setMaximumSize(new Dimension(0, 42767));
		this.add(verticalGlue_4);
		
		//LOGICA DE LA VISTA
			
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteView();
				Principal.loadEditarCongres();
					
			}
		});
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteView();
				Principal.loadImportCongres();
					
			}
		});
		
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteView();
				Principal.loadExportCongres();
					
			}
		});
		
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Principal.getIO().generarRandom((int) spinner.getValue(), (int) spinner_1.getValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
				deleteView();
				Principal.loadMenu();
					
			}
		});
		
		btnVeureCongrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JTree tree = null;
				try {
					tree = Principal.getCC().getArbreCongres();
				} catch (Exception e) {
					e.printStackTrace();
				}
				deleteView();
				Principal.loadVeureCongres(tree);
					
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
