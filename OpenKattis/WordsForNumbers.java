import java.util.Scanner;

public class WordsForNumbers {

    public String[] ones = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public String[] tweens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    public String[] tens = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    public Scanner scan;

    public static void main(String[] args) {
        WordsForNumbers w = new WordsForNumbers();
        w.solve();
    }

    private void solve() {
        scan = new Scanner(System.in);
        String line = "";

        while(scan.hasNextLine()) {
            line = scan.nextLine();

            for (int i = 0; i < line.length(); i++) {
                if(checkIfNumber(line.charAt(i))) {
                    line = updateString(line, i);
                }
            }

            System.out.println(line);

        }
    }



    private String updateString(String line, int index) {
        String toParse = "";
        int number = 0;
        boolean nextChar = false;

        if (index != line.length() - 1 && checkIfNumber(line.charAt(index + 1))) {
            nextChar = true;
            toParse = line.substring(index, index + 2);
        } else {
            toParse = line.substring(index, index + 1);
        }

        number = Integer.parseInt(toParse);

        if (number < 20) {
            if (number >= 10) {
                toParse = tweens[number % 10];
            } else {
                toParse = ones[number];
            }
        } else {
            toParse = tens[number / 10];
            if (number % 10 != 0) {
                toParse += "-" + ones[number % 10];
            }

        }

        if (index == 0) {
            if(toParse.length() > 1) {
                toParse = toParse.substring(0, 1).toUpperCase() + toParse.substring(1);
            }else {
                toParse = toParse.toUpperCase();
            }
        }

        if (nextChar) {
            return line.substring(0, index) + toParse + line.substring(index + 2);
        }

        return line.substring(0, index) + toParse + line.substring(index + 1);
    }

    public boolean checkIfNumber(char a) {
        return (int) a >= 48 && (int) a <= 57;
    }




}
