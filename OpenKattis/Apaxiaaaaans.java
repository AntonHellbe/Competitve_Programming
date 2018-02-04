import java.util.Arrays;
import java.util.Scanner;

public class Apaxiaaaaans {

    static Scanner sc;

    public static void main(String[] args){
        sc = new Scanner(System.in);
        fixName(sc.nextLine().toString());
    }

    static void fixName(String name) {
        String newName = "";
        for (int i = 0; i < name.length(); i++) {
            if(newName.length() > 0 && newName.charAt(newName.length() - 1) == name.charAt(i)) {
                continue;
            }else {
                newName += name.charAt(i);
            }
        }

        System.out.println(newName);

    }
}
