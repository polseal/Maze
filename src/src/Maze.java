package src;
import java.awt.*;
import java.util.*;
import java.util.List;


public class Maze {

    public static int cols, rows;
    public static Block [][] maze;
    public static Set<Coordinates> visited = new HashSet<>();
    public static int size = 40;

    static void makeMaze(int cols, int rows)
    {
        maze = new Block [rows][cols];
        for (int row = maze.length-1; row >=0 ; row--)
        {
            for (int col = maze[0].length-1; col >=0; col--)
        {
            maze[row][col] = new Block(row,col);
        }
        }
    }

    public Maze()
    {

    }

    public static void algorithm() {
        try {
            backtracker(getRandomStart());
        } catch (Exception e) {

        }
    }

    public static void backtracker(Coordinates location) throws Exception {

            if(visited.size() == cols*rows)
            {
                throw new Exception();
            }

            Coordinates successor = null;
            visited.add(location);
            Map<Integer, Coordinates> neighbourhood = NeumannNeighbourhood(location);
            Map<Integer, Coordinates> notVisited = new HashMap<>();
            for (Map.Entry<Integer, Coordinates> entry : neighbourhood.entrySet()) {

                if (!visited.contains(entry.getValue())) {
                    notVisited.put(entry.getKey(), entry.getValue());
                }
            }
            if (notVisited.size() > 0) {
                int rand_elem_index = getRandomElemIndex(notVisited);
                int key = getKey(notVisited, rand_elem_index);
                successor = notVisited.get(key);
                maze[location.x()][location.y()].removeBorder(key);
                maze[successor.x()][successor.y()].removeBorder(returnTheOpposite(key));
                System.out.println("Direction " + key + " X:" + successor.x() + " Y:" + successor.y());
                backtracker(successor);
            } else {
                int rand_visited;
                rand_visited = getRand_elem_index();
                int i = 0;
                for (Coordinates obj : visited) {
                    if (i == rand_visited) {
                        successor = obj;
                        System.out.println(" X:" + successor.x() + " Y:" + successor.y());
                        break;
                    }
                    i++;
                }
                backtracker(successor);
            }
    }

    private static int returnTheOpposite(int key)
    {
        return switch (key) {
            case 0 -> 1;
            case 1 -> 0;
            case 2 -> 3;
            case 3 -> 2;
            default -> -1;
        };
    }

    private static int getKey(Map<Integer, Coordinates> available, int rand_elem_index) {
        Object[] values =  available.keySet().toArray();
        Object key = values[rand_elem_index];
        return (int)key;
    }

    public static int getRandomElemIndex(Map<Integer, Coordinates> nei)
    {
        return new Random().nextInt(nei.size());
    }

    private static int getRand_elem_index() {
        return new Random().nextInt(visited.size());
    }

    public static Coordinates getRandomStart() {
        int rnd_rows = new Random().nextInt(maze.length);
        int rnd_columns = new Random().nextInt(maze[0].length);
        return new Coordinates (rnd_rows,rnd_columns);
    }

    static Map<Integer, Coordinates> NeumannNeighbourhood(Coordinates location)
    {
        Map<Integer, Coordinates> map = new HashMap<>();
        Coordinates down = location.x() + 1 < maze.length ? map.put(1, getCoordinate(location.x() + 1, location.y())) : null;
        Coordinates up = location.x()-1>=0 ? map.put(0, getCoordinate(location.x()-1, location.y())) : null;
        Coordinates left = location.y()-1>= 0 ? map.put(2, getCoordinate(location.x(), location.y()-1)) : null;
        Coordinates right = location.y()+1< maze[0].length ? map.put(3, getCoordinate(location.x(), location.y()+1)) : null;
        return map;
    }

    public static Coordinates getCoordinate(int x, int y)
    {
        return new Coordinates (x,y);
    }

    public static void createEntryExit()
    {
        maze[0][0].borders.set(0, false);
        maze[rows-1][cols-2].borders.set(1, false);
    }
}
