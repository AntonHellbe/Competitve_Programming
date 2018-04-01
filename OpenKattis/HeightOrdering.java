import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HeightOrdering {

    public BufferedReader br;

    public static void main(String[] args) throws IOException{
        HeightOrdering h = new HeightOrdering();
        h.go();
    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int dataSets = Integer.valueOf(br.readLine()), t = 0;

        while(t < dataSets) {
            int[] heightArr = new int[21];
            String[] split = br.readLine().split(" ");
            for (int i = 0; i < 21; i++) {
                heightArr[i] = Integer.valueOf(split[i]);
            }

            int steps = 0;
            for (int i = 1; i < heightArr.length; i++) {
                int swaps = 0;
                for (int j = i + 1; j < heightArr.length; j++) {
                    if (heightArr[i] > heightArr[j]) {
                        swaps++;
                    }
                }

                steps += swaps;

            }

            System.out.printf("%d %d\n", heightArr[0], steps);
            t++;
        }

    }

}
