import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ICPCAwards {

    public Scanner scan;
    public HashMap<String, Team> winnerMap;
    public static final int AWARDS = 12;

    public class Team {
        String teamName;
        int place;

        public Team(String teamName, int place) {
            this.teamName = teamName;
            this.place = place;
        }


    }

    public static void main(String[] args) {
        ICPCAwards icpcAwards = new ICPCAwards();
        icpcAwards.solveAwardIssue();
    }

    private void solveAwardIssue() {
        winnerMap = new HashMap<>();
        scan = new Scanner(System.in);
        int teams = Integer.parseInt(scan.nextLine()), count = 0;

        for (int i = 0; i < teams; i++) {
            String[] lines = scan.nextLine().split(" ");
            if(winnerMap.get(lines[0]) == null) {
                winnerMap.put(lines[0], new Team(lines[0] + " " + lines[1], i));
                count++;
            }

            if(count >= AWARDS) {
                break;
            }
        }

        ArrayList<Team> teamz = new ArrayList<>();
        teamz.addAll(winnerMap.values());

        teamz.sort((a1, b1) -> a1.place - b1.place);

        teamz.forEach((t) -> {
            System.out.println(t.teamName);
        });
    }
}
