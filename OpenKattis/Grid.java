import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Grid {

    public class Pair {
        int y, x;

        public Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public BufferedReader br;
    public int[][] grid;
    public int rows, cols;
    public int[] dx = { -1, 1, 0, 0 };
    public int[] dy = { 0, 0, -1, 1 };
    public int[][] dist;

    public static void main(String[] args) throws IOException {
        Grid g = new Grid();
        g.go();
    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;

        split = br.readLine().split(" ");

        rows = Integer.valueOf(split[0]);
        cols = Integer.valueOf(split[1]);

        grid = new int[rows][cols];
        dist = new int[rows][cols];

        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < rows; i++) {
            split = br.readLine().split("");
            for (int j = 0; j < cols; j++) {
                grid[i][j] = Integer.valueOf(split[j]);
            }
        }

        bfs();

        if(dist[rows - 1][cols - 1] == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(dist[rows - 1][cols - 1]);


    }


    private void bfs() {
        dist[0][0] = 0;
        int newRow, newCol;
        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));

        while(!queue.isEmpty()) {

            Pair p = queue.remove();
            int multiplier = grid[p.y][p.x];

            for (int i = 0; i < 4; i++) {
                newRow = (dy[i] * multiplier) + p.y;
                newCol = (dx[i] * multiplier) + p.x;
                if(inBounds(newRow, newCol) && dist[newRow][newCol] > dist[p.y][p.x] + 1) {
                    dist[newRow][newCol] = dist[p.y][p.x] + 1;
                    queue.add(new Pair(newRow, newCol));
                }
            }

        }
    }


    private boolean inBounds(int y, int x) {
        return y >= 0 && y < rows && x >= 0 && x < cols;
    }
}
