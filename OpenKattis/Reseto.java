import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Reseto {

    public BufferedReader br;
    public int[] numArr;

    public class Number {
        int number;
        boolean crossed;

        public Number(int number) {
            this.number = number;
            crossed = false;
        }
    }

    public static void main(String[] args) throws IOException {
        Reseto r = new Reseto();
        r.solve();
    }

    private void solve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = br.readLine().split(" ");
        int n = Integer.parseInt(lines[0]);
        int k = Integer.parseInt(lines[1]);

        numArr = new int[n + 1];
        boolean found = false;
        int min = 0;

        for (int i = 2; i <= n; i++) {
            numArr[i] = i;
        }

        while (!found) {
            min = 1;
            for (int i = 2; i <= n;) {
                if(numArr[i] != 0) {
                    if (min == 1) {
                        min = numArr[i];
                    }

                    if(k == 1){
                        System.out.println(numArr[i]);
                        return;
                    }

                    numArr[i] = 0;
                    i += min;
                    k--;
                }else{
                    i+= min;
                }
            }

        }

    }
}
