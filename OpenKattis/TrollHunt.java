import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrollHunt {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        TrollHunt t = new TrollHunt();
        t.calcDays();
    }

    private void calcDays() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        int bridges = Integer.valueOf(split[0]) - 1;
        int knightGroups = Integer.valueOf(split[1]) / Integer.valueOf(split[2]);

        if(bridges % knightGroups == 0){
            //Even means that the days taken is bridges divided by groups
            System.out.println(bridges / knightGroups);
        }else{
            //Uneven needs an extra day
            System.out.println((bridges / knightGroups) + 1);
        }

    }
}
