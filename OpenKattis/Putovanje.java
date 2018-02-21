import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Putovanje {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        Putovanje p = new Putovanje();
        p.calcFruits();
    }

    private void calcFruits() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;


        split = br.readLine().split(" ");
        int n = Integer.valueOf(split[0]), c = Integer.valueOf(split[1]);
        int[] fruit = new int[n];

        split = br.readLine().split(" ");

        int max = 0;

        for (int i = 0; i < n; i++) {
            fruit[i] = Integer.valueOf(split[i]);
        }


        for (int i = 0; i < n - max; i++) {
            int weight = 0, eatFruits = 0;
            for (int j = i; j < n && weight <= c; j++) {
                if(weight + fruit[j] <= c){
                    weight += fruit[j];
                    eatFruits += 1;
                }

            }

            max = Math.max(eatFruits, max);

        }



        System.out.println(max);


    }
}
