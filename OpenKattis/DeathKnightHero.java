import java.util.Scanner;

public class DeathKnightHero {

    public Scanner scan;

    public static void main(String[] args){
        DeathKnightHero k = new DeathKnightHero();
//        k.fixShit();
        int t = 1;
        long temp = 0;
        for (int i = 0; i <= 10000; i++) {
            temp += Math.pow(150 - t, 2);
        }
        long temp2 = 0;
        for (int i = 0; i <= 20000; i++) {
            temp2 += Math.pow(50 - t, 2);
        }
        System.out.println(temp2 / 2);
        System.out.println(temp / 2);
    }

    private void fixShit() {
        scan = new Scanner(System.in);

        int lines = Integer.parseInt(scan.nextLine());
        String line = "";
        int battlesWon = 0;
        for (int i = 0; i < lines; i++) {
            line = scan.nextLine();
            boolean battleLost = false;

            for (int j = 0; j < line.length() - 1; j++) {
                if(line.charAt(j) == 'C' && line.charAt(j + 1) == 'D') {
                    battleLost = true;
                }
            }

            if(!battleLost) battlesWon++;
        }

        System.out.println(battlesWon);
    }
}
