import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class UserMenu extends JMenuBar implements ActionListener {

    JMenu menu, submenu;

    public  UserMenu() {
    //    menubar = new JMenuBar();
        menu = new JMenu("File");
        submenu = new JMenu("Add");
        submenu.add(createMenuItem("Timer"));
        submenu.add(createMenuItem("Counter"));
        submenu.add(createMenuItem("Stopwatch"));
        menu.add(submenu);
        // menu.add(new JMenuItem("Ad"))
        add(menu);


    }



   private JMenuItem createMenuItem(String name) {
        JMenuItem temp = new JMenuItem(name);
        temp.addActionListener(this);
return temp;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
