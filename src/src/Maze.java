package src;
import java.util.*;


public class Maze {

    public static int cols, rows;
    public static Block [][] maze;
    public static Set<int[]> visited = new HashSet<>();
    public static int [] coordinates_start;
    public static char start;
    public static int size = 40;

    static void makeMaze(int cols, int rows)
    {
        //ArrayList<char[][]> visited = new ArrayList<char[][]>();
        maze = new Block [rows][cols];
        for (int row = 0; row < maze.length; row++)
        {
            for (int col = 0; col < maze[0].length; col++)
        {
            maze[row][col] = new Block(row,col);
        }
        }


    }

    public Maze()
    {

    }

    public static void backtracker(int[] location)
    {
        int[] successor = new int[2];
        printMaze();
        visited.add(location);
        Map<Integer, int[]> nei = NeumannNeighbourhood(location);
        Map<Integer, int[]> notVisited = new HashMap<>();
        for (Map.Entry<Integer, int[]> entry: nei.entrySet())
        {
            if(!visited.contains(entry.getValue()))
            {
                notVisited.put(entry.getKey(),entry.getValue());
            }
        }
        if (notVisited.size() > 0)
        {
            int rand_elem_index = getRandomElemIndex(nei);
            int key = getKey(nei, rand_elem_index);
            successor = nei.get(key);
            maze[successor[0]][successor[1]].removeBorder(key);
            backtracker(successor);

        }
        else
        {
            int rand_visited;
            rand_visited = getRand_elem_index();
            int i = 0;
            for(Object obj : visited)
            {
                if (i == rand_visited)
                    successor = (int[]) obj;
                i++;
            }
            backtracker(successor);

        }


    }

    private static int getKey(Map<Integer, int[]> nei, int rand_elem_index) {
        Integer[] values = (Integer[]) nei.keySet().toArray();
        int key = values[rand_elem_index];
        return key;
    }

    public static int getRandomElemIndex(Map<Integer, int[]> nei)
    {
        return new Random().nextInt(nei.size());
    }


    private static int getRand_elem_index() {
        return new Random().nextInt(visited.size());
    }

    public static void printMaze()
    {
            // Loop through all elements of current row
            //for(char[] x: maze)
            //    System.out.println(Arrays.toString(x));
        //System.out.println();
    }


    public static int[] getRandomStart() {
        int[] coordinates = new int[2];
        int rnd_rows = new Random().nextInt(maze.length);
        int rnd_columns = new Random().nextInt(maze[0].length);
        coordinates[0] = rnd_rows;
        coordinates[1] = rnd_columns;
        return coordinates;
    }


    static Map<Integer, int[]> NeumannNeighbourhood(int [] location)
    {
        Map<Integer, int[]> map = new HashMap<>();
        int[] down = location[0] + 1 < maze.length ? map.put(1, getCoordinate(location[0] + 1, location[1])) : null;
        int[] up = location[0]-1>=0 ? map.put(0, getCoordinate(location[0]-1, location[1])) : null;
        int[] left = location[1]-1>= 0 ? map.put(2, getCoordinate(location[0], location[1]-1)) : null;
        int[] right = location[1]+1< maze[0].length ? map.put(3, getCoordinate(location[0], location[1]+1)) : null;
        return map;
    }

    public static int[] getCoordinate(int x, int y)
    {
        return new int[] {x,y};
    }

}
