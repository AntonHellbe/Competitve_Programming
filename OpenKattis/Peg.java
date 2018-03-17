import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Peg {

    enum Direction {
        UP(-1, 0),
        DOWN(1, 0),
        LEFT(0, -1),
        RIGHT(0, 1);

        int y, x;

        Direction(int y, int x){
            this.y = y;
            this.x = x;
        }

    }

    public BufferedReader br;
    public static final int COLS = 7, ROWS = 7;

    public static void main(String[] args) throws IOException {
        Peg p = new Peg();

        p.countLegalMoves();
    }

    private void countLegalMoves() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        char[] c;
        char[][] board = new char[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            c = br.readLine().toCharArray();
            for (int j = 0; j < c.length; j++) {
                board[i][j] = c[j];
            }
        }


        int legalMoves = 0;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if(board[i][j] == '.'){
                    for (Direction d: Direction.values()) {
                        int x, x1, y, y1;
                        x = j + d.x;
                        x1 = x + d.x;
                        y = i + d.y;
                        y1 = y + d.y;
                        if(inBounds(y, x) && inBounds(y1, x1))
                            if(board[y][x] == 'o' && board[y1][x1] == 'o')
                                legalMoves++;
                    }
                }
            }
        }

        System.out.println(legalMoves);

    }


    public boolean inBounds(int y, int x){
        return y >= 0 && y < ROWS && x >= 0 && x < COLS;
    }
}
