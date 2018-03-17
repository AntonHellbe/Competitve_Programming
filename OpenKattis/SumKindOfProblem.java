import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumKindOfProblem {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        SumKindOfProblem s = new SumKindOfProblem();
        s.calcIntegers();
    }

    private void calcIntegers() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;
        int testCases = Integer.valueOf(br.readLine()), t = 0;

        while (t < testCases) {
            split = br.readLine().split(" ");
            int k = Integer.valueOf(split[0]);
            int n = Integer.valueOf(split[1]);

            int count = 0, sum1 = 0, sum2 = 0, sum3 = 0;

            for (int i = 1; i <= n; i++) {
                sum1 += i;
            }

            for (int i = 1; count < n; i++) {
                if (i % 2 == 0) {
                    sum3 += i;
                    count++;
                }


            }
            count = 0;

            for (int i = 1; count < n; i++) {
                if (i % 2 == 1) {
                    sum2 += i;
                    count++;
                }

            }


            System.out.println(k + " " + sum1 + " " + sum2 + " " + sum3);
            t++;
        }
    }
}
