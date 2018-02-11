import java.util.Arrays;
import java.util.Scanner;

public class Natrij {

    public Scanner scan;
    public int[] currentTime;
    public int[] explosionTime;
    public int hoursToExplosion = 0, minutesToExplosion = 0, secondsToExplosion = 0;


    public static void main(String[] args) {
        Natrij n = new Natrij();
        n.solveBombTime();
    }

    private void solveBombTime() {
        scan = new Scanner(System.in);

        currentTime = Arrays.stream(scan.nextLine().split(":")).mapToInt(Integer::parseInt).toArray();
        explosionTime = Arrays.stream(scan.nextLine().split(":")).mapToInt(Integer::parseInt).toArray();

        bombTimeHours(currentTime[0], explosionTime[0]);
        bombTimeMinutes(currentTime[1], explosionTime[1]);
        bombTimeSeconds(currentTime[2], explosionTime[2]);





        String output = "";
        if(hoursToExplosion + minutesToExplosion + secondsToExplosion == 0){
            hoursToExplosion += 24;
        }

        output += hoursToExplosion < 10 ? "0" + hoursToExplosion : hoursToExplosion;
        output += minutesToExplosion < 10 ? ":0" + minutesToExplosion : ":" + minutesToExplosion;
        output += secondsToExplosion < 10 ? ":0" + secondsToExplosion : ":" + secondsToExplosion;

        System.out.println(output);
    }

    private void bombTimeSeconds(int currentSeconds, int bombTimeSeconds) {
        if(bombTimeSeconds - currentSeconds < 0) {
            secondsToExplosion = 60 + (bombTimeSeconds - currentSeconds);
            minutesToExplosion -= 1;
            if(minutesToExplosion < 0) {
                minutesToExplosion += 60;
                hoursToExplosion -= 1;
                if(hoursToExplosion < 0) {
                    hoursToExplosion = 23;
                }
            }
        }else {
            secondsToExplosion = bombTimeSeconds - currentSeconds;
        }
    }

    private void bombTimeMinutes(int currentMinutes, int bombTimeMinutes) {
        if(bombTimeMinutes - currentMinutes < 0) {
            minutesToExplosion = 60 + (bombTimeMinutes - currentMinutes);
            hoursToExplosion -= 1;
            if(hoursToExplosion < 0) {
                hoursToExplosion = 23;
            }
        }else {
            minutesToExplosion = bombTimeMinutes - currentMinutes;
        }
    }


    private void bombTimeHours(int currentHour, int bombTimeHour) {
        int hourDifference = 0;
        while(currentHour != bombTimeHour) {
            currentHour = (currentHour + 1) % 24;
            hourDifference++;
        }

        hoursToExplosion = hourDifference;
    }



}
