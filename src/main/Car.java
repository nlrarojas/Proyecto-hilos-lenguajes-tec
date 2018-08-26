package main;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;

public class Car {
	
	private double x;
    private double y;
    
    private BufferedImage image;

	public Car(double x, double y) {
		super();
		this.x = x;
		this.y = y;
		
		try {
		    this.image = ImageIO.read(new File("utility/lento.png"));
		} 
		catch (IOException e) {
		}
	}
    

}
