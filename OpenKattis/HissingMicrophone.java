import java.util.Scanner;
import java.util.regex.Pattern;

public class HissingMicrophone {

    static Scanner scan;

    public static void main(String[] args){
        scan = new Scanner(System.in);
        String line = scan.nextLine();
        int counter = 0;
        for (int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == 's')
                counter++;
            else
                counter = 0;

            if(counter > 1) {
                System.out.println("hiss");
                return;
            }
        }

        System.out.println("no hiss");


    }
}
