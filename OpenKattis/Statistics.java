import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Statistics {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        Statistics s = new Statistics();
        s.go();
    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int t = 1;

        while((line = br.readLine()) != null){
            String[] split = line.split(" ");
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            int numNumbers = Integer.valueOf(split[0]);
            for (int i = 1; i <= numNumbers; i++) {
                int currVal = Integer.valueOf(split[i]);
                min = Math.min(min, currVal);
                max = Math.max(max, currVal);
            }

            System.out.printf("Case %d: %d %d %d\n", t, min, max, (max - min));
            t++;

        }
    }
}
