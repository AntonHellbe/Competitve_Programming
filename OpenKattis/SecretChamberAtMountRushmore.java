import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SecretChamberAtMountRushmore {

    public BufferedReader br;
    public int[][] adjList;

    public static void main(String[] args) throws IOException {
        SecretChamberAtMountRushmore sc = new SecretChamberAtMountRushmore();
        sc.go();

    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;
        adjList = new int[26][26];
        split = br.readLine().split(" ");
        int m = Integer.valueOf(split[0]), n = Integer.valueOf(split[1]);
        for (int i = 0; i < m; i++) {
            split = br.readLine().split(" ");
            int a = (split[0].charAt(0) - 'a');
            int b = (split[1].charAt(0) - 'a');
            adjList[a][b] = 1;
        }

        for (int i = 0; i < n; i++) {
            split = br.readLine().split(" ");
            String word1 = split[0], word2 = split[1];
            if(word1.length() != word2.length()){
                System.out.println("no");
                continue;
            }

            boolean isTransformAble = true;
            for (int j = 0; j < word1.length(); j++) {
                int a = word1.charAt(j) - 'a';
                int b = word2.charAt(j) - 'a';
                if(!dfs(a, b)){
                    isTransformAble = false;
                    break;
                }
            }

            if(!isTransformAble)
                System.out.println("no");
            else
                System.out.println("yes");
            
        }



    }


    private boolean dfs(int currNumber, int targetNumber){
        if(currNumber == targetNumber) return true;
        boolean[] visited = new boolean[26];

        Stack<Integer> q = new Stack();
        q.add(currNumber);

        while(!q.isEmpty()){
            Integer currNum = q.pop();
            visited[currNum] = true;

            for (int i = 0; i < 26; i++) {
                if(adjList[currNum][i] == 1){
                    if(!visited[i]){
                        if(i == targetNumber) return true;
                        q.add(i);
                    }

                }
            }

        }

        return false;

    }
}
