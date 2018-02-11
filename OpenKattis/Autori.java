import java.util.Scanner;

public class Autori {

    public Scanner scan;

    public static void main(String[] args){
        Autori autori = new Autori();
        autori.solve();
    }

    private void solve() {
        scan = new Scanner(System.in);
        String line[] = scan.nextLine().split("-");
        for (int i = 0; i < line.length; i++) {
            System.out.print(line[i].charAt(0));
        }
    }
}
