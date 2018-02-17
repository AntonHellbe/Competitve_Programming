import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class AWalkThroughTheForest {

    public BufferedReader br;
    public HashMap<Integer, ArrayList<Edge>> adjList;
    public int[] distances;
    int[] totalPaths;

    public class Edge{
        int from, to, weight;

        public Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        AWalkThroughTheForest a = new AWalkThroughTheForest();
        a.solveHowManyPaths();

    }

    private void solveHowManyPaths() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String lines[] = br.readLine().split(" ");
            int intersections = Integer.parseInt(lines[0]);

            if (intersections == 0) return;

            int paths = Integer.parseInt(lines[1]);
            distances = new int[intersections + 1];
            adjList = new HashMap<>();

            for (int i = 1; i < intersections + 1; i++) {
                distances[i] = Integer.MAX_VALUE;
                adjList.put(i, new ArrayList<>());
            }
            int a, b, c;
            for (int i = 0; i < paths; i++) {
                lines = br.readLine().split(" ");
                a = Integer.parseInt(lines[0]);
                b = Integer.parseInt(lines[1]);
                c = Integer.parseInt(lines[2]);
                adjList.get(a).add(new Edge(a, b, c));
                adjList.get(b).add(new Edge(b, a, c));
            }

            totalPaths = new int[intersections + 1];
            Arrays.fill(totalPaths, -1);
            totalPaths[1] = 1;
            dijkstra();
            System.out.println(countPaths(2));
        }

    }

    private int countPaths(int to) {
        if(totalPaths[to] != -1) return totalPaths[to];
        int ways = 0;
        int from;
        int size = adjList.get(to).size();
        for (int i = 0; i < size; i++) {
            from = adjList.get(to).get(i).to;
            if(distances[from] > distances[to]) ways += countPaths(from);
        }

        return totalPaths[to] = ways;
    }


    private void dijkstra() {
        distances[2] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(2);

        while(!pq.isEmpty()){
            Integer currentNode = pq.remove();

            ArrayList<Edge> neighbours = adjList.get(currentNode);
            for (int i = 0; i < neighbours.size(); i++) {
                Edge e = neighbours.get(i);
                int dist = distances[e.to];
                if(dist > distances[currentNode] + e.weight) {
                    distances[e.to] = distances[currentNode] + e.weight;
                    pq.add(e.to);
                }

            }


        }
    }

    private void prettyPrint() {
        adjList.forEach((k, v) -> {
            System.out.print(k + " ");
            v.forEach((e) -> {
                System.out.print(e.to + " ");
            });
            System.out.println("");
        });
    }
}
