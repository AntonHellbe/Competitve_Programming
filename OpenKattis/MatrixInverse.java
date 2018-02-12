import java.util.Scanner;

public class MatrixInverse {

    public Scanner scan;

    public static void main(String[] args){
        MatrixInverse m = new MatrixInverse();
        m.findInverse();
    }

    private void findInverse() {
        scan = new Scanner(System.in);
        int temp = 1;
        while(scan.hasNextInt()) {
            int[][] inverseMat = new int[2][2];
            int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt(), d = scan.nextInt();

            double t = (1 / (a * d - b * c));

            inverseMat[0][0] = d;
            inverseMat[0][1] = -b;
            inverseMat[1][0] = -c;
            inverseMat[1][1] = a;
            System.out.println("Case " + temp + ":");
            for (int i = 0; i < inverseMat.length; i++) {
                for (int j = 0; j < inverseMat[i].length; j++) {
                    inverseMat[i][j] = (int) t * inverseMat[i][j];
                    System.out.print(inverseMat[i][j] + " ");
                }
                System.out.println("");
            }

            scan.nextLine(); // blank
            temp++;

        }



    }
}
