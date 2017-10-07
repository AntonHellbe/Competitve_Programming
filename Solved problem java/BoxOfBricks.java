import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Anton on 2017-10-06.
 */
public class BoxOfBricks {
    static Scanner scan;
    //static int stackCount;
    static int[] stacks;
    static boolean running = true;
    static int setCounter = 1;


    public static void main(String[] args){
        scan = new Scanner(System.in);
        while (running) {
            minimumMoves();
        }
        scan.close();


    }

    static void minimumMoves() {
        int sum = 0, optimalHeight, moves = 0;
        int stackCount = Integer.parseInt(scan.nextLine());
        if (stackCount == 0) {
            running = false;
            return;
        }

        String[] temp = scan.nextLine().split(" ");
        stacks = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < stacks.length; i++) {
            sum += stacks[i];
        }

        optimalHeight = sum / stackCount;

        for (int i = 0; i < stacks.length; i++) {
            if (stacks[i] > optimalHeight) {
                moves += stacks[i] - optimalHeight;
            }
        }

        System.out.println("Set #" + setCounter);
        System.out.println("The minimum number of moves is " + moves + ".");
        System.out.println();
        setCounter++;

    }

}
