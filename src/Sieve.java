//Connor Kunstek
//CS335
//Exercise 2
//Sieve


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Sieve extends JFrame implements ActionListener {

    private boolean[] sieve;

    private SieveButton numbers[];
    private SieveButton enter;
    private SieveButton clear;

    private JPanel buttons;

    private JPanel textField;
    private JTextField field;

    private int currentNum;

    private String current;

    public Sieve() {
        super("Sieve");

        sieve = new boolean[10000];

        sieve = sieve();

        currentNum = 0;

        current = "";

        Container c = getContentPane();

        buttons = new JPanel();

        textField = new JPanel();
        field = new JTextField();

        numbers = new SieveButton[10];

        for(int i = 9; i > -1; i--){
            SieveButton num = new SieveButton(i);
            numbers[i] = num;
        }

        for(SieveButton num : numbers){
            num.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String tempString = current;
                    current = current + num.getNumber();
                    int tempInt = currentNum;
                    currentNum = Integer.parseInt(current);
                    if(currentNum > 10000){
                        currentNum = tempInt;
                        current = tempString;
                    }
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

        enter = new SieveButton("Enter");
        enter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                enter();
            }
        });

        buttons.add(enter);
        clear = new SieveButton("Clear");
        clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                clear();
            }
        });
        buttons.add(clear);

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

        if(sieve[currentNum]){
            field.setText(current + " is Prime");
            repaint();
        }else{
            field.setText(current + " is not Prime");
            repaint();
        }
        for(int i = 0; i < 10; i++){
            numbers[i].setEnabled(false);
        }
        enter.setEnabled(false);
    }

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

    public static boolean[] sieve(){

        int SIEVE_ARRAY_SIZE = 10000;
        //create boolean array
        boolean[] array = new boolean[SIEVE_ARRAY_SIZE+1];

        //initialize array to all trues
        for(int i = 0; i < SIEVE_ARRAY_SIZE; i++){
            array[i] = true;
        }

        //loop through array (numbers)
        for(int i = 0; i * i <= SIEVE_ARRAY_SIZE; i++){
            //check to make sure it hasn't been eliminated already
            if(array[i] == true){
                //loop to eliminate multiples
                for(int p = i * 2; p <= SIEVE_ARRAY_SIZE; p += i) {
                    array[p] = false;
                }
            }
        }
        return array;
    }
}
