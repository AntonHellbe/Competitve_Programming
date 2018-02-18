import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreasureHunt {

    public Scanner scan;
    public Tile[][] treasureMap;
    public int[][] distances;
    public int n,m;
    public boolean found = false, out = false;
    public static final int MAX = 99999;

    public class Tile{
        int y, x;
        String c;

        public Tile(int y, int x, String c){
            this.y = y;
            this.x = x;
            this.c = c;
        }
    }

    public class Pair{
        int y, x;

        public Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args){
        TreasureHunt t = new TreasureHunt();
        t.solve();
    }

    private void solve() {
        scan = new Scanner(System.in);
        String[] lines;

        lines = scan.nextLine().split(" ");
        n = Integer.parseInt(lines[0]);
        m = Integer.parseInt(lines[1]);
        treasureMap = new Tile[n][m];
        distances = new int[n][m];
        Pair treasure = null;

        for (int i = 0; i < distances.length; i++) {
            for (int j = 0; j < distances[i].length; j++) {
                distances[i][j] = MAX;
            }
        }

        for (int i = 0; i < n; i++) {
            lines = scan.nextLine().split("");
            for (int j = 0; j < lines.length; j++) {
                treasureMap[i][j] = new Tile(i, j, lines[j]);
                if(lines[j].equals("T")){
                    treasure = new Pair(i, j);
                }
            }
        }


        bfs();

        if(out){
            System.out.println("Out");
        }else if(distances[treasure.y][treasure.x] == MAX){
            System.out.println("Lost");
        }else {
            System.out.println(distances[treasure.y][treasure.x]);
        }

    }

    private void bfs(){

        Queue queue = new LinkedList<Tile>();
        distances[0][0] = 0;
        queue.add(treasureMap[0][0]);

        while(!queue.isEmpty()){

            Tile t = (Tile) queue.remove();

            Pair p = newCoordinates(t);

            if(p == null){
                return;
            }

            if(distances[p.y][p.x] == MAX){
                distances[p.y][p.x] = distances[t.y][t.x] + 1;
                queue.add(treasureMap[p.y][p.x]);
            }

        }
    }


    private Pair newCoordinates(Tile t){
        Pair p = null;
        switch(t.c){
            case "N":
                p = new Pair(t.y - 1, t.x);
                break;
            case "S":
                p = new Pair(t.y + 1, t.x);
                break;
            case "E":
                p = new Pair(t.y, t.x + 1);
                break;
            case "W":
                p = new Pair(t.y, t.x- 1);
                break;
            case "T":
                found = true;
                break;

        }

        if(p != null && inBounds(p.y, p.x)){
            return p;
        }else{
            if(!found)
                out = true;

            return null;
        }
    }

    public boolean inBounds(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
