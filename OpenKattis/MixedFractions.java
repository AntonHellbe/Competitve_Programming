import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MixedFractions {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        MixedFractions mf = new MixedFractions();
        mf.calcMixedFractions();
    }

    private void calcMixedFractions() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;


        while(true){
            split = br.readLine().split(" ");
            int nominator = Integer.valueOf(split[0]);
            int denominator = Integer.valueOf(split[1]);

            if(nominator == 0 && denominator == 0) return;

            int divided = nominator / denominator, rest = nominator % denominator;

            System.out.printf("%d %d / %d\n", divided, rest, denominator);
        }
    }
}
