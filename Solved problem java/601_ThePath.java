import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThePath {

    static BufferedReader br;
    static boolean running = true;
    static int size;
    static Tile[][] matrix;

    static enum Directions{
        UP (-1, 0),
        DOWN (1, 0),
        LEFT (0, -1),
        RIGHT (0, 1);

        int x;
        int y;

        Directions(int y, int x){
            this.y = y;
            this.x = x;
        }

    }


    static class Tile {
        int y;
        int x;
        Character value;
        boolean visited;

        public Tile(int y, int x, Character value){
            this.y = y;
            this.x = x;
            this.value = value;
            visited = false;
        }
    }

    public static void main (String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        while(running){
            refereeTheGame();
            br.readLine(); // Empty Line
        }
    }

    static void refereeTheGame() throws IOException {
        size = Integer.parseInt(br.readLine());
        String[] input;
        boolean bWin = false;
        boolean wWin = false;

        if(size == 0){
            running = false;
            return;
        }
        matrix = new Tile[size][size]; // Symmetric Dimensions

        br.readLine(); // Empty Line

        for (int i = 0; i < size; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < input.length; j++) {
                matrix[i][j] = new Tile(i, j, input[j].charAt(0));
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            dfs(matrix[i][0], 'W');
        }

        for (int i = 0; i < matrix.length; i++) {
            dfs(matrix[0][i], 'B');
        }

        for (int i = 0; i < size; i++) {
            if(matrix[i][size - 1].visited && matrix[i][size - 1].value == 'W'){
                wWin = true;
            }

            if(matrix[size - 1][i].visited && matrix[size - 1][i].value == 'B'){
                bWin = true;
            }
        }

        if(wWin) {
            System.out.println("White has a winning path.");
            return;
        }


        if(bWin) {
            System.out.println("Black has a winning path.");
            return;
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j].value == 'U'){

                    for (int a = 0; a < matrix.length; a++) {
                        for (int b = 0; b < matrix[0].length; b++) {
                            matrix[a][b].visited = false;
                        }
                    }
                    matrix[i][j].value = 'W';

                    for (int k = 0; k < size; k++) {
                        dfs(matrix[k][0], 'W');
                    }

                    for (int k = 0; k < size; k++) {
                        if(matrix[k][size - 1].visited && matrix[k][size - 1].value == 'W'){
                            wWin = true;
                        }
                    }

                    matrix[i][j].value = 'U';
                }

            }
        }

        if(wWin){
            System.out.println("White can win in one move.");
            return;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j].value == 'U'){

                    for (int k = 0; k < matrix.length; k++) {
                        for (int l = 0; l < matrix[0].length; l++) {
                            matrix[k][l].visited = false;
                        }
                    }

                    matrix[i][j].value = 'B';

                    for (int k = 0; k < size; k++) {
                        dfs(matrix[0][k], 'B');
                    }

                    for (int k = 0; k < size; k++) {
                        if(matrix[size - 1][k].visited && matrix[size - 1][k].value == 'B'){
                            bWin = true;
                        }
                    }

                    matrix[i][j].value = 'U';


                }
            }
        }

        if(bWin){
            System.out.println("Black can win in one move.");
            return;
        }

        System.out.println("There is no winning path.");


    }

    static void dfs(Tile tile, Character playing){
//        System.out.println(tile.value);
        if(tile.visited || tile.value != playing){
            return;
        }

        matrix[tile.y][tile.x].visited = true;
        for(Directions d: Directions.values()){
            if(inBounds(tile.y + d.y, tile.x + d.x)) {
                dfs(matrix[tile.y + d.y][tile.x + d.x], playing);
            }
        }

    }

    static boolean inBounds(int y, int x){
        return y >= 0 && y < size && x >= 0 && x < size;
    }
}
