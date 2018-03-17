import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Slatski {

    public BufferedReader br;
    public long[] moduloValues = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

    public static void main(String[] args) throws IOException {
        Slatski s = new Slatski();
        s.solve();
    }

    private void solve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;


        split = br.readLine().split(" ");
        long t = Long.valueOf(split[0]);
        int zeroes = Integer.valueOf(split[1]);
        //System.out.println(t % moduloValues[zeroes]);
    }
}
