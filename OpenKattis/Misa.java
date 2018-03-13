import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Misa {

    public BufferedReader br;
    public int rows, cols;
    public char[][] seating;

    enum Directions{
        UP (-1, 0),
        DOWN(1, 0),
        LEFT(0, -1),
        RIGHT(0, 1),
        UPLEFT(-1, -1),
        UPRIGHT(-1, 1),
        DOWNLEFT(1, -1),
        DOWNRIGHT(1, 1);

        int y, x;

        Directions(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public class Pair{
        int y, x;

        public Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        Misa m = new Misa();
        m.handshakes();
    }

    private void handshakes() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;

        split = br.readLine().split(" ");
        rows = Integer.valueOf(split[0]);
        cols = Integer.valueOf(split[1]);
        int freeSeat = 0;
        seating = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < cols; j++) {
                if(input[j] == '.'){
                    freeSeat++;
                }
                seating[i][j] = input[j];
            }
        }

        Pair p = new Pair(0, 0);

        int newRow, newCol, max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(seating[i][j] == '.') {
                    int shakes = 0;
                    for (Directions d : Directions.values()) {
                        newRow = i + d.y;
                        newCol = j + d.x;
                        if (inBounds(newRow, newCol) && seating[newRow][newCol] == 'o') {
                            shakes++;
                        }
                    }
                    if(shakes > max){
                        p.y = i;
                        p.x = j;
                        max = shakes;
                    }

                }
            }
        }
        seating[p.y][p.x] = 'o';
        int totalShakes = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(seating[i][j] == 'o'){
                    for(Directions d: Directions.values()){
                        newRow = i + d.y;
                        newCol = j + d.x;
                        if (inBounds(newRow, newCol) && seating[newRow][newCol] == 'o') totalShakes++;

                    }
                }
            }
        }

        System.out.println(totalShakes / 2);


    }


    public boolean inBounds(int y, int x) {
        return y >= 0 && y < rows && x >= 0 && x < cols;
    }
}
