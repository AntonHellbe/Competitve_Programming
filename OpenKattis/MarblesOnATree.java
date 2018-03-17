import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MarblesOnATree {

    public class Node {

        public Node parent;
        public List<Node> children;
        public int marblesCount;
        public int label;

        public Node() {
        }
    }

    public BufferedReader br;


    public int balanceMoves(Node root, List<Node> nodeList){
        Collections.reverse(nodeList); //Start with the leafs, and move up in the tree


        int minMoves = 0;

        for(Node node: nodeList){

            if(node == root)
                break;

            if(node.marblesCount == 0){
                node.parent.marblesCount -= 1; //Decrease parents marbleCount
                minMoves++; // Move needed
            }else if(node.marblesCount > 1){
                node.parent.marblesCount += (node.marblesCount - 1); // Transfer marbles to parent instead
                minMoves += (node.marblesCount -1); //Add move
            }else if(node.marblesCount < 0){
                node.parent.marblesCount -= -node.marblesCount + 1; // Can become negative count, transfer it to the parent
                minMoves += -node.marblesCount + 1; // Count the negative as moves, since they have marbles has to be moved to satisfy.
            }
        }

        return minMoves;
    }


    public static void main(String[] args) throws IOException {
        MarblesOnATree m = new MarblesOnATree();
        m.solve();
    }

    private void solve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;

        while(true) {
            int lines = Integer.valueOf(br.readLine());

            if(lines == 0) return;

            Node[] nodeArr = new Node[lines];

            for (int i = 0; i < lines; i++)
                nodeArr[i] = new Node();



            for (int i = 0; i < lines; i++) {
                split = br.readLine().split(" ");
                int v = Integer.valueOf(split[0]) - 1;
                int m = Integer.valueOf(split[1]);
                int children = Integer.valueOf(split[2]);

                nodeArr[v].label = v;
                nodeArr[v].marblesCount = m;
                nodeArr[v].children = new LinkedList<>();

                for (int j = 3; j <  (3 + children); j++) {
                    int adj = Integer.valueOf(split[j]) - 1;
                    nodeArr[v].children.add(nodeArr[adj]);
                    nodeArr[adj].parent = nodeArr[v];
                }
            }

            Node root  = nodeArr[0];

            for (int i = 0; i < lines; i++) {
                if(nodeArr[i].parent == null)
                    root = nodeArr[i];
            }

            List<Node> nodeList = new LinkedList();

            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty()){
                Node node = q.poll();
                nodeList.add(node);
                for(Node nodeChild: node.children){
                    q.add(nodeChild);
                }
            }

            int moves = balanceMoves(root, nodeList);
            System.out.println(moves);

        }

    }

}
