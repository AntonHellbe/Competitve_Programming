import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class TouchScreen {

    public BufferedReader br;

    public char[][] keyboard = {
            {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
            {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
            {'z', 'x', 'c', 'v', 'b', 'n', 'm'}
    };

    public class Pair{
        int y, x;

        public Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public class Word implements Comparable<Word> {
        String word;
        int dist;

        public Word(String word, int dist){
            this.word = word;
            this.dist = dist;
        }


        @Override
        public int compareTo(Word o) {
            if(this.dist == o.dist){
                return this.word.compareTo(o.word);
            }

            return Integer.compare(this.dist, o.dist);
        }
    }


    public static void main(String[] args) throws IOException {
        TouchScreen s = new TouchScreen();
        s.fixShit();
    }

    private void fixShit() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;
        int testCases = Integer.valueOf(br.readLine()), t = 0;

        while(t < testCases){
            split = br.readLine().split(" ");
            String word = split[0];
            int comparisons = Integer.valueOf(split[1]);
            Word[] wordsDist = new Word[comparisons];
            Pair[] initialWordDist = new Pair[word.length()];

            for (int i = 0; i < keyboard.length; i++) {
                for (int j = 0; j < keyboard[i].length; j++) {
                    for (int k = 0; k < word.length(); k++) {
                        if(word.charAt(k) == keyboard[i][j]){
                            initialWordDist[k] = new Pair(i, j);
                        }
                    }
                }
            }

//            for (int i = 0; i < initialWordDist.length; i++) {
//                System.out.println(initialWordDist[i].y + " " + initialWordDist[i].x);
//            }

            //System.out.println("-----------------");

            for (int i = 0; i < comparisons; i++) {
                String comparisonWord = br.readLine();
                int dist = 0;
                for (int j = 0; j < keyboard.length; j++) {
                    for (int k = 0; k < keyboard[j].length; k++) {

                        for (int l = 0; l < comparisonWord.length(); l++) {
                            if (comparisonWord.charAt(l) == keyboard[j][k]) {
                                dist += (Math.abs(initialWordDist[l].y - j)) + Math.abs((initialWordDist[l].x) - k);
                            }
                        }
                    }

                }
                wordsDist[i] = new Word(comparisonWord, dist);
            }

            Arrays.sort(wordsDist, Word::compareTo);
            for (int i = 0; i < comparisons; i++) {
                System.out.println(wordsDist[i].word + " " + wordsDist[i].dist);
            }
//            System.out.println("-----------------");


            t++;

        }
    }
}
