import java.util.Arrays;
import java.util.Scanner;

public class AnthonyAndDiablo {

    public Scanner scan;

    public static void main(String[] args){
        AnthonyAndDiablo a = new AnthonyAndDiablo();
        a.solve();
    }

    private void solve() {
        scan = new Scanner(System.in);

        double[] numers = Arrays.stream(scan.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        double radian = numers[1] / (2 * 3.14);
        double area = 3.14 * Math.pow(radian, 2);

        if(numers[0] <= area) {
            System.out.println("Diablo is happy!");
        }else {
            System.out.println("Need more materials!");
        }

    }
}
