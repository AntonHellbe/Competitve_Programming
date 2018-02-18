import java.util.Scanner;

public class SimonSays {

    public Scanner scan;

    public static void main(String[] args){
        SimonSays s = new SimonSays();
        s.doWhatSimonSays();
    }

    private void doWhatSimonSays() {
        scan = new Scanner(System.in);

        int lines = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < lines; i++) {
            String line = scan.nextLine();
//            System.out.println(line);
            if(line.length() > 10) {
                if (line.substring(0, 10).equals("Simon says")) {
                    System.out.println(line.substring(10));
                }
            }

        }
    }
}
