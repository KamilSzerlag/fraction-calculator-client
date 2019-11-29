/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polsl.jium.kszerlag;

import polsl.jium.kszerlag.client.FractionClient;
import polsl.jium.kszerlag.controller.FractionCalculatorController;
import polsl.jium.kszerlag.view.console.ConsolePrinter;
import polsl.jium.kszerlag.view.window.CalculatorView;

/**
 *
 * @author szerlag
 */
public class FractionCalculatorJiumClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FractionClient client = new FractionClient();
        if (args.length == 1) {
            ConsolePrinter consolePrinter = new ConsolePrinter();
            FractionCalculatorController controller = new FractionCalculatorController(client, consolePrinter);
            client.setController(controller);
            client.startClient();
        } else {
            CalculatorView calculatorView = new CalculatorView();
            FractionCalculatorController controller = new FractionCalculatorController(client, calculatorView);
            calculatorView.setController(controller);
        }
    }
    
}
