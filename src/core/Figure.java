package core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JPanel;
import utility.IConstants;

public class Figure extends JPanel implements IConstants{  
    private final int x;
    private int y;
    private final int panelPosition;   
    private final Graphics g;
    
    private boolean ended;
    
    private Color objectColor;

    public Figure(int w, int h, int panelPosition) {
        this.setSize(w, h);
        this.x = w / 2;
        this.y = GOING_DOWN ? 0 : h;        
        this.panelPosition = panelPosition;
        this.g = this.getGraphics();
        
        this.ended = false;
        
        this.objectColor = generateRandomColor();
    }

    //Agregar a función que modifica la trayectoria de cada hilo dependiendo de una función aleatoria
    public void move() {
        y = GOING_DOWN ? y + 1 : y - 1;
        ended = y >= getHeight();
    }    

    //Dibuja un Cuadrado
    public void draw() {
        g.setColor(this.objectColor);
        g.fillRect((int) x, (int) y, SIZE_FIGURE, SIZE_FIGURE);
    }

    //Dibuja un circulo
    public void drawCircle() {
        g.drawOval(x, y, SIZE_FIGURE, SIZE_FIGURE);
        g.setColor(this.objectColor);
        g.fillOval(x, y, SIZE_FIGURE + 1, SIZE_FIGURE + 1);
    }

    //Funcion que crea un triangulo
    public void drawTriangle() {
        int[] xp = {x, x + 5, x - 5};
        int[] yp = {y, y + 5, y + 5};        
        Polygon p = new Polygon(xp, yp, yp.length);
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