import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ABC {

    static Scanner sc;
    static boolean running = true;

    public static void main(String[] args){
        sc = new Scanner(System.in);

        while(running) {
            correctOrder();
        }
    }

    static void correctOrder() {
        int[] numbers = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] reArranged = new int[numbers.length];
        String letters = sc.nextLine().toString();

        for (int i = 0; i < letters.length(); i++) {
            if(letters.charAt(i) == 'C'){
                reArranged[i] = Arrays.stream(numbers).max().getAsInt();
            }

            if(letters.charAt(i) == 'A') {
                reArranged[i] = Arrays.stream(numbers).min().getAsInt();
            }

            if(letters.charAt(i) == 'B') {
                for (int j = 0; j < numbers.length; j++) {
                    if(numbers[j] != Arrays.stream(numbers).min().getAsInt() && numbers[j] != Arrays.stream(numbers).max().getAsInt()) {
                        reArranged[i] = numbers[j];
                    }
                }
            }
        }

        for (Integer i: reArranged) {
            System.out.print(i + " ");
        }

        running = false;
        return;
    }
}
