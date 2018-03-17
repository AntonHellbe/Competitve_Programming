import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SidewaySorting {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        SidewaySorting s = new SidewaySorting();
        s.sortSideways();
    }

    private void sortSideways() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;


        while(true){
            split = br.readLine().split(" ");
            int rows = Integer.valueOf(split[0]), cols = Integer.valueOf(split[1]);
            if(rows == 0 && cols == 0) return;
            String[] allCols = new String[cols];

            for (int i = 0; i < allCols.length; i++) {
                allCols[i] = "";
            }

            for (int i = 0; i < rows; i++) {

                split = br.readLine().split("");

                int colCount = 0;

                for (int j = 0; j < split.length; j++) {
                    allCols[colCount] += split[j]; //Create each column from the read row by reading one character per row
                    colCount += 1;
                }
            }


            Arrays.sort(allCols, (a, b) -> a.toLowerCase().compareTo(b.toLowerCase())); // Sort by column and lowercase


            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(allCols[j].charAt(i));
                }

                System.out.println("");
            }
            System.out.println("");

        }

    }
}
