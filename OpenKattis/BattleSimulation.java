import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BattleSimulation {

    public BufferedReader br;
    public static final String COMB = "LBR";

    public static void main(String[] args) throws IOException {
        BattleSimulation bs = new BattleSimulation();
        bs.go();
    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));


        String line = br.readLine();

        String battleString = "";

        for (int index = 0; index < line.length(); index++) {
            if (index < line.length() - 2) {
                char a = line.charAt(index);
                char b = line.charAt(index + 1);
                char c = line.charAt(index + 2);
                if (a != b && b != c && c != a) {
                    System.out.print('C');
                    index += 2;
                    continue;
                }
            }

            System.out.print(getCounterMove(line.charAt(index)));

        }

    }

    public char getCounterMove(char c){
        switch(c){
            case 'R':
                return 'S';
            case 'B':
                return 'K';
            case 'L':
                return 'H';
        }

        return ' ';
    }

}
