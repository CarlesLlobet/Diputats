package gui.gestioexode;


import gui.Principal;
import gui.graf.GrafStarWarsPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

public class ConsultaExode extends JPanel{
	
	private String idExode;
	private JComboBox<String> rebelsCombo;
	private JTextField textoFlow;
	private JTextField textoCoste;
	private GrafStarWarsPanel graphComponent;
	private JList<String> listaBasesCamino;
	private DefaultListModel<String> listModel;
	private JButton marcarDesmarcarCuellos;
	private JTextField textoDestinos;
	
	public void actualitza(String idExode) throws IOException{
		this.idExode = idExode;
		ItemListener i = rebelsCombo.getItemListeners()[0];
		rebelsCombo.removeItemListener(i);
		rebelsCombo.removeAllItems();
		rebelsCombo.addItem("Escoge rebelde");
		ArrayList<String> rebels = new ArrayList<String>(Principal.getEc().getRebelsExode(idExode).keySet());
		for(String r : rebels){
			System.out.println("Rebelde " + r);
			rebelsCombo.addItem(r);
		}
		textoFlow.setText("MaxFlow: "+Principal.getEc().getFlowExode(idExode));
		textoCoste.setText("Coste: "+Principal.getEc().getCostExode(idExode));
		textoDestinos.setText("Rebeldes que llegan al destino: "+Principal.getEc().getCaminsExode(idExode).keySet().toString());
		
		graphComponent.setGraf(Principal.getEc().getGrafResidual(idExode));
		graphComponent.paintTheGraf();
		
		rebelsCombo.addItemListener(i);
	}
	
	
	public void reset(){
		
	}
	
	
	public ConsultaExode(){
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(verticalBox);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_2);
		
		graphComponent = new GrafStarWarsPanel();
		graphComponent.setMaximumSize(new Dimension(4525623, 5962562));
		graphComponent.setMinimumSize(new Dimension(400, 250));
		graphComponent.setSize(new Dimension(600, 350));
		try{
			graphComponent.paintTheGraf();
		}catch(Exception e){}
		verticalBox.add(graphComponent);
		
		JLabel labelInfo = new JLabel("Los cuellos de botella se indican con aristas en rojo");
		labelInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelInfo.setForeground(Color.RED);
		verticalBox.add(labelInfo);
		
		marcarDesmarcarCuellos = new JButton();
		marcarDesmarcarCuellos.setAlignmentX(Component.CENTER_ALIGNMENT);
		marcarDesmarcarCuellos.setText("Cuellos de botella");
		marcarDesmarcarCuellos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer[]> ampolla = null;
				try {
					ampolla = Principal.getEc().getAmpollaIdBases(idExode);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(ampolla!=null){
					for (Integer[] integers : ampolla) {
								graphComponent.coloreaAresta(integers[0], integers[1], "red");
					}
				}
			}
		});
		verticalBox.add(marcarDesmarcarCuellos);
		
		
		Box horizontalBox0 = Box.createHorizontalBox();
		horizontalBox0.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(horizontalBox0);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox0.add(horizontalGlue);
		
		textoFlow = new JTextField("MaxFlow: ");
		textoFlow.setMinimumSize(new Dimension(50,15));
		textoFlow.setMaximumSize(new Dimension(50,15));
		horizontalBox0.add(textoFlow);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setMaximumSize(new Dimension(20, 20));
		horizontalBox0.add(horizontalStrut);
		
		textoCoste= new JTextField("Coste: ");
		textoCoste.setMinimumSize(new Dimension(50,15));
		textoCoste.setMaximumSize(new Dimension(50,15));
		horizontalBox0.add(textoCoste);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setMaximumSize(new Dimension(20, 20));
		horizontalBox0.add(horizontalStrut_1);
		
		textoDestinos= new JTextField("Rebeldes que llegan al destino: ");
		textoDestinos.setMinimumSize(new Dimension(250,15));
		textoDestinos.setMaximumSize(new Dimension(250,15));
		horizontalBox0.add(textoDestinos);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox0.add(horizontalGlue_1);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(horizontalBox);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_3);
		
		JLabel labelRebelCombo = new JLabel("Rebelde:");
		horizontalBox.add(labelRebelCombo);
		
		rebelsCombo = new JComboBox<String>();
		rebelsCombo.setMaximumSize(new Dimension(100, 20));
		rebelsCombo.setVisible(true);
		horizontalBox.add(rebelsCombo);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setMaximumSize(new Dimension(20, 20));
		horizontalBox.add(horizontalStrut_2);
		
		JLabel labelCamiList = new JLabel("Detalle camino");
		horizontalBox.add(labelCamiList);
		listModel = new DefaultListModel<String>();

		listaBasesCamino = new JList<String>();
		horizontalBox.add(listaBasesCamino);
		listaBasesCamino.setVisible(true);
		listaBasesCamino.setModel(listModel);
		listaBasesCamino.setMinimumSize(new Dimension(50,100));
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_2);
		
		
		rebelsCombo.addItemListener(new ItemListener() {
			private ArrayList<Integer> basesCamiSeleccionat;

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED) {
					  if(basesCamiSeleccionat!=null){
						  for (int i = 0; i < basesCamiSeleccionat.size()-1; i++) {
			        		  graphComponent.coloreaAresta(basesCamiSeleccionat.get(i), basesCamiSeleccionat.get(i+1), "blue");
			        	  }
					  }
					  
			          String idRebel = arg0.getItem().toString();
			          System.out.println("idRebel :"+idRebel);
			          basesCamiSeleccionat = Principal.getEc().getCaminsExode(idExode).get(idRebel);
			          listModel.removeAllElements();
			          if(basesCamiSeleccionat!=null){
			        	  for (Integer integer : basesCamiSeleccionat) {
			        		  listModel.addElement(integer+"");
			        	  }
			        	  
			        	  for (int i = 0; i < basesCamiSeleccionat.size()-1; i++) {
			        		  graphComponent.coloreaAresta(basesCamiSeleccionat.get(i), basesCamiSeleccionat.get(i+1), "green");
			        	  }
				          
			          }
			       }
				
				
			}
		});
		
		
		
		
	}

}
