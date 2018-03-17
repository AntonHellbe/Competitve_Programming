import java.util.Arrays;
import java.util.Scanner;

public class Akcija {

    public Scanner scan;

    public static void main(String[] args){

        Akcija akcija = new Akcija();
        akcija.solveBookStoreProblem();

    }

    private void solveBookStoreProblem() {
        scan = new Scanner(System.in);
        int numberOfBooks = Integer.parseInt(scan.nextLine());
        int[] input = new int[numberOfBooks];
        int sum = 0;
        int t = 1;

        for (int i = 0; i < numberOfBooks; i++) {
            input[i] = Integer.parseInt(scan.nextLine());
        }

        Arrays.sort(input);

        for (int i = input.length - 1; i >= 0; i--) {
            if(t % 3 != 0) {
                sum += input[i];
            }
            t++;
        }
        System.out.println(sum);
    }


}
