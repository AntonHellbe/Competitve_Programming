import java.util.*;


public class Friends {

    static HashMap<Integer, ArrayList<Integer>> friendsGraph;
    static HashMap<Integer, Vertex> visitedDict;
    static Scanner scan;
    static int longestSequence;
    static int sequence;

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
        visitedDict = new HashMap<>();

        String[] temp = scan.nextLine().split(" ");
        int[] friendMapper;
        int population = Integer.parseInt(temp[0]), pairs = Integer.parseInt(temp[1]);


        for (int i = 1; i < population + 1; i++) {
            friendsGraph.put(i, new ArrayList<>());
            visitedDict.put(i, new Vertex(i));
        }


        for (int i = 0; i < pairs; i++) {
            friendMapper = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            friendsGraph.get(friendMapper[0]).add(friendMapper[1]);
            friendsGraph.get(friendMapper[1]).add(friendMapper[0]);
        }


        longestSequence = 0;
        for (int i = 1; i < population + 1; i++) {
            sequence = 0;
            dfs(i);
            visitedDict.values().forEach((v) -> {
                v.visited = false;
            });
            if(sequence > longestSequence){
                longestSequence = sequence;
            }


        }

        System.out.println(longestSequence);

    }

    static void dfs(int i){
		
        visitedDict.get(i).visited = true;
        sequence++;
        friendsGraph.get(i).forEach((vert) -> {
            if(!visitedDict.get(vert).visited){
                dfs(vert);
            }
        });

    }
}
