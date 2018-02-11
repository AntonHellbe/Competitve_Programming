import java.util.Scanner;

public class HiddenPassword {

    static Scanner scan;

    public static void main(String[] args) {
        HiddenPassword hiddenPassword = new HiddenPassword();
        hiddenPassword.solveCorrectPassword();
    }

    private void solveCorrectPassword() {
        scan = new Scanner(System.in);
        String[] lines = scan.nextLine().split(" ");
        int passwordIndex = 0;

        String passwordCharacters = lines[1].replaceAll("[^" + lines[0] + "]", "");
        for (int i = 0; i < passwordCharacters.length(); i++) {

            if(passwordIndex != lines[0].length() - 1 && passwordCharacters.charAt(i) == lines[0].charAt(passwordIndex)) {
                passwordIndex++;

            }else {
                if(passwordIndex != lines[0].length() - 1) {
                    for (int j = passwordIndex + 1; j < lines[0].length(); j++) {
                        if (passwordCharacters.charAt(i) == lines[0].charAt(j)) {
                            System.out.println("FAIL");
                            return;
                        }
                    }
                }else {
                    if(passwordCharacters.charAt(i) == lines[0].charAt(passwordIndex)){
                        System.out.println("PASS");
                        return;
                    }
                }
            }


        }

        System.out.println("FAIL");



    }
}
