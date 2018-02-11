import java.util.Scanner;

public class DaylightSavingTime {

    public Scanner scan;

    public static void main(String[] args) {
        DaylightSavingTime daylightSavingTime = new DaylightSavingTime();
        daylightSavingTime.solveTimeProblem();
    }

    private void solveTimeProblem() {
        scan = new Scanner(System.in);
        int testcases = Integer.parseInt(scan.nextLine());
        String[] lines;

        for (int i = 0; i < testcases; i++) {
            lines = scan.nextLine().split(" ");
            calcNewTime(lines);
        }
    }

    private void calcNewTime(String[] lines) {
        int minutesToChange = Integer.parseInt(lines[1]);
        int currentHour = Integer.parseInt(lines[2]);
        int currentMinutes = Integer.parseInt(lines[3]);

        if(lines[0].equals("F")) {
            if((currentMinutes + minutesToChange) / 60 >= 1) {
                currentHour = (currentHour + (currentMinutes + minutesToChange) / 60);
                currentMinutes = (currentMinutes + minutesToChange) % 60;
            }else {
                currentMinutes = (currentMinutes + minutesToChange) % 60;
            }

            currentHour = currentHour % 24;
        }

        if(lines[0].equals("B")) {
            int d_h = minutesToChange / 60, d_m = minutesToChange % 60;

            currentHour -= d_h;
            currentMinutes -= d_m;
            if(currentMinutes < 0 ){
                currentMinutes += 60;
                currentHour -= 1;
            }

            if(currentHour < 0) {
                currentHour += 24;
            }
        }

        System.out.println(currentHour + " " + currentMinutes);
    }


}
