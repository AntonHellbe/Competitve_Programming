import java.util.Arrays;
import java.util.Scanner;

public class BestCompression {

    public Scanner scan;


    public static void main(String[] args){
        BestCompression b = new BestCompression();
        b.solve();
    }

    private void solve() {
        scan = new Scanner(System.in);

        long[] input = Arrays.stream(scan.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long combinations = 0;

        for (int i = 0; i <= input[1]; i++) {
            combinations += Math.pow(2, i);
        }
        
        if(combinations >= input[0]) {
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}
