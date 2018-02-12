import java.util.Arrays;
import java.util.Scanner;

public class PermutedArithmeticSequence {

    public Scanner scan;

    public static void main(String[] args){
        PermutedArithmeticSequence p = new PermutedArithmeticSequence();
        p.solve();
    }

    private void solve() {
        scan = new Scanner(System.in);

        int testcases = scan.nextInt(), k = 0;

        while(k < testcases) {
            int numbers = scan.nextInt();
            int[] sequence = new int[numbers];

            for (int i = 0; i < numbers; i++) {
                sequence[i] = scan.nextInt();
            }

            int diff = Math.abs(sequence[0] - sequence[1]);
            if(checkDiff(sequence, diff)) {
                System.out.println("arithmetic");
            }else {
                Arrays.sort(sequence);
                diff = Math.abs(sequence[0] - sequence[1]);
                boolean perm = checkDiff(sequence, diff);
                if(perm)
                    System.out.println("permuted arithmetic");
                else
                    System.out.println("non-arithmetic");
            }


            k++;
        }

    }

    public boolean checkDiff(int[] arr, int diff){
        int prev = 0;
        for (int i = 0; i < arr.length; i++) {
            if(prev != 0){
                if(Math.abs(arr[i] - prev) != diff){
                    return false;
                }
            }

            prev = arr[i];
        }

        return true;
    }
}
