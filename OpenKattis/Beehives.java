import java.util.Scanner;

public class Beehives {

    public Scanner scan;

    public class Point {
        double y, x;
        boolean sour;

        public Point(double y, double x){
            this.y = y;
            this.x = x;
            this.sour = false;
        }
    }

    public static void main(String[] args){
        Beehives b = new Beehives();
        b.sweetNSour();
    }

    private void sweetNSour() {
        scan = new Scanner(System.in);

        while(true) {
            double d = scan.nextDouble();
            int lines = scan.nextInt();
            Point[] beehivePositions = new Point[lines];
            double y, x;

            if(d == 0.0 && lines == 0) return;

            for (int i = 0; i < lines; i++) {
                x = scan.nextDouble();
                y = scan.nextDouble();
                beehivePositions[i] = new Point(y, x);
            }
            int sour = 0, sweet = 0;

            double beehiveDist = 0, deltaY = 0, deltaX = 0;
            for (int i = 0; i < beehivePositions.length; i++) {
                for (int j = i + 1; j < beehivePositions.length; j++) {
                    deltaY = beehivePositions[i].y - beehivePositions[j].y;
                    deltaX = beehivePositions[i].x - beehivePositions[j].x;
                    beehiveDist = Math.sqrt(Math.pow(deltaY, 2) + Math.pow(deltaX, 2));
                    if (beehiveDist <= d) {
                        beehivePositions[i].sour = true;
                        beehivePositions[j].sour = true;
                    }
                }
            }

            for (int i = 0; i < beehivePositions.length; i++) {
                if(beehivePositions[i].sour)
                    sour++;
                else
                    sweet++;
            }

            System.out.println(sour + " sour, " + sweet + " sweet");
        }


    }
}
