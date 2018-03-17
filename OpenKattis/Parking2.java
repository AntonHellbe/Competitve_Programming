import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Parking {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        Parking p = new Parking();
        p.calcParkingCost();
    }


    public class ParkingTime{
        int startTime, endTime, totalTime;

        public ParkingTime(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
            this.totalTime = endTime - startTime;
        }
    }

    private void calcParkingCost() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;


        split = br.readLine().split(" ");
        int[] costs = new int[4];
        costs[0] = 0;
        for (int i = 0; i < 3; i++) {
            costs[i + 1] = Integer.valueOf(split[i]);
        }

        ParkingTime[] times = new ParkingTime[3];
        int max = 0;
        for (int i = 0; i < 3; i++) {
            split = br.readLine().split(" ");
            int start = Integer.valueOf(split[0]), end = Integer.valueOf(split[1]);
            times[i] = new ParkingTime(start, end);
            max = Math.max(max, end);
        }

        int[] calcTimes = new int[max + 1];

        for (int i = 0; i < times.length; i++) {
            for (int j = times[i].startTime; j < times[i].endTime; j++) {
                calcTimes[j]++;
            }
        }


//        for (int i = 1; i < calcTimes.length; i++) {
//            System.out.print(calcTimes[i] + " ");
//        }

        int totalCost = 0;

        for (int i = 1; i < calcTimes.length; i++) {
            switch(calcTimes[i]){
                case 1:
                    totalCost+= costs[calcTimes[i]];
                    break;
                case 2:
                    totalCost += costs[calcTimes[i]] * 2;
                    break;
                case 3:
                    totalCost+= costs[calcTimes[i]] * 3;
                    break;
            }
        }

        System.out.println(totalCost);

    }
}
