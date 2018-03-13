import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Oktalni {

    public BufferedReader br;
    public static final int GROUP_LENGTH = 3;

    public static void main(String[] args) throws IOException {
        Oktalni o = new Oktalni();
        o.oct();
    }

    private void oct() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        int rest = line.length() % 3;
        String[] groups = new String[(int) Math.ceil( (double) line.length() / 3)];
        int count = 1;
        for (int i = line.length() - 1; i >= 0; i--) {
            if(count % GROUP_LENGTH == 0) {
                groups[(count / GROUP_LENGTH) - 1] = line.substring(i, i + GROUP_LENGTH);
            }

            count += 1;
        }

        if(rest > 0){
            if(rest == 1) {
                groups[groups.length - 1] = "00" + line.substring(0, rest);
            }else if(rest == 2){
                groups[groups.length - 1] = "0" + line.substring(0, rest);
            }
        }

        String conversion = "";

        for (int i = 0; i < groups.length; i++) {
            conversion = Integer.parseInt(groups[i], 2) + conversion;
        }

        System.out.println(conversion);
    }
}
