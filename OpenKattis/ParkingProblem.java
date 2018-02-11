import java.util.Arrays;
import java.util.Scanner;

public class ParkingProblem {

    public Scanner scan;
    public int[] parkingSpots;

    public static void main(String[] args){
        ParkingProblem p = new ParkingProblem();
        p.solve();
    }

    private void solve() {
        scan = new Scanner(System.in);

        int testcases = Integer.parseInt(scan.nextLine()), i = 0;
        while(i < testcases) {
            int storesToVisit = scan.nextInt();
            parkingSpots = new int[storesToVisit];

            for (int j = 0; j < storesToVisit; j++) {
                parkingSpots[j] = scan.nextInt();
            }

//            Arrays.sort(parkingSpots);

            int round = Arrays.stream(parkingSpots).max().getAsInt() - Arrays.stream(parkingSpots).min().getAsInt();

            System.out.println(round * 2);

            i++;


        }

    }
}
