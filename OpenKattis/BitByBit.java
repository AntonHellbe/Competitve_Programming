import java.util.Scanner;

public class BitByBit {
    static Scanner scan;
    static boolean running = true;
    public static void main(String[] args) {
        scan = new Scanner(System.in);
        while(running) {
            solveBitByBit();
        }
    }

    static String OR(String bitOne, String bitTwo) {
        if(bitOne.equals("1") || bitTwo.equals("1")) {
            return "1";
        }

        if(bitOne.equals("?") || bitTwo.equals("?")) {
            return "?";
        }

        return "0";
    }

    static String AND(String bitOne, String bitTwo) {
        if(bitOne.equals("0") || bitTwo.equals("0") ) {
            return "0";
        }

        if(bitOne.equals("?") || bitTwo.equals("?")) {
            return "?";
        }

        return "1";


    }

    static void solveBitByBit() {
        String[] bit = new String[32];
        for (int i = 0; i < bit.length; i++) {
            bit[i] = "?";
        }
        int instructions = Integer.parseInt(scan.nextLine());
        if(instructions == 0) {
            running = false;
            return;
        }

        for (int i = 0; i < instructions; i++) {
            String[] command = scan.nextLine().split(" ");
            int position1, position2;
            switch(command[0]) {
                case "SET":
                    position1 = Integer.parseInt(command[1]);
                    bit[position1] = "1";
                    break;
                case "CLEAR":
                    position1 = Integer.parseInt(command[1]);
                    bit[position1] = "0";
                    break;
                case "AND":
                    position1 = Integer.parseInt(command[1]);
                    position2 = Integer.parseInt(command[2]);
                    bit[position1] = AND(bit[position1], bit[position2]);
                    break;
                case "OR":
                    position1 = Integer.parseInt(command[1]);
                    position2 = Integer.parseInt(command[2]);
                    bit[position1] = OR(bit[position1], bit[position2]);

                    break;
                default:
                    System.out.println("BIG FAT ERROR");
                    break;
            }
        }

        for (int i = bit.length - 1; i >= 0; i--) {
            System.out.print(bit[i]);
        }

        System.out.println("");
    }
}
