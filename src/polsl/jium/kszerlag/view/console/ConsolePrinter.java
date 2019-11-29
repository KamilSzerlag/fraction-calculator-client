package polsl.jium.kszerlag.view.console;

import polsl.jium.kszerlag.view.Displayable;

/**
 * This class is printing provided content in console. 
 * 
 * @version 1.0
 * @author Kamil Szerląg
 */
public class ConsolePrinter implements Displayable {

    @Override
    public void displayResult(String fraction) {
        System.out.println("Result:" + fraction);
    }

    @Override
    public void displayWarningMsg(RuntimeException e) {
        System.out.println("Warning: " + e.getMessage());
    }

    @Override
    public void displayErrorMsg(Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
    
}
