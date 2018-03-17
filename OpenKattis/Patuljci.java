import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Patuljci {

    public BufferedReader br;
    public ArrayList<ArrayList<Integer>> allCombs;

    public static void main(String[] args) throws IOException {
        Patuljci p = new Patuljci();
        p.calcSnowWhiteDwarves();
    }

    private void calcSnowWhiteDwarves() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        allCombs = new ArrayList<>();
        int[] dwarves = new int[9];
        for (int i = 0; i < 9; i++) {
            dwarves[i] = Integer.valueOf(br.readLine());
        }

        printCombination(dwarves, dwarves.length, 7);


        for (int i = 0; i < allCombs.size(); i++) {
            ArrayList<Integer> t = allCombs.get(i);
            int sum = t.stream().mapToInt(Integer::intValue).sum();
            if(sum == 100){
                for (int j = 0; j < t.size(); j++) {
                    System.out.println(t.get(j));
                }

                break;
            }
        }

        System.out.println("");





    }

    public void combinationUtil(int arr[], int n, int r,
                                int index, int data[], int i)
    {

        if (index == r) {
            ArrayList<Integer> t = new ArrayList<>();
            for (int j = 0; j < r; j++)
                t.add(data[j]);
            allCombs.add(t);
            return;
        }

        if (i >= n)
            return;

        data[index] = arr[i];
        combinationUtil(arr, n, r, index + 1,
                data, i + 1);

        combinationUtil(arr, n, r, index, data, i + 1);
    }

    public void printCombination(int arr[], int n, int r)
    {
        // A temporary array to store all combination
        // one by one
        int data[] = new int[r];

        // Print all combination using temprary
        // array 'data[]'
        combinationUtil(arr, n, r, 0, data, 0);
    }



}
