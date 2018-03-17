import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CryptographersConundrum {

    public BufferedReader br;
    public static final String NAME= "PER";

    public static void main(String[] args) throws IOException {
        CryptographersConundrum cc = new CryptographersConundrum();
        cc.solve();
    }

    private void solve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int days = 0;
        for (int i = 0; i < line.length(); i++) {
            if(NAME.charAt((i) % NAME.length()) != line.charAt(i)){
                days++;
            }
        }

        System.out.println(days);
    }
}
