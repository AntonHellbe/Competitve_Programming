import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class MinimumSpanningTree {

    public class Edge implements Comparable<Edge>{
        int from, to, cost;

        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public class UnionFind {

        private int[] parent;
        private int[] rank;
        public int nSets;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            nSets = size;
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);

            if (xRoot == yRoot) {
                return;
            }

            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else if (rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
            } else {
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
            nSets--;
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }

    public BufferedReader br;

    public static void main(String[] args) throws IOException{
        MinimumSpanningTree mst = new MinimumSpanningTree();
        mst.go();
    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;

        while(true) {
            split = br.readLine().split(" ");
            int n = Integer.valueOf(split[0]);
            int m = Integer.valueOf(split[1]);
            if(n == 0 && m == 0) return;
            ArrayList<Edge> edgeList = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                split = br.readLine().split(" ");
                int a = Integer.valueOf(split[0]);
                int b = Integer.valueOf(split[1]);
                int c = Integer.valueOf(split[2]);
                if(a > b)
                    edgeList.add(new Edge(b, a, c));
                else
                    edgeList.add(new Edge(a, b, c));
            }

            edgeList.sort(Edge::compareTo);
            ArrayList<Edge> mstEdges = new ArrayList<>();
            int connectedEdges = 0, sum = 0;
            UnionFind uf = new UnionFind(n);

            for (Edge e : edgeList) {
                if (uf.find(e.from) != uf.find(e.to)) {
                    uf.union(e.from, e.to);
                    sum += e.cost;
                    connectedEdges++;
                    mstEdges.add(e);
                    if (connectedEdges == n - 1) break;
                }
            }

            mstEdges.sort(new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    if (o1.from == o2.from) {
                        return Integer.compare(o1.to, o2.to);
                    }
                    return Integer.compare(o1.from, o2.from);
                }
            });

            if (connectedEdges == n - 1) {
                System.out.println(sum);
                for (Edge e : mstEdges) {
                    System.out.println(e.from + " " + e.to);
                }
            } else {
                System.out.println("Impossible");
            }
        }




    }


}
