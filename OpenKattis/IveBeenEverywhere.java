import java.util.HashSet;
import java.util.Scanner;

public class IveBeenEverywhere {

    static Scanner scan;

    public static void main(String[] args){
        scan = new Scanner(System.in);
        int i = 0, testscases = Integer.parseInt(scan.nextLine());
        while(i < testscases) {
            solve();
            i++;
        }
    }

    static void solve() {
        HashSet<String> cities = new HashSet<>();
        int towns = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < towns; i++) {
            cities.add(scan.nextLine());

        }

        System.out.println(cities.size());

    }


}
