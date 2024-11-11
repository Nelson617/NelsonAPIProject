import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Layout implements ActionListener {

    private JFrame frame;
    private JPanel panel, gridPanel, borderPanel;
    private JTextArea results;
    private JTextField search;
    private JButton goButton;
    private JComboBox stats;



    public static void main(String[] args) {
        Layout a = new Layout();
    }

    public Layout() {
        frame = new JFrame("border!");

        panel = new JPanel(new BorderLayout());

        gridPanel = new JPanel(new GridLayout (3, 1));

        results = new JTextArea("RESULTS");

        results.setEditable(false);

        search = new JTextField("Team or Player...");

        String s1[] = {"points per game", "assists per game", "rebounds per game"};

        stats = new JComboBox(s1);

        goButton = new JButton("GO");

        goButton.addActionListener(this);

        panel.add(results, BorderLayout.CENTER);

        panel.add(gridPanel, BorderLayout.NORTH);

        gridPanel.add(search);

            gridPanel.add(stats);

        gridPanel.add(goButton);


        frame.add(panel);

        // frame stuff at the bottom of constructor


//        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setVisible(true);
    }

    @Override 
    public void actionPerformed(ActionEvent e) {
//        if (e.getActionCommand() == "GO") {
//            System.out.println("GO button clicked");
//            results.setText("GO");
//        }
//        else if () {
//
//        }
    }
}


