import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ASCIIaddition {

    public Scanner scan;
    public HashMap<String, String[]> asciiMap;


    public static void main(String[] args){
        ASCIIaddition a = new ASCIIaddition();
        a.doTheMath();
    }

    private void doTheMath() {
        scan = new Scanner(System.in);
        asciiMap = new HashMap<>();
        putInMap();
        String[][] input = null;

        int i = 0, rows = 0, cols = 0;
        String line = "";
        while(scan.hasNextLine()) {
            line = scan.nextLine();
            if(line.equals("")){
                break;
            }

            if(i == 0) {
                rows = (int) Math.ceil( (double) line.length() / 6);
                input = new String[rows][7];
            }

            for (int j = 1; j <= line.length() + 1 ; j++) {
                if(j % 6 == 0) {
                    input[cols][i] = line.substring(j - 6, j - 1);
                    cols++;
                }
            }

            i++;
            cols = 0;
        }

        String a = "";
        String b = "";
        boolean bTime = false;
        for (int j = 0; j < rows; j++) {
            String f = numberCheck(input[j]);
            if(f == "+") {
                bTime = true;
                continue;
            }

            if(!bTime) {
                a += f;
            }else {
                b += f;
            }
        }

        String sum = String.valueOf((Integer.parseInt(a) + Integer.parseInt(b)));
        String[][] output = new String[7][sum.length()];

        for (int j = 0; j < sum.length(); j++) {
            String[] number = asciiMap.get(sum.charAt(j) + "");
            for (int k = 0; k < number.length; k++) {
                if(j == 0) {
                    output[k][j] = number[k];
                }else {
                    output[k][j] = "." + number[k];
                }
            }

        }

        for (int j = 0; j < output.length; j++) {
            for (int k = 0; k < output[j].length; k++) {
                System.out.print(output[j][k]);
            }

            System.out.println("");
        }

    }


    private String numberCheck(String[] number){
        for(Map.Entry<String, String[]> e: asciiMap.entrySet()){
            boolean correct = true;
            String[] arr = asciiMap.get(e.getKey());
            for (int i = 0; i < arr.length; i++) {
                if(!arr[i].equals(number[i])){
                    correct = false;
                    break;
                }

            }

            if(correct) {
                return e.getKey();
            }

        }
        System.out.println("Returning nothing");
        return "";

    }


    private void putInMap() {
        asciiMap.put("0", new String[]{
                "xxxxx",
                "x...x",
                "x...x",
                "x...x",
                "x...x",
                "x...x",
                "xxxxx"});
        asciiMap.put("1", new String[]{
                "....x",
                "....x",
                "....x",
                "....x",
                "....x",
                "....x",
                "....x"
        });
        asciiMap.put("2", new String[]{
                "xxxxx",
                "....x",
                "....x",
                "xxxxx",
                "x....",
                "x....",
                "xxxxx"
        });

        asciiMap.put("3", new String[]{
                "xxxxx",
                "....x",
                "....x",
                "xxxxx",
                "....x",
                "....x",
                "xxxxx"
        });

        asciiMap.put("4", new String[]{
                "x...x",
                "x...x",
                "x...x",
                "xxxxx",
                "....x",
                "....x",
                "....x",
        });
        asciiMap.put("5", new String[]{
                "xxxxx",
                "x....",
                "x....",
                "xxxxx",
                "....x",
                "....x",
                "xxxxx"
        });
        asciiMap.put("6", new String[]{
                "xxxxx",
                "x....",
                "x....",
                "xxxxx",
                "x...x",
                "x...x",
                "xxxxx"
        });

        asciiMap.put("7", new String[]{
                "xxxxx",
                "....x",
                "....x",
                "....x",
                "....x",
                "....x",
                "....x"
        });

        asciiMap.put("8", new String[]{
                "xxxxx",
                "x...x",
                "x...x",
                "xxxxx",
                "x...x",
                "x...x",
                "xxxxx"
        });

        asciiMap.put("9", new String[]{
                "xxxxx",
                "x...x",
                "x...x",
                "xxxxx",
                "....x",
                "....x",
                "xxxxx",
        });

        asciiMap.put("+", new String[]{
                ".....",
                "..x..",
                "..x..",
                "xxxxx",
                "..x..",
                "..x..",
                ".....",
        });


    }
}
