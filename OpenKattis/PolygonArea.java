import java.awt.*;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PolygonArea {

    public BufferedReader br;

    public static void main(String[] args) throws IOException{
        PolygonArea p = new PolygonArea();
        p.calcArea();
    }

    private void calcArea() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;

        while(true) {
            int numPoints = Integer.valueOf(br.readLine());

            if(numPoints == 0) return;

            double[] xCoordinates = new double[numPoints];
            double[] yCoordinates = new double[numPoints];

            double x, y;

            for (int i = 0; i < numPoints; i++) {
                split = br.readLine().split(" ");
                x = Double.valueOf(split[0]);
                y = Double.valueOf(split[1]);
                xCoordinates[i] = x;
                yCoordinates[i] = y;
            }

            boolean isCCW = isCCW(xCoordinates, yCoordinates, numPoints);

            double area = 0;
            int j = numPoints - 1;
            // Shoelace algorithm
            for (int i = 0; i < numPoints; i++) {
                area += (xCoordinates[j] + xCoordinates[i]) * (yCoordinates[j] - yCoordinates[i]);
                j = i;
            }

            area = Math.abs(area / 2);

            if(isCCW){
                System.out.format("CCW %.1f\n", area);
            }else{
                System.out.format("CW %.1f\n", area);
            }




        }


    }


    private boolean isCCW(double[] xCoords, double[] yCoords, int numPoints) {
        double a = 0.0;
        for (int i = 0; i < numPoints; i++) {
            a += (xCoords[(i + 1) % numPoints] - xCoords[i]) * (yCoords[(i + 1) % numPoints] + yCoords[i]);
        }

        return a <= 0.0;

    }




}
