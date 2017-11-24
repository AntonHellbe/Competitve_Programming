import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Anton on 2017-10-29.
 */
public class OilDeposists {

    static Scanner scan;
    static int y, x;
    static Tile[][] oilField;
    static boolean running = true;


    enum Directions{

        LEFT (0, - 1),
        RIGHT(0,  1),
        UP (-1, 0),
        DOWN (1, 0),
        UPLEFT(-1, -1),
        DOWNLEFT(1, -1),
        UPRIGHT(-1, 1),
        DOWNRIGHT(1, 1);

        int y, x;

        Directions(int y, int x){
            this.y = y;
            this.x = x;
        }
    }


    static class Tile{
        int y;
        int x;
        String object;
        boolean visited;

        public Tile(int y, int x, String obj){
            this.y = y;
            this.x = x;
            this.object = obj;
            visited = false;
        }

        public Tile(int y, int x){
            this.y = y;
            this.x = x;
        }
    }


    public static void main(String[] args){
        scan = new Scanner(System.in);
        while(running)
            oilDeposists();

    }

    static void oilDeposists(){
        int[] temp;
        temp = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        y = temp[0];
        x = temp[1];

        ArrayList<Tile> startPositions = new ArrayList<>();

        if(y == 0 && x == 0) {
            running = false;
            return;
        }

        oilField = new Tile[y][x];

        for (int i = 0; i < y; i++) {
            String row = scan.nextLine();
            for (int j = 0; j < row.length(); j++) {
                oilField[i][j] = new Tile(i, j, row.charAt(j) + "");
                if(row.charAt(j) == '@'){
                    startPositions.add(new Tile(i, j));
                }
            }
        }
        int count = 0;
        for(Tile t: startPositions){
            if(!oilField[t.y][t.x].visited){
                dfs(t);
                count++;
            }
        }

        System.out.println(count);


    }


    static void dfs(Tile startPos){

        oilField[startPos.y][startPos.x].visited = true;
        int row, col;
        for(Directions d: Directions.values()){
            row = startPos.y + d.y;
            col = startPos.x + d.x;
            if(inBounds(row, col) && oilField[row][col].object.equals("@") && !oilField[row][col].visited){
                dfs(oilField[row][col]);
            }
        }

    }



    static boolean inBounds(int row,int col){
        return row >= 0 && row < y && col >= 0 && col < x;
    }

}
