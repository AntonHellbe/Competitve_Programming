import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mjehuric {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        Mjehuric m = new Mjehuric();
        m.swapPieces();
    }

    private void swapPieces() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;

        int[] numbers = new int[5];
        split = br.readLine().split(" ");

        for (int i = 0; i < 5; i++) {
            numbers[i] = Integer.valueOf(split[i]);
        }

        while(true){
            boolean updateMade = false;
            for (int i = 0; i < 4; i++) {
                if(numbers[i + 1] < numbers[i]){
                    swap(numbers, i, i + 1);
                    for (int j = 0; j < 5; j++) {
                        updateMade = true;
                        System.out.print(numbers[j] + " ");
                    }

                    System.out.println("");

                }
            }

            if(!updateMade){
                break;
            }

        }



    }


    public void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;

    }
}
