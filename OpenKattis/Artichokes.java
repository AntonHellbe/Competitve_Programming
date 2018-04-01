import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Artichokes {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        Artichokes a = new Artichokes();
        a.go();


    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int p = Integer.valueOf(split[0]);
        int a = Integer.valueOf(split[1]);
        int b = Integer.valueOf(split[2]);
        int c = Integer.valueOf(split[3]);
        int d = Integer.valueOf(split[4]);
        int n = Integer.valueOf(split[5]);

        double largestPeak = 0, maxDecline = 0;

        for (int i = 1; i <= n; i++) {
            double currPeak = p * (Math.sin((double)a * i + b) + Math.cos((double)c * i + d) + 2);
            largestPeak = Math.max(largestPeak, currPeak);
            if(largestPeak != currPeak && largestPeak - currPeak > maxDecline){
                maxDecline = largestPeak - currPeak;
                System.out.println(maxDecline);
            }
        }

        System.out.printf("%.08f\n", maxDecline);

    }
}
