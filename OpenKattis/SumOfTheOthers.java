import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumOfTheOthers {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        SumOfTheOthers s = new SumOfTheOthers();
        s.go();
    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while((line = br.readLine()) != null){

            String[] split = line.split(" ");

            if(split[0].equals("")) return;

            int[] nums = new int[split.length];

            for (int i = 0; i < split.length; i++) {
                nums[i] = Integer.valueOf(split[i]);
            }

            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = 0; j < nums.length; j++) {

                    if(i != j) sum += nums[j];

                }
                if(sum == nums[i]) {
                    System.out.println(nums[i]);
                    break;
                }
            }

        }

    }

}
