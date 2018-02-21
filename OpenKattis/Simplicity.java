import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Simplicity {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        Simplicity s = new Simplicity();
        s.findSimpleWord();
    }

    private void findSimpleWord() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int[] count = new int[26];

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if(count[c - 'a'] != 0){
                count[c - 'a'] = count[c - 'a'] + 1;
            }

            if(count[c - 'a'] == 0){
                count[c - 'a'] = 1;
            }
        }

        Arrays.sort(count);
        int removeCount = 0;
        // Leave the 2 most occuring characters, i.e to always get a simplicity of 2
        for (int i = 0; i < count.length - 2; i++) {
            removeCount += count[i];
        }

        System.out.println(removeCount);

    }

}
