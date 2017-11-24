import java.util.*;

class Main {
    static Scanner scan;
    static HashMap<Integer, ArrayList<Node>> adjList;
    static boolean running = true;

    static class Node{

        int value;
        int set;
        boolean visited;

        Node(int value){
            this.value = value;
            visited = false;
        }

    }


    public static void main(String[] args){
        scan = new Scanner(System.in);

        while(running) {
            try {
                biColoring();
            }catch(Exception e){
                e.printStackTrace();
                scan.close();
                System.exit(0);
            }
        }

    }

    static void biColoring() {

        int numberOfEdges;
        int numberOfNodes;
        try {
            numberOfNodes = Integer.parseInt(scan.nextLine());
        }catch(Exception e){
            running = false;
            return;
        }
        if(numberOfNodes == 0){
            running = false;
            return;
        }
        numberOfEdges = Integer.parseInt(scan.nextLine());
        int[] input;


        adjList = new HashMap<>();

        for (int i = 0; i < numberOfNodes; i++) {
            adjList.put(i, new ArrayList<>());

        }

        for (int i = 0; i < numberOfEdges; i++) {
            input = Arrays.stream(scan.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            adjList.get(input[0]).add(new Node(input[1]));
            adjList.get(input[1]).add(new Node(input[0]));
        }

        adjList.get(0).get(0).set = 0;
        try {
            if (bfs(adjList.get(0).get(0)))
                System.out.println("BICOLORABLE.");
            else
                System.out.println("NOT BICOLORABLE.");
        }catch(Exception e){
            e.printStackTrace();
        }


    }

    static boolean bfs(Node startNode){

        Queue queue = new LinkedList();
        queue.add(startNode);

        while(!queue.isEmpty()){
            Node node = (Node) queue.remove();
            ArrayList<Node> neighbors = adjList.get(node.value);
            for (int i = 0; i < neighbors.size(); i++) {
                Node neighbor = neighbors.get(i);
                if(neighbor.visited){
                    if(neighbor.set == node.set){
                        return false;
                    }
                    continue;
                }else{
                    neighbor.visited = true;
                    neighbor.set = 1 - node.set;
                    queue.add(neighbor);

                }

            }

        }
        return true;

    }

}
