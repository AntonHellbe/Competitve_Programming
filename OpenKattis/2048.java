import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PuzzleGame {

    public BufferedReader br;
    public Tile[][] board = new Tile[4][4];
    public int row = 4, col = 4;

    public class Tile{
        int y, x, value;
        boolean moved;
        public Tile(int y, int x, int value){
            this.y = y;
            this.x = x;
            this.value = value;
            this.moved = false;
        }
    }

    public static void main(String[] args) throws IOException {
        PuzzleGame p = new PuzzleGame();
        p.playTheGame();
    }

    private void playTheGame() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int[] input;

        for (int i = 0; i < 4; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < input.length; j++) {
                board[i][j] = new Tile(i, j, input[j]);
            }
        }

        int command = Integer.valueOf(br.readLine());
        switch(command){
            case 0:
                left();
                break;
            case 1:
                up();
                break;
            case 2:
                right();
                break;
            case 3:
                down();
                break;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j].value + " ");
            }
            System.out.println("");
        }


    }

    public void left(){
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < 4; k++) {
                updateRow(i, -1);
            }
            for (int j = 0; j < board.length - 1; j++) {
                if(board[i][j].value == board[i][j + 1].value){
                    board[i][j].value += board[i][j + 1].value;
                    board[i][j + 1].value = 0;
                }
            }

            for (int k = 0; k < 4; k++) {
                updateRow(i, -1);
            }
        }
    }


    public void right(){
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < 4; k++) {
                updateRow(i, 1);
            }
            for (int j = col - 1; j >= 1; j--) {
                if(board[i][j].value == board[i][j - 1].value){
                    board[i][j].value += board[i][j - 1].value;
                    board[i][j - 1].value = 0;
                }
            }

            for (int k = 0; k < 4; k++) {
                updateRow(i, 1);
            }
        }
    }

    public void up(){
        for (int i = 0; i < board.length - 1; i++) {
            for (int j = 0; j < board[i].length; j++) {
                for (int k = 0; k < col; k++) {
                    updateColumn(j, 1);
                }
                if(board[i][j].value == board[i + 1][j].value){
                    board[i][j].value += board[i + 1][j].value;
                    board[i + 1][j].value = 0;
                }

                for (int k = 0; k < col; k++) {
                    updateColumn(j, 1);
                }
            }

        }
    }

    public void down(){
        for (int i = row - 1; i >= 1; i--) {
            for (int j = 0; j < board[i].length; j++) {
                for (int k = 0; k < col; k++) {
                    updateColumn(j, -1);
                }

                if(board[i][j].value == board[i - 1][j].value){
                    board[i][j].value += board[i - 1][j].value;
                    board[i - 1][j].value = 0;
                }

                for (int k = 0; k < col; k++) {
                    updateColumn(j, -1);
                }

            }
        }
    }
    

    public void updateRow(int row, int dir){
        if(dir == 1) {
            for (int i = col - 1; i >= 1; i--) {
                if (board[row][i].value == 0) {
                    board[row][i].value = board[row][i - 1].value;
                    board[row][i - 1].value = 0;
                }
            }
        }else {
            for (int i = 0; i < board.length - 1; i++) {
                if (board[row][i].value == 0 && board[row][i + 1].value != 0) {
                    board[row][i].value = board[row][i + 1].value;
                    board[row][i + 1].value = 0;
                }
            }
        }
    }

    public void updateColumn(int col, int dir){
        if(dir == 1) {
            for (int i = 0; i < board.length - 1; i++) {
                if (board[i][col].value == 0 && board[i + 1][col].value != 0) {
                    board[i][col].value = board[i + 1][col].value;
                    board[i + 1][col].value = 0;
                }
            }
        }else {
            for (int i = row - 1; i >= 1; i--) {
                if(board[i][col].value == 0 && board[i - 1][col].value != 0){
                    board[i][col].value = board[i - 1][col].value;
                    board[i - 1][col].value = 0;
                }
            }
        }

    }



}
