import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class WhatDoesTheFoxSay {

    public BufferedReader br;
    public HashMap<String, String> animalMap;

    public static void main(String[] args) throws IOException{
        WhatDoesTheFoxSay w = new WhatDoesTheFoxSay();
        w.whatDoesTheFoxActullySay();
    }

    private void whatDoesTheFoxActullySay() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[] animalSounds;
        String[] split;

        int testCases = Integer.valueOf(br.readLine()), t = 0;

        while(t < testCases) {

            animalSounds = br.readLine().split(" ");
            animalMap = new HashMap<>();
            line = br.readLine();
            //System.out.println(line);
            while(!line.equals("what does the fox say?")){
                split = line.split(" ");
//                System.out.println(split[2] + " " + split[0]);
                animalMap.put(split[2], split[0]);

                line = br.readLine();
//                System.out.println(line);
            }

            for (int i = 0; i < animalSounds.length; i++) {
                if(animalMap.get(animalSounds[i]) == null){
                    System.out.print(animalSounds[i] + " ");
                }
            }

            System.out.println("");

            t++;

        }

    }
}
