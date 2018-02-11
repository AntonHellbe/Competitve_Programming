import java.util.HashMap;
import java.util.Scanner;

public class AddingWords {

    public Scanner scan;
    public HashMap<Integer, String> intToString;
    public HashMap<String, Integer> stringToInt;
    public static final int POSITIVE = 1;
    public static final int NEGATIVE = -1;

    public static void main(String[] args){
        AddingWords addingWords = new AddingWords();
        
        addingWords.solveIssue();
    }

    private void solveIssue() {
        scan = new Scanner(System.in);
        intToString = new HashMap<>();
        stringToInt = new HashMap<>();
        int value;

        while(scan.hasNextLine()) {
            try {
                String lines[] = scan.nextLine().split(" ");
                if(lines[0].equals("")){
                    return;
                }
                switch (lines[0]) {
                    case "def":
                        value = Integer.parseInt(lines[2]);
                        addToMemory(lines[1], value);
                        break;

                    case "calc":
                        System.out.println();
                        calculateResult(lines);
                        break;

                    case "clear":
                        clearMemoryMaps();
                        break;
                }
            }catch(Exception e){
                return;
            }

        }
    }

    private void clearMemoryMaps() {
//        System.out.println("Clearing memory maps!");
        intToString.clear();
        stringToInt.clear();
    }

    private void calculateResult(String[] lines) {
        int finalValue = 0;
        boolean unknown = false;
        int nextMove = POSITIVE;

        for (int i = 1; i < lines.length && !unknown; i++) {
            switch(lines[i]) {
                case "-":
                    nextMove = NEGATIVE;
                    break;
                case "+":
                    nextMove = POSITIVE;
                case "=":
                    break;
                default:
                    if(stringToInt.get(lines[i]) == null){
                        unknown = true;
                    }else {
                        if(nextMove == POSITIVE) {
                            finalValue += stringToInt.get(lines[i]);
                        }else {
                            finalValue -= stringToInt.get(lines[i]);
                        }
                    }
                    break;
            }
        }

        if (unknown) {
            for (int i = 1; i < lines.length; i++) {
                System.out.print(lines[i] + " ");
            }
            System.out.print("unknown");
            return;
        }

        for (int i = 1; i < lines.length; i++) {
            System.out.print(lines[i] + " ");
        }

        if (intToString.get(finalValue) == null) {
            System.out.print("unknown");
        }else {
            System.out.print(intToString.get(finalValue));
        }

    }

    private void addToMemory(String identifier, int value) {
        int oldValue = 0;
        if(stringToInt.get(identifier) != null) {
            oldValue = stringToInt.get(identifier);
            intToString.remove(oldValue);
        }
        stringToInt.put(identifier, value);
        intToString.put(value, identifier);

    }


}
