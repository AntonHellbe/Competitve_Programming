import java.util.Scanner;

public class PhDCandidate {

    public Scanner scan;

    public static void main(String[] args){
        PhDCandidate p = new PhDCandidate();
        p.solveIssue();
    }

    private void solveIssue() {
        scan = new Scanner(System.in);
        int numberofLines = Integer.parseInt(scan.nextLine());
        String line = "";

        for (int i = 0; i < numberofLines; i++) {
            String[] lines = scan.nextLine().split("\\+|=");

            if(lines[0].equals("P") || lines[1].equals("NP")) {
                System.out.println("skipped");
            }else{
                System.out.println(Integer.parseInt(lines[0]) + Integer.parseInt(lines[1]));
            }

        }
    }
}
