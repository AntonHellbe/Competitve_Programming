import java.util.Arrays;
import java.util.Scanner;

public class FizzBuzz {

    static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        fizzToTheBuzz();
    }

    static void fizzToTheBuzz() {
        int[] input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i <= input[2]; i++) {
            if(i % input[0] == 0 && i % input[1] == 0) {
                System.out.println("FizzBuzz");
            }else if(i % input[0] == 0) {
                System.out.println("Fizz");
            } else if(i % input[1] == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
