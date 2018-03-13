import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PigLatin {

    public BufferedReader br;
    public char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'y'};

    public static void main(String[] args) throws IOException {
        PigLatin pig = new PigLatin();
        pig.translateText();
    }

    private void translateText() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[] split;

        while((line = br.readLine()) != null){

            if(line.equals("")) return;

            split = line.split(" ");

            for (int i = 0; i < split.length; i++) {

                boolean firstVowels = false;
                for (int j = 0; j < vowels.length; j++) {
                    if(vowels[j] == split[i].charAt(0)){
                        firstVowels = true;
                    }
                }

                if(firstVowels){
                    System.out.print(split[i] + "yay ");
                }

                if(!firstVowels){
                    int vowelIndex = 0;
                    String newLine = "";
                    outer: for (int j = 0; j < split[i].length(); j++) {
                        for (int k = 0; k < vowels.length; k++) {
                            if(split[i].charAt(j) == vowels[k]){
                                vowelIndex = j;
                                break outer;
                            }
                        }
                    }

                    newLine = split[i].substring(vowelIndex) + split[i].substring(0, vowelIndex) + "ay ";
                    System.out.print(newLine);


                }

            }

            System.out.println("");

        }

    }
}
