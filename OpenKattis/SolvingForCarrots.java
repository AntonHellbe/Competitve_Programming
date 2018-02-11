import java.util.Arrays;
import java.util.Scanner;

public class SolvingForCarrots {

    public Scanner scan;

    public static void main(String[] args){
        SolvingForCarrots s = new SolvingForCarrots();
        s.solve();
    }

    private void solve() {
        scan = new Scanner(System.in);

        int[] input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(input[1]);
    }
}
