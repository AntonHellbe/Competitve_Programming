import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Anton on 2017-10-07.
 */
public class WineTradingGeorgia {

    static Scanner scan;
    static int inhabitants;
    static long moves;
    static boolean running = true;

    public static void main(String[] args){
        scan = new Scanner(System.in);
        while(running)
            doSomeTrading();

        scan.close();
        System.exit(0);
    }

    static void doSomeTrading() {
        inhabitants = Integer.parseInt(scan.nextLine());

        if(inhabitants == 0){
            running = false;
            return;
        }
        moves = 0;
        int[] bottles = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] firstHalf = Arrays.copyOfRange(bottles, 0, bottles.length / 2);
        int[] secondHalf = Arrays.copyOfRange(bottles, (bottles.length / 2), bottles.length);
//        reverse(secondHalf);


        for (int i = 0; i < firstHalf.length - 1; i++) { // left ---> right
            moves += Math.abs(firstHalf[i]);
            firstHalf[i + 1] = firstHalf[i] + firstHalf[i + 1];
        }

        for (int i = secondHalf.length - 1; i > 0; i--) { // right ----> left
            moves += Math.abs(secondHalf[i]);
            secondHalf[i - 1] = secondHalf[i] + secondHalf[i - 1];

        }



        moves += Math.abs(firstHalf[firstHalf.length - 1]);

        System.out.println(moves);

    }

    /* Alternative to going backwards, instead it's possible to reverse and go from left ---> right */

    static void reverse(int[] array){

        for(int left = 0, right = array.length - 1; left < right; left++, right--){
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
    }
}
