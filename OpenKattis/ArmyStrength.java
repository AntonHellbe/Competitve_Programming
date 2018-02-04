import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArmyStrength {

    static Scanner scan;
    static ArrayList<Integer> godzilla;
    static ArrayList<Integer> mechaGodzilla;

    public static void main(String[] args){
        scan = new Scanner(System.in);
        int i = 0, testcases = Integer.parseInt(scan.nextLine());
        while(i < testcases) {
            scan.nextLine(); // Empty line
            battle();
            i++;
        }

    }

    static void battle() {
        godzilla = new ArrayList<>();
        mechaGodzilla = new ArrayList<>();

        int[] input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int godzillaMonsters = input[0], mechaGodzillaMonsters = input[1];

        input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < input.length; i++) {
            godzilla.add(input[i]);
        }


        input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < input.length; i++) {
            mechaGodzilla.add(input[i]);
        }


        while(godzilla.size() != 0 && mechaGodzilla.size() != 0) {
            int weakestGodzilla = godzilla.stream().min(Integer::compareTo).get();
            int weakestMechaGodzilla = mechaGodzilla.stream().min(Integer::compareTo).get();
            boolean allInSameArmy = true;

            if(weakestGodzilla == weakestMechaGodzilla) {
                mechaGodzilla.remove(findFirstOccurance(mechaGodzilla, weakestMechaGodzilla));
            }else if(weakestGodzilla > weakestMechaGodzilla) {

                if(mechaGodzilla.stream().max(Integer::compareTo).get() > weakestGodzilla) allInSameArmy = false;

                if(allInSameArmy) {
                    mechaGodzilla.remove((int) Math.floor(Math.random() * (mechaGodzilla.size() - 1)));
                }else {
                    mechaGodzilla.remove(findFirstOccurance(mechaGodzilla, weakestMechaGodzilla));
                }
            }else if(weakestMechaGodzilla > weakestGodzilla) {
                if(godzilla.stream().max(Integer::compareTo).get() > weakestMechaGodzilla) allInSameArmy = false;

                if(allInSameArmy) {
                    godzilla.remove((int) Math.floor(Math.random() * (godzilla.size() - 1)));
                } else {
                    godzilla.remove(findFirstOccurance(godzilla, weakestGodzilla));
                }
            }
        }
        if(godzilla.size() == 0 && mechaGodzilla.size() == 0) {
            System.out.println("uncertain");
        }else if(godzilla.size() == 0) {
            System.out.println("MechaGodzilla");
        }else {
            System.out.println("Godzilla");
        }

        return;
    }


    static int findFirstOccurance(ArrayList<Integer> list, int number) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == number) return i;
        }
        return -1;
    }


}
