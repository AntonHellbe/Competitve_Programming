import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CurseTheDarkness {

    public BufferedReader br;
    public static final double RADIUS = 8.0;

    public static void main(String[] args) throws IOException {
        CurseTheDarkness c = new CurseTheDarkness();
        c.calcDist();
    }

    public void calcDist() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;
        int testCases = Integer.valueOf(br.readLine()), t = 0;

        outer: while(t < testCases) {
            split = br.readLine().split(" ");
            double bookX = Double.valueOf(split[0]);
            double bookY = Double.valueOf(split[1]);

            int candles = Integer.valueOf(br.readLine());
            double x, y, dist;
            boolean foundLight = false;

            for (int i = 0; i < candles; i++) {
                split = br.readLine().split(" ");
                x = Double.valueOf(split[0]);
                y = Double.valueOf(split[1]);
                //Shortest distance between 2 points in 2D
                dist = Math.sqrt(Math.pow((x - bookX), 2) + Math.pow((y - bookY), 2));
                if(dist <= RADIUS){
                    foundLight = true;
                }
            }
            if(foundLight)
                System.out.println("light a candle");
            else
                System.out.println("curse the darkness");


            t++;
        }

    }

}
