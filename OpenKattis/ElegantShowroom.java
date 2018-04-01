import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class ElegantShowroom {

    public class Tuple {
        int y, x;

        public Tuple(int y, int x) {
            this.y = y;
            this.x = x;
        }

    }

    enum Directions {
        UP (-1, 0),
        DOWN (1, 0),
        LEFT (0, -1),
        RIGHT (0, 1);

        int y, x;

        Directions(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public BufferedReader br;
    public int rows, cols;
    public char[][] maze;
    public int[][] dist;
    public int best = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        ElegantShowroom es = new ElegantShowroom();
        es.go();
    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;


        split = br.readLine().split(" ");
        rows = Integer.valueOf(split[0]);
        cols = Integer.valueOf(split[1]);
        maze = new char[rows][cols];
        dist = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < rows; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < cols; j++) {
                maze[i][j] = c[j];
            }
        }

        split = br.readLine().split(" ");
        int startY = Integer.valueOf(split[0]) - 1;
        int startX = Integer.valueOf(split[1]) - 1;
        Tuple start = new Tuple(startY, startX);

        bfs(start);

        System.out.println(best + 1);

    }

    public void bfs(Tuple start) {
        LinkedList<Tuple> q = new LinkedList<>();
        dist[start.y][start.x] = 0;
        int newRow, newCol;
        q.add(start);

        while(!q.isEmpty()) {

            Tuple current = q.remove();

            for (Directions d: Directions.values()) {
                newRow = current.y + d.y;
                newCol = current.x + d.x;
                if(inBounds(newRow, newCol) && maze[newRow][newCol] != '#') {
                    if(maze[newRow][newCol] == 'D') {
                        if(dist[newRow][newCol] > dist[current.y][current.x]) {
                            dist[newRow][newCol] = dist[current.y][current.x];
                            q.add(new Tuple(newRow, newCol));
                        }

                        if(newRow == 0 || newRow == rows - 1 || newCol == 0 || newCol == cols - 1){
                            best = Math.min(dist[newRow][newCol], best);
                        }

                    }

                    if(maze[newRow][newCol] == 'c') {
                        if(dist[newRow][newCol] > dist[current.y][current.x] + 1){
                            dist[newRow][newCol] = dist[current.y][current.x] + 1;
                            q.add(new Tuple(newRow, newCol));
                        }
                    }

                }

            }
        }


    }

    public boolean inBounds(int y, int x) {
        return y >= 0 && y < rows && x >= 0 && x < cols;
    }

}
