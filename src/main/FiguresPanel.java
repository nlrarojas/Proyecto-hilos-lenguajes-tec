

package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class FiguresPanel extends JPanel {

    private static final long serialVersionUID = -6291233936414618049L;
    
    private Figure[] gameObjectsArray;
    private Car[] gameCars;

    private int width;
    private int height;
    
    public FiguresPanel(Figure[] gameObjectsArray, Car[] pCar,int width, int heigth) {
        this.gameObjectsArray = gameObjectsArray;
        this.width = width;
        this.height = heigth;
        this.gameCars = pCar;
        setPreferredSize(new Dimension(width, heigth));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);   
        
        //Se vuelve a pintar los cuadrados
        Color myColor = new Color(255, 239, 179);
        g.setColor(myColor);
        g.fillRect(width/2, 0, width, height);

        for (int i = 0; i < gameObjectsArray.length; i++) {
            gameObjectsArray[i].draw(g);
        }
        
        for (int x = 0; x < gameCars.length; x++){
        	Car tempCar = gameCars[x];
        	g.drawImage(tempCar.getImage(), (int)tempCar.getX(), (int)tempCar.getY(), this);
        }
        
        /*
        //Ahora revisamos si hay que volver a pintar una barrera 
        for (int x = 0; x < barriers.length; x++){
        	if (barriers[x].isState()){
        		barriers[x].drawBarrier(g);
        	}
        }
        */
    }
    
    /*
    public void paintBarriers(Graphics g){
    	for (int i = 0; i < barriers.length; i++) {
    		barriers[i].setState(true);
            barriers[i].drawBarrier(g);
        }
    }
    */
    
    protected void paintImage(Graphics g, Car pCar) {
        super.paintComponent(g);
        g.drawImage(pCar.getImage(), 0, 0, this);          
    }

}
