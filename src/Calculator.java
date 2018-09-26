//Connor Kunstek
//CS335
//Exercise 2
//Calculator Class
//To run,   $javac Calculator.java
//          $java Calculator

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {

    private CalculatorButton numbers[];
    private CalculatorButton decimal;
    private CalculatorButton equal;
    private CalculatorButton divide;
    private CalculatorButton multiply;
    private CalculatorButton subtract;
    private CalculatorButton add;

    private JPanel buttons;
    private JPanel text;

    public Calculator(){
        super("Calculator");

        buttons = new JPanel();

        Container c = getContentPane();

        numbers = new CalculatorButton[10];

        for(int i = 9; i > -1; i--){
            CalculatorButton num = new CalculatorButton(i);
            numbers[i] = num;
        }

        //top row
        calculatorView.add(numbers[7]);
        calculatorView.add(numbers[8]);
        calculatorView.add(numbers[9]);
        divide = new CalculatorButton("/");
        calculatorView.add(divide);

        //top middle row
        calculatorView.add(numbers[4]);
        calculatorView.add(numbers[5]);
        calculatorView.add(numbers[6]);
        multiply = new CalculatorButton("*");
        calculatorView.add(multiply);

        //bottom middle row
        calculatorView.add(numbers[1]);
        calculatorView.add(numbers[2]);
        calculatorView.add(numbers[3]);
        subtract = new CalculatorButton("-");
        calculatorView.add(subtract);

        //bottom row
        calculatorView.add(numbers[0]);
        decimal = new CalculatorButton(".");
        calculatorView.add(decimal);
        equal = new CalculatorButton("=");
        calculatorView.add(equal);
        add = new CalculatorButton("+");
        calculatorView.add(add);


        calculatorView.setLayout(new GridLayout(4, 4, 2, 2));

        c.add(calculatorView);
        setSize(500, 500);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
    {

    }

    public static void main(String args[])
    {
        Calculator C = new Calculator();
        C.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
    }

}
