import java.util.ArrayList;
import java.util.Scanner;

public class Cudoviste {

    public Scanner scan;
    public ParkingSlot[][] parkingMap;
    public int rows = 0, cols = 0;

    enum Directions {
        LEFT (0, -1),
        DOWN (1, 0),
        DOWNLEFT (1, -1),
        CURRENT (0, 0);

        int y, x;

        Directions(int y, int x) {
            this.y = y;
            this.x = x;
        }

    }

    public class ParkingSlot {
        char value;
        int x, y;

        public ParkingSlot(char value, int y, int x){
            this.value = value;
            this.y = y;
            this.x = x;
        }

        public ParkingSlot(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        Cudoviste cudoviste = new Cudoviste();
        cudoviste.solveMirkosParkingProblem();
    }

    private void solveMirkosParkingProblem() {
        scan = new Scanner(System.in);
        String[] line = scan.nextLine().split(" ");
        rows = Integer.parseInt(line[0]);
        cols = Integer.parseInt(line[1]);
        parkingMap = new ParkingSlot[rows][cols];

        int occupiedSlots = 0;
        char[] input;

        for (int i = 0; i < rows; i++) {
            input = scan.nextLine().toCharArray();
            for (int j = 0; j < input.length; j++) {
                parkingMap[i][j] = new ParkingSlot(input[j], i, j);
                if(input[j] == 'X') {
                    occupiedSlots++;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            if(i > occupiedSlots) {
                System.out.println(0);
            }else {
                System.out.println(availableSpots(i));
            }
        }

    }

    private int availableSpots(int squashLevel) {
        int spotsToParkIn = 0;

        for (int k = 0; k < parkingMap.length; k++) {
            for (int j = 0; j < parkingMap[k].length; j++) {
                if(k < rows - 1 && j > 0) {
                    boolean canPark = check2by2(k, j, squashLevel);
                    if(canPark) spotsToParkIn++;
                }
            }
        }

        return spotsToParkIn;
    }

    private boolean check2by2(int i, int j, int squashLevel){
        int t = 0;

        for(Directions d: Directions.values()) {
            if(parkingMap[i + d.y][j + d.x].value == 'X') {
                t++;
            }

            if(parkingMap[i + d.y][j + d.x].value == '#'){
                return false;
            }

        }
        if(t == squashLevel) {
            return true;
        }

        return false;
    }


}
