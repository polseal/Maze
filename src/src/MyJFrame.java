package src;
import javax.swing.*;
import java.awt.*;
import java.io.*;

import static src.Maze.*;

public class MyJFrame
{
    public static void main(String[] args) throws IOException, InterruptedException
    {

            cols = 6;
            rows = 6;
            Maze.makeMaze(rows, cols);
            Maze.removeAdjacentBorders();
            JFrame frame = new JFrame("Maze");
            MazePanel panel = new MazePanel(maze);
            JScrollPane scrollPane = new JScrollPane(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 800);
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setVisible(true);
            backtracker(getRandomStart());

    }
}

class MazePanel extends JPanel
{
    private Block[][] m;
    public MazePanel(Block[][] ourMaze)
    {
        m = ourMaze;
    }

    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);

        draw(page);
    }
}