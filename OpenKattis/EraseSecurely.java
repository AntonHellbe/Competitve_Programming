import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EraseSecurely {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        EraseSecurely es = new EraseSecurely();
        es.go();
    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        String beforeDeletion = br.readLine();
        String afterDeletion = br.readLine();

       char[] binaryString = beforeDeletion.toCharArray();


        if(n % 2 == 1){
            for (int i = 0; i < binaryString.length; i++) {
                if(binaryString[i] == '0')
                    binaryString[i] = '1';
                else
                    binaryString[i] = '0';
            }
        }

        String flipped = String.valueOf(binaryString);

        if(flipped.equals(afterDeletion)){
            System.out.println("Deletion succeeded");
        }else{
            System.out.println("Deletion failed");
        }


    }
}
