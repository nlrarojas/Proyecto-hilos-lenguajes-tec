package core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;
import utility.IConstants;

public class Figure implements IConstants{  
    private final int x;
    private int y;
    private final int panelPosition;   
    private final Graphics g;
    
    private final int height;
    private TrackPanel panel;
    private boolean ended;
    
    private Color objectColor;

    public Figure(TrackPanel panel, int panelPosition) {        
        this.x = panel.getWidth() / 2;
        this.y = GOING_DOWN ? 0 : panel.getHeight();        
        this.panelPosition = panelPosition;
        this.g = panel.getGraphics();
        this.height = panel.getHeight();
        this.panel = panel;
        
        this.ended = false;
        
        this.objectColor = generateRandomColor();
    }

    //Agregar a función que modifica la trayectoria de cada hilo dependiendo de una función aleatoria
    public void move() {
        System.out.println(new Random().nextInt(100));
        y = GOING_DOWN ? y + 1 : y - 1;
        ended = y >= height;        
        //if ended remove the figure from the track panel
    }    

    //Dibuja un Cuadrado
    public void draw(Graphics g) {
        g.setColor(this.objectColor);
        g.fillRect(x, y, SIZE_FIGURE, SIZE_FIGURE);
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