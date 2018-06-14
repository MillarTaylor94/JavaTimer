import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterPanel extends PanelComponent {
    //Addition, Subtraction, Reset Button
    private final JButton addButton;
    private final JButton subButton;
    private final JButton resetButton;
    //displays current count;
    private JLabel countLabel;

    private int count = 0;

    public CounterPanel() {

        // JPanel panel= new JPanel(layout);
        //panel.setPreferredSize(new Dimension(220, 40));
        //panel.setBackground(Color.BLACK);

        addButton = new JButton("+");
        subButton = new JButton("-");
        resetButton = new JButton("Reset");
        countLabel = new JLabel(Integer.toString(count));


        addListeners();


        addButton.setSize(50, 50);
        add(countLabel);
        add(addButton);
        add(subButton);
        add(resetButton);

    }


    //Function: addListeners
//Purpose: Add listeners to each of the components
    public void addListeners() {


//Incremental logic for counter
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                countLabel.setText(Integer.toString(count));
            }
        });

        subButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count--;
                countLabel.setText(Integer.toString(count));

            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count = 0;
                countLabel.setText(Integer.toString(count));
            }
        });


    }
}
