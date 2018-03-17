import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PizzaCrust {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        PizzaCrust p = new PizzaCrust();
        p.calcPizza();
    }

    private void calcPizza() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;

        split = br.readLine().split(" ");
        double r = Double.valueOf(split[0]);
        double c = r - Double.valueOf(split[1]);

        double pizzaArea = Math.PI * Math.pow(r, 2);
        double cheeseArea = Math.PI * Math.pow(c, 2);

        double totalCheeseArea = cheeseArea / pizzaArea * 100;

        System.out.printf("%.9f", totalCheeseArea);


    }

}
