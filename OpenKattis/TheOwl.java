import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheOwl {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        TheOwl t = new TheOwl();
        t.findNumber();
    }

    private void findNumber() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        int testCases = Integer.valueOf(br.readLine()), t = 0;

        while(t < testCases) {

            char[] c = br.readLine().toCharArray();

            for (int i = c.length - 1; i >= 0; i--) {
                if(c[i] != '0'){
                    c[i] = (char) (c[i] - 1);
                    break;
                }
            }

            String closestNumber = String.valueOf(c);

            System.out.println(Integer.valueOf(closestNumber));





            t++;
        }
    }
}
