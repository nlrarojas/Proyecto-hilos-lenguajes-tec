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
    private int drawingHeight;
    private Color objectColor;

    public Figure(int drawingWidth, int drawingHeight) {   
        this.drawingWidth = drawingWidth - 100;
        this.drawingHeight = drawingHeight;
        
        x = (Math.random() * drawingWidth + size) + drawingWidth / 2;
        y = Math.random() * drawingWidth + size;
        dx = 200; //(int)Math.round(Math.random());
        dy = 200;//(int)Math.round(Math.random());
        
        this.drawingWidth = drawingWidth;
        this.objectColor = generateRandomColor();
    }

    //Agregar a función que modifica la trayectoria de cada hilo dependiendo de una función aleatoria
    public void move() {
        int lowerLimit = 0;
        int upperLimit = drawingHeight - size;    

        //x += dx;
        //if (x < lowerLimit) {
          ///  dx *= -1;     
        //} else if (x > upperLimit) {
            //dx *= -1;
        //}
        if (y <= drawingHeight) {
            y += 1;
        } 
        
        if (y < lowerLimit) {
            dy *= -1;
        } else if (y > upperLimit) {
            dy *= -1;
        }
    }

    //Dibuja un Cuadrado
    public void draw(Graphics g) {
        g.setColor(this.objectColor);
        g.fillRect((int) x, (int) y, size, size);
       
    }

    //Dibuja un circulo
    public void drawCircle(Graphics g)
	{
		g.drawOval((int)x, (int)y, size, size);
		g.setColor(this.objectColor);
		g.fillOval((int)x, (int)y, size+1, size+1);
	}

	//Funcion que crea un triangulo
	public void drawTriangle(Graphics g)
	{
		Polygon p = new Polygon([x, x+5, x-5], [y, y+5, y-5], 3);
		g.drawPolygon(p);
		g.setColor(this.objectColor);
		g.fillPolygon(p);
	}

    private Color generateRandomColor() {
        int R = (int) (Math.random() * 256);
        int G = (int) (Math.random() * 256);
        int B = (int) (Math.random() * 256);
        Color c = new Color(R, G, B);
        return c;
    }
}
