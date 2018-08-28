package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class FiguresPanelnterrupt extends JPanel {
	
	 private Figure[] gameObjectsArray;
	    private int width;
	    private int height;
	    private int numCols;
	    
	    public FiguresPanelnterrupt(int numCols, Figure[] gameObjectsArray, int width, int heigth) {
	        this.gameObjectsArray = gameObjectsArray;
	        this.width = width;
	        this.height = heigth;
	        this.numCols = numCols;
	        setPreferredSize(new Dimension(width, heigth));
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);   
	        
	        Color myColor = new Color(255, 239, 179);
	        g.setColor(myColor);
	        g.fillRect(width/2, 0, width, height);
	        
	        for (int i = 0; i < gameObjectsArray.length; i++) {
	            gameObjectsArray[i].drawInt(g);
	        }
	        
	        for (int i = 0; i < numCols; i++) 
	        {
	        	g.drawLine((i * width/numCols)+width/2, 0, (i * width/numCols)+width/2, height);
	        	g.setColor(Color.BLACK);
	        }
	    	       
	        	  
	  	  }
	

}
