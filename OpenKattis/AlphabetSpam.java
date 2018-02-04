import java.util.Scanner;

public class AlphabetSpam {

    static int uppercase, lowercase, whitespace, symbols;
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        solveSpamRation();
    }

    static void solveSpamRation() {
        String line = sc.nextLine().toString();
        for (int i = 0; i < line.length(); i++) {
            if((int) line.charAt(i) >= 97 && (int) line.charAt(i) <= 122) {
                lowercase++;
            } else if((int) line.charAt(i) >= 65 && (int) line.charAt(i) <= 90) {
                uppercase++;
            } else if(line.charAt(i) == '_') {
                whitespace++;
            } else {
                symbols++;
            }
        }

        System.out.printf("%.15f\n", (double) whitespace / line.length());
        System.out.printf("%.15f\n", (double) lowercase / line.length());
        System.out.printf("%.15f\n", (double) uppercase / line.length());
        System.out.printf("%.15f\n", (double) symbols / line.length());

    }


}
