import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecretMessage {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        SecretMessage m = new SecretMessage();

        m.encodeMessage();
    }

    private void encodeMessage() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine()), t = 0;

        while(t < testcases) {
            String line = br.readLine();

            int L = line.length();
            int M = (int) Math.ceil(Math.sqrt(L));
            int squared = (int) Math.pow(M, 2);

            for (int i = line.length(); i < squared; i++) {
                line += "*";
            }

            char[][] encryptionTable = new char[M][M];
            int count = 0;
            for (int i = encryptionTable.length - 1; i >= 0; i--) {
                for (int j = 0; j < encryptionTable[i].length; j++) {
                    encryptionTable[j][i] = line.charAt(count++);
                }

            }

            String message = "";

            for (int i = 0; i < encryptionTable.length; i++) {
                for (int j = 0; j < encryptionTable[i].length; j++) {
                    if (encryptionTable[i][j] != '*') message += encryptionTable[i][j];
                }
            }

            System.out.println(message);
            t++;
        }
    }
}
