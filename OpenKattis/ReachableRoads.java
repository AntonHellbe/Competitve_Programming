import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ReachableRoads {

    public BufferedReader br;
    public HashMap<Integer, ArrayList<Integer>> adjList;
    public boolean[] visitedArr;

    public static void main(String[] args) throws IOException {
        ReachableRoads r = new ReachableRoads();
        r.howManyRoadsToBuild();

    }

    private void howManyRoadsToBuild() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;

        int testcases = Integer.valueOf(br.readLine()), t = 0;

        while(t < testcases) {
            int cities = Integer.valueOf(br.readLine());
            int roads = Integer.valueOf(br.readLine());

            visitedArr = new boolean[cities];
            adjList = new HashMap<>();
            int a, b;
            for (int i = 0; i < cities; i++) {
                adjList.put(i, new ArrayList<>());
            }

            for (int i = 0; i < roads; i++) {
                split = br.readLine().split(" ");
                a = Integer.valueOf(split[0]);
                b = Integer.valueOf(split[1]);

                adjList.get(a).add(b);
                adjList.get(b).add(a);
            }

//            adjList.forEach((k, v) -> {
//                System.out.println(k + " : " + v);
//            });

            int roadsToBuild = 0;

            for (int i = 0; i < cities; i++) {
                if (!visitedArr[i]) {
                    dfs(i);
                    roadsToBuild++;
                }
            }

            System.out.println(roadsToBuild - 1);
            t++;
        }

    }


    private void dfs(int startNode){
        visitedArr[startNode] = true;

        ArrayList<Integer> neigh = adjList.get(startNode);
        for (int i = 0; i < neigh.size(); i++) {
            Integer t = neigh.get(i);
            if(!visitedArr[t]){
                dfs(t);
            }

        }
    }
}
