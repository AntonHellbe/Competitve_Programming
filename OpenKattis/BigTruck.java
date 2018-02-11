import java.util.*;

public class BigTruck {

    public Scanner scan;
    public HashMap<Integer, ArrayList<Edge>> adjList;
    public Vertice[] verticeArray;
    public int lastStop = 0;

    public class Edge {
        int to, weight;

        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    public class Vertice {
        int number, packages, distance;

        public Vertice(int number, int packages) {
            this.number = number;
            this.packages = packages;
            this.distance = Integer.MAX_VALUE;
        }

    }

    public static void main(String[] args) {
        BigTruck bigTruck = new BigTruck();
        bigTruck.findMaxPath();
    }

    private void findMaxPath() {
        scan = new Scanner(System.in);
        adjList = new HashMap<>();
        lastStop = Integer.parseInt(scan.nextLine());
        verticeArray = new Vertice[lastStop + 1];
        int[] input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] packagesArr = new int[lastStop + 1];
        for (int i = 1; i <= lastStop; i++) {
            verticeArray[i] = new Vertice(i, 0);
        }
        for (int i = 0; i < input.length; i++) {
            packagesArr[i + 1] = input[i];
        }

        int roads = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < roads; i++) {
            input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adjList.putIfAbsent(input[0], new ArrayList<>());
            adjList.putIfAbsent(input[1], new ArrayList<>());

            adjList.get(input[0]).add(new Edge(input[1], input[2]));
            adjList.get(input[1]).add(new Edge(input[0], input[2]));
        }
        verticeArray[1].packages = packagesArr[1];
        dijkstra(verticeArray[1], packagesArr);

        if(verticeArray[lastStop].distance == Integer.MAX_VALUE) {
            System.out.println("impossible");
        }else {
            System.out.println(verticeArray[lastStop].distance + " " + verticeArray[lastStop].packages);
        }


    }

    private void dijkstra(Vertice startVertice, int[] packarArr) {
        startVertice.distance = 0;
        PriorityQueue<Vertice> pq = new PriorityQueue<>((a1, a2) -> a1.distance - a2.distance);
        pq.add(startVertice);

        while(!pq.isEmpty()) {
            Vertice currentVert = pq.remove();

            ArrayList<Edge> neighbours = adjList.get(currentVert.number);
            if(neighbours == null) continue;

            for (int i = 0; i < neighbours.size(); i++) {
                Edge neighbour = neighbours.get(i);
                Vertice nextVert = verticeArray[neighbour.to];
                if(nextVert.distance > nextVert.distance + neighbour.weight) {
                    nextVert.packages = packarArr[nextVert.number] + currentVert.packages;
                    nextVert.distance = currentVert.distance + neighbours.get(i).weight;
                    pq.add(nextVert);

                }else if(nextVert.distance == currentVert.distance + neighbour.weight &&
                        currentVert.packages + packarArr[nextVert.number] > nextVert.packages) {
                    nextVert.packages = currentVert.packages + packarArr[nextVert.number];
                    nextVert.distance = currentVert.distance + neighbours.get(i).weight;
                    pq.add(nextVert);
                }

            }
        }
    }
}
