import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NPuzzle {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        NPuzzle n = new NPuzzle();
        n.solveMinDistance();
    }

    private void solveMinDistance() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        char[][] board = new char[4][4];

        for (int i = 0; i < 4; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < c.length; j++) {
                board[i][j] = c[j];
            }
        }

        int dist = 0;

        outer:for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(board[i][j] != '.'){
                    int val = board[i][j] - 'A';
                    int col = val % 4;
                    int row = val / 4;
//                    System.out.println(row);
//                    System.out.println(col);
                    dist += (int) Math.abs((col - j)) + Math.abs(i - row);
                    //break outer;
                }
            }
        }

        System.out.println(dist);
    }
}
