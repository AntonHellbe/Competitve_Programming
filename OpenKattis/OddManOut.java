import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OddManOut {

    public Scanner scan;
    public HashMap<Integer, Invitation> invitationMap;

    public class Invitation{
        int number, amount;

        public Invitation(int number){
            this.number = number;
            this.amount = 1;
        }
    }

    public static void main(String[] args){
        OddManOut o = new OddManOut();
        o.solve();
    }

    private void solve() {
        scan = new Scanner(System.in);
        int testcases = scan.nextInt(), i = 0;
        invitationMap = new HashMap<>();
        while(i < testcases){
            int guests = scan.nextInt();
            for (int j = 0; j < guests; j++) {
                int next = scan.nextInt();
                if(invitationMap.get(next) != null){
                    invitationMap.get(next).amount += 1;
                }else {
                    invitationMap.put(next, new Invitation(next));
                }
            }


            for (Map.Entry<Integer, Invitation> entry: invitationMap.entrySet()) {
                if(entry.getValue().amount % 2 != 0){
                    System.out.println("Case #" + (i + 1) + ": " + entry.getKey());
                    break;
                }
            }

            invitationMap.clear();

            i++;
        }
    }
}
