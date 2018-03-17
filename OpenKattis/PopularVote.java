import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PopularVote {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        PopularVote p = new PopularVote();
        p.calcVotes();
    }

    private void calcVotes() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.valueOf(br.readLine()), t = 0;

        outer:
        while (t < testCases) {

            int candidates = Integer.valueOf(br.readLine());

            int max = 0, maxIndex = 0, totalVotes = 0;
            int[] candidateVotes = new int[candidates + 1];

            for (int i = 1; i < candidates + 1; i++) {
                candidateVotes[i] = Integer.valueOf(br.readLine());
                totalVotes += candidateVotes[i];
                if (candidateVotes[i] > max) {
                    max = candidateVotes[i];
                    maxIndex = i;
                }
            }

            int count = 0;
            for (int i = 1; i < candidateVotes.length; i++) {
                if (candidateVotes[i] == max) count++;
                if (count > 1) {
                    t++;
                    System.out.println("no winner");
                    continue outer;
                }
            }

            if ((double) max / totalVotes > 0.5) {
                System.out.println("majority winner " + maxIndex);
            } else {
                System.out.println("minority winner " + maxIndex);
            }

            t++;

        }


    }
}
