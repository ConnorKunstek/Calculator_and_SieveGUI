//Connor Kunstek
//CS335
//Exercise 2
//SieveButton Class

//imports
import javax.swing.*;


public class SieveButton extends JButton {

    //holds value for numbers
    private int number;

    //constructor for number buttons
    public SieveButton(int num){
        super();
        number = num;
        String text = Integer.toString(num);
        super.setText(text);
    }
    //constructor for Enter and Clear buttons
    public SieveButton(String type){
        super();
        super.setText(type);
    }

    //get number
    public int getNumber(){ return this.number; }


}
