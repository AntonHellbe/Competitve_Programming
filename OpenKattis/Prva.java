import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Prva {

    public BufferedReader br;
    public char[][] crosswordPuzzle;
    public String smallestWord = "";

    public static void main(String[] args) throws IOException {
        Prva p = new Prva();
        p.go();
    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;


        split = br.readLine().split(" ");
        int rows = Integer.valueOf(split[0]), cols = Integer.valueOf(split[1]);

        crosswordPuzzle = new char[rows][cols];
        ArrayList<String> allWords = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < cols; j++) {
                crosswordPuzzle[i][j] = c[j];
            }
        }

        for (int i = 0; i < rows; i++) {
            String s = "";
            int count = 0;
            for (int j = 0; j < cols; j++) {
                if(crosswordPuzzle[i][j] == '#'){
                    if(count >= 2) allWords.add(s);
                    count = 0;
                    s = "";
                }

                if(crosswordPuzzle[i][j] != '#') {
                    s += crosswordPuzzle[i][j];
                    count++;
                }
            }

            if(count >= 2){
                allWords.add(s);
            }

        }

        for (int i = 0; i < cols; i++) {
            String s = "";
            int count = 0;
            for (int j = 0; j < rows; j++) {
                if(crosswordPuzzle[j][i] == '#'){
                    if(count >= 2) allWords.add(s);
                    count = 0;
                    s = "";
                }

                if(crosswordPuzzle[j][i] != '#') {
                    s += crosswordPuzzle[j][i];
                    count++;
                }
            }

            if(count >= 2){
                allWords.add(s);
            }

        }


        allWords.sort(String::compareTo);

        System.out.println(allWords.get(0));


    }


    public void lexiWord(String s){
        int lengthDiff = Math.min(s.length(), smallestWord.length());
        for (int i = 0; i < lengthDiff; i++) {
            if((s.charAt(i) - 'a') == (smallestWord.charAt(i) - 'a')){
                continue;
            }else if((s.charAt(i) - 'a') < smallestWord.charAt(i)){
                smallestWord = s;
            }else{
                return;
            }
        }

        if(smallestWord.length() == 0){
            smallestWord = s;
        }

    }
}
