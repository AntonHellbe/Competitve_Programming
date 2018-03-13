import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class HayPoint {

    public BufferedReader br;
    public HashMap<String, Integer> salaryDict;

    public static void main(String[] args) throws IOException {
        HayPoint p = new HayPoint();
        p.administerStuff();
    }

    private void administerStuff() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;

        split = br.readLine().split(" ");

        int salaryWords = Integer.valueOf(split[0]);
        int descriptions = Integer.valueOf(split[1]);
        salaryDict = new HashMap<>();

        for (int i = 0; i < salaryWords; i++) {
            split = br.readLine().split(" ");
            salaryDict.put(split[0], Integer.valueOf(split[1]));
        }

//        salaryDict.forEach((k, v) -> {
//            System.out.println(k + " " + v);
//        });
//
//        System.out.println("------------");


        for (int i = 0; i < descriptions; i++) {
            int salarySum = 0;
            while(true){
                split = br.readLine().split(" ");
                if(split[0].equals(".")) break;

                for (int j = 0; j < split.length; j++) {
                    if(salaryDict.get(split[j]) != null) salarySum += salaryDict.get(split[j]);
                }
            }
            System.out.println(salarySum);
        }


    }
}
