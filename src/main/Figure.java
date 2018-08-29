package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Random;
import org.apache.commons.lang3.tuple.ImmutablePair;
import utility.RegularConstants;

public class Figure {

    private final int x;
    private int y;
    private int panelPosition;

    private int drawingWidth;
    private int drawingHeight;
    private Color objectColor;
    private int typeFigure;
//***************************************************************************

    public Figure(int drawingWidth, int drawingHeight, int type) {
        Random r = new Random();
        this.drawingWidth = drawingWidth - 100;
        this.drawingHeight = drawingHeight;
        x = generatePosition(r.nextInt(10));
        y = 0;
        this.drawingWidth = drawingWidth;
        this.objectColor = generateRandomColor();
        this.typeFigure = type;

        panelPosition = 0;
    }

    public int getTypeFigure() {
        return typeFigure;
    }

    public void setTypeFigure(int typeFigure) {
        this.typeFigure = typeFigure;
    }

    //Function that moves threads downward
    public void move() {
        int upperLimit = drawingHeight - RegularConstants.SIZE_FIGURE;
        if (y <= upperLimit) {

            if (RegularConstants.REVERT_THREAD) {
                y -= 1;
            } else {
                y += 1;
            }
        }

    }

    public void moveUpward() {

        int upperLimit = drawingHeight - RegularConstants.SIZE_FIGURE;

        if (y <= drawingHeight) {
            y -= 1;
        }
    }

    //Dibuja un Cuadrado
    public void draw(Graphics g) {
        g.setColor(this.objectColor);
        g.fillRect(x, y, RegularConstants.SIZE_FIGURE, RegularConstants.SIZE_FIGURE);
    }

    //Dibuja un circulo
    public void drawCircle(Graphics g) {
        g.drawOval(x, y, RegularConstants.SIZE_FIGURE, RegularConstants.SIZE_FIGURE);
        g.setColor(this.objectColor);
        g.fillOval(x, y, RegularConstants.SIZE_FIGURE + 1, RegularConstants.SIZE_FIGURE + 1);
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
