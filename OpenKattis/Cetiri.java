import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Cetiri {

    public BufferedReader br;

    public static void main(String[] args) throws IOException{
        Cetiri c = new Cetiri();
        c.solve();
    }

    private void solve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] lines;
        lines = br.readLine().split(" ");
        int[] numbers = new int[lines.length];
        int[] diff = new int[lines.length - 1];
        for (int i = 0; i < lines.length; i++) {
            numbers[i] = Integer.parseInt(lines[i]);
        }

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 1; i++) {
            diff[i] = numbers[i + 1] - numbers[i];
        }

        if(diff[0] == diff[1]){
            System.out.println(numbers[numbers.length - 1] + diff[0]);
        }else if(diff[0] > diff[1]){
            System.out.println(numbers[1] - diff[0] / 2);
        }else{
            System.out.println(numbers[numbers.length - 1] - diff[1] / 2);
        }
    }
}
