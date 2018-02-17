import java.util.Scanner;

public class Cryptography {

    public Scanner scan;
    public String[] alphabet = {"A", "B", "C", "D", "E", "F", "G","H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static void main(String[] args){
        Cryptography c = new Cryptography();
        c.cryptIssue();
    }

    private void cryptIssue() {
        scan = new Scanner(System.in);

        String cipherText = scan.nextLine(), key = scan.nextLine();
        String newText = "";
        for (int i = 0; i < cipherText.length(); i++) {
            char c = key.charAt(i);
            int index = (cipherText.charAt(i) - 'A') - (c - 'A');
            if(index < 0) {
                index += 26;
            }
            key += alphabet[index];
            newText += alphabet[index];
        }

        System.out.println(newText);
    }
}
