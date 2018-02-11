import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Bard {

    public Scanner scan;
    public Villager[] villagersArray;

    public class Villager {
        int number;
        HashSet<Integer> knownSongs;

        public Villager(int number) {
            this.number = number;
            knownSongs = new HashSet<>();
        }

        @Override
        public String toString() {
            return number + " " + knownSongs;
        }
    }

    public static void main(String[] args){
        Bard b = new Bard();
        b.solveGraphProblem();
    }

    private void solveGraphProblem() {
        scan = new Scanner(System.in);
        int numbersOfVillagers = Integer.parseInt(scan.nextLine());
        villagersArray = new Villager[numbersOfVillagers + 1];
        int rows = Integer.parseInt(scan.nextLine());
        HashSet<Integer> copySet;
        for (int i = 1; i < numbersOfVillagers + 1; i++) {
            villagersArray[i] = new Villager(i);
        }

        for (int i = 0; i < rows; i++) {
            String[] line = scan.nextLine().split(" ");
            int[] input = new int[line.length - 1];
            for (int j = 1; j < line.length; j++) {
                input[j - 1] = Integer.parseInt(line[j]);
            }

            Arrays.sort(input);

            if(input[0] == 1) {
                for (int j = 0; j < input.length; j++) {
                    villagersArray[input[j]].knownSongs.add(i);
                }
            }else {
                copySet = new HashSet<>();
                for (int j = 0; j < input.length; j++) {
                    copySet.addAll(villagersArray[input[j]].knownSongs);
                }

                for (int j = 0; j < input.length; j++) {
                    villagersArray[input[j]].knownSongs.addAll(copySet);
                }

            }
        }

        System.out.println(villagersArray[1].number);
        for (int i = 2; i < villagersArray.length; i++) {
            if(villagersArray[1].knownSongs.size() == villagersArray[i].knownSongs.size()) {
                System.out.println(villagersArray[i].number);
            }
        }

    }


}
