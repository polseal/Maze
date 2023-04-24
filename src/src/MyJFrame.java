package src;
import javax.swing.*;
import java.awt.*;
import java.io.*;

import static src.Maze.*;
import static src.Maze.size;

public class MyJFrame
{
    public static void main(String[] args) {

            cols = 7;
            rows = 7;
            Maze.makeMaze(rows, cols);
            Maze.createEntryExit();
            //Maze.removeAdjacentBorders();
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

    /*public static void draw(Graphics g)
    {
        int buffer = 10;
        g.setColor(Color.BLACK);
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if(maze[i][j].borders.get(0)) //up
                {
                    g.drawLine(buffer+maze[i][j].x, buffer+maze[i][j].y, buffer+(i + 1) * size, buffer+j * size);
                }
                if(maze[i][j].borders.get(1)) //down
                {
                    g.drawLine(buffer+maze[i][j].x, buffer+(j + 1) * size, buffer+(i + 1) * size, buffer+(j + 1) * size);
                }
                if(maze[i][j].borders.get(2)) //left
                {
                    g.drawLine(buffer+maze[i][j].x, buffer+maze[i][j].y, buffer+maze[i][j].x, buffer+(j + 1) * size);
                }
                if(maze[i][j].borders.get(3)) //right
                {
                    g.drawLine(buffer+(i + 1) * size, buffer+maze[i][j].y, buffer+(i + 1) * size, buffer+(j + 1) * size);
                }
            }
        }
    }*/

    public static void draw(Graphics g) {
        int buffer = 10;
        g.setColor(Color.BLACK);


        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if(maze[i][j].borders.get(0)) //up
                {
                    g.drawLine(buffer+j*size, buffer+i*size, buffer+(j+1)*size, buffer+i*size);
                }
                if(maze[i][j].borders.get(1)) //down
                {
                    g.drawLine(buffer+j*size, buffer+(i+1)*size, buffer+(j+1)*size, buffer+(i+1)*size);
                }
                if(maze[i][j].borders.get(2)) //left
                {
                    g.drawLine(buffer+j*size, buffer+i*size, buffer+j*size, buffer+(i+1)*size);
                }
                if(maze[i][j].borders.get(3)) //right
                {
                    g.drawLine(buffer+(j+1)*size, buffer+i*size, buffer+(j+1)*size, buffer+(i+1)*size);
                }
            }
        }


    }
}