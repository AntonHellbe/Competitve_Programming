import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HittingTheTargets {

    public BufferedReader br;
    public class Shape {
        String shape;
        int x, y, x1, y1;

        public Shape(String shape, int x, int y, int x1, int y1){
            this.shape = shape;
            this.x = x;
            this.y = y;
            this.x1 = x1;
            this.y1 = y1;
        }
        public Shape(String shape, int x, int y, int x1){
            this.shape = shape;
            this.x = x;
            this.y = y;
            this.x1 = x1;
        }

    }

    public static void main(String[] args) throws IOException {
        HittingTheTargets ht = new HittingTheTargets();
        ht.go();
    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;

        int numShapes = Integer.valueOf(br.readLine());
        Shape[] targets = new Shape[numShapes];

        for (int i = 0; i < numShapes; i++) {
            split = br.readLine().split(" ");

            if(split[0].equals("rectangle")){
                targets[i] = new Shape(split[0],
                        Integer.valueOf(split[1]),
                        Integer.valueOf(split[2]),
                        Integer.valueOf(split[3]),
                        Integer.valueOf(split[4]));
            }else{
                targets[i] = new Shape(split[0],
                        Integer.valueOf(split[1]),
                        Integer.valueOf(split[2]),
                        Integer.valueOf(split[3]));
            }
        }

        int numShots = Integer.valueOf(br.readLine());

        for (int i = 0; i < numShots; i++) {
            split = br.readLine().split(" ");
            int x = Integer.valueOf(split[0]), y = Integer.valueOf(split[1]), hits = 0;
            for (int j = 0; j < targets.length; j++) {
                if(targets[j].shape.equals("rectangle")){
                    if(x >= targets[j].x && x <= targets[j].x1 && y >= targets[j].y && y <= targets[j].y1) hits++;

                }else{
                    if(Math.pow((x - targets[j].x), 2) + Math.pow((y - targets[j].y), 2) <= Math.pow(targets[j].x1, 2)) hits++;

                }
            }
            System.out.println(hits);


        }

    }
}
