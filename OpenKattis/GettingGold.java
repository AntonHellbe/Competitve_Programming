import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GettingGold {


    public BufferedReader br;
    public char[][] maze;
    public boolean[][] visited;
    public int goldCount = 0, rows, cols;

    enum Direction {
        UP (-1, 0),
        DOWN (1, 0),
        LEFT (0, -1),
        RIGHT (0, 1);

        int y, x;

        Direction(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        GettingGold g = new GettingGold();
        g.calcGold();
    }

    private void calcGold() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;


        split = br.readLine().split(" ");
        cols = Integer.valueOf(split[0]);
        rows = Integer.valueOf(split[1]);
        visited = new boolean[rows][cols];

        maze = new char[rows][cols];

        int startX = 0, startY = 0;

        for (int i = 0; i < rows; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < cols; j++) {
                maze[i][j] = c[j];
                if(c[j] == '#'){
                    visited[i][j] = true;
                }

                if(c[j] == 'P'){
                    startX = j;
                    startY = i;
                }
            }
        }

        dfs(startY, startX);
        System.out.println(goldCount);
    }


    public void dfs(int y, int x) {
        visited[y][x] = true;
        if(maze[y][x] == 'G') goldCount++;

        int newRow, newCol;

        if(senseTrap(y, x)) return;

        for (Direction d: Direction.values()) {
            newRow = y + d.y;
            newCol = x + d.x;
            if(!visited[newRow][newCol]){
                dfs(newRow, newCol);
            }
        }

    }

    public boolean senseTrap(int y, int x){
        int newRow, newCol;
        for (Direction d: Direction.values()) {
            newRow = y + d.y;
            newCol = x + d.x;
            if(maze[newRow][newCol] == 'T'){
                return true;
            }
        }

        return false;
    }

}
