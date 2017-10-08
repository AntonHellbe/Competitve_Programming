import java.util.*;
/**
@Author Anton Hellbe
Finds the longest friends sequence using recursive DFS (DFS with stack might be quicker?) TODO - Try it out
Running time 800ms according to UVA online judge
 **/

public class Friends {

    static HashMap<Integer, ArrayList<Integer>> friendsGraph;
    static Vertex[] visitedArray;
    static Scanner scan;
    static int longestSequence;
    static ArrayList<Integer> friendsList;

    static class Vertex{

        int id;
        boolean visited = false;

        public Vertex(int id){
            this.id = id;
            visited = false;
        }

        @Override
        public String toString() {
            return this.id + " " + visited;
        }

    }

    public static void main(String[] args){
        scan = new Scanner(System.in);
        int i = 0, testCases = Integer.parseInt(scan.nextLine());
        while(i != testCases){
            friendsGraph();
            i++;
        }
        scan.close();
        System.exit(0);

    }

    static void friendsGraph() {
        friendsGraph = new HashMap<>();


        String[] temp = scan.nextLine().split(" ");
        int[] friendMapper;
        int population = Integer.parseInt(temp[0]), pairs = Integer.parseInt(temp[1]);
        visitedArray = new Vertex[population + 1];

        for (int i = 0; i < population + 1; i++) {
            friendsGraph.put(i, new ArrayList<>());
            visitedArray[i] = new Vertex(i);
        }

        for (int i = 0; i < pairs; i++) {
            friendMapper = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            friendsGraph.get(friendMapper[0]).add(friendMapper[1]); // Undirected graph
            friendsGraph.get(friendMapper[1]).add(friendMapper[0]);
        }


        longestSequence = 0;
        for (int i = 1; i < population + 1; i++) {
            if(!visitedArray[i].visited){
                friendsList = new ArrayList<>(); // if a node isnt discovered yet, create a new list add all his friends to this list, this ensures that we dont run DFS on a node that's already discovered
                dfs(i);

            }

            if(friendsList.size() > longestSequence){
                longestSequence = friendsList.size();
            }

        }

        System.out.println(longestSequence);

    }

    static void dfs(int i){
        visitedArray[i].visited = true;
        friendsList.add(i);
        friendsGraph.get(i).forEach((vert) -> {
            if(!visitedArray[vert].visited){
                dfs(vert);
            }
        });

    }
}
