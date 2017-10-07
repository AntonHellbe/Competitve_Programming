import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Anton on 2017-10-07.
 */
public class NotSoMobile {

    static Scanner scan;
    static Boolean balanced = true;

    public static void main(String[] args){
        scan = new Scanner(System.in);
        int i = 0, testCases = Integer.parseInt(scan.nextLine());
        //System.out.println(testCases);
        for (int j = 0; j <= testCases - 1; j++) {
            String emptyLine = scan.nextLine();
            fulcrum();
            if(balanced){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            balanced = true;
            if(j != testCases - 1){
                System.out.println("");
            }
        }

        scan.close();
        System.exit(0);
    }

    static int fulcrum() {

        String line = scan.nextLine();
//        System.out.println(line);
        int[] fulcrumWeights;
        if(line.isEmpty()){
            return 0;
        }
        fulcrumWeights = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int wl = fulcrumWeights[0], dl = fulcrumWeights[1], wr = fulcrumWeights[2], dr = fulcrumWeights[3];

        if(wl == 0){
            wl = fulcrum();
        }

        if(wr == 0){
            wr = fulcrum();
        }

        if((wl * dl) != (wr * dr)){
            balanced = false;
        }

        return wl + wr;
    }
}
