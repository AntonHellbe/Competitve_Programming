import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FlyingSafely {

    public BufferedReader br;
    public HashMap<Integer, ArrayList<Integer>> adjList;
    public Vertex[] visitedArray;
    public int pilots;

    public class Vertex {
        int number;
        boolean visited;

        public Vertex(int number){
            this.number = number;
            this.visited = false;
        }
    }

    public static void main(String[] args) throws IOException {
        FlyingSafely f = new FlyingSafely();
        f.graphProblem();
    }

    private void graphProblem() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(br.readLine()), i = 0;
        String[] lines;
        while(i < testcases) {
            adjList = new HashMap<>();
            lines = br.readLine().split(" ");
            int n = Integer.parseInt(lines[0]);
            int m = Integer.parseInt(lines[1]);
            int a, b;
            visitedArray = new Vertex[n + 1];
            for (int j = 1; j <= n; j++) {
                visitedArray[j] = new Vertex(j);
                adjList.put(j, new ArrayList<>());
            }

            for (int j = 0; j < m; j++) {
                lines = br.readLine().split(" ");
                a = Integer.parseInt(lines[0]);
                b = Integer.parseInt(lines[1]);
                adjList.get(a).add(b);
                adjList.get(b).add(a);
            }
            pilots = 0;

            dfs(1);

            i++;
            System.out.println(pilots);
        }
    }


    public void dfs(int startNode){
        visitedArray[startNode].visited = true;

        ArrayList<Integer> neighbours = adjList.get(startNode);

        for (int i = 0; i < neighbours.size(); i++) {
            if(!visitedArray[neighbours.get(i)].visited){
                dfs(neighbours.get(i));
                pilots += 1;
            }
        }
    }
}
