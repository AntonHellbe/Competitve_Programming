import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BabylonianNumbers {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        BabylonianNumbers b = new BabylonianNumbers();
        b.solveShit();
    }

    private void solveShit() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.valueOf(br.readLine()), t = 0;

        while(t < testCases) {
            String line = br.readLine();

            line = parseLine(line);

            String[] split = line.split(",");

            int factor = split.length - 1;
            long sum = 0;

            for (int i = 0; i < split.length; i++) {
                sum += (long) Math.pow(60, factor--) * Integer.valueOf(split[i]);
            }

            System.out.println(sum);

            t++;
        }

    }



    public String parseLine(String line) {
        for (int i = 0; i < line.length() - 1; i++) {
            if(line.substring(i, i + 2).equals(",,")){
                line = line.substring(0, i + 1) + "0" + line.substring(i + 1);
            }
        }

        if(line.charAt(line.length() - 1) == ','){
            line += "0";
        }

        return line;

    }



}
