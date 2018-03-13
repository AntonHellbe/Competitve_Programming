import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Natjecanje {

    public BufferedReader br;

    public class Team {
        int number;
        boolean reserveKayak;
        boolean damagedKayak;

        public Team(int number){
            this.number = number;
            reserveKayak = false;
            damagedKayak = false;
        }
    }

    public static void main(String[] args) throws IOException {
        Natjecanje n = new Natjecanje();
        n.kayakProblem();
    }

    private void kayakProblem() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;

        split = br.readLine().split(" ");
        int numberOfTeams = Integer.valueOf(split[0]);
        int damagedKayaks = Integer.valueOf(split[1]);
        int reserveKayaks = Integer.valueOf(split[2]);
        Team[] teams = new Team[numberOfTeams + 1];

        for (int i = 0; i <= numberOfTeams; i++) {
            teams[i] = new Team(i);
        }

        split = br.readLine().split(" ");

        for (int i = 0; i < damagedKayaks; i++) {
            teams[Integer.valueOf(split[i])].damagedKayak = true;
        }
        split = br.readLine().split(" ");
        int a;
        for (int i = 0; i < reserveKayaks; i++) {
            a = Integer.valueOf(split[i]);
            if(teams[a].damagedKayak) {
                teams[a].damagedKayak = false;
            }else{
                teams[a].reserveKayak = true;
            }
        }

        int cannotStart = 0;

        for (int i = 1; i < teams.length; i++) {
            if(teams[i].damagedKayak){
                if(i == 1 && teams.length > 1){
                    if(teams[i + 1].reserveKayak && !teams[i + 1].damagedKayak){
                        teams[i + 1].reserveKayak = false;
                    }else{
                        cannotStart++;
                    }
                }else if(i == teams.length - 1){
                    if(teams[i - 1].reserveKayak && !teams[i - 1].damagedKayak){
                        teams[i - 1].reserveKayak = false;
                    }else{
                        cannotStart++;
                    }
                }else{
                    if(!teams[i + 1].reserveKayak && !teams[i - 1].reserveKayak){
                        cannotStart++;
                    }else{
                        if(teams[i - 1].reserveKayak && !teams[i - 1].damagedKayak){
                            teams[i - 1].reserveKayak = false;
                        }else if(teams[i + 1].reserveKayak && !teams[i + 1].damagedKayak){
                            teams[i + 1].reserveKayak = false;
                        }else{
                            cannotStart++;
                        }
                    }
                }
            }
        }

        System.out.println(cannotStart);




    }
}
