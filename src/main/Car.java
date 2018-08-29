package main;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

import javax.imageio.ImageIO;

public class Car {

	private static final int size = 10;
	
	private double x;
    private double y;
    private double dx;
    private double dy;

    private int drawingWidth;
    private int drawingHeight;
    
    private BufferedImage image;
	
	public Car(int drawingWidth, int drawingHeight) {   
        this.drawingWidth = drawingWidth - 100;
        this.drawingHeight = drawingHeight;
        
        x = (Math.random() * drawingWidth + size) + drawingWidth / 2;
        y = Math.random() * drawingWidth + size;
        dx = 200; //(int)Math.round(Math.random());
        dy = 200;//(int)Math.round(Math.random());
        
        this.drawingWidth = drawingWidth;
        try {
        	Random rand = new Random();
        	int randomNum = rand.nextInt((2 - 0) + 1) + 0;
        	if (randomNum == 0){
        		this.image = ImageIO.read(new File("C:/Universidad/workspace/Hilos/src/utility/8bit.jpg"));
        	}else if(randomNum == 1){
        		this.image = ImageIO.read(new File("C:/Universidad/workspace/Hilos/src/utility/bocho.jpg"));
        	}else if (randomNum == 2){
        		this.image = ImageIO.read(new File("C:/Universidad/workspace/Hilos/src/utility/negro.jpg"));
        	}
		    //this.image = ImageIO.read(new File("C:/Universidad/workspace/Hilos/src/utility/8bit.jpg"));
		} 
		catch (IOException e) {
		}
    }

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	//Agregar a función que modifica la trayectoria de cada hilo dependiendo de una función aleatoria
    public void move() {
        int lowerLimit = 0;
        int upperLimit = drawingHeight - size; 

        if (y <= upperLimit) {
            y += 1;
            if ((int)y == upperLimit){
            	y = upperLimit;
            	while (y > 0){
            		y -= 1;
            	}
            }
        }
    }
    

}
