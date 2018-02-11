import java.util.Arrays;
import java.util.Scanner;

public class PrimaryRegister {

    public Scanner scan;
    public int[] registerValues;
    public int[] primeArray = { 2, 3, 5, 7, 11, 13, 17, 20 };
    public int increments = 0;

    public static void main(String[] args){
        PrimaryRegister primaryRegister = new PrimaryRegister();

        primaryRegister.solveRegisterIssue();
    }

    private void solveRegisterIssue() {
        scan = new Scanner(System.in);

        registerValues = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int length = registerValues.length - 1;
        for (int i = 0; i < 100000000; i++) {
            updateRegisterValues();
            increments++;
            if(registerValues[length] == 19) {
                System.out.println(increments - 1);
                break;
            }
        }
    }

    private void updateRegisterValues() {
        registerValues[0] += 1;
        for (int j = 0; j < registerValues.length; j++) {
            if(registerValues[j] != 0 && registerValues[j] % primeArray[j] == 0){
                registerValues[j] = 0;
                registerValues[j + 1] += 1;
//                increments++;
            }
        }
    }
}
