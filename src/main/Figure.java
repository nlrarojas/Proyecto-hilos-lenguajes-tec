package main;

import core.TrackPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Random;
import org.apache.commons.lang3.tuple.ImmutablePair;
import utility.IConstants;

public class Figure implements IConstants {

    private final int x;
    private int y;
    private int panelPosition;    

    private int height;
    private TrackPanel panel;
    private boolean ended;

    private Color objectColor;

    private int drawingWidth;
    private int drawingHeight;

    public Figure(TrackPanel panel, int panelPosition) {
        this.x = panel.getWidth() / 2;
        this.y = GOING_DOWN ? 0 : panel.getHeight();
        this.panelPosition = panelPosition;
        this.height = panel.getHeight();
        this.panel = panel;

        this.ended = false;

        this.objectColor = generateRandomColor();
    }

    public Figure(int drawingWidth, int drawingHeight) {
    	Random r = new Random();
        this.drawingWidth = drawingWidth - 100;
        this.drawingHeight = drawingHeight;
        x = generatePosition(r.nextInt(10));
        y = 0; 
        this.drawingWidth = drawingWidth;
        this.objectColor = generateRandomColor();
        
        panelPosition = 0;
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
    public void drawCircle(Graphics g) {
        g.drawOval(x, y, SIZE_FIGURE, SIZE_FIGURE);
        g.setColor(this.objectColor);
        g.fillOval(x, y, SIZE_FIGURE + 1, SIZE_FIGURE + 1);
    }

    //Funcion que crea un triangulo
    public void drawTriangle(Graphics g) {
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

    private int generatePosition(int result) {
        Random r = new Random();
        int Low;
        int High;
        int Result;
        ArrayList<ImmutablePair<Integer, Integer>> positions = new ArrayList<ImmutablePair<Integer, Integer>>();
        ImmutablePair<Integer, Integer> pair1 = new ImmutablePair<>(306, 347);
        positions.add(pair1);
        ImmutablePair<Integer, Integer> pair2 = new ImmutablePair<>(361, 402);
        positions.add(pair2);
        ImmutablePair<Integer, Integer> pair3 = new ImmutablePair<>(416, 457);
        positions.add(pair3);
        ImmutablePair<Integer, Integer> pair4 = new ImmutablePair<>(471, 512);
        positions.add(pair4);
        ImmutablePair<Integer, Integer> pair5 = new ImmutablePair<>(526, 567);
        positions.add(pair5);
        ImmutablePair<Integer, Integer> pair6 = new ImmutablePair<>(581, 622);
        positions.add(pair6);
        ImmutablePair<Integer, Integer> pair7 = new ImmutablePair<>(636, 677);
        positions.add(pair7);
        ImmutablePair<Integer, Integer> pair8 = new ImmutablePair<>(691, 732);
        positions.add(pair8);
        ImmutablePair<Integer, Integer> pair9 = new ImmutablePair<>(746, 787);
        positions.add(pair9);
        ImmutablePair<Integer, Integer> pair10 = new ImmutablePair<>(801, 842);
        positions.add(pair10);
        Low = positions.get(result).getLeft();
        High = positions.get(result).getRight();
        return Result = r.nextInt(High - Low) + Low;

    }
}
