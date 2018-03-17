import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LineThemUp {

    public BufferedReader br;
    public static final int INCREASING = 1, DECREASING = -1;

    public static void main(String[] args) throws IOException {
        LineThemUp t = new LineThemUp();
        t.findOrdering();
    }

    private void findOrdering() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int numNames = Integer.valueOf(br.readLine());
        String[] names = new String[numNames];

        for (int i = 0; i < numNames; i++) {
            names[i] = br.readLine();
        }

        int ordering = 0, compValue = 0;

        for (int i = 1; i < names.length; i++) {

            if(i == 1) {
                compValue = names[i].compareTo(names[i - 1]);
                if(compValue < 0)
                    ordering = DECREASING;
                else
                    ordering = INCREASING;
            }

            if(ordering == DECREASING){
                compValue = names[i].compareTo(names[i - 1]);
                if(compValue > 0){
                    System.out.println("NEITHER");
                    return;
                }
            }

            if(ordering == INCREASING){
                compValue = names[i].compareTo(names[i - 1]);
                if(compValue < 0){
                    System.out.println("NEITHER");
                    return;
                }
            }
        }

        if(ordering == INCREASING){
            System.out.println("INCREASING");
        }

        if(ordering == DECREASING){
            System.out.println("DECREASING");
        }

    }
}
