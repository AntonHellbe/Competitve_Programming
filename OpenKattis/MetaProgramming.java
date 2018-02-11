import java.util.HashMap;
import java.util.Scanner;

public class MetaProgramming {

    public Scanner scan;
    public HashMap<String, Integer> intToString;


    public static void main(String[] args){
        MetaProgramming metaProgramming = new MetaProgramming();
        metaProgramming.solveEiger();
    }

    private void solveEiger() {
        scan = new Scanner(System.in);
        intToString = new HashMap<>();
        String[] lines;

        while(scan.hasNextLine()) {
            lines = scan.nextLine().split(" ");

            if(lines[0].equals("define")) {
                def(lines);
            }else {
                evaluate(lines);
            }

        }

    }


    private void def(String[] input) {
        int val = Integer.parseInt(input[1]);
        intToString.put(input[2], val);
    }

    private void evaluate(String[] input) {
        if(!intToString.containsKey(input[1]) || !intToString.containsKey(input[3])) {
            System.out.println("undefined");
            return;
        }
        int val1 = intToString.get(input[1]), val2 = intToString.get(input[3]);
        switch(input[2]) {
            case "<":
                System.out.println(val1 < val2);
                break;
            case ">":
                System.out.println(val1 > val2);
                break;
            case "=":
                System.out.println(val1 == val2);
                break;

        }

    }
}
