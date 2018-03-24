import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class KittenOnATree {

    public BufferedReader br;
    public HashMap<Integer, Integer> connectionMap;

    public static void main(String[] args) throws IOException {
        KittenOnATree k = new KittenOnATree();
        k.go();
    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;
        int start = Integer.valueOf(br.readLine());
        connectionMap = new HashMap<>();
        while(true){
            split = br.readLine().split(" ");
            int to = Integer.valueOf(split[0]);

            if(to == -1) break;

            for (int i = 1; i < split.length; i++) {
                connectionMap.put(Integer.valueOf(split[i]), to);
            }
        }

        dfs(start);

    }

    private void dfs(int start) {
        System.out.print(start + " ");

        if(connectionMap.get(start) != null){
            dfs(connectionMap.get(start));
        }
    }
}
