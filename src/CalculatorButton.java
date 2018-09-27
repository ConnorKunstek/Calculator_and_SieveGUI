//Connor Kunstek
//CS335
//Exercise 2
//CalculatorButton Class
//To run,   $javac Calculator.java
//          $java Calculator

import javax.swing.*;

public class CalculatorButton extends JButton{

    private ClassLoader loader = getClass().getClassLoader();

    private int number;

    private String symbol;

    public CalculatorButton(int num){
        super();
        number = num;
        String text = Integer.toString(num);
        super.setText(text);
    }

    public CalculatorButton(String symb){
        super();
        symbol = symb;
        super.setText(symb);
    }

    public int getNumber(){
        return this.number;
    }
}
