import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kolone {

    public BufferedReader br;
    public Ant[] queue;

    public class Ant{
        char id;
        int direction;

        public Ant(char id, int direction){
            this.id = id;
            this.direction = direction;
        }
    }


    public static void main(String[] args) throws IOException {
        Kolone k = new Kolone();
        k.jumpingAnts();
    }

    private void jumpingAnts() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;


        split = br.readLine().split(" ");
        int row1 = Integer.valueOf(split[0]), row2 = Integer.valueOf(split[1]);
        queue = new Ant[row1 + row2];
        char[] c = br.readLine().toCharArray();

        for (int i = row1 - 1; i >= 0; i--) {
            queue[i] = new Ant(c[row1 - i - 1], 1);
        }
        c = br.readLine().toCharArray();
        for (int i = row1; i < row1 + row2; i++) {
            queue[i] = new Ant(c[i - row1], 0);
        }

        if(row2 == 0){
            for (int i = row1 - 1; i >= 0; i--) {
                System.out.print(queue[i].id);
            }
            return;
        }

        if(row1 == 0){
            for (int i = row1; i < row1 + row2; i++) {
                System.out.println(queue[i]);
            }
            return;
        }

        int tSeconds = Integer.valueOf(br.readLine());

        for (int i = 0; i < tSeconds; i++) {
            for (int j = 0; j < (row1 + row2 - 1); j++) {
                if(queue[j].direction > queue[j + 1].direction){
                    swap(j, j +1);
                    j++;
                }
            }
        }

        for (int i = 0; i < queue.length; i++) {
            System.out.print(queue[i].id);
        }
    }


    private boolean swap(int i, int j){
        Ant a1 = queue[i];
        queue[i] = queue[j];
        queue[j] = a1;
        return true;

    }
}
