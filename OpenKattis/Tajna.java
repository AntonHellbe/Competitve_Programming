import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tajna {

    public BufferedReader br;
    public static final int MAX = 99999;

    public class Pair{
        int rows, cols;

        public Pair(int y, int x){
            this.rows = y;
            this.cols = x;
        }
    }

    public static void main(String[] args) throws IOException {
        Tajna t = new Tajna();
        t.findMatrix();
    }

    private void findMatrix() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int length = line.length();

        Pair p = new Pair(MAX, 0);

        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                if(i * j == length){
                    if(Math.abs(i - j) < Math.abs(p.rows - p.cols) && j <= i){
                        p.rows = i;
                        p.cols = j;
                    }
                }
            }
        }

        int charIndex = 0;
        char[][] encryptMatrix = new char[p.rows][p.cols];
        for (int i = 0; i < p.rows; i++) {
            for (int j = 0; j < p.cols; j++) {
                encryptMatrix[i][j] = line.charAt(charIndex++);
            }
        }

        String message = "";

        for (int i = 0; i < p.cols; i++) {
            for (int j = 0; j < p.rows; j++) {
                message += encryptMatrix[j][i];
            }
        }

        System.out.println(message);


    }
}
