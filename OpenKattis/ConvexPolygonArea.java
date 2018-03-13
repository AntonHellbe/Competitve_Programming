import java.awt.*;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConvexPolygonArea {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        ConvexPolygonArea c = new ConvexPolygonArea();
        c.calcArea();
    }

    private void calcArea() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;
        int testcases = Integer.valueOf(br.readLine()), t = 0;

        while(t < testcases){
            split = br.readLine().split(" ");
            int numPoints = Integer.valueOf(split[0]);
            Point2D[] poly = new Point2D[numPoints + 1];

            double x, y;
            int polyIndex = 0;

            for (int i = 1; i < split.length; i += 2) {
                x = Double.valueOf(split[i]);
                y = Double.valueOf(split[i + 1]);
                poly[polyIndex++] = new Point2D.Double(x, y);
            }


            poly[numPoints] = poly[0];

            double area = 0;
            double fpx = poly[0].getX(), fpy = poly[0].getY();

            for (int i = 1; i < numPoints; i++) {
                Point2D p1 = poly[i];
                Point2D p2 = poly[i + 1];


                double a = p1.getX() - fpx;
                double b = p2.getX() - fpx;
                double c = p1.getY() - fpy;
                double d = p2.getY() - fpy;

                area += (a * d) - (b * c);
            }
            area = Math.abs(area / 2);
            System.out.println(area);

            t++;
        }
    }

}
