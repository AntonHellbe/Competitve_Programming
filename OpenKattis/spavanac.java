import java.util.Scanner;

public class spavanac {

    public Scanner scan;

    public static void main(String[] args){
        spavanac s = new spavanac();

        s.solve();
    }

    private void solve() {
        scan = new Scanner(System.in);
        int hour = scan.nextInt();
        int minute = scan.nextInt();

        minute -= 45;

        if(minute < 0) {
            minute += 60;
            hour--;
        }

        if(hour < 0) {
            hour += 24;
        }

        System.out.println(hour + " " + minute);
    }
}
