import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class ReconnectingComputerSites {
    static BufferedReader br;
    static boolean running = true;
    static HashMap<Integer, Node> ufMap;
    static ArrayList<Edge> edgeList;
    static int numberOfComputerSites;
    static int count;

    static class Node {
        int data;
        Node parent;
        int rank;

        Node(int data) {
            this.data = data;
            rank = 0;
        }

    }

    static class UnionFind {

        UnionFind() {
            ufMap = new HashMap<>();
        }


        static void makeSet(int data) {
            Node node = new Node(data);
            node.parent = node;
            ufMap.putIfAbsent(data, node);

        }

        static void union(int data1, int data2) {
            Node node1 = ufMap.get(data1);
            Node node2 = ufMap.get(data2);

            Node parent1 = findset(node1);
            Node parent2 = findset(node2);


            if (parent1.rank >= parent2.rank) {
                if (parent1.rank == parent2.rank) {
                    parent1.rank++;
                    parent2.parent = parent1;
                }

                parent2.parent = parent1;
            } else {
                parent1.parent = parent2;
            }
        }

        static Node findset(Node node) {
            Node node_parent = node.parent;
            if (node == node_parent)
                return node_parent;

            node_parent = findset(node_parent.parent);
            node.parent = node_parent;
            return node_parent;
        }
    }

    static class Edge{
        int from, to, cost;

        Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int getCost() {
            return this.cost;
        }
    }

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        while(running)
            connectComputerSites();

    }

    static void connectComputerSites() throws IOException {
        UnionFind uf = new UnionFind();
        try {
            numberOfComputerSites = Integer.parseInt(br.readLine());
        }catch(Exception e){
            running = false;
            return;
        }

        if(count > 0)
            System.out.println("");

        count++;
        edgeList = new ArrayList<>();
        int[] input;
        int sum = 0;

        for (int i = 0; i < numberOfComputerSites - 1; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            edgeList.add(new Edge(input[0], input[1], input[2]));
        }

        sum = kruskalsAlgorithm(uf);
        System.out.println(sum);

        int newConnections = Integer.parseInt(br.readLine());

        for (int i = 0; i < newConnections; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            edgeList.add(new Edge(input[0], input[1], input[2]));
        }

        int originallyAvailable = Integer.parseInt(br.readLine());

        for (int i = 0; i < originallyAvailable; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            edgeList.add(new Edge(input[0], input[1], input[2]));
        }
        
        uf = new UnionFind();
        sum = kruskalsAlgorithm(uf);
        System.out.println(sum);

        br.readLine();

    }


    static int kruskalsAlgorithm(UnionFind uf){
        int sum = 0;
        for (int i = 1; i <= numberOfComputerSites; i++) {
            uf.makeSet(i);
        }

        edgeList.sort(Comparator.comparing(Edge::getCost));

        for (int i = 0; i < edgeList.size(); i++) {
            Edge currentEdge = edgeList.get(i);
            if(uf.findset(ufMap.get(currentEdge.from)) != uf.findset(ufMap.get(currentEdge.to))){
                uf.union(currentEdge.from, currentEdge.to);
                sum += currentEdge.getCost();
            }
        }

        return sum;
    }

}

