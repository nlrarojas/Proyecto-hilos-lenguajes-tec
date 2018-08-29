/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import core.Fig;
import java.awt.Color;
import java.util.Random;
import utility.Constants;
import utility.RegularConstants;

/**
 *
 * @author nelson
 */
public class CreateFigures {

    private int speed;
    private int value;

    public CreateFigures(int speed, int value) {
        this.value = value;
        this.speed = speed;
    }

    public void create() {
        for (int i = 0; i < value; i++) {
            Random random = new Random();
            int position = random.nextInt(RegularConstants.NUMBER_OF_TRACKS);
            Fig fig = new Fig(speed * 250, 5, Color.ORANGE, null, Constants.getInstance().getTracks()[position]);
            Constants.getInstance().getTracks()[position].addFigure(fig);
            fig.start(); 
            System.out.println(Constants.getInstance().getTracks()[position].getNumberOfFigures());
        }
    }
}
