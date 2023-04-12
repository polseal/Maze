package src;
import javax.swing.*;
import java.awt.*;
import java.io.*;

import static src.Maze.*;

public class MyJFrame
{
    public static void main(String[] args) {

            cols = 10;
            rows = 10;
            Maze.makeMaze(rows, cols);
            Maze.removeAdjacentBorders();
            JFrame frame = new JFrame("Maze");
            MazePanel panel = new MazePanel();
            JScrollPane scrollPane = new JScrollPane(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 500);
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setVisible(true);
            algorithm();

    }
}

class MazePanel extends JPanel
{
    public MazePanel()
    {
    }

    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);

        draw(page);
    }

    public static void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if(maze[i][j].borders.get(0))
                {
                    g.drawLine(maze[i][j].x, maze[i][j].y, (i + 1) * size, j * size);
                }
                if(maze[i][j].borders.get(1))
                {
                    g.drawLine(maze[i][j].x, (j + 1) * size, (i + 1) * size, (j + 1) * size);
                }
                if(maze[i][j].borders.get(2))
                {
                    g.drawLine(maze[i][j].x, maze[i][j].y, maze[i][j].x, (j + 1) * size);
                }
                if(maze[i][j].borders.get(3))
                {
                    g.drawLine((i + 1) * size, maze[i][j].y, (i + 1) * size, (j + 1) * size);
                }
            }
        }
    }
}