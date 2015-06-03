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

import javax.swing.JCheckBox;

public class EstadisticaNodes_Activity extends JPanelFondo{
	
	private static final long serialVersionUID = 1L;
	private JButton enrere;
	private JLabel titol;
	private Component verticalGlue;
	private Component verticalGlue_1;
	private Component verticalGlue_5;
	private JLabel lblGraf;
	private Box horizontalBox;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxNewCheckBox_1;
	private JCheckBox chckbxNewCheckBox_2;
	private Box verticalBox;
	
	public EstadisticaNodes_Activity() throws IOException {
		
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
		
		titol = new JLabel("Estadística per Nodes");
		titol.setHorizontalAlignment(SwingConstants.CENTER);
		titol.setForeground(Color.WHITE);
		titol.setFocusable(false);
		titol.setFont(new Font("Tahoma", Font.BOLD, 14));
		titol.setAlignmentX(Component.CENTER_ALIGNMENT);
		titol.setMaximumSize(new Dimension(245, 23));
		add(titol);
		
		verticalGlue_5 = Box.createVerticalGlue();
		add(verticalGlue_5);
		
		File imageFile = new File("io/estadisticaNodes.jpeg");
		Image imatge = ImageIO.read(imageFile);  
        
        horizontalBox = Box.createHorizontalBox();
        add(horizontalBox);
        
        lblGraf = new JLabel(new ImageIcon(imatge));
        horizontalBox.add(lblGraf);
		
		verticalBox = Box.createVerticalBox();
		horizontalBox.add(verticalBox);
		
		chckbxNewCheckBox = new JCheckBox("Cliqu\u00E9-Percolation");
		chckbxNewCheckBox.setSelected(true);
		verticalBox.add(chckbxNewCheckBox);
		
		chckbxNewCheckBox_1 = new JCheckBox("Louvain");
		chckbxNewCheckBox_1.setPreferredSize(new Dimension(111, 23));
		chckbxNewCheckBox_1.setMinimumSize(new Dimension(111, 23));
		chckbxNewCheckBox_1.setMaximumSize(new Dimension(111, 23));
		chckbxNewCheckBox_1.setSelected(true);
		verticalBox.add(chckbxNewCheckBox_1);
		
		chckbxNewCheckBox_2 = new JCheckBox("Newman-Girvan");
		chckbxNewCheckBox_2.setMaximumSize(new Dimension(111, 23));
		chckbxNewCheckBox_2.setMinimumSize(new Dimension(111, 23));
		chckbxNewCheckBox_2.setPreferredSize(new Dimension(111, 23));
		chckbxNewCheckBox_2.setSelected(true);
		verticalBox.add(chckbxNewCheckBox_2);
		
		verticalGlue_1 = Box.createVerticalGlue();
		add(verticalGlue_1);
		
		//Logica de la vista
		
		enrere.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		deleteView();
        		Principal.loadTriarEstadistica();
        	}
        });
		
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox.isSelected()){
					if (chckbxNewCheckBox_1.isSelected()){
						if (chckbxNewCheckBox_2.isSelected()){
							try {
								lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaNodes.jpeg"))));
							} catch (IOException e) {
								e.printStackTrace();
							}
							 horizontalBox.remove(lblGraf);
						     horizontalBox.add(lblGraf);
						}
						else {
							try {
								lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaNodes1.jpeg"))));
							} catch (IOException e) {
								e.printStackTrace();
							}
							 horizontalBox.remove(lblGraf);
						     horizontalBox.add(lblGraf);
						}
					}
					else{
						if(chckbxNewCheckBox_2.isSelected()){
							try {
								lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaNodes2.jpeg"))));
							} catch (IOException e) {
								e.printStackTrace();
							}
							 horizontalBox.remove(lblGraf);
						     horizontalBox.add(lblGraf);
						}
						else {
							try {
								lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaNodes3.jpeg"))));
							} catch (IOException e) {
								e.printStackTrace();
							}
							 horizontalBox.remove(lblGraf);
						     horizontalBox.add(lblGraf);
						}
					}
				}
				else {
					if (chckbxNewCheckBox_1.isSelected()){
						if (chckbxNewCheckBox_2.isSelected()){
							try {
								lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaNodes4.jpeg"))));
							} catch (IOException e) {
								e.printStackTrace();
							}
							 horizontalBox.remove(lblGraf);
						     horizontalBox.add(lblGraf);
						}
						else {
							try {
								lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaNodes5.jpeg"))));							} catch (IOException e) {
								e.printStackTrace();
							}
							 horizontalBox.remove(lblGraf);
						     horizontalBox.add(lblGraf);
						}
					}
					else{
						if(chckbxNewCheckBox_2.isSelected()){
							try {
								lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaNodes6.jpeg"))));							} catch (IOException e) {
								e.printStackTrace();
							}
							 horizontalBox.remove(lblGraf);
						     horizontalBox.add(lblGraf);
						}
						else {
							try {
								lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaNodes7.jpeg"))));
							} catch (IOException e) {
								e.printStackTrace();
							}
							 horizontalBox.remove(lblGraf);
						     horizontalBox.add(lblGraf);
						}
					}
				}
        	}
		});

		
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox.isSelected()){
					if (chckbxNewCheckBox_1.isSelected()){
						if (chckbxNewCheckBox_2.isSelected()){
							try {
								lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaNodes.jpeg"))));
							} catch (IOException e) {
								e.printStackTrace();
							}
							 horizontalBox.remove(lblGraf);
						     horizontalBox.add(lblGraf);
						}
						else {
							try {
								lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaNodes1.jpeg"))));
							} catch (IOException e) {
								e.printStackTrace();
							}
							 horizontalBox.remove(lblGraf);
						     horizontalBox.add(lblGraf);
						}
					}
					else{
						if(chckbxNewCheckBox_2.isSelected()){
							try {
								lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaNodes2.jpeg"))));
							} catch (IOException e) {
								e.printStackTrace();
							}
							 horizontalBox.remove(lblGraf);
						     horizontalBox.add(lblGraf);
						}
						else {
							try {
								lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaNodes3.jpeg"))));
							} catch (IOException e) {
								e.printStackTrace();
							}
							 horizontalBox.remove(lblGraf);
						     horizontalBox.add(lblGraf);
						}
					}
				}
				else {
					if (chckbxNewCheckBox_1.isSelected()){
						if (chckbxNewCheckBox_2.isSelected()){
							try {
								lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaNodes4.jpeg"))));
							} catch (IOException e) {
								e.printStackTrace();
							}
							 horizontalBox.remove(lblGraf);
						     horizontalBox.add(lblGraf);
						}
						else {
							try {
								lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaNodes5.jpeg"))));							} catch (IOException e) {
								e.printStackTrace();
							}
							 horizontalBox.remove(lblGraf);
						     horizontalBox.add(lblGraf);
						}
					}
					else{
						if(chckbxNewCheckBox_2.isSelected()){
							try {
								lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaNodes6.jpeg"))));							} catch (IOException e) {
								e.printStackTrace();
							}
							 horizontalBox.remove(lblGraf);
						     horizontalBox.add(lblGraf);
						}
						else {
							try {
								lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaNodes7.jpeg"))));
							} catch (IOException e) {
								e.printStackTrace();
							}
							 horizontalBox.remove(lblGraf);
						     horizontalBox.add(lblGraf);
						}
					}
				}
        	}
		});
		
		chckbxNewCheckBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox.isSelected()){
					if (chckbxNewCheckBox_1.isSelected()){
						if (chckbxNewCheckBox_2.isSelected()){
							try {
								lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaNodes.jpeg"))));
							} catch (IOException e) {
								e.printStackTrace();
							}
							 horizontalBox.remove(lblGraf);
						     horizontalBox.add(lblGraf);
						}
						else {
							try {
								lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaNodes1.jpeg"))));
							} catch (IOException e) {
								e.printStackTrace();
							}
							 horizontalBox.remove(lblGraf);
						     horizontalBox.add(lblGraf);
						}
					}
					else{
						if(chckbxNewCheckBox_2.isSelected()){
							try {
								lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaNodes2.jpeg"))));
							} catch (IOException e) {
								e.printStackTrace();
							}
							 horizontalBox.remove(lblGraf);
						     horizontalBox.add(lblGraf);
						}
						else {
							try {
								lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaNodes3.jpeg"))));
							} catch (IOException e) {
								e.printStackTrace();
							}
							 horizontalBox.remove(lblGraf);
						     horizontalBox.add(lblGraf);
						}
					}
				}
				else {
					if (chckbxNewCheckBox_1.isSelected()){
						if (chckbxNewCheckBox_2.isSelected()){
							try {
								lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaNodes4.jpeg"))));
							} catch (IOException e) {
								e.printStackTrace();
							}
							 horizontalBox.remove(lblGraf);
						     horizontalBox.add(lblGraf);
						}
						else {
							try {
								lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaNodes5.jpeg"))));							} catch (IOException e) {
								e.printStackTrace();
							}
							 horizontalBox.remove(lblGraf);
						     horizontalBox.add(lblGraf);
						}
					}
					else{
						if(chckbxNewCheckBox_2.isSelected()){
							try {
								lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaNodes6.jpeg"))));							} catch (IOException e) {
								e.printStackTrace();
							}
							 horizontalBox.remove(lblGraf);
						     horizontalBox.add(lblGraf);
						}
						else {
							try {
								lblGraf.setIcon(new ImageIcon(ImageIO.read( new File("io/estadisticaNodes7.jpeg"))));
							} catch (IOException e) {
								e.printStackTrace();
							}
							 horizontalBox.remove(lblGraf);
						     horizontalBox.add(lblGraf);
						}
					}
				}
        	}
		});
		
		
	}

	public void config(){		
		//Asociamos la tecla intro con el botón de Generar Comunidades
		JRootPane rootPane = SwingUtilities.getRootPane(enrere); 
		rootPane.setDefaultButton(enrere);
	}
}
