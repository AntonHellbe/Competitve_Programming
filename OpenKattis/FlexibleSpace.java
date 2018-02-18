import java.util.Scanner;

public class FlexibleSpace {

    public Scanner scan;

    public static void main(String[] args){
        FlexibleSpace f = new FlexibleSpace();
        f.solveIssue();
    }

    private void solveIssue() {
        scan = new Scanner(System.in);
        int width = scan.nextInt();
        int partitions = scan.nextInt();

        int[] allPartitions = new int[partitions];
        boolean[] possiblePartitions = new boolean[width + 1];
        possiblePartitions[width] = true;

        for (int i = 0; i < partitions; i++) {
            allPartitions[i] = scan.nextInt();
        }

        for (int i = 0; i < allPartitions.length; i++) {
            possiblePartitions[allPartitions[i]] = true;
            possiblePartitions[width - allPartitions[i]] = true;
        }

        for (int i = 0; i < allPartitions.length; i++) {
            for (int j = i + 1; j < allPartitions.length; j++) {
                possiblePartitions[allPartitions[j] - allPartitions[i]] = true;
            }
        }

        for (int i = 1; i < possiblePartitions.length; i++) {
            if(possiblePartitions[i])
                System.out.print(i + " ");
        }


        
    }
}
