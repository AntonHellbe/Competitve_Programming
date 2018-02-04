import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class modulo {

    static Scanner scan;

    public static void main(String[] args){
        scan = new Scanner(System.in);

        solveModulo42();

    }

    static void solveModulo42() {
        ArrayList<Integer> numbers = new ArrayList();
        HashSet<Integer> distNumbers = new HashSet<>(); // Only distinct numbers
        while(true) {
            try {
                numbers.add(Integer.parseInt(scan.nextLine()));
            }catch(Exception e){
                break;
            }
        }

        numbers.forEach((value) -> {
            distNumbers.add(value % 42);
        });

        System.out.println(distNumbers.size());

    }
}
