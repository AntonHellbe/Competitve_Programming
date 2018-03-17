import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseRot {

    public BufferedReader br;
    public static char[] alphabetOrder = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '_', '.'};


    public static void main(String[] args) throws IOException {
        ReverseRot rr = new ReverseRot();
        rr.shiftLetters();
    }

    private void shiftLetters() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;

        while(true) {
            split = br.readLine().split(" ");
            int shiftValue = Integer.valueOf(split[0]);

            if(shiftValue == 0) return;

            char[] line = new StringBuilder(split[1]).reverse().toString().toCharArray();

            for (int i = 0; i < line.length; i++) {
                int shiftedLetter = 0;
//                System.out.print(line[i]);
                if(line[i] != '.' && line[i] != '_') {
                    shiftedLetter = ((line[i] - 'A') + shiftValue) % alphabetOrder.length;
                }else{
                    if(line[i] == '.')
                        shiftedLetter = ((27) + shiftValue) % alphabetOrder.length;
                    else
                        shiftedLetter = ((26) + shiftValue) % alphabetOrder.length;
                }

                line[i] = alphabetOrder[shiftedLetter];
            }

            System.out.println(String.valueOf(line));
        }


    }
}
