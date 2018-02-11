import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WeakVertices {

    public Scanner scan;
    public int[][] adjMatrix;
    public boolean[] weakOnes;

    public static void main(String[] args) {
        WeakVertices v = new WeakVertices();

        v.solveWeakProblem();
    }

    private void solveWeakProblem() {
        scan = new Scanner(System.in);

        while(true) {
            int dimension = Integer.parseInt(scan.nextLine());

            if(dimension == -1) {
                return;
            }
            adjMatrix = new int[dimension][dimension];
            weakOnes = new boolean[dimension];
            ArrayList<Integer> neighbors = new ArrayList<>();
            int[] input;

            for (int i = 0; i < dimension; i++) {
                input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < input.length; j++) {
                    adjMatrix[i][j] = input[j];
                }
            }

            for (int i = 0; i < adjMatrix.length; i++) {
                boolean weakVertex = true;
                for (int j = 0; j < adjMatrix[i].length; j++) {
                    if (adjMatrix[i][j] == 1) {
                        neighbors.add(j);
                    }

                }

                for (int j = 0; j < neighbors.size(); j++) {
                    int n1 = neighbors.get(j);
                    for (int k = 0; k < neighbors.size(); k++) {
                        int n2 = neighbors.get(k);
                        if(n2 != n1 && !neighborCheck(i, n2, n1)) {
                            weakVertex = false;
                        }
                    }
                }

                if(weakVertex) {
                    weakOnes[i] = true;
                }
                neighbors.clear();

            }



            for (int i = 0; i < weakOnes.length; i++) {
                if (weakOnes[i] == true) {
                    if(i == weakOnes.length - 1) {
                        System.out.print(i);
                    }else {
                        System.out.print(i + " ");
                    }
                }
            }
            System.out.println("");
        }

    }


    private boolean neighborCheck(int y, int x1, int x2) {
        if(adjMatrix[y][x1] == 0 || adjMatrix[y][x2] == 0 || adjMatrix[x1][x2] == 0) {
            return true;
        }

        return false;
    }
}
