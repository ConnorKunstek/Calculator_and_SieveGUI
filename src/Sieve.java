//Connor Kunstek
//CS335
//Exercise 2
//Sieve

//imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Sieve extends JFrame implements ActionListener {

    //size of sieve
    private int SIEVE_ARRAY_SIZE = 10000;

    //holds sieve
    private boolean[] sieve;

    //GUI buttons
    private SieveButton numbers[];
    private SieveButton enter;
    private SieveButton clear;

    //GUI elements
    private JPanel buttons;
    private JPanel textField;
    private JTextField field;

    //saves values entered
    private int currentNum;
    //saves string entered
    private String current;

    //constructor
    public Sieve() {
        super("Sieve");

        //initialzie sieve array
        sieve = new boolean[SIEVE_ARRAY_SIZE+1];
        //run sieve
        sieve();

        //initialize
        currentNum = 0;
        current = "";
        buttons = new JPanel();
        textField = new JPanel();
        field = new JTextField();
        numbers = new SieveButton[10];

        //get container
        Container c = getContentPane();

        //create number buttons
        for(int i = 9; i > -1; i--){
            SieveButton num = new SieveButton(i);
            numbers[i] = num;
        }

        //create action listener for number buttons
        for(SieveButton num : numbers){
            num.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    //save values in case over limit
                    String tempString = current;
                    current = current + num.getNumber();
                    int tempInt = currentNum;
                    currentNum = Integer.parseInt(current);
                    //check if over 10000
                    if(currentNum > 10000){
                        //revert if so
                        currentNum = tempInt;
                        current = tempString;
                    }
                    //update field
                    field.setText(current);
                    repaint();
                }
            });
        }

        //top row
        buttons.add(numbers[7]);
        buttons.add(numbers[8]);
        buttons.add(numbers[9]);

        //top middle row
        buttons.add(numbers[4]);
        buttons.add(numbers[5]);
        buttons.add(numbers[6]);

        //bottom middle row
        buttons.add(numbers[1]);
        buttons.add(numbers[2]);
        buttons.add(numbers[3]);

        //bottom row
        buttons.add(numbers[0]);

        //create enter button with action listener
        enter = new SieveButton("Enter");
        enter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                enter();
            }
        });

        //create clear button with action listener
        buttons.add(enter);
        clear = new SieveButton("Clear");
        clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                clear();
            }
        });
        buttons.add(clear);

        //set layouts
        buttons.setLayout(new GridLayout(4, 4, 2, 2));
        textField.add(field);
        textField.setLayout(new GridLayout(1, 1, 2, 0));
        c.add(field, BorderLayout.NORTH);
        c.add(buttons, BorderLayout.CENTER);
        setSize(250, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {}

    public void enter(){

        //check number against contents of sieve
        if(sieve[currentNum]){
            field.setText(current + " is Prime");
            repaint();
        }else{
            field.setText(current + " is not Prime");
            repaint();
        }
        //disable all buttons except clear, forcing user to clear
        for(int i = 0; i < 10; i++){
            numbers[i].setEnabled(false);
        }
        enter.setEnabled(false);
    }

    //clears values, resets text field
    public void clear(){
        field.setText("");
        repaint();
        current = "";
        currentNum = 0;
        for(int i = 0; i < 10; i++){
            numbers[i].setEnabled(true);
        }
        enter.setEnabled(true);
    }


    public static void main(String args[])
    {
        Sieve S = new Sieve();
        S.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
    }

    //seive function from previous exercise, updated
    public void sieve(){

        //initialize array to all trues
        for(int i = 0; i < SIEVE_ARRAY_SIZE; i++){
            sieve[i] = true;
        }

        //loop through array (numbers)
        for(int i = 2; i * i <= SIEVE_ARRAY_SIZE; i++){
            //check to make sure it hasn't been eliminated already
            if(sieve[i] == true){
                //loop to eliminate multiples
                for(int p = i * 2; p <= SIEVE_ARRAY_SIZE; p += i) {
                    sieve[p] = false;
                }
            }
        }
    }
}
