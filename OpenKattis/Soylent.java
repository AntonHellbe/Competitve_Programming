import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Soylent {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        Soylent s = new Soylent();
        s.go();
    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.valueOf(br.readLine());

        for (int i = 0; i < testCases; i++) {
            int toTakeIn = Integer.valueOf(br.readLine());
            System.out.println((int) Math.ceil((double) toTakeIn / 400));
        }
    }
}
