import java.util.Arrays;
import java.util.Scanner;

public class AboveAverage {

    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int i = 1, testcases = Integer.parseInt(sc.nextLine());
        calculateStudentGrade();
        while(i < testcases) {
            calculateStudentGrade();
            i++;
        }
    }


    static void calculateStudentGrade() {
        int[] line = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int numbersOfStudents = line[0], count = 0;
        double average = (double) (Arrays.stream(line).sum() - numbersOfStudents) / numbersOfStudents;


        for (int i = 1; i < line.length; i++) {
            if(line[i] > average) count ++;
        }

        float studentsAboveAverage = ((float) count / numbersOfStudents) * 100;

        System.out.printf("%.3f%%", studentsAboveAverage);
        System.out.println("");

    }
}
