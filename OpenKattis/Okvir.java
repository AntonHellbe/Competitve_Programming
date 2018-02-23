import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Okvir {

    public BufferedReader br;
    public int row, col;
    public int[] paddings;
    public char[][] puzzle;

    public static void main(String[] args) throws IOException {
        Okvir o = new Okvir();
        o.createFrame();
    }

    private void createFrame() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;

        split = br.readLine().split(" ");
        row = Integer.valueOf(split[0]);
        col = Integer.valueOf(split[1]);

        paddings = new int[4];

        split = br.readLine().split(" ");

        for (int i = 0; i < split.length; i++) {
            paddings[i] = Integer.valueOf(split[i]);
        }


        puzzle = new char[row + paddings[0] + paddings[3]][col + paddings[1] + paddings[2]];

        padTop();
        padBottom();
        padLeft();
        padRight();

        for (int i = paddings[0]; i < (puzzle.length - paddings[3]); i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = paddings[1]; j < (puzzle[i].length - paddings[2]); j++) {
                puzzle[i][j] = c[j - paddings[1]];
            }
        }

        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                System.out.print(puzzle[i][j]);
            }
            System.out.println("");
        }

    }


    public void padTop(){
        for (int i = 0; i < paddings[0]; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                if((i + j) % 2 == 0){
                    puzzle[i][j] = '#';
                }else{
                    puzzle[i][j] = '.';
                }
            }
        }
    }

    public void padBottom(){
        for (int i = puzzle.length - 1; i >= (puzzle.length - paddings[3]) ; i--) {
            for (int j = 0; j < puzzle[i].length; j++) {
                if((i + j) % 2 == 1){
                    puzzle[i][j] = '.';
                }else{
                    puzzle[i][j] = '#';
                }
            }
        }
    }

    public void padLeft(){
        for (int i = paddings[0]; i < (puzzle.length - paddings[3]); i++) {
            for (int j = 0; j < paddings[1]; j++) {
                if((i + j) % 2 == 0){
                    puzzle[i][j] = '#';
                }else{
                    puzzle[i][j] = '.';
                }
            }
        }
    }

    public void padRight(){
        for (int i = paddings[0]; i < (puzzle.length - paddings[3]); i++) {
            for (int j = puzzle[i].length - 1; j >= (puzzle[i].length - paddings[2]) ; j--) {
                if((i + j) % 2 == 1){
                    puzzle[i][j] = '.';
                }else{
                    puzzle[i][j] = '#';
                }
            }
        }
    }
}
