import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ShortestPaths {

    public Scanner scan;
    public Node[] nodeArray;
    public HashMap<Integer, ArrayList<Edge>> adjList;

    public class Node implements Comparable<Node>{
        int number, distance;

        public Node(int number){
            this.number = number;
            this.distance = Integer.MAX_VALUE;
        }

        @Override
        public int compareTo(Node node) {
            int distanceQ = ((Node) node).distance;

            return this.distance - distanceQ;
        }
    }

    public class Edge{
        int to, weight;

        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return to + "";
        }

    }

    public static void main(String[] args) throws IOException{
        ShortestPaths p = new ShortestPaths();
        p.solveShortestPaths();
    }

    private void solveShortestPaths() throws IOException {
        scan = new Scanner(System.in);
        adjList = new HashMap<>();
        while(true) {
            int nodes = scan.nextInt(), edges = scan.nextInt(), queries = scan.nextInt(), startIndex = scan.nextInt();

            if(nodes + edges + queries + startIndex == 0) {
                return;
            }


            nodeArray = new Node[nodes];

            for (int i = 0; i < nodes; i++) {
                nodeArray[i] = new Node(i);
                adjList.put(i, new ArrayList<>());
            }
            int a, b, c;
            for (int i = 0; i < edges; i++) {
                a = scan.nextInt();
                b = scan.nextInt();
                c = scan.nextInt();

                adjList.get(a).add(new Edge(b, c));
            }
            dijkstra(startIndex);

            for (int i = 0; i < queries; i++) {
                int queryNode = scan.nextInt();
                if(nodeArray[queryNode].distance != Integer.MAX_VALUE) {
                    System.out.println(nodeArray[queryNode].distance);
                }else {
                    System.out.println("Impossible");
                }
            }
            System.out.println("");
            adjList.clear();
        }
    }


    private void dijkstra(int startNode) {
        for (int i = 0; i < nodeArray.length; i++) {
            nodeArray[i].distance = Integer.MAX_VALUE;
        }
        nodeArray[startNode].distance = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(nodeArray[startNode]);

        while(!pq.isEmpty()){
            Node currentNode = pq.remove();

            ArrayList<Edge> neighbors = adjList.get(currentNode.number);

            for (int i = 0; i < neighbors.size(); i++) {
                Edge currentEdge = neighbors.get(i);
                Node nextNode = nodeArray[currentEdge.to];
                if(nextNode.distance > currentNode.distance + currentEdge.weight) {
                    nextNode.distance = currentNode.distance+ currentEdge.weight;
                    pq.add(nextNode);

                }
            }

        }
    }
}
