package prop.g12.diputats.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

abstract public class JPanelFondo extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private Image fondo= null;
   
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(fondo,0,0,getWidth(),getHeight(),null);
    }

    public void setImage(String image){
        fondo=new ImageIcon(getClass().getResource(image)).getImage();
     }
    
    protected void deleteView(){
    	ControladorPrincipal.removeView(this);
    }
    
 }
