import java.util.Arrays;
import java.util.Scanner;

public class Server {


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int input[] = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int tasks = input[0], time = input[1];
        input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < input.length; i++) {
            time -= input[i];
            if(time < 0){
                System.out.println(i);
                return;
            }
        }

        System.out.println(tasks);
    }
}
