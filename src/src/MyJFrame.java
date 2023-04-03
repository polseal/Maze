package src;

import javax.swing.*;
import java.awt.*;

public class MyJFrame
{
    private JFrame frame;

    public MyJFrame()
    {
        initialize();

    }

    private void initialize()
    {
        frame = new JFrame();
        this.frame.setTitle("Maze");
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setSize(800, 800);
        this.frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panel.setBackground(Color.red);

        Button b = new Button("Button");
        panel.add(b);

        frame.add(panel, BorderLayout.CENTER);


        this.frame.setVisible(true);
    }
}
