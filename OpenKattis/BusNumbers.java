import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BusNumbers {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        BusNumbers b = new BusNumbers();
        b.minRepresentation();
    }

    private void minRepresentation() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] lines;

        int numbers = Integer.parseInt(br.readLine());
        int[] busNumbers = new int[numbers];
        lines = br.readLine().split(" ");

        for (int i = 0; i < numbers; i++) {
            busNumbers[i] = Integer.parseInt(lines[i]);
        }

        Arrays.sort(busNumbers);
        String s = "";
        int count = 0;


        for (int i = 0; i < busNumbers.length; i++) {
            if(i != busNumbers.length - 1 && busNumbers[i + 1] - busNumbers[i] == 1){
                if(count == 0){
                    if(s.length() == 0) {
                        s += busNumbers[i];
                    }else {
                        s += " " + busNumbers[i];
                    }
                }
                count += 1;
            }

            if(i != busNumbers.length - 1 && busNumbers[i + 1] - busNumbers[i] > 1){
                if(count >= 2){
                    s += "-" + busNumbers[i];
                }else {
                    s += " " + busNumbers[i];
                }
                count = 0;
            }

            if(i == busNumbers.length - 1){
                if(count >= 2){
                    s += "-" + busNumbers[i];
                }else {
                    s += " " + busNumbers[i];
                }
            }
        }

        System.out.println(s);

    }
}
