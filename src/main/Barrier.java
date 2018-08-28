package main;

import java.awt.Color;
import java.awt.Graphics;

public class Barrier {
	
	private double x;
    private double y;
    
    private boolean state;
    
    private Color objectColor;

	public Barrier(double x, boolean state) {
		super();
		this.x = x;
		this.y = 100;
		this.state = state;
		this.objectColor = generateRandomColor();
	}
	
    
	//Funcion que genera la barrera que impide el paso
	public void drawBarrier(Graphics g){
		g.setColor(this.objectColor);
        g.fillRect((int) x, 100, 55, 10);
	}
		
	//Getters and Setters
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	private Color generateRandomColor() {
        int R = (int) (Math.random() * 256);
        int G = (int) (Math.random() * 256);
        int B = (int) (Math.random() * 256);
        Color c = new Color(R, G, B);
        return c;
    }
	
	

}
