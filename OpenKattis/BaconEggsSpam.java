import java.util.*;

public class BaconEggsSpam {

    public Scanner scan;
    public HashMap<String, ArrayList<String>> breakfastMap;

    public static void main(String[] args){
        BaconEggsSpam baconEggsSpam = new BaconEggsSpam();
        baconEggsSpam.solveBreakfastIssue();
    }

    private void solveBreakfastIssue() {
        scan = new Scanner(System.in);
        breakfastMap = new HashMap<>();
        while(true) {


            int lines = Integer.parseInt(scan.nextLine());
            String[] input;

            if(lines == 0) return;


            for (int i = 0; i < lines; i++) {
                input = scan.nextLine().split(" ");
                for (int j = 1; j < input.length; j++) {
                    breakfastMap.putIfAbsent(input[j], new ArrayList<>());
                    breakfastMap.get(input[j]).add(input[0]);
                }
            }

            String[] temp = breakfastMap.keySet().toArray(new String[breakfastMap.size()]);
            Arrays.sort(temp);

            for (int i = 0; i < temp.length; i++) {
                ArrayList<String> names = breakfastMap.get(temp[i]);
                names.sort(Comparator.comparing(String::toString));
                System.out.print(temp[i] + " ");
                for (int j = 0; j < names.size(); j++) {
                    if(j == names.size() - 1)
                        System.out.print(names.get(j) + "\n");
                    else
                        System.out.print(names.get(j) + " ");
                }
            }
            breakfastMap.clear();
            System.out.println("");

        }
    }
}
