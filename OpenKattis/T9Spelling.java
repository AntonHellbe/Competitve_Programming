import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T9Spelling {

    public BufferedReader br;
    public static final char[][] keypad = {
        {' '},
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
    };
    public static void main(String[] args) throws IOException {
        T9Spelling t9 = new T9Spelling();
        t9.spellWord();

    }

    private void spellWord() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.valueOf(br.readLine()), t = 0;

        while(t < testCases) {

            int prev = 0, index = 0, current = 0;
            String line = br.readLine();
            String result = "";

            for (int i = 0; i < line.length(); i++) {


                outer:for (int j = 0; j < keypad.length; j++) {
                    for (int k = 0; k < keypad[j].length; k++) {
                        if (keypad[j][k] == line.charAt(i)) {
                            current = j;
                            index = k;
                            break outer;
                        }
                    }
                }


                if (i != 0 && prev == current) {
                    result += " ";
                }


                for (int j = 0; j < index + 1; j++) {
                    if (current == 0)
                        result += (current);
                    else
                        result += (current + 1);
                }

                prev = current;

            }


            System.out.printf("Case #%d: %s\n", (t + 1), result);
            t++;
        }




    }
}
