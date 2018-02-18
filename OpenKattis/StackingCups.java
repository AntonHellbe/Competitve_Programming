import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class StackingCups {

    public BufferedReader br;
    public int numberOfCups;
    public TreeMap<Integer, String> cupMap;

    public static void main(String[] args) throws IOException{
        StackingCups s = new StackingCups();
        s.stackTheCups();
    }

    private void stackTheCups() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        String[] lines;

        lines = br.readLine().split(" ");
        numberOfCups = Integer.parseInt(lines[0]);
        cupMap = new TreeMap<>();
        int radius;
        String color;
        for (int i = 0; i < numberOfCups; i++) {
            lines = br.readLine().split(" ");
            try{
                color = lines[0];
                radius = Integer.parseInt(lines[1]);
                cupMap.put(radius, color);
            }catch(NumberFormatException e){
                radius = Integer.parseInt(lines[0]) / 2;
                color = lines[1];
                cupMap.put(radius, color);
            }
        }


        cupMap.forEach((k , v) -> {
            System.out.println(v);
        });

    }
}
