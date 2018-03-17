import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Yoda {

    public BufferedReader br;

    public static void main(String[] args) throws IOException{
        Yoda y = new Yoda();
        y.findFallOut();
    }

    private void findFallOut() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        String start = "";
        String topNumbers = br.readLine();
        String bottomNumbers = br.readLine();

        int max = Math.max(topNumbers.length(), bottomNumbers.length());

        // Pad if the length differs
        bottomNumbers = String.format("%" + max + "s", bottomNumbers).replace(' ', '0');
        topNumbers = String.format("%" + max + "s", topNumbers).replace(' ', '0');



        String top = "", bottom = "";

        for (int i = 0; i < max; i++) {
            if(topNumbers.charAt(i) - '0' > bottomNumbers.charAt(i) - '0'){
                top += (topNumbers.charAt(i) - '0');
            }else if(bottomNumbers.charAt(i) - '0' > topNumbers.charAt(i) - '0'){
                bottom += (bottomNumbers.charAt(i) - '0');
            }else{
                top += (topNumbers.charAt(i) - '0');
                bottom += (bottomNumbers.charAt(i) - '0');
            }
        }

        if(top.length() == 0)
            System.out.println("YODA");
        else
            System.out.println(Integer.valueOf(top));

        if(bottom.length() == 0)
            System.out.println("YODA");
        else
            System.out.println(Integer.valueOf(bottom));


    }




}
