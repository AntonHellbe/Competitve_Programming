import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DVDs {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        DVDs d = new DVDs();
        d.go();
    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.valueOf(br.readLine()), t = 0;

        while(t < testCases) {
            int numCds = Integer.valueOf(br.readLine());

            int pos = 1;
            String[] split = br.readLine().split(" ");
            for (int i = 0; i < numCds; i++) {
                if(pos == Integer.valueOf(split[i])) {
                    pos++;
                }
            }

            System.out.printf("%d\n", (numCds - pos) + 1);

            t++;

        }
    }
}
