import java.util.*;

/**
 * Created by Anton on 2017-10-14.
 * DP Approach, going from last column to first column calulcating the minimal cost. The path is assembled using pointers to the previous
 * visited tiles
 */
public class TSPV2 {

    static Scanner scan;
    static int[] dimens;
    static int[][] maze;
    static int y;
    static int x;
    static ArrayList<Tile> pathChoser;
    static boolean running = true;
    static Tile[][] matrix;

    enum Directions{
        UPRIGHT (-1,1),
        DOWNRIGHT (1, 1),
        RIGHT (0, 1);

        int row;
        int col;

        Directions(int y, int x){
            this.row = y;
            this.col = x;
        }

    }

    static class Tile{
        int y;
        int x;
        Tile prev;
        int weight;

        @Override
        public String toString() {
            return this.y + " " + this.x + " " + this.prev;
        }

        public Tile(int y, int x){
            this.x = x;
            this.y = y;
            prev = null;
        }

        public int getY(){
            return this.y;
        }


    }

    static void prettyprint(){
        for (int i = 0; i < maze.length; i++) {
            System.out.println("");
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
        }
    }

    public static void main(String[] args){
        scan = new Scanner(System.in);
        while(running)
            traverseMaze();

        scan.close();
        System.exit(0);

    }

    static int checkRow(int row){
        if(row == -1){
            return y - 1;
        }else if(row == y){
            return 0;
        }
        return row;

    }


    static void traverseMaze() {
        try {
            dimens = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        } catch (Exception e) {
            running = false;
            return;
        }
        y = dimens[0];
        x = dimens[1];
        matrix = new Tile[y][x];
        maze = new int[y][x];
        int compareWeight = Integer.MAX_VALUE;
        Integer[] totalInput = new Integer[x * y];
        int h = 0;
        while (totalInput[totalInput.length - 1] == null) {
            String[] row = scan.nextLine().split(" ");
            for (int i = 0; i < row.length; i++) {
                try {
                    totalInput[h] = Integer.parseInt(row[i]);
                    h++;

                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }

        for (int i = 0; i < totalInput.length; i++) {
            maze[i / x][i % x] = totalInput[i];
        }

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                matrix[i][j] = new Tile(i, j);
                matrix[i][j].weight = Integer.MAX_VALUE;
            }
        }


        for (int i = 0; i < maze.length; i++) {
            matrix[i][x - 1].weight = maze[i][x - 1];
        }

        for (int i = x - 2; i >= 0 ; i--) {
            int newRow;
            int newCol;
            for(int j = 0; j < y; j++){
                ArrayList<Tile> tileList = new ArrayList<>();
                for(Directions d: Directions.values()) {
                    newRow = checkRow(d.row + j);
                    newCol = i + d.col;
                    Tile newTile = new Tile(newRow, newCol);
                    newTile.weight = matrix[newRow][newCol].weight;
                    tileList.add(newTile);
                }

                selectMinWeight(tileList);

                Collections.sort(pathChoser, Comparator.comparing(Tile::getY));
                matrix[j][i].prev = matrix[pathChoser.get(0).y][pathChoser.get(0).x];
                matrix[j][i].weight = maze[j][i] + matrix[pathChoser.get(0).y][pathChoser.get(0).x].weight;
            }

        }

        int minIndex = 0;


        for (int i = 0; i < y; i++) {
            if(matrix[i][0].weight < compareWeight){
                minIndex = i;
                compareWeight = matrix[i][0].weight;
            }
        }

        Tile parentTile = matrix[minIndex][0];

        if(parentTile.prev != null) {
            System.out.print((parentTile.y + 1) + " ");
        }else{
            System.out.println(parentTile.y + 1);
        }

        while(true){
            parentTile = parentTile.prev;
            if(parentTile == null){
                break;
            }
            if(parentTile.prev == null){
                System.out.println((parentTile.y + 1));
                break;
            }else{
                System.out.print((parentTile.y + 1) + " ");
            }

        }
        System.out.println(matrix[minIndex][0].weight);


    }

    static void selectMinWeight(ArrayList<Tile> listTile) {
        pathChoser = new ArrayList<>();
        int tempWeight = Integer.MAX_VALUE;
        for (int i = 0; i < listTile.size(); i++) {
            if(listTile.get(i).weight < tempWeight){
                tempWeight = listTile.get(i).weight;
            }
        }

        for (int i = 0; i < listTile.size(); i++) {
            if(listTile.get(i).weight == tempWeight){
                pathChoser.add(listTile.get(i));
            }
        }

    }
}
