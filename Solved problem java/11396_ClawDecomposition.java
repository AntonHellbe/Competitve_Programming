import java.util.*;

public class ClawDecomposition {

    static Scanner scan;
    static boolean running = true;
    static HashMap<Integer, ArrayList<Node>> adjList;

    static class Node{
        int value;
        boolean set;
        boolean visited;

        Node(int value){
            this.value = value;
            this.visited = false;
        }


    }

    public static void main(String[] args){
        scan = new Scanner(System.in);
        while(running){
            clawDecomposition();
        }

        scan.close();
        System.exit(0);

    }

    private static void clawDecomposition() {
        adjList = new HashMap<>();
        int[] input;
        int numberOfNodes = Integer.parseInt(scan.nextLine());

        if(numberOfNodes == 0){
            running = false;
            return;
        }

        for (int i = 1; i < numberOfNodes + 1; i++) {
            adjList.put(i, new ArrayList<>());
        }

        while(true){
            input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(input[0] == 0 && input[1] == 0){
                break;
            }
            adjList.get(input[0]).add(new Node(input[1]));
            adjList.get(input[1]).add(new Node(input[0]));
        }

        adjList.get(1).get(0).set = true;
        if(bfs(adjList.get(1).get(0)))
            System.out.println("YES");
        else
            System.out.println("NO");

    }


    public static boolean bfs(Node startNode){

        LinkedList queue = new LinkedList();
        queue.add(startNode);

        while(!queue.isEmpty()){
            Node node = (Node) queue.remove();
            ArrayList<Node> neighbours = adjList.get(node.value);
            for(int i = 0; i < neighbours.size(); i++){
                Node currentNode = neighbours.get(i);
                if(currentNode.visited){
                    if(node.set == currentNode.set){
                        return false;
                    }
                }else{
                    currentNode.visited = true;
                    currentNode.set = !node.set;
                    queue.add(currentNode);
                }
            }
        }

        return true;
    }


}
