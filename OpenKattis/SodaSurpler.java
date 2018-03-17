import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SodaSurpler {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        SodaSurpler ss = new SodaSurpler();
        ss.go();
    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        int e = Integer.valueOf(split[0]), f = Integer.valueOf(split[1]), c = Integer.valueOf(split[2]);
        int totalDrinks = 0;

        int totalEmptyBottle = (e + f);

        while(true) {
            totalDrinks += (totalEmptyBottle / c);

            totalEmptyBottle = (totalEmptyBottle / c) + (totalEmptyBottle % c);
            if(totalEmptyBottle < c){
                break;
            }

        }

        System.out.println(totalDrinks);

    }
}
