import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class AlmostPerfect {
    
    public BufferedReader br;
    
    public static void main(String[] args) throws IOException {
        AlmostPerfect ap = new AlmostPerfect();
        ap.tryToSolve();
    }

    private void tryToSolve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null) {
            if(str.equals("")) return;
            int number = Integer.parseInt(str);

            long sumDivisors = getAllDivisors(number);


            long diff = number - sumDivisors;

            if(diff != 0){
                if(Math.abs(diff) > 2){
                    System.out.println(number + " not perfect");
                }else if(Math.abs(diff) <= 2){
                    System.out.println(number + " almost perfect");
                }
            }else {
                System.out.println(number + " perfect");
            }
        }

    }
    
    
    private long getAllDivisors(int number) {
        long sum = 1;
        long maxD = (long) Math.sqrt(number);
        long d;
        for (int i = 2; i <= maxD; i++) {
            if(number % i == 0){
                sum += i;
                if(i != number / i){
                    sum += number / i;
                }
            }
        }

        return sum;
    }
}
