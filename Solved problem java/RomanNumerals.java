import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Anton on 2017-10-22.
 */
public class RomanNumerals {
    static Scanner scan;
    static HashMap<Character, Integer> romanMap;
    static int solutionType;
    static String answer;
    static boolean running = true;
    static String part1;
    static String part2;
    static String part3;


    static void init(){
        romanMap = new HashMap<>();
        romanMap.put('M',1000);
        romanMap.put('D',500);
        romanMap.put('C',100);
        romanMap.put('L',50);
        romanMap.put('X',10);
        romanMap.put('V',5);
        romanMap.put('I',1);
    }

    static int romanToNumber(String romanNumber){
        int number = 0;
        for (int i = 0; i < romanNumber.length(); i++) {
            int firstNumber = romanMap.get(romanNumber.charAt(i));
            if(i == romanNumber.length() - 1){
                number += firstNumber;
            }else{
                int secondNumber = romanMap.get(romanNumber.charAt(i + 1));
                if(firstNumber < secondNumber ){
                    number -= firstNumber;
                }else{
                    number += firstNumber;
                }
            }

        }

        return number;
    }

    public static void main(String[] args){
        scan = new Scanner(System.in);
        init();
        while(running)
            solveRoman();

    }

    static void solveRoman() {
        String romanNumbers = scan.nextLine();
        answer = "";
        HashSet<Character> uniqueCharacters = new HashSet<>();
        boolean[] leadingCharacters = new boolean[128];
        int[] value = new int[128];
        boolean[] potentialEncoding = new boolean[10];

        if(romanNumbers.charAt(0) == '#'){
            running = false;
            return;
        }

        for(Character c: romanNumbers.toCharArray()){
            if(c != '+' && c != '=')
                uniqueCharacters.add(c);
        }

        ArrayList<Character> allCharacters = new ArrayList<>(uniqueCharacters);

        String[] temp = romanNumbers.split("\\+|=");

        for (int i = 0; i < temp.length; i++) {
            leadingCharacters[temp[i].charAt(0)] = true;
        }
        part1 = temp[0];
        part2 = temp[1];
        part3 = temp[2];


        solutionType = 0;

        if(romanToNumber(part1) + romanToNumber(part2) == romanToNumber(part3))
            answer += "Correct";
        else
            answer += "Incorrect";

        arabicEncoding(0, allCharacters, value, potentialEncoding, leadingCharacters);

        switch(solutionType){
            case 0:
                answer += " impossible";
                break;
            case 1:
                answer += " valid";
                break;
            default:
                answer += " ambiguous";
                break;
        }

        System.out.println(answer);

    }

    static void arabicEncoding(int currentIndex, ArrayList<Character> uniqueCharacters, int[] value, boolean[] potentSolution, boolean[] leadingCharacters){
        if(solutionType > 1){
            return;
        }

        if(currentIndex == uniqueCharacters.size()){
            int valChar1 = 0, valChar2 = 0, valChar3 = 0;

            for (int i = 0; i < part1.length(); i++) {
                valChar1 = valChar1 * 10 + value[part1.charAt(i)];
            }

            for (int i = 0; i < part2.length(); i++) {
                valChar2 = valChar2 * 10 + value[part2.charAt(i)];
            }

            for (int i = 0; i < part3.length(); i++) {
                valChar3 = valChar3 * 10 + value[part3.charAt(i)];
            }

            if(valChar1 + valChar2 == valChar3)
                solutionType++;

            return;
        }

        boolean leadingOrNotLeading = leadingCharacters[uniqueCharacters.get(currentIndex)];
        int startValue = 0;
        if(!leadingOrNotLeading)
            startValue = 0;
        else
            startValue = 1;

        for (int i = startValue; i < 10 && solutionType <= 1; i++) {
            if(!potentSolution[i]){
                value[uniqueCharacters.get(currentIndex)] = i;
                potentSolution[i] = true;
                arabicEncoding(currentIndex + 1, uniqueCharacters, value, potentSolution, leadingCharacters);
                potentSolution[i] = false;
            }

        }


    }
}
