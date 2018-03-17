import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Peragrams {

    public BufferedReader br;


    public static void main(String[] args) throws IOException {
        Peragrams p = new Peragrams();
        p.go();
    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));


        int[] characterCount = new int[26];

        String line = br.readLine();

        for (int i = 0; i < line.length(); i++) {
            characterCount[(line.charAt(i) - 'a')] = characterCount[(line.charAt(i) - 'a')] + 1;
        }

        int toRemove = 0;

        for (int i = 0; i < 26; i++) {
            if(characterCount[i] % 2 == 1) toRemove++;
        }

        if(toRemove > 1)
            System.out.println(toRemove - 1);
        else
            System.out.println(0);
    }


}
