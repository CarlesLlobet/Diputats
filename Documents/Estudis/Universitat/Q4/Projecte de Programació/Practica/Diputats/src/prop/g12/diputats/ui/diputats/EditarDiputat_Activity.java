package prop.g12.diputats.ui.diputats;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellEditor;

import prop.g12.diputats.ui.JPanelFondo;
import prop.g12.diputats.ui.Principal;

public class EditarDiputat_Activity extends JPanelFondo{
	
	private static final long serialVersionUID = 1L;
	private JButton button;
	private JButton enrere;
	private JLabel titol;
	private Component verticalGlue;
	private Component verticalGlue_1;
	private Component verticalGlue_2;
	private Component verticalGlue_5;
	private JTextField txtNom;
	private Component verticalGlue_3;
	private JTextField txtNomEmpresa;
	private JTextField txtAmbitEmpresa;
	private JTextField txtIdeologa;
	private JTextField txtProcedncia;
	private Component verticalGlue_4;
	private Component verticalGlue_6;
	private Component verticalGlue_7;
	private JLabel lblOK;
	private Component verticalGlue_8;
	private Box verticalBox;
	private JLabel lblNewLabel;
	private JTextField textField;
	private Box horizontalBox;
	private JButton btnEliminar;
	
	public EditarDiputat_Activity(String nom, String procedencia, String ideologia, String nomEmpresa, String ambitEmpresa, JTree esdeveniments) {
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
		
		titol = new JLabel("Editar Diputat");
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
		txtNom.setText(nom);
		add(txtNom);
		txtNom.setColumns(10);
		
		verticalGlue_4 = Box.createVerticalGlue();
		verticalGlue_4.setMaximumSize(new Dimension(0, 7267));
		add(verticalGlue_4);
		
		txtNomEmpresa = new JTextField();
		txtNomEmpresa.setText(nomEmpresa);
		txtNomEmpresa.setMaximumSize(new Dimension(217, 100));
		txtNomEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomEmpresa.setColumns(10);
		add(txtNomEmpresa);
		
		verticalGlue_6 = Box.createVerticalGlue();
		verticalGlue_6.setMaximumSize(new Dimension(0, 7267));
		add(verticalGlue_6);
		
		txtAmbitEmpresa = new JTextField();
		txtAmbitEmpresa.setText(ambitEmpresa);
		txtAmbitEmpresa.setMaximumSize(new Dimension(217, 100));
		txtAmbitEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		txtAmbitEmpresa.setColumns(10);
		add(txtAmbitEmpresa);
		
		verticalGlue_6 = Box.createVerticalGlue();
		verticalGlue_6.setMaximumSize(new Dimension(0, 7267));
		add(verticalGlue_6);
		
		txtIdeologa = new JTextField();
		txtIdeologa.setText(ideologia);
		txtIdeologa.setMaximumSize(new Dimension(217, 100));
		txtIdeologa.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdeologa.setColumns(10);
		add(txtIdeologa);
		
		verticalGlue_1 = Box.createVerticalGlue();
		verticalGlue_1.setMaximumSize(new Dimension(0, 7267));
		add(verticalGlue_1);
		
		txtProcedncia = new JTextField();
		txtProcedncia.setText(procedencia);
		txtProcedncia.setMaximumSize(new Dimension(217, 100));
		txtProcedncia.setHorizontalAlignment(SwingConstants.CENTER);
		txtProcedncia.setColumns(10);
		add(txtProcedncia);
		
		verticalGlue_7 = Box.createVerticalGlue();
		verticalGlue_7.setMaximumSize(new Dimension(0, 7267));
		add(verticalGlue_7);
		
		JScrollPane scrollPane = new JScrollPane(esdeveniments);
		esdeveniments.setEditable(true);
		TreeCellEditor editor = 
		        new DefaultTreeCellEditor(esdeveniments, (DefaultTreeCellRenderer) 
		        		esdeveniments.getCellRenderer()) {
		    @Override
		    protected boolean canEditImmediately(EventObject event) {
		        if((event instanceof MouseEvent) &&
		           SwingUtilities.isLeftMouseButton((MouseEvent)event)) {
		            MouseEvent me = (MouseEvent)event;

		            return ((me.getClickCount() >= 1) &&
		                    inHitRegion(me.getX(), me.getY()));
		        }
		        return (event == null);
		    }
		};
		esdeveniments.setCellEditor(editor);
		
		scrollPane.setMaximumSize(new Dimension(250, 1767));
		add(scrollPane);
		
		verticalGlue_8 = Box.createVerticalGlue();
		verticalGlue_8.setMaximumSize(new Dimension(0, 7267));
		add(verticalGlue_8);
		
		horizontalBox = Box.createHorizontalBox();
		add(horizontalBox);
		
		verticalBox = Box.createVerticalBox();
		horizontalBox.add(verticalBox);
		
		lblNewLabel = new JLabel("Eliminar esdeveniment:");
		lblNewLabel.setForeground(Color.WHITE);
		verticalBox.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setText("\"304\"");
		textField.setMaximumSize(new Dimension(300, 20));
		textField.setForeground(Color.BLACK);
		verticalBox.add(textField);
		textField.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		horizontalBox.add(btnEliminar);
		
		verticalGlue_5 = Box.createVerticalGlue();
		add(verticalGlue_5);
		
		lblOK = new JLabel("");
		add(lblOK);
	
		
		
		button = new JButton("Guardar");
		button.setSelected(true);
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setMinimumSize(new Dimension(150, 23));
		button.setMaximumSize(new Dimension(150, 23));
		this.add(button);

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
		
		txtIdeologa.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {	
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txtIdeologa.setText("");
			}
		});
		
		txtProcedncia.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {	
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txtProcedncia.setText("");
			}
		});
		
		txtNomEmpresa.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {	
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txtNomEmpresa.setText("");
			}
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				esdeveniments.stopEditing();
				String nomC = txtNom.getText();
				String ideologiaC = txtIdeologa.getText();
				String procedenciaC = txtProcedncia.getText();
				String nomEmpresaC = txtNomEmpresa.getText();
				try {
					Principal.getCD().modificarDiputat(nomC, ideologiaC, procedenciaC, nomEmpresaC);
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					Principal.getCC().modificarEsdeveniment(esdeveniments);
				} catch (Exception e) {
					e.printStackTrace();
				}
				deleteView();
				Principal.loadDiputats();
					
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int c = Integer.parseInt(textField.getText());
				try {
					Principal.getCC().eliminarAssistencia(nom, c);
				} catch (Exception e) {
					e.printStackTrace();
				}
				deleteView();
				Principal.loadDiputats();
					
			}
		});
		
		enrere.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		deleteView();
        		Principal.loadBuscarDiputat();
        	}
        });
	}

	public void config(){		
		//Asociamos la tecla intro con el botón de Generar Comunidades
		JRootPane rootPane = SwingUtilities.getRootPane(button); 
		rootPane.setDefaultButton(button);
	}
}
