import java.util.Arrays;
import java.util.Scanner;

public class AnotherCandies {

    public Scanner scan;
    public long children;
    public long totalCandy;

    public static void main(String[] args){
        AnotherCandies a = new AnotherCandies();
        a.solveIssues();
    }

    private void solveIssues() {
        scan = new Scanner(System.in);
        int testcases = scan.nextInt(), i = 0;

        while(i < testcases) {
            scan.nextLine(); // Blank line
            children = scan.nextLong();
            totalCandy = 0;
            for (int j = 0; j < children; j++) {
                totalCandy += (scan.nextLong() % children);
            }

            if(totalCandy % children == 0) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }


            i++;
        }
    }
}
