import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Layout {


    public class Layouts implements ActionListener {

        private JFrame frame;
        private JPanel panel;
        private JTextArea ta;
        private JButton stopButton;
        private JButton goButton;

        public static void main(String[] args) {
            Layouts a = new Layouts();
        }

        public Layout() {
            frame = new JFrame("border!");
            panel = new JPanel(new BorderLayout());
            ta = new JTextArea("Type here...");
            goButton = new JButton("GO");
            goButton.addActionListener(this);
            stopButton = new JButton("STOP");
            stopButton.addActionListener(this);

            panel.add(ta, BorderLayout.CENTER);
            panel.add(goButton, BorderLayout.EAST);
            panel.add(stopButton, BorderLayout.SOUTH);

            frame.add(panel);

            // frame stuff at the bottom of constructor
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300,300);
            frame.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() == "GO") {
                System.out.println("GO button clicked");
                ta.setText("GO");
            }
//        else if () {
//
//        }
        }
    }

}

