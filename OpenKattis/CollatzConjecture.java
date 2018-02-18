import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CollatzConjecture {

    public BufferedReader br;
    public HashMap<Long, Long> memoryMap;

    public static void main(String[] args) throws IOException {
        CollatzConjecture c = new CollatzConjecture();
        c.solve();
    }

    private void solve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String[] split = br.readLine().split(" ");

            int a = Integer.valueOf(split[0]), b = Integer.valueOf(split[1]);

            long aCopy = a, bCopy = b;
            if (a + b == 0){
                return;
            }

            memoryMap = new HashMap<>();
            long aSteps = 0, bSteps = 0;

            while(aCopy != 1) {

                if (memoryMap.get(aCopy) == null)
                    memoryMap.put(aCopy, aSteps);

                if (aCopy % 2 == 0) {
                    aCopy /= 2;
                } else {
                    aCopy = (aCopy * 3) + 1;
                }

                aSteps += 1;
            }

            memoryMap.put(aCopy, aSteps);


            Long num = null;
            Long tempSteps = null;
            while(bCopy != 1) {
                if (num == null && memoryMap.containsKey(bCopy)) {
                    num = bCopy;
                    tempSteps = bSteps;
                    break;
                }

                if (bCopy % 2 == 0) {
                    bCopy /= 2;
                } else {
                    bCopy = (bCopy * 3) + 1;
                }

                bSteps += 1;

            }

            if(num == null){
                num = (long) 1;
                tempSteps = bSteps;
            }

            System.out.println(a + " needs " + (memoryMap.get(num)) + " steps, " + b + " needs " + (tempSteps) + " steps, they meet at " + num);

        }



    }

}
