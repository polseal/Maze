package src;


import java.util.Arrays;
import java.util.List;

public class Block {

    //int x;
    //int y;
    int thisRow;
    int thisCol;
    List<Boolean> borders;

    public Block(int row, int col)
    {   //this.x = Maze.size * row;
        //this.y = Maze.size * col;
        this.thisRow = row;
        this.thisCol = col;
        this.borders = Arrays.asList(true,true,true,true); //up, down, left, right
    }


    public void removeBorder(int i)
    {
        this.borders.set(i, false);
    }


}
