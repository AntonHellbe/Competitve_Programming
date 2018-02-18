import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class BirthdayParty {

    public BufferedReader br;
    public int p, c;
    public HashMap<Integer, ArrayList<Integer>> adjList;
    public Node[] visitedArr;
    public int visited = 0;

    public class Node{
        int num;
        boolean visited;

        public Node(int num){
            this.num = num;
            this.visited = false;
        }
    }

    public class Edge{
        int from, to;

        public Edge(int from, int to){
            this.from = from;
            this.to = to;
        }
    }


    public static void main(String[] args) throws IOException {
        BirthdayParty b = new BirthdayParty();
        b.inviteAllFriends();
    }

    private void inviteAllFriends() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] lines;

        outer: while(true) {
            lines = br.readLine().split(" ");
            p = Integer.parseInt(lines[0]);
            c = Integer.parseInt(lines[1]);
            visitedArr = new Node[p];
            adjList = new HashMap<>();

            if(p + c == 0) return;

            ArrayList<Edge> e = new ArrayList<>();

            for (int i = 0; i < p; i++) {
                visitedArr[i] = new Node(i);
                adjList.put(i, new ArrayList<>());
            }

            int a, b;

            for (int i = 0; i < c; i++) {
                lines = br.readLine().split(" ");
                a = Integer.parseInt(lines[0]);
                b = Integer.parseInt(lines[1]);
                adjList.get(a).add(b);
                adjList.get(b).add(a);
                e.add(new Edge(a, b));
                e.add(new Edge(b, a));
            }

            for (int i = 0; i < e.size(); i++) {
                Edge currEdge = e.get(i);
                removeEdge(currEdge.from, currEdge.to);
                if (!isConnected()) {
                    System.out.println("Yes");
                    continue outer;

                }
                adjList.get(currEdge.from).add(currEdge.to);
                adjList.get(currEdge.to).add(currEdge.from);

            }

            System.out.println("No");
        }
    }


    private boolean isConnected(){
        for (int i = 0; i < visitedArr.length; i++) {
            visitedArr[i].visited = false;
        }
        visited = 0;

        dfs(0);

        for (int i = 0; i < visitedArr.length; i++) {
            if(visitedArr[i].visited) visited++;
        }

        return p == visited;

    }


    private void dfs(int startNode){
        visitedArr[startNode].visited = true;
        ArrayList<Integer> neighbours = adjList.get(startNode);

        for (int i = 0; i < neighbours.size(); i++) {
            if(!visitedArr[neighbours.get(i)].visited){
                dfs(neighbours.get(i));
            }
        }

    }

    private void removeEdge(int a, int b){
        ArrayList<Integer> temp = adjList.get(a);
        for (int i = 0; i < temp.size(); i++) {
            if(temp.get(i) == b){
                temp.remove(i);
                break;
            }
        }

        temp = adjList.get(b);

        for (int i = 0; i < temp.size(); i++) {
            if(temp.get(i) == a){
                temp.remove(i);
                break;
            }
        }
    }
}
