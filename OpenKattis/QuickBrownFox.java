import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class QuickBrownFox {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        QuickBrownFox q = new QuickBrownFox();
        q.calcCharacters();
    }

    private void calcCharacters() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.valueOf(br.readLine()), t = 0;


        while(t < lines) {
            int[] alphabet = new int[26];
            String line = br.readLine().toLowerCase();
            for (int i = 0; i < line.length(); i++) {
                if(line.charAt(i) - 'a' < 26 && (line.charAt(i) - 'a') >= 0){
                    alphabet[(line.charAt(i) - 'a')] = 1;
                }
            }

            int count = Arrays.stream(alphabet).sum();

            if(count == 26){
                System.out.println("pangram");
            }else{
                System.out.print("missing ");
                for (int i = 0; i < alphabet.length; i++) {
                    if(alphabet[i] == 0){
                        char c = (char) (i + 'a');
                        System.out.print(c);
                    }
                }

                System.out.println("");

            }

            t++;

        }
    }
}
