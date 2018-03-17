import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class RollCall {

    public BufferedReader br;
    public TreeMap<String, ArrayList<String>> nameMap;
    public HashMap<String, Integer> firstNameMap;

    public static void main(String[] args) throws IOException {
        RollCall r = new RollCall();
        r.callNames();
    }

    private void callNames() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        nameMap = new TreeMap<>();
        firstNameMap = new HashMap<>();
        String[] split;
        String line;

        while((line = br.readLine()) != null){
            if(line.equals("")) break;
            split = line.split(" ");
            nameMap.putIfAbsent(split[1], new ArrayList<>());
            nameMap.get(split[1]).add(split[0]);
            if(firstNameMap.get(split[0]) == null){
                firstNameMap.put(split[0], 1);
            }else{
                firstNameMap.put(split[0], firstNameMap.get(split[0]) + 1);
            }
        }

        nameMap.forEach((k, v) -> {
            v.sort(String::compareTo);
            v.forEach((name) -> {
                if(firstNameMap.get(name) != 1){
                    System.out.println(name + " " + k);
                }else{
                    System.out.println(name);
                }
            });
        });

    }
}
