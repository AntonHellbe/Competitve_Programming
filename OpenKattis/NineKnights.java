import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NineKnights {

    enum Direction{
        UPLEFT (-2, -1),
        UPRIGHT (-2, 1),

        RIGHTUP (-1, 2),
        LEFTUP (-1, -2),

        LEFTDOWN (1, -2),
        RIGHTDOWN (1, 2),

        DOWNLEFT(2, -1),
        DOWNRIGHT(2, 1);

        int y, x;

        Direction(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public BufferedReader br;
    public char[][] board;
    public static final int ROWS = 5, COLS = 5;

    public static void main(String[] args) throws IOException{
        NineKnights nk = new NineKnights();
        nk.calcValidBoard();
    }

    private void calcValidBoard() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        char[] boardRow;
        board = new char[ROWS][COLS];
        boolean invalid = false;
        int knights = 0;

        for (int i = 0; i < ROWS; i++) {
            boardRow = br.readLine().toCharArray();
            for (int j = 0; j < boardRow.length; j++) {
                board[i][j] = boardRow[j];
                if(board[i][j] == 'k'){
                    knights++;
                }
            }
        }

        if(knights != 9) invalid = true;

        outer: for (int i = 0; i < ROWS && !invalid; i++) {
            for (int j = 0; j < COLS; j++) {
                if(board[i][j] == 'k'){
                    int newRow, newCol;
                    for (Direction d: Direction.values()) {
                        newRow = i + d.y;
                        newCol = j + d.x;
                        if(inBounds(newRow, newCol) && board[newRow][newCol] == 'k'){
                            invalid = true;
                            break outer;
                        }
                    }
                }
            }
        }


        if(!invalid)
            System.out.println("valid");
        else
            System.out.println("invalid");
    }




    public boolean inBounds(int y, int x) {
        return x >= 0 && x < COLS && y >= 0 && y < ROWS;
    }
}
