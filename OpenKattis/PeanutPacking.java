import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PeanutPacking {

    public class Box {
        double x1, y1, x2, y2;
        String boxType;

        public Box(double x1, double y1, double x2, double y2, String boxType){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.boxType = boxType;
        }
    }

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        PeanutPacking p = new PeanutPacking();
        p.go();
    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;


        while(true) {
            int numberOfBoxes = Integer.valueOf(br.readLine());

            if(numberOfBoxes == 0) return;

            Box[] boxArr = new Box[numberOfBoxes];

            for (int i = 0; i < numberOfBoxes; i++) {
                split = br.readLine().split(" ");
                double x1 = Double.valueOf(split[0]);
                double x2 = Double.valueOf(split[2]);
                double y1 = Double.valueOf(split[1]);
                double y2 = Double.valueOf(split[3]);
                String boxType = split[4];
                boxArr[i] = new Box(x1, y1, x2, y2, boxType);
            }

            int numberOfPeanuts = Integer.valueOf(br.readLine());

            outer: for (int i = 0; i < numberOfPeanuts; i++) {
                split = br.readLine().split(" ");
                double x = Double.valueOf(split[0]);
                double y = Double.valueOf(split[1]);
                String boxType = split[2];

                for (int j = 0; j < boxArr.length; j++) {
                    if (x >= boxArr[j].x1 && x <= boxArr[j].x2 && y >= boxArr[j].y1 && y <= boxArr[j].y2) {
                        if (boxType.equals(boxArr[j].boxType))
                            System.out.println(boxType + " correct");
                        else
                            System.out.println(boxType + " " + boxArr[j].boxType);

                        continue outer;
                    }
                }

                System.out.println(boxType + " floor");

            }

            System.out.println("");
        }

    }
}
