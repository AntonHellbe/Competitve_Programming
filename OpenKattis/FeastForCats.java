import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FeastForCats {

    public class Edge implements Comparable<Edge> {
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
        FeastForCats feast = new FeastForCats();
        feast.go();
    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;
        int testCases = Integer.valueOf(br.readLine()), t = 0;

        while(t < testCases) {
            split = br.readLine().split(" ");
            int m = Integer.valueOf(split[0]), cats = Integer.valueOf(split[1]);
            ArrayList<Edge> edgeList = new ArrayList<>();
            int catCombinations = (cats * (cats - 1)) / 2;

            for (int i = 0; i < catCombinations; i++) {
                split = br.readLine().split(" ");
                int a = Integer.valueOf(split[0]);
                int b = Integer.valueOf(split[1]);
                int c = Integer.valueOf(split[2]);
                edgeList.add(new Edge(a, b, c));
            }

            UnionFind uf = new UnionFind(cats);
            int count = 0;
            int sum = 0;
            edgeList.sort(Edge::compareTo);

            for (Edge e: edgeList) {
                if (uf.find(e.from) != uf.find(e.to)) {
                    sum += e.cost;
                    uf.union(e.from, e.to);
                    count++;
                    if (count == cats - 1) break;
                }
            }

            if((count == cats - 1) && (sum + cats <= m)){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }


            t++;
        }


    }

}
