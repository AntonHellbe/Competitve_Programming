import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TrainPassengers {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        TrainPassengers p = new TrainPassengers();
        p.calcPassengers();
    }

    private void calcPassengers() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;

        split = br.readLine().split(" ");

        int capacity = Integer.valueOf(split[0]);
        int numberOfStops = Integer.valueOf(split[1]);

        int enterTrain = 0, leaveTrain = 0, hadToWait = 0, prev = 0;
        int capacityCpy = capacity;

        for (int i = 0; i < numberOfStops; i++) {
            split = br.readLine().split(" ");
            leaveTrain = Integer.valueOf(split[0]);
            enterTrain = Integer.valueOf(split[1]);
            hadToWait = Integer.valueOf(split[2]);

            capacityCpy -= enterTrain;
            capacityCpy += leaveTrain;

            if(i == 0 && leaveTrain != 0){
                System.out.println("impossible");
                return;
            }

            if(capacityCpy > capacity){
                System.out.println("impossible");
                return;
            }

            if(capacityCpy > 0 && hadToWait != 0){
                System.out.println("impossible");
                return;
            }

            if(capacityCpy < 0){
                System.out.println("impossible");
                return;
            }

            if(capacityCpy == 0 && prev == 1 && leaveTrain == 0){
                System.out.println("impossible");
                return;
            }

            if(i == numberOfStops - 1 && capacityCpy != capacity){
                System.out.println("impossible");
                return;
            }



            prev = enterTrain;

        }

        System.out.println("possible");

    }
}
