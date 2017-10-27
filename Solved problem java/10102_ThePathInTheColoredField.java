import java.util.*;

/**
 * Created by Anton on 2017-10-27.
 */
public class ThePathInTheColoredField {
    static Scanner scan;
    static Tile[][] field;
    static int fieldsize;


    public static void main(String[] args){
        scan = new Scanner(System.in);
        while(true) {
            try {
                fieldsize = Integer.parseInt(scan.nextLine());
                solveColorField(fieldsize);
            } catch (Exception e) {
                break;
            }
        }

    }

    enum Direction{
        LEFT (0, -1),
        RIGHT (0, 1),
        DOWN (1, 0),
        UP (-1, 0);

        int y, x;

        Direction(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static class Tile{
        int y, x, color, dist;


        public Tile(int y, int x, int color){
            this.y = y;
            this.x = x;
            this.color = color;
            this.dist = Integer.MAX_VALUE;
        }

        public Tile(){
            this.dist = Integer.MAX_VALUE;
        }

        public Tile(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static void solveColorField(int size) {
        field = new Tile[size][size];
        String row;
        ArrayList<Tile> startingPositions = new ArrayList<>();
        ArrayList<Tile> finishingPositions = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            row = scan.nextLine();
            for (int j = 0; j < row.length(); j++) {
                if(row.charAt(j) == '3')
                    finishingPositions.add(new Tile(i, j));
                if(row.charAt(j) == '1')
                    startingPositions.add(new Tile(i, j));
                field[i][j] = new Tile(i, j, Integer.parseInt(String.valueOf(row.charAt(j))));
            }

        }
        ArrayList<Integer> candidates = new ArrayList<>();
        for(Tile t: startingPositions){
            candidates.add(bfs(field[t.y][t.x], 3).dist);
        }
        int m = 0;
        for(Integer i: candidates){
            if(m < i)
                m = i;
        }
        System.out.println(m);



    }

    static Tile bfs(Tile startNode, int target){

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j].dist = Integer.MAX_VALUE;
            }

        }
        Queue queue = new LinkedList();

        queue.add(startNode);
        int row, col = 0;
        startNode.dist = 0;
        boolean flag = true;

        while(!queue.isEmpty() && flag){
            Tile currentTile = (Tile) queue.remove();
            for(Direction d: Direction.values()){
                row = currentTile.y + d.y;
                col = currentTile.x + d.x;
                if(inBounds(row, col, fieldsize) && field[row][col].dist == Integer.MAX_VALUE){
                    field[row][col].dist = currentTile.dist + 1;
                    if(field[row][col].color == target){
                        return field[row][col];
                    }
                    queue.add(field[row][col]);
                    }
                }

            }

        return new Tile();
    }

    static boolean inBounds(int y,int x,int size){
        return y >= 0 && y < size && x >= 0 && x < size;
    }
}
