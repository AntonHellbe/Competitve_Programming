import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Anton on 2017-10-06.
 */
public class DecodeTheTape {
    static ArrayList<String> allRows;

    static Scanner scan;

    public static void main(String[] args){
        scan = new Scanner(System.in);
        decodeTape();

    }

    static void decodeTape(){
        String message = "";
        allRows = new ArrayList<>();
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            if(line.charAt(0) != '_') {
                line = line.replaceAll("[\\s]", "0").replaceAll("[\\.]", "").replaceAll("[o]", "1").replaceAll("[\\|]", "");
                message += (char) (Integer.parseInt(line, 2)); //Binary to Int -> Char
            }
        }
        System.out.print(message);
    }
}
