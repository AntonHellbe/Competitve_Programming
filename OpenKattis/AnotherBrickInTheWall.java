import java.util.Scanner;

public class AnotherBrickInTheWall {

    public Scanner scan;

    public static void main(String[] args){
        AnotherBrickInTheWall b = new AnotherBrickInTheWall();
        b.solveLarsIssue();
    }

    private void solveLarsIssue() {
        scan = new Scanner(System.in);
        double h = scan.nextDouble();
        int w = scan.nextInt(), bricks = scan.nextInt();
        int[] brickPile = new int[bricks];

        for (int i = 0; i < bricks; i++) {
            brickPile[i] = scan.nextInt();
        }

        int widthCopy = w;
        for (int i = 0; i < brickPile.length; i++) {
            widthCopy -= brickPile[i];

            if(widthCopy == 0) {
                widthCopy = w;
                h--;
                if(h == 0) {
                    System.out.println("YES");
                    return;
                }
            }else if(widthCopy < 0) {
                System.out.println("NO");
                return;
            }

        }
    }
}
