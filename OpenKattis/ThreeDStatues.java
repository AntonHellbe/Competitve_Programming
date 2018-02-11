import java.util.Scanner;

public class ThreeDStatues {

    public Scanner scan;

    public static void main(String[] args){
        ThreeDStatues t  = new ThreeDStatues();
        t.solve();
    }

    private void solve() {
        scan = new Scanner(System.in);
        int statues = scan.nextInt();

        int ans = 1 +  (int) Math.ceil(Math.log(statues) / Math.log(2));
        System.out.println(ans);
    }
}
