import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SavingDaylight {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        SavingDaylight sv = new SavingDaylight();
        sv.go();
    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while((line = br.readLine()) != null) {
            String[] split = line.split(" |:");

            if(split[0].equals("")) return;

            String month = split[0];
            int date = Integer.valueOf(split[1]), year = Integer.valueOf(split[2]);

            int sunriseHour = Integer.valueOf(split[3]), sunriseMinutes = Integer.valueOf(split[4]);
            int sunsetHour = Integer.valueOf(split[5]), sunsetMinutes = Integer.valueOf(split[6]);

            sunsetHour = (sunsetHour - sunriseHour);
            if (sunsetMinutes - sunriseMinutes < 0) {
                sunsetHour--;
                sunsetMinutes = 60 + (sunsetMinutes - sunriseMinutes);
            } else {
                sunsetMinutes = sunsetMinutes - sunriseMinutes;
            }

            System.out.printf("%s %d %d %d hours %d minutes\n", month, date, year, sunsetHour, sunsetMinutes);
        }

    }
}
