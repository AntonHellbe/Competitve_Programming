import java.util.Arrays;
import java.util.Scanner;

public class Mia {

    public Scanner scan;

    public static void main(String[] args){
        Mia m = new Mia();
        m.playGame();
    }

    private void playGame() {
        scan = new Scanner(System.in);
        int[] input;
        while(true) {
            input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if(input[0] + input[1] + input[2] + input[3] == 0) return;


            if(testMia(input)){

            }else if(isPair(input)){

            }else if(bestDiceScore(input)){

            }

        }

    }


    public boolean testMia(int[] numbers){
        if(numbers[0] + numbers[1] == 3 || numbers[2] + numbers[3] == 3) {
            if (numbers[0] + numbers[1] == 3 && numbers[2] + numbers[3] == 3) {
                System.out.println("Tie.");
            } else if (numbers[0] + numbers[1] == 3) {
                System.out.println("Player 1 wins.");
            } else if (numbers[2] + numbers[3] == 3) {
                System.out.println("Player 2 wins.");

            }
            return true;
        }

        return false;
    }

    public boolean isPair(int[] numbers){
        if(numbers[0] == numbers[1] || numbers[3] == numbers[2]){
            if(numbers[0] == numbers[1] && numbers[2] == numbers[3]){
                if(numbers[0] == numbers[2]){
                    System.out.println("Tie.");
                }else if(numbers[0] > numbers[2]){
                    System.out.println("Player 1 wins.");
                }else{
                    System.out.println("Player 2 wins.");
                }
                return true;
            }else if(numbers[0] == numbers[1]){
                System.out.println("Player 1 wins.");
                return true;
            }else if(numbers[2] == numbers[3]){
                System.out.println("Player 2 wins.");
                return true;
            }


        }
        return false;
    }

    public boolean bestDiceScore(int[] numbers){
        String a = numbers[0] > numbers[1] ? numbers[0] + "" + numbers[1] : numbers[1] + ""+numbers[0];
        String b = numbers[2] > numbers[3] ? numbers[2] + "" + numbers[3] : numbers[3] + "" + numbers[2];
        int a1 = Integer.parseInt(a);
        int b1 = Integer.parseInt(b);
        if(a1 == b1){
            System.out.println("Tie.");
        }else if(a1 > b1){
            System.out.println("Player 1 wins.");
        }else{
            System.out.println("Player 2 wins.");
        }

        return true;
    }

}
