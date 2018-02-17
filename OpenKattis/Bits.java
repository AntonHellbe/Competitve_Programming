import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bits {

    public Scanner scan;

    public static void main(String[] args){
        Bits b = new Bits();
        b.maxOneBits();
    }

    private void maxOneBits() {
        scan = new Scanner(System.in);

        int i = 0, testcases = Integer.parseInt(scan.nextLine());

        while(i < testcases) {

            String[] line = scan.nextLine().split("");
            int[] oneCount = new int[line.length];

            String temp = "";
            for (int j = 0; j < line.length; j++) {
                temp = temp + line[j];
                int currentInt = Integer.parseInt(temp);
                String binary = Integer.toBinaryString(currentInt);
                binary = binary.replaceAll("0", "");
                oneCount[j] = binary.length();

            }


            System.out.println(Arrays.stream(oneCount).max().getAsInt());


            i++;
        }
    }
}
