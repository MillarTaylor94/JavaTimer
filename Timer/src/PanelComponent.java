import javax.swing.*;
import java.awt.*;

public class PanelComponent extends JPanel {
    public PanelComponent() {

//this.setBackground(Color.black);
       this.setLayout(new FlowLayout());
       this.setMinimumSize(new Dimension(500,100));
        this.setPreferredSize(new Dimension(500,100));
       this.setBorder(BorderFactory.createLineBorder(Color.RED));
      this.setVisible(true);
    }
}