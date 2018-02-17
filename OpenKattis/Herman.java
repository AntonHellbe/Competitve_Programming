import java.util.Scanner;

public class Herman {

    public Scanner scan;
    public static final double PI = 3.141593;

    public static void main(String[] args){
        Herman h = new Herman();
        h.solveCircleThing();
    }

    private void solveCircleThing() {
        scan = new Scanner(System.in);
        int radii = scan.nextInt();
        double eucArea = Math.PI * Math.pow(radii, 2);
        double taxArea = 4/2 * Math.pow(radii, 2);

        System.out.printf("%.6f\n", eucArea);
        System.out.printf("%.6f\n", taxArea);

    }
}
