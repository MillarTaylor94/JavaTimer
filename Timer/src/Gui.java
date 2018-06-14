import javax.swing.*;
import java.awt.*;

public class Gui {

    public static void test(){


        JFrame ParentFrame= new JFrame("Taylors Java Counter");
        ParentFrame.setLayout(new FlowLayout());
        ParentFrame.setSize(500,300);

        //-----------------------------------------------------------------
        //Counter field

//JTextField txt;
        //     txt = new JTextField(50);

        //   txt.setText("Hello my dear frame");
//txt.setForeground(Color.white);
//txt.setHorizontalAlignment(JTextField.LEFT);

        // MainPanel.add(txt);
        // MainPanel.setVisible(true);
JMenuBar bar= new UserMenu();
        ParentFrame.setJMenuBar(bar);
        ParentFrame.add(new CounterPanel());
        ParentFrame.add(new TimerPanel());
        ParentFrame.add(new Stopwatch());
        ParentFrame.setVisible(true);
        ParentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




    }
    public static void main(String[] args){
test();

    }
}
