import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class TimeBomb {

    public BufferedReader br;
    public HashMap<Integer, String[]> numMap;
    public static final int ROWS = 5;


    public static void main(String[] args) throws IOException {
        TimeBomb tb = new TimeBomb();
        tb.go();

    }

    private void go() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        numMap = new HashMap<>();
        addToNumMap();
        String line;
        int t = 0;
        ArrayList<String[]> allNumbers = new ArrayList<>();

        while((line = br.readLine()) != null){

            if(line.equals("")) break;

            if(t == 0){
                int totalNums = (line.length() - (line.length() / 4)) / 3;
                for (int i = 0; i < totalNums; i++) {
                    allNumbers.add(new String[ROWS]);
                }
            }
            int currNum = 0;
            allNumbers.get(currNum)[t] = line.substring(0, 3);
            currNum ++;

            for (int i = 3; i < line.length(); i++) {
                if(i % 4 == 0){
                    allNumbers.get(currNum)[t] = line.substring(i, i + 3);
                    currNum++;
                }
            }
            t++;

        }

        String fullNumber = "";

        for (int i = 0; i < allNumbers.size(); i++) {
            boolean noMatch = true;
            String[] currNumber = allNumbers.get(i);
            for (int j = 0; j <= 9; j++) {
                int matches = 0;
                String[] possibleNumber = numMap.get(j);
                for (int k = 0; k < possibleNumber.length; k++) {
                    if(currNumber[k].equals(possibleNumber[k])){
                        matches++;
                    }
                }
                if(matches == ROWS){
                    fullNumber += j;
                    noMatch = false;
                }
            }

            if(noMatch){
                System.out.println("BOOM!!");
                return;
            }

        }

        if(Integer.valueOf(fullNumber) % 6 == 0){
            System.out.println("BEER!!");
        }else {
            System.out.println("BOOM!!");
        }





    }



    public void addToNumMap() {
        numMap.put(0, new String[]{
            "***",
            "* *",
            "* *",
            "* *",
            "***"
        });

        numMap.put(1, new String[]{
            "  *",
            "  *",
            "  *",
            "  *",
            "  *"
        });

        numMap.put(2,new String[]{
             "***",
             "  *",
             "***",
             "*  ",
             "***"
        });

        numMap.put(3, new String[]{
             "***",
             "  *",
             "***",
             "  *",
             "***"
        });

        numMap.put(4, new String[]{
            "* *",
            "* *",
            "***",
            "  *",
            "  *"
        });

        numMap.put(5, new String[]{
            "***",
            "*  ",
            "***",
            "  *",
            "***"
        });

        numMap.put(6, new String[]{
            "***",
            "*  ",
            "***",
            "* *",
            "***"
        });

        numMap.put(7, new String[]{
            "***",
            "  *",
            "  *",
            "  *",
            "  *"
        });

        numMap.put(8, new String[]{
            "***",
            "* *",
            "***",
            "* *",
            "***"
        });

        numMap.put(9, new String[]{
            "***",
            "* *",
            "***",
            "  *",
            "***"
        });





    }


}
