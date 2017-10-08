import java.util.Scanner;

/**
 * Created by Anton on 2017-10-07.
 */
public class AllinAll {
    static Scanner scan;

    public static void main(String[] args){
        scan = new Scanner(System.in);
        decodeString();
        scan.close();
        System.exit(0);

    }

    static void decodeString() {
        while(scan.hasNextLine()){
            String[] temp;
            temp = scan.nextLine().split(" ");
            String sequence = temp[0];
            String encodedString = temp[1];

            int counter = 0;

            for (int i = 0; i < encodedString.length(); i++) {
                if(counter == sequence.length())
                    break;

                if(encodedString.charAt(i) == sequence.charAt(counter)){
                    counter++;
                }
            }

            if(counter == sequence.length()){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }

        }

        return;
    }
}
