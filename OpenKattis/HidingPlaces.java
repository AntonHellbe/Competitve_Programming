import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class HidingPlaces {

    enum Direction{
        UPLEFT (-2, -1),
        UPRIGHT(-2, 1),

        DOWNLEFT(2, -1),
        DOWNRIGHT(2, 1),

        LEFTUP(-1, -2),
        LEFTDOWN(1, -2),

        RIGHTUP(-1, 2),
        RIGHTDOWN(1, 2);

        int y, x;

        Direction(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public class Pair {
        int y, x;

        public Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public BufferedReader br;
    public static final int ROWS = 8, COLS = 8;
    public int[][] distMap;

    public static void main(String[] args) throws IOException {
        HidingPlaces h = new HidingPlaces();
        h.go();
    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;



        int testCases = Integer.valueOf(br.readLine()), t = 0;
        while(t < testCases) {
            distMap = new int[ROWS][COLS];

            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    distMap[i][j] = Integer.MAX_VALUE;
                }
            }

            split = br.readLine().split("");
            int startCol = split[0].charAt(0) - 'a';
            int startRow = Integer.valueOf(split[1]) - 1;

            bfs(startRow, startCol);

            int max = 0;

            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    max = Math.max(max, distMap[i][j]);
                }
            }

            System.out.print(max);

            for (int i = ROWS  - 1; i >= 0; i--) {
                for (int j = 0; j < COLS; j++) {
                    if(distMap[i][j] == max){
                        System.out.printf(" %c%c", 'a' + j, i + '1');
                    }
                }
            }
            System.out.println("");


            t++;

        }

    }


    public void bfs(int startRow, int startCol){
        distMap[startRow][startCol] = 0;

        int newRow, newCol;

        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startRow, startCol));

        while(!queue.isEmpty()) {
            Pair currentNode = queue.remove();

            for (Direction d: Direction.values()) {
                newRow = currentNode.y + d.y;
                newCol = currentNode.x + d.x;
                if(inBounds(newRow, newCol)){
                    if(distMap[newRow][newCol] > (distMap[currentNode.y][currentNode.x] + 1)){
                        distMap[newRow][newCol] = distMap[currentNode.y][currentNode.x] + 1;
                        queue.add(new Pair(newRow, newCol));
                    }

                }
            }

        }
    }


    public boolean inBounds(int y, int x){
        return y >= 0 && y < ROWS && x >= 0 && x < COLS;
    }

}
