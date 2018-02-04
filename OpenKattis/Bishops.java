import java.util.Scanner;

public class Bishops {

    static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        solveBishops();
    }

    private static void solveBishops() {
        //formula for bishops is 2n - 2
        while (scan.hasNextLine()) {
            try {
                int dimension = Integer.parseInt(scan.nextLine());
                if(dimension == 1) {
                    System.out.println(1);
                } else {
                    System.out.println(2 * dimension - 2);
                }
            } catch (Exception e) {
                break;
            }
        }

    }


}
