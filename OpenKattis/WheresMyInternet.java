import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class WheresMyInternet {

    public BufferedReader br;
    public int[][] adjList;
    public boolean[] visited;

    static class UnionFind {
        private int[] parent;
        private int[] rank;
        public int nSets;

        public UnionFind(int size) {
            parent = new int[size + 1];
            rank = new int[size + 1];
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




    public static void main(String[] args) throws IOException {
        WheresMyInternet w = new WheresMyInternet();
        w.findConnectedHouses();
    }

    private void findConnectedHouses() throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;


        split = br.readLine().split(" ");

        int houses = Integer.valueOf(split[0]);
        int connections = Integer.valueOf(split[1]);

        UnionFind uf = new UnionFind(houses);

        int a, b;

        for (int i = 0; i < connections; i++) {
            split = br.readLine().split(" ");
            a = Integer.valueOf(split[0]);
            b = Integer.valueOf(split[1]);
            uf.union(a, b);
        }

        ArrayList<Integer> notConnect = new ArrayList<>();
        int parent = uf.find(1);

        for (int i = 1; i <= houses; i++) {
            if(uf.find(i) != parent){
                notConnect.add(i);
            }
        }


        if(notConnect.size() == 0){
            System.out.println("Connected");
        }else {
//            notConnect.sort(Integer::compareTo);
            for (int i = 0; i < notConnect.size(); i++) {
                System.out.println(notConnect.get(i));
            }
        }

    }


    public void dfs(int startNode){
        visited[startNode] = true;

        for (int i = 0; i < adjList[startNode].length; i++) {
            if(!visited[i] && adjList[startNode][i] != 0){
                dfs(i);
            }
        }
    }

}
