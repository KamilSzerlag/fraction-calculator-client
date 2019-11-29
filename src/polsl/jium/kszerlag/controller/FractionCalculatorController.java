package polsl.jium.kszerlag.controller;

import polsl.jium.kszerlag.client.FractionClient;
import polsl.jium.kszerlag.view.Displayable;

/**
 * Controller class that performs the role of an intermediate layer between 
 * the view an the model.
 * 
 * @version 2.0
 * @author Kamil Szerląg
 */
public class FractionCalculatorController {
    
    private final FractionClient client;
    private final Displayable calculatorView; 

    /**
     * Constructing controller with defined model logic provided by 
     * <code>SimpleFractionExpressionEvaluator</code> and view represented by
     * class implementing <code>Displayable</code> interface.
     * 
     * @param evaluator model containing logic to evaluating mathematical expression.
     * @param calculatorView view implementing <code>Displayable</code> interface.
     */
    public FractionCalculatorController(FractionClient client, Displayable calculatorView) {
        this.client = client;
        this.calculatorView = calculatorView;
    }
    
    /**
     * Performing expression calculation, and displaying result value in 
     * calculator view text field.
     * 
     * @param expression - <code>String</code> contains mathematics expression containing fractions.
     */
    public void calculate(String result) {
            calculatorView.displayResult(result);
    }
    
    
}
