import java.util.Scanner;

public class CalcDartScores {


    public Scanner scan;
    public int[] dartBoardPoints = {20, 1, 18, 4, 13, 6, 10, 15, 2, 17, 3, 19, 7, 16, 8, 11, 14, 9, 12, 5 };
    public int[] multipliers = { 1, 2, 3};

    public static void main(String[] args){
        CalcDartScores c = new CalcDartScores();

        c.solve();
    }

    private void solve() {
        scan = new Scanner(System.in);
        int targetPoints = scan.nextInt();

        boolean found = false;

        if(targetPoints <= 60) {
            for (int i = 0; i < dartBoardPoints.length && !found; i++) {
                for (int j = 0; j < multipliers.length && !found; j++) {
                    if (dartBoardPoints[i] * multipliers[j] == targetPoints) {
                        print(multipliers[j], dartBoardPoints[i]);
                        found = true;
                    }
                }
            }
        }
        if(!found) {
            for (int i = 0; i < dartBoardPoints.length && !found; i++) {
                for (int j = 0; j < dartBoardPoints.length &&!found; j++) {
                    for (int k = 0; k < multipliers.length && !found; k++) {
                        for (int l = 0; l < multipliers.length && !found; l++) {
                            if (dartBoardPoints[i] * multipliers[k] + dartBoardPoints[j] * multipliers[l] == targetPoints) {
                                print(multipliers[k], dartBoardPoints[i]);
                                print(multipliers[l], dartBoardPoints[j]);
                                found = true;
                            }
                        }
                    }
                }
            }

        }
        if(!found) {
            for (int i = 0; i < dartBoardPoints.length && !found; i++) {
                for (int j = 0; j < dartBoardPoints.length && !found; j++) {
                    for (int k = 0; k < dartBoardPoints.length && !found; k++) {
                        for (int l = 0; l < multipliers.length && !found; l++) {
                            for (int m = 0; m < multipliers.length && !found; m++) {
                                for (int n = 0; n < multipliers.length && !found; n++) {
                                    if (dartBoardPoints[i] * multipliers[l] + dartBoardPoints[j] * multipliers[m] + dartBoardPoints[k] * multipliers[n]
                                            == targetPoints) {
                                        print(multipliers[l], dartBoardPoints[i]);
                                        print(multipliers[m], dartBoardPoints[j]);
                                        print(multipliers[n], dartBoardPoints[k]);
                                        found = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if(!found) {
            System.out.println("impossible");
        }

    }



    private void print(int multiplier, int points){

        switch(multiplier) {
            case 1:
                System.out.println("single " + points);
                break;
            case 2:
                System.out.println("double " + points);
                break;
            case 3:
                System.out.println("triple " + points);
        }
    }
}
