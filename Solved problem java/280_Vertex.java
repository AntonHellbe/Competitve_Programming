import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Vertex {

   static class Node{
       int value;
       boolean visited;

       Node(int value){
           this.value = value;
           this.visited = false;
       }

       @Override
       public String toString() {
           return this.value + " " + this.visited;
       }
   }

    static BufferedReader scanner;
    static boolean running = true;
    static HashMap<Integer, ArrayList<Integer>> adjList;
    static Node[] visitedArray;
    static int nodesVisitedCount = 0;


    public static void main(String[] args) throws IOException{
        scanner = new BufferedReader(new InputStreamReader(System.in));
        while(running)
            reachAble();

        scanner.close();
        System.exit(0);
    }



    static void reachAble() throws IOException {
        adjList = new HashMap<>();

        int[] input;
        boolean readingInput = true;
        int numberOfNodes = Integer.parseInt(scanner.readLine().toString());

        if(numberOfNodes == 0){
            running = false;
            return;
        }
        visitedArray = new Node[numberOfNodes + 1];


        for (int i = 1; i < numberOfNodes + 1; i++) {
            adjList.put(i, new ArrayList<>());
            visitedArray[i] = new Node(i);
        }

        while(readingInput){
            input = Arrays.stream(scanner.readLine().toString().split(" "))
                    .mapToInt(Integer::parseInt)
                    .filter(number -> number != 0).toArray();
            if(input.length == 0){
                readingInput = false;
                continue;
            }

            for (int i = 1; i < input.length; i++) {
                adjList.get(input[0]).add(input[i]);
            }

        }

        input = Arrays.stream(scanner.readLine().toString().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        ArrayList<Integer> startNodes = new ArrayList<>();

        for (int i = 1; i < input[0] + 1; i++) {
            startNodes.add(input[i]);
        }

        for (int i = 0; i < startNodes.size(); i++) {
            dfs(startNodes.get(i));
            String notVisited = "";

            for (int j = 1  ; j < visitedArray.length; j++) {
                if(!visitedArray[j].visited){
                    notVisited += visitedArray[j].value + " ";
                }else{
                    visitedArray[j].visited = false;
                }
            }
            if(notVisited.length() > 1){
                notVisited = notVisited.substring(0, notVisited.length() - 1);
                System.out.print(numberOfNodes - nodesVisitedCount + " ");
                System.out.print(notVisited);
            }else{
                System.out.print(0);
            }




            nodesVisitedCount = 0;
            System.out.println("");
        }

    }

    static void dfs(int startNode){

        ArrayList<Integer> neighbours = adjList.get(startNode);
        for (int i = 0; i < neighbours.size(); i++) {
            if(!visitedArray[neighbours.get(i)].visited){
                visitedArray[neighbours.get(i)].visited = true;
                nodesVisitedCount++;
                dfs(neighbours.get(i));
            }
        }
    }
}
