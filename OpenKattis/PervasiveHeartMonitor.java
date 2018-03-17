import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PervasiveHeartMonitor {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        PervasiveHeartMonitor h = new PervasiveHeartMonitor();
        h.solve();
    }

    private void solve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;
        String line = "";
        while((line = br.readLine()) != null) {
            if(line.equals("")) return;

            split = line.split(" ");

            String name = "";
            double average = 0;
            int nameFields = 0;

            for (int i = 0; i < split.length; i++) {
                try {
                    average += Double.valueOf(split[i]);
                } catch (NumberFormatException e) {
                    name += split[i] + " ";
                    nameFields++;
                }
            }

            average = (average / (split.length - nameFields));

            System.out.printf("%.6f %s\n", average, name);
        }

    }
}
