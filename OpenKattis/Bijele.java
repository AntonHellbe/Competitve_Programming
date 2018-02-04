import java.util.Arrays;
import java.util.Scanner;

public class Bijele {

    static Scanner sc;
    static int[] set = { 1, 1, 2, 2, 2, 8 };

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        solveBijele();
    }

    static void solveBijele() {
        int input[] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < input.length; i++) {
            if(input[i] == set[i]) {
                System.out.print(0 + " ");
            }

            if(input[i] > set[i] || input[i] < set[i]) {
                System.out.print(set[i] - input[i] + " ");
            }

//            if(input[i] < set[i]) {
//                System.out.print(set[i] - input[i] + " ");
//            }
        }
    }
}
