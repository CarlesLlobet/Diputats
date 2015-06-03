package prop.g12.diputats.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import java.io.File;
import java.io.IOException;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class EstadisticaSolucions_Activity extends JPanelFondo{
	
	private static final long serialVersionUID = 1L;
	private JButton enrere;
	private JLabel titol;
	private Component verticalGlue;
	private Component verticalGlue_1;
	private Component verticalGlue_5;
	private JLabel lblGraf;
	private Box horizontalBox;
	private Box verticalBox;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public EstadisticaSolucions_Activity() throws IOException {
		
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
		verticalGlue.setMaximumSize(new Dimension(0, 5767));
		add(verticalGlue);
		
		titol = new JLabel("Estadística per Solucions");
		titol.setHorizontalAlignment(SwingConstants.CENTER);
		titol.setForeground(Color.WHITE);
		titol.setFocusable(false);
		titol.setFont(new Font("Tahoma", Font.BOLD, 14));
		titol.setAlignmentX(Component.CENTER_ALIGNMENT);
		titol.setMaximumSize(new Dimension(245, 23));
		add(titol);
		
		verticalGlue_5 = Box.createVerticalGlue();
		add(verticalGlue_5);
		
		File imageFile = new File("io/estadisticaSolucions.jpeg");
		Image imatge = ImageIO.read(imageFile);  
        
        horizontalBox = Box.createHorizontalBox();
        add(horizontalBox);
        
        lblGraf = new JLabel(new ImageIcon(imatge));
        lblGraf.setAlignmentX(Component.CENTER_ALIGNMENT);
        horizontalBox.add(lblGraf);
		
		verticalBox = Box.createVerticalBox();
		horizontalBox.add(verticalBox);
		
		rdbtnNewRadioButton = new JRadioButton("Cliqu\u00E9-Percolation");
		rdbtnNewRadioButton.setPreferredSize(new Dimension(120, 23));
		rdbtnNewRadioButton.setMinimumSize(new Dimension(120, 23));
		rdbtnNewRadioButton.setMaximumSize(new Dimension(120, 23));
		buttonGroup.add(rdbtnNewRadioButton);
		verticalBox.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Louvain");
		rdbtnNewRadioButton_1.setPreferredSize(new Dimension(120, 23));
		rdbtnNewRadioButton_1.setMinimumSize(new Dimension(120, 23));
		rdbtnNewRadioButton_1.setMaximumSize(new Dimension(120, 23));
		buttonGroup.add(rdbtnNewRadioButton_1);
		verticalBox.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("Newman-Girvan");
		rdbtnNewRadioButton_2.setMaximumSize(new Dimension(120, 23));
		rdbtnNewRadioButton_2.setMinimumSize(new Dimension(120, 23));
		rdbtnNewRadioButton_2.setPreferredSize(new Dimension(120, 23));
		buttonGroup.add(rdbtnNewRadioButton_2);
		verticalBox.add(rdbtnNewRadioButton_2);
		
		verticalGlue_1 = Box.createVerticalGlue();
		add(verticalGlue_1);
		
		//Logica de la vista
		
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaSolucions.jpeg"))));
				} catch (IOException e) {
					e.printStackTrace();
				}
				horizontalBox.remove(lblGraf);
				horizontalBox.add(lblGraf);
			}
		});
		
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaSolucions1.jpeg"))));
				} catch (IOException e) {
					e.printStackTrace();
				}
				horizontalBox.remove(lblGraf);
				horizontalBox.add(lblGraf);
			}
		});
		
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaSolucions2.jpeg"))));
				} catch (IOException e) {
					e.printStackTrace();
				}
				horizontalBox.remove(lblGraf);
				horizontalBox.add(lblGraf);
			}
		});
						
		
		enrere.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		deleteView();
        		Principal.loadTriarEstadistica();
        	}
        });
		
		
	}

	public void config(){		
		//Asociamos la tecla intro con el botón de Generar Comunidades
		JRootPane rootPane = SwingUtilities.getRootPane(enrere); 
		rootPane.setDefaultButton(enrere);
	}
}
