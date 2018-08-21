/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.MainView;


public class Program {
    public static void main (String [] args) {
    	
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }
}
