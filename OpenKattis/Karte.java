import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Karte {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        Karte k = new Karte();
        k.go();

    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        ArrayList<String> s = new ArrayList<>();

        for (int i = 1; i <= line.length(); i++) {
            if(i % 3 == 0) s.add(line.substring(i - 3, i));
        }


        HashSet<String> t = new HashSet<>(s);

        //Duplicate cards
        if(t.size() != s.size()) {
            System.out.println("GRESKA");
            return;
        }

        //No duplicates
        int[] cardCount = { 13, 13, 13 ,13 };

        for (int i = 0; i < s.size(); i++) {
            reduceNumber(s.get(i).charAt(0), cardCount);
        }

        for (int i = 0; i < cardCount.length; i++) {
            System.out.print(cardCount[i] + " ");
        }




    }

    public void reduceNumber(char c, int[] arr) {
        switch(c) {
            case 'P':
                arr[0]--;
                break;
            case 'K':
                arr[1]--;
                break;
            case 'H':
                arr[2]--;
                break;
            case 'T':
                arr[3]--;
                break;
        }
    }
}
