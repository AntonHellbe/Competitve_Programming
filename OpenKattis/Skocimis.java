import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Skocimis {

    public BufferedReader br;

    public static void main(String[] args) throws IOException{
        Skocimis s = new Skocimis();
        s.go();
    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int a = Integer.valueOf(split[0]);
        int b = Integer.valueOf(split[1]);
        int c = Integer.valueOf(split[2]);

        int dist1 = (b - a) - 1, dist2 = (c - b) - 1;

        if(dist1 > dist2)
            System.out.println(dist1);
        else
            System.out.println(dist2);
    }
}
