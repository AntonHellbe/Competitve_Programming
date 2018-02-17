import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class AnIndustrialSpy {
    public BufferedReader br;
    public HashSet<String> allCombinations;
    public static void main(String[] args) throws IOException {
        AnIndustrialSpy a = new AnIndustrialSpy();
        a.solveForPrimes();
    }

    private void solveForPrimes() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testscases = Integer.parseInt(br.readLine());
        allCombinations = new HashSet<>();
        String s = "1276543";
        combo("", s);
        ArrayList<String> toTest = new ArrayList<>();
        toTest.addAll(allCombinations);
        System.out.println(toTest.size());


    }


    private void combo(String prefix, String s)
    {
        int N = s.length();

        if(!prefix.equals("")) allCombinations.add(prefix);

        for (int i = 0 ; i < N ; i++)
            combo(prefix + s.charAt(i), s.substring(i+1));
    }
}
