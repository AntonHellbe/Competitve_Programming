import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class JollyJumpers {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        JollyJumpers j = new JollyJumpers();
        j.solveJollyJumpers();
    }

    private void solveJollyJumpers() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        String[] split;

        while((line = br.readLine()) != null) {
            Set<Integer> absSet = new HashSet<>();
            Set<Integer> lengthSet = new HashSet<>();
            split = line.split(" ");

            if(split[0].equals("")) return;

            int numbers = Integer.valueOf(split[0]);
            int num1, num2;
            for (int i = 1; i < numbers; i++) {
                num1 = Integer.valueOf(split[i]);
                num2 = Integer.valueOf(split[i + 1]);
                absSet.add(Math.abs(num1 - num2));
            }

            for (int i = 1; i < numbers; i++) {
                lengthSet.add(i);
            }

            if (absSet.containsAll(lengthSet)) {
                System.out.println("Jolly");
            } else {
                System.out.println("Not jolly");
            }

        }
    }
}
