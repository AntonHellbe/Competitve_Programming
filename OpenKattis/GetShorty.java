import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class GetShorty {

    public BufferedReader br;
    public HashMap<Integer, ArrayList<Edge>> adjList;
    public Vertex[] v;


    public class Vertex implements Comparable<Vertex> {
        int num;
        double factor;

        public Vertex(int num, double factor){
            this.num = num;
            this.factor = factor;
        }

        @Override
        public int compareTo(Vertex o) {
            return Double.compare(o.factor, this.factor);
        }
    }

    public class Edge {
        int to;
        double fac;

        public Edge(int to, double fac){
            this.to = to;
            this.fac = fac;
        }
    }

    public static void main(String[] args) throws IOException {
        GetShorty g = new GetShorty();
        g.solve();
    }

    private void solve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;


        while(true){

            split = br.readLine().split(" ");
            int n = Integer.valueOf(split[0]), m = Integer.valueOf(split[1]);
            if(n == 0 && m == 0) return;
            v = new Vertex[n];
            adjList = new HashMap<>();

            for (int i = 0; i < n; i++) {
                v[i] = new Vertex(i, 0);
                adjList.put(i, new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                split = br.readLine().split(" ");
                int a = Integer.valueOf(split[0]), b = Integer.valueOf(split[1]);
                double fac = Double.valueOf(split[2]);
                adjList.get(a).add(new Edge(b, fac));
                adjList.get(b).add(new Edge(a, fac));

            }

            dijkstra(0);

            System.out.printf("%.4f\n" ,v[n - 1].factor);

        }


    }

    public void dijkstra(int startNode) {
        v[startNode].factor = 1;
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Vertex::compareTo);

        pq.add(v[startNode]);
        while(!pq.isEmpty()){

            Vertex currentVert = pq.remove();
            ArrayList<Edge> neighbours = adjList.get(currentVert.num);

            for (Edge e : neighbours) {
                if(v[e.to].factor < v[currentVert.num].factor * e.fac){
                    v[e.to].factor = v[currentVert.num].factor * e.fac;
                    pq.add(v[e.to]);
                }
            }

        }
    }
}
