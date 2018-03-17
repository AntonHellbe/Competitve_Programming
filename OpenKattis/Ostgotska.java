import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ostgotska {

    public BufferedReader br;
    public static final String AE = "ae";
    public static final double NOT_RIKSVENSKA = 0.4;

    public static void main(String[] args) throws IOException {
        Ostgotska o = new Ostgotska();
        o.solveIssue();
    }

    private void solveIssue() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        int count = 0, words = 0;
        outer: for (int i = 0; i < split.length; i++) {
            words++;
            if(split[i].length() > 1) {
                for (int j = 0; j < split[i].length() - 1; j++) {
                    if((split[i].charAt(j) + "" + split[i].charAt(j + 1)).equals(AE)){
                        count++;
                        continue outer; // Dont count the same word twice
                    }
                }
            }
        }

        double ratio = (double) count / words;

        if(ratio >= NOT_RIKSVENSKA) {
            System.out.println("dae ae ju traeligt va");
        }else{
            System.out.println("haer talar vi rikssvenska");
        }
    }
}
