package src;

import javax.swing.*;

import static src.Maze.backtracker;
import static src.Maze.getRandomStart;

public class Main {

    public static void main(String[] args)
    {
        int cols = 6;
        int rows = 6;
        //Maze.makeMaze(rows, cols);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyJFrame frame = new MyJFrame();
            }
        });
        //Maze.printMaze();
        //backtracker(getRandomStart());
    }
}
