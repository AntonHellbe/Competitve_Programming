import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MirrorImages {

    public BufferedReader br;


    public static void main(String[] args) throws IOException {
        MirrorImages mi = new MirrorImages();
        mi.dispImages();
    }

    private void dispImages() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[] split;
        int testCases = Integer.valueOf(br.readLine()), t = 0;
        Stack<String> q = new Stack<>();

        while(t < testCases) {
            split = br.readLine().split(" ");
            int rows = Integer.valueOf(split[0]);
            for (int i = 0; i < rows; i++) {
                q.add(br.readLine());
            }
            System.out.println("Test " + (t+ 1));
            while(!q.isEmpty()){
                line = q.pop();
                for (int i = line.length() - 1; i >= 0; i--) {
                    System.out.print(line.charAt(i));
                }

                System.out.println("");
            }


            t++;


        }

    }
}
