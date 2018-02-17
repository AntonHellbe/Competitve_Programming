import java.util.Scanner;

public class Rijeci {

    public Scanner scan;

    public static void main(String[] args){
        Rijeci r = new Rijeci();
        r.isActullyFibonacci();
    }

    private void isActullyFibonacci() {
        scan = new Scanner(System.in);

        int num = scan.nextInt();

        int t1 = 0, t2 = 1, t3;

        for (int i = 0; i < num - 1; i++) {
            t3 = t1 + t2;
            t1 = t2;
            t2 = t3;
        }

        System.out.println(t1 + " " + t2);
    }
}
