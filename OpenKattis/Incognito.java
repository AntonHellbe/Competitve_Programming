import javax.swing.text.html.HTMLDocument;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Incognito {

    public BufferedReader br;
    public HashMap<String, Integer> outfitMap;

    public static void main(String[] args) throws IOException {
        Incognito n = new Incognito();
        n.distinctApperances();
    }

    private void distinctApperances() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;
        int testcases = Integer.valueOf(br.readLine()), t = 0;

        while(t < testcases) {
            int lines = Integer.valueOf(br.readLine());
            outfitMap = new HashMap<>();

            for (int i = 0; i < lines; i++) {
                split = br.readLine().split(" ");
                if (outfitMap.containsKey(split[1])) {
                    outfitMap.put(split[1], outfitMap.get(split[1]) + 1);
                } else {
                    outfitMap.put(split[1], 1);
                }
            }

            int totalOutfits = 0;

            for (Map.Entry<String, Integer> entrySet : outfitMap.entrySet()) {
                totalOutfits += entrySet.getValue() + (totalOutfits * entrySet.getValue());
            }


            System.out.println(totalOutfits);
            t++;
        }




    }
}
