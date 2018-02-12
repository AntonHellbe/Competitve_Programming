import java.util.Scanner;

public class DRMMessage {

    public Scanner scan;
    public String[] alphabet = {"A", "B", "C", "D", "E", "F", "G","H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static void main(String[] args){
        DRMMessage drm = new DRMMessage();
        drm.decodeMessage();
    }

    private void decodeMessage() {
        scan = new Scanner(System.in);

        String message = scan.nextLine();
        int length = message.length();
        String part1 = message.substring(0, length / 2), part2 = message.substring(length/2);
        int sumPart1 = 0, sumPart2 = 0;
        for (int i = 0; i < part1.length(); i++) {
            sumPart1 += part1.charAt(i) - 'A';
        }

        for (int i = 0; i < part2.length(); i++) {
            sumPart2 += part2.charAt(i) - 'A';
        }

        String rotate1 = "", rotate2 = "";

        for (int i = 0; i < part1.length(); i++) {
            rotate1 += alphabet[((part1.charAt(i) - 'A') + sumPart1) % alphabet.length];
        }

        for (int i = 0; i < part2.length(); i++) {
            rotate2 += alphabet[((part2.charAt(i) - 'A') + sumPart2) % alphabet.length];
        }

        String merged = "";

        for (int i = 0; i < rotate1.length(); i++) {
            merged += alphabet[((rotate1.charAt(i) - 'A') + (rotate2.charAt(i) - 'A')) % alphabet.length];
        }

        System.out.println(merged);

    }
}
