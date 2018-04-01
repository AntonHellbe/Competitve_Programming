import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SimpleAddition {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        SimpleAddition sa = new SimpleAddition();
        sa.go();
    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        BigInteger a = new BigInteger(line);
        line = br.readLine();
        BigInteger b = new BigInteger(line);

        BigInteger c = a.add(b);

        System.out.println(c.toString());




    }
}
