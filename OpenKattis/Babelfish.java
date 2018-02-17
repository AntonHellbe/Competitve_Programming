import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Babelfish {

    public Scanner scan;
    public HashMap<String, String> dictionary;

    public static void main(String[] args) throws IOException{
        Babelfish b = new Babelfish();
        b.createDictionary();
    }

    private void createDictionary() throws IOException {
        scan = new Scanner(System.in);
        dictionary = new HashMap<>();
        while(true) {
            String[] lines = scan.nextLine().split(" ");
            if(lines[0].length() == 0) {
                break;
            }

            dictionary.putIfAbsent(lines[1], lines[0]);

        }


        while(scan.hasNextLine()){
            String line = scan.nextLine();
            if(line.equals("")){
                break;
            }

            if(dictionary.get(line) != null)
                System.out.println(dictionary.get(line));
            else
                System.out.println("eh");
        }

    }
}
