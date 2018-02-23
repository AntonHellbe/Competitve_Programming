import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ClosestSums {

    public BufferedReader br;

    public static void main(String[] args) throws IOException{
        ClosestSums c = new ClosestSums();
        c.calcClosestSum();
    }

    private void calcClosestSum() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int cases = 1;
        String line;
        while((line = br.readLine()) != null){
            int numbers = Integer.valueOf(line);

            int[] numberArr = new int[numbers];
            ArrayList<Integer> allSums = new ArrayList<>();
            for (int i = 0; i < numbers; i++) {
                numberArr[i] = Integer.valueOf(br.readLine());
            }


            for (int i = 0; i < numberArr.length; i++) {
                for (int j = i + 1; j < numberArr.length; j++) {
                    allSums.add((numberArr[i] + numberArr[j]));
                }
            }

            int queries = Integer.valueOf(br.readLine());
            int[] queriesArr = new int[queries];
            for (int i = 0; i < queries; i++) {
                queriesArr[i] = Integer.valueOf(br.readLine());
            }
            System.out.println("Case " + cases + ":");
            for (int i = 0; i < queries; i++) {
                int bestAbs = Integer.MAX_VALUE, sum = 0;
                for (int j = 0; j < allSums.size(); j++) {
                    if(Math.abs(queriesArr[i] - allSums.get(j)) < bestAbs){
                        bestAbs = Math.abs(queriesArr[i] - allSums.get(j));
                        sum = allSums.get(j);
                    }
                }
                System.out.println("Closest sum to " + queriesArr[i] + " is " + sum + ".");
            }
            cases++;


        }
    }
}
