import java.util.*;

/**
 * Created by Anton on 2017-10-23.
 */
public class LineSweepClosestPairs {

    static Scanner scan;
    static boolean running = true;
    static int numberOfPoints = 0;

    static class Point{
        double x;
        double y;

        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){
        scan = new Scanner(System.in);
        while(running)
            lineSweep();
    }

    static void lineSweep() {
        numberOfPoints = Integer.parseInt(scan.nextLine());
        double [] point;
        Point[] allpoints = new Point[numberOfPoints];
        if(numberOfPoints == 0){
            running = false;
            return;
        }

        for (int i = 0; i < numberOfPoints; i++) {
            point = Arrays.stream(scan.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            allpoints[i] = new Point(point[0], point[1]);
        }
        double dist = closestPair(allpoints);
        if(dist >= 10000)
            System.out.println("INFINITY");
        else
            System.out.println(String.format("%.4f",dist));


    }

    static double closestPair(Point[] points){

        double minDist = Double.POSITIVE_INFINITY;

        Point[] sortedPoints = Arrays.copyOf(points, points.length);
        int leftCandidate = 0;

        Arrays.sort(sortedPoints,X_COMPARATOR);

        SortedSet<Point> potentialCandidates = new TreeSet<Point>(Y_COMPARATOR);

        for(Point curr: sortedPoints){
            while(curr.x - sortedPoints[leftCandidate].x > minDist){
                potentialCandidates.remove(points[leftCandidate]);
                leftCandidate++;
            }

            Point bottomLimit = new Point(curr.x, (curr.y - minDist));
            Point topLimit = new Point(curr.x, (curr.y) + minDist);

            for(Point p: potentialCandidates.subSet(bottomLimit, topLimit)){
                if(!p.equals(curr)){
                    double newDist = distance(curr, p);
                    if(minDist > newDist)
                        minDist = newDist;
                }
            }
            potentialCandidates.add(curr);
        }

        return minDist;


    }

    private static final Comparator<Point> X_COMPARATOR = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            if(o1.x < o2.x)
                return -1;
            if(o1.x > o2.x)
                return 1;
            if(o1.y < o2.y)
                return -1;
            if(o1.y > o2.y)
                return -1;

            return 0;
        }
    };

    private static final Comparator<Point> Y_COMPARATOR = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            if(o1.y < o2.y)
                return -1;
            if(o1.y > o2.y)
                return 1;
            if(o1.x < o2.x)
                return -1;
            if(o1.x > o2.x)
                return 1;
            return 0;

        }
    };

    static double distance(Point p1, Point p2){
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;

        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }


}
