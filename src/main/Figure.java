package main;


import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Figure {

    private static final int size = 10;

    private double x;
    private double y;
    private double dx;
    private double dy;

    private int drawingWidth;
    private Color objectColor;

    public Figure(int drawingWidth) {   
        int range = drawingWidth - 100;
        
        x = Math.random() * range + size;
        y = Math.random() * range + size;
        dx = 200; //(int)Math.round(Math.random());
        dy = 200;//(int)Math.round(Math.random());
        
        this.drawingWidth = drawingWidth;
        this.objectColor = generateRandomColor();
    }

    //Agregar a función que modifica la trayectoria de cada hilo dependiendo de una función aleatoria
    public void move() {

    	
        int lowerLimit = 0;
        int upperLimit = drawingWidth - size;    

        //x += dx;
        //if (x < lowerLimit) {
          ///  dx *= -1;     
        //} else if (x > upperLimit) {
            //dx *= -1;
        //}

        y += 1;
        if (y < lowerLimit) {
            dy *= -1;
        } else if (y > upperLimit) {
            dy *= -1;
        }
    }

    public void draw(Graphics g) {
        g.setColor(this.objectColor);
        g.fillRect((int) x, (int) y, size, size);
       
    }

    private Color generateRandomColor() {
        int R = (int) (Math.random() * 256);
        int G = (int) (Math.random() * 256);
        int B = (int) (Math.random() * 256);
        Color c = new Color(R, G, B);
        return c;
    }
}
