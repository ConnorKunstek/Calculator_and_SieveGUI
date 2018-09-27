import javax.swing.*;

public class SieveButton extends JButton {

    private ClassLoader loader = getClass().getClassLoader();

    private int number;

    public SieveButton(int num){
        super();
        number = num;
        String text = Integer.toString(num);
        super.setText(text);
    }

    public SieveButton(String type){
        super();
        super.setText(type);
    }

    public int getNumber(){ return this.number; }


}
