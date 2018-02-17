import java.util.Scanner;

public class Bus {

    public Scanner scan;

    public static void main(String[] args){
        Bus b = new Bus();
        b.solve();
    }

    private void solve() {
        scan = new Scanner(System.in);

        int testcases = scan.nextInt(), t = 0;

        while(t < testcases) {
            int numberOfStops = scan.nextInt();
//            System.out.println(numberOfStops);
            double numberOfPeople = 0;

            for (int i = 1; i <= numberOfStops; i++) {
                numberOfPeople += 0.5;
                numberOfPeople *= 2;

            }

//            System.out.println((int) Math.ceil(numberOfPeople));
            System.out.println((int)numberOfPeople);
            t++;


        }
    }
}
