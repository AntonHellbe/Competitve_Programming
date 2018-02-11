import java.util.Scanner;

public class BrunosNightclub {
    
    public Scanner scan;
    public char[] persons;
    
    public static void main(String[] args){
        BrunosNightclub b = new BrunosNightclub();
        b.solve();
    }

    private void solve() {
        scan = new Scanner(System.in);
        int absDifference = Integer.parseInt(scan.nextLine());

        persons = scan.nextLine().toCharArray();
        int maleCount = 0, femaleCount = 0;
        char latest = 'B';

        for (int i = 0; i < persons.length; i++) {

            if(i != persons.length - 1) {
                if (maleCount > femaleCount || latest == 'M') {
                    if (persons[i + 1] == 'W')  {
                        swap(i, i + 1);
                    }
                } else if (femaleCount > maleCount || latest == 'W') {
//                    System.out.println("Swapping male " + i);
                    if (persons[i + 1] == 'M') {
                        swap(i, i + 1);
                    }
                }
            }

            if(persons[i] == 'W') {
                femaleCount++;
                latest = 'W';
            }

            if(persons[i] == 'M') {
                maleCount++;
                latest = 'M';
            }


            if(Math.abs(femaleCount - maleCount) > absDifference) {
                System.out.println(femaleCount + maleCount - 1);
                return;
            }
        }

        System.out.println(femaleCount + maleCount);

    }

    private void swap(int i, int j) {
//        System.out.println("Swapping");
        char temp = persons[i];
        persons[i] = persons[j];
        persons[j] = temp;
    }
}
