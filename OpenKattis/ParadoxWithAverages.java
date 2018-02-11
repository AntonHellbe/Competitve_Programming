import java.util.Arrays;
import java.util.Scanner;

public class ParadoxWithAverages {

    public Scanner scan;
    public int[] computerScience;
    public int[] economics;
    public double csAverage = 0, eAverage = 0;

    public static void main(String[] args){
        ParadoxWithAverages p = new ParadoxWithAverages();
        p.averageJoke();
    }

    private void averageJoke() {
        scan = new Scanner(System.in);

        int testcases = Integer.parseInt(scan.nextLine()), j = 0;

        while(j < testcases) {

            scan.nextLine(); //blank line;

            int[] input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            computerScience = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            economics = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            csAverage = (double) Arrays.stream(computerScience).sum() / input[0];
            eAverage = (double) Arrays.stream(economics).sum() / input[1];

            double newCsAverage = 0, newEaverage = 0;
            int funnyEvents = 0;

            for (int i = 0; i < computerScience.length; i++) {
                newCsAverage = (double) (Arrays.stream(computerScience).sum() - computerScience[i]) / (input[0] - 1);
                newEaverage = (double) (Arrays.stream(economics).sum() + computerScience[i]) / (input[1] + 1);

                if (newCsAverage > csAverage && newEaverage > eAverage) {
                    funnyEvents++;
                }
            }

            System.out.println(funnyEvents);
            j++;
        }


    }
}
