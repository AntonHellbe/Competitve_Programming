import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class EcologicalPremium {
    static Scanner scan;
    static int totalMoney;



    public static void main(String[] args){
        scan = new Scanner(System.in);
        int i = 0, testCases = Integer.parseInt(scan.nextLine());
        while(i != testCases){
            budgetCalc();
            i++;
        }

    }

    static void budgetCalc(){
        int[] farmInformation;
        totalMoney = 0;
        int yardSize, animals, equipmentStatus;

        int rows = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < rows; i++) {
            String[] line = scan.nextLine().split(" ");
            farmInformation = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
            yardSize = farmInformation[0];
            animals = farmInformation[1];
            equipmentStatus = farmInformation[2];
            totalMoney += Math.round(((float) yardSize / animals * equipmentStatus * animals));

        }

        System.out.println(totalMoney);
    }


}
