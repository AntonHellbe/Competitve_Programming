import java.io.BufferedReader;
import java.util.*;

public class CompoundWords {

    public Scanner scan;

    public static void main(String[] args){
        CompoundWords w = new CompoundWords();
        w.findAllWords();
    }

    private void findAllWords() {
        scan = new Scanner(System.in);
        HashSet<String> uniqueWords = new HashSet<>();
        ArrayList<String> wordList = new ArrayList<>();
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            if(line.equals("")) break;
            wordList.addAll(Arrays.asList(line.split(" ")));
        }

        String t = "";
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < wordList.size(); j++) {
                if(i != j) {
                    t = wordList.get(i) + wordList.get(j);
                    uniqueWords.add(t);
                }
            }
        }

        wordList.clear();
        wordList.addAll(uniqueWords);
        wordList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        wordList.forEach((w) -> {
            System.out.println(w);
        });
    }
}
