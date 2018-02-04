import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class birthdayparty {
    
    static Scanner scan;
    static Node[] visitedArray;
    static HashMap<Integer, ArrayList<Integer>> adjList;
    static int visitedPeople = 0;
    static boolean running = true;
    
    static class Node {
        int value;
        boolean visited;
        
        public Node(int value) {
            this.value = value;
            this.visited = false;
        }
    }

    static class Edge {
        int from, to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return from + " " + to;
        }
    }
    
    public static void main(String[] args) {
        scan = new Scanner(System.in);
        while(running) {
            solveBirthdayIssue();
        }
    }

    static void solveBirthdayIssue() {
        adjList = new HashMap<>();
        int[] input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int peopleToInvite = input[0], connections = input[1];
        ArrayList<Edge> edgeList = new ArrayList<Edge>();

        if(peopleToInvite == 0 && connections == 0) {
            running = false;
            return;
        }
        visitedArray = new Node[peopleToInvite + 1];

        for (int i = 0; i <= peopleToInvite; i++) {
            visitedArray[i] = new Node(i);
        }

        for (int i = 0; i < connections; i++) {
            input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adjList.putIfAbsent(input[0], new ArrayList<>());
            adjList.putIfAbsent(input[1], new ArrayList<>());
            adjList.get(input[0]).add(input[1]);
            adjList.get(input[1]).add(input[0]);
            edgeList.add(new Edge(input[0], input[1]));
        }

        for (int i = 0; i < edgeList.size(); i++) {
            Edge currentEdge = edgeList.get(i);
            adjList.get(currentEdge.from).removeIf(x -> x == currentEdge.to);
            adjList.get(currentEdge.to).removeIf(x -> x == currentEdge.from);

            boolean canInviteAll = false;


            for (int j = 0; j < peopleToInvite; j++) {
                dfs(j);
                if(visitedPeople >= peopleToInvite) {
                    canInviteAll = true;
                }

                for (int k = 0; k < visitedArray.length; k++) {
                    visitedArray[k].visited = false;
                }
                visitedPeople = 0;
            }

            if(!canInviteAll) {
                System.out.println("Yes");
                return;
            }


            adjList.get(currentEdge.from).add(currentEdge.to);
            adjList.get(currentEdge.to).add(currentEdge.from);
        }

        System.out.println("No");

    }
    
    
    static void dfs(int i) {
        visitedArray[i].visited = true;
        visitedPeople++;
        adjList.get(i).forEach(vert -> {
            if (!visitedArray[vert].visited) {
                dfs(vert);

            }
        });
    }
}
