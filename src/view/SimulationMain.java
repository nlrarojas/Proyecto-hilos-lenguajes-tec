/*
 * Fabian Fallas-Moya
 * Multiples thread over a single panel
 */

package view;

import javax.swing.SwingUtilities;

import main.InitInterfaceAndThreads;

/**
 *
 * @author root
 */
public class SimulationMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new InitInterfaceAndThreads());
    }
    
}
