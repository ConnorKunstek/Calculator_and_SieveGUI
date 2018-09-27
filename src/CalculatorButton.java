//Connor Kunstek
//CS335
//Exercise 2
//CalculatorButton Class
//To run,   $javac Calculator.java
//          $java Calculator

//imports
import javax.swing.*;

public class CalculatorButton extends JButton{

    //saves value
    private int number;
    //saves symbol
    private String symbol;

    //constructor for number buttons
    public CalculatorButton(int num){
        super();
        number = num;
        String text = Integer.toString(num);
        super.setText(text);
    }

    //constructor for symbol buttons
    public CalculatorButton(String symb){
        super();
        symbol = symb;
        super.setText(symb);
    }

    //return number
    public int getNumber(){
        return this.number;
    }
}
