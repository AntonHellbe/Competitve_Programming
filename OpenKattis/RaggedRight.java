import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RaggedRight {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        RaggedRight r = new RaggedRight();
        r.computeRaggedness();
    }

    private void computeRaggedness() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        ArrayList<String> lines = new ArrayList<>();
        int max = 0, index = 0;

        for (int i = 0; i < 100 && (line = br.readLine()) != null; i++) {
            if(line.equals("")) break;

            if(line.length() > max){
                max = line.length();
                index = i;
            }
            lines.add(line);
        }

        int raggedness = 0;

        for (int i = 0; i < lines.size() - 1; i++) {
            if(i != index){
                raggedness += Math.pow((max - lines.get(i).length()), 2);
            }
        }

        System.out.println(raggedness);

    }



}
