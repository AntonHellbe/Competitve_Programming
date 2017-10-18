import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Anton on 2017-10-18.
 */
public class ClosestPairs {

    static BufferedReader scan;
    static boolean running = true;
    static Point[] pointList;
    static NumberFormat format;

    static class Point{
        double x;
        double y;

        Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{
        scan = new BufferedReader(new InputStreamReader(System.in));
        while(running)
            solve();
    }

    static double Helper(double x, double y){
        return Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
    }


    static void solve() throws IOException{
        scan.readLine().split("\\[\\+\\=]");
        int points = Integer.parseInt(scan.readLine().toString());
        pointList = new Point[points];
        if(points == 0){
            running = false;
            return;
        }

        for (int i = 0; i < points; i++) {
            String[] temp = scan.readLine().toString().split(" ");
            pointList[i] = (new Point(Double.parseDouble(temp[0]), Double.parseDouble(temp[1])));
        }


        double minDistance = 10000, yDiff, xDiff, dist;


        for (int i = 0; i < pointList.length; i++) {
            for (int j = i + 1; j < pointList.length; j++) {
                xDiff = pointList[j].x - pointList[i].x;
                yDiff = pointList[j].y - pointList[i].y;
                dist = Helper(xDiff, yDiff);
                if (dist < minDistance) {
                    minDistance = dist;
                }
            }
        }
        if(minDistance >= 10000){
            System.out.println("INFINITY");
        }else{
            System.out.println(String.format("%.4f", minDistance));
        }

    }

}
