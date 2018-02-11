import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class UniversalControlNumbers {
    
    public Scanner scan;
    public HashMap<Character, Character> confusingLetters;
    public HashMap<Character, Integer> numberSystem;
    public char[] allCharacters = {'0','1','2','3','4','5','6','7','8','9','A','C','D','E','F','H','J','K','L','M','N','P','R','T','V','W','X'};
    
    public static void main(String[] args){
        
        UniversalControlNumbers universalControlNumbers = new UniversalControlNumbers();
        universalControlNumbers.FBIControlDigits();
    }

    private void FBIControlDigits() {
        scan = new Scanner(System.in);
        confusingLetters = new HashMap<>();
        numberSystem = new HashMap<>();
        addConfusingLetters();
        int testcases = Integer.parseInt(scan.nextLine()), i = 0;
        int[] factors = {2, 4, 5, 7, 8, 10, 11, 13};
        
        while(i < testcases) {
            String line = scan.nextLine().split(" ")[1];
            int[] numbers = new int[line.length()];
            for (int j = 0; j < line.length(); j++) {
                if(confusingLetters.get(line.charAt(j)) != null) {
                    numbers[j] = numberSystem.get(confusingLetters.get(line.charAt(j)));
                }else {
                    numbers[j] = numberSystem.get(line.charAt(j));
                }
            }

            int sum = 0;

            for (int j = 0; j < numbers.length - 1; j++) {
                sum += numbers[j] * factors[j];
            }

            if(allCharacters[sum % 27] == line.charAt(line.length() - 1)) {
                long temp = 0;
                for (int j = 0; j  < numbers.length - 1; j++) {
                    temp += (long) (numbers[j] * Math.pow(27, (7 - j)));
                }
                System.out.println(i + 1 + " " + temp);
            }else {
                System.out.println(i + 1 +" Invalid");
            }

            i++;

        }
    }
    
    
    private void addConfusingLetters() {
        confusingLetters.put('B', '8');
        confusingLetters.put('G', 'C');
        confusingLetters.put('I', '1');
        confusingLetters.put('O', '0');
        confusingLetters.put('Q', '0');
        confusingLetters.put('S', '5');
        confusingLetters.put('U', 'V');
        confusingLetters.put('Y', 'V');
        confusingLetters.put('Z', '2');

        for (int i = 0; i < 27; i++) {
            numberSystem.put(allCharacters[i], i);
        }
    }
}
