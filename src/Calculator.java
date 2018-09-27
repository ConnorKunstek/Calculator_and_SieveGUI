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

    private JPanel output;
    private JTextField outputText;

    public Calculator(){
        super("Calculator");

        buttons = new JPanel();
        outputText = new JTextField();
        output = new JPanel();

        Container c = getContentPane();

        numbers = new CalculatorButton[10];

        for(int i = 9; i > -1; i--){
            CalculatorButton num = new CalculatorButton(i);
            numbers[i] = num;
        }

        //top row
        buttons.add(numbers[7]);
        buttons.add(numbers[8]);
        buttons.add(numbers[9]);
        divide = new CalculatorButton("/");
        buttons.add(divide);

        //top middle row
        buttons.add(numbers[4]);
        buttons.add(numbers[5]);
        buttons.add(numbers[6]);
        multiply = new CalculatorButton("*");
        buttons.add(multiply);

        //bottom middle row
        buttons.add(numbers[1]);
        buttons.add(numbers[2]);
        buttons.add(numbers[3]);
        subtract = new CalculatorButton("-");
        buttons.add(subtract);

        //bottom row
        buttons.add(numbers[0]);
        decimal = new CalculatorButton(".");
        buttons.add(decimal);
        equal = new CalculatorButton("=");
        buttons.add(equal);
        add = new CalculatorButton("+");
        buttons.add(add);

        buttons.setLayout(new GridLayout(4, 4, 2, 2));

        output.add(outputText);
        output.setLayout(new GridLayout(1, 1, 2,0));

        c.add(output, BorderLayout.NORTH);
        c.add(buttons, BorderLayout.CENTER);

        setSize(250, 250);
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
