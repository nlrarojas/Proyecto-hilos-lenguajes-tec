package main;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class GridsCanvas extends Canvas {
	
	  int width, height;

	  int rows;

	  int cols;

	  GridsCanvas(int w, int h,  int c) {
	    setSize(width = w, height = h);
	    cols = c;
	  }

	  public void paint(Graphics g) {
	    int i;
	    width = getSize().width;
	    height = getSize().height;


	    int rowWid = width / (cols);
	    for (i = 0; i < cols; i++)
	      g.drawLine(i * rowWid, 0, i * rowWid, height);
	  }
}




