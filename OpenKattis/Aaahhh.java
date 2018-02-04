import java.util.Scanner;

public class Aaahhh {

    static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        doTheAhhh();
    }

    static void doTheAhhh() {
        String doc1 = scan.nextLine();
        String doc2 = scan.nextLine();

        if(doc1.length() - 1 >= doc2.length() - 1) {
            System.out.println("go");
        } else {
            System.out.println("no");
        }
    }
}
