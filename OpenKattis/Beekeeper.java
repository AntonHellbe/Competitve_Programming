import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Beekeeper {

    public Scanner scan;

    public static void main(String[] args){
        Beekeeper b = new Beekeeper();
        b.solve();
    }

    public int count(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if(s.substring(i, i +2).equals("aa")){
                sum++;
            }
            if(s.substring(i, i +2).equals("ee")){
                sum++;
            }
            if(s.substring(i, i +2).equals("ii")){
                sum++;
            }
            if(s.substring(i, i +2).equals("oo")){
                sum++;
            }
            if(s.substring(i, i +2).equals("uu")){
                sum++;
            }
            if(s.substring(i, i +2).equals("yy")){
                sum++;
            }
        }
        return sum;
    }

    private void solve() {
        scan = new Scanner(System.in);


        while(true) {
            int lines = Integer.parseInt(scan.nextLine());

            if(lines == 0) return;

            String line = "", saved = "";
            int pairs = 0, max = -1, current = 0;

            for (int i = 0; i < lines; i++) {
                line = scan.nextLine();
                for (int j = 0; j < line.length() - 1; j++) {
                    char c = line.charAt(j);
                    if(checkCharacter(c)) {
                        if(c == line.charAt(j + 1)){
                            pairs++;
                        }
                    }
                }
                if(pairs > max) {
                    max = pairs;
                    saved = line;
                }
                pairs = 0;
            }

            System.out.println(saved);






        }

    }

    public boolean checkCharacter(char c) {
        switch(c) {
            case 'a':
                return true;
            case 'e':
                return true;
            case 'i':
                return true;
            case 'o':
                return true;
            case 'u':
                return true;
            case 'y':
                return true;
            default:
                return false;
        }
    }
}
