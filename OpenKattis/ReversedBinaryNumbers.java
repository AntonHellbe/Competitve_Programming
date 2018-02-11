import java.util.Scanner;

public class ReversedBinaryNumbers {

    public Scanner scan;

    public static void main(String[] args) {
        ReversedBinaryNumbers reversedBinaryNumbers = new ReversedBinaryNumbers();
        reversedBinaryNumbers.solve();
    }

    private void solve() {
        scan = new Scanner(System.in);

        int number = scan.nextInt();
        String binaryRepresentation = Integer.toBinaryString(number);
        char[] reverse = new char[binaryRepresentation.length()];
        int t = 0;
        for (int i = binaryRepresentation.length() - 1; i >= 0; i--) {

            reverse[t++] = binaryRepresentation.charAt(i);
        }

        String reversedBinary = String.valueOf(reverse);

        System.out.println(Integer.parseInt(reversedBinary, 2));






    }
}
