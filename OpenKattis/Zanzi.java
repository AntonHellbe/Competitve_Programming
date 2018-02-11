import java.util.Arrays;
import java.util.Scanner;

public class Zanzi {

    public Scanner scan;

    public static void main(String[] args){
        Zanzi z = new Zanzi();
        z.lowerBound();

    }

    private void lowerBound() {
        scan = new Scanner(System.in);
        int testcases = Integer.parseInt(scan.nextLine()), i = 0;
        int[] input;
        int lowerbound = 0;
        while(i < testcases) {
            input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < input.length - 1; j++) {
                if(input[j + 1] > input[j] * 2) {
                    lowerbound += input[j + 1] - input[j] * 2;
                }
            }

            System.out.println(lowerbound);
            lowerbound = 0;
            i++;
        }
    }
}
