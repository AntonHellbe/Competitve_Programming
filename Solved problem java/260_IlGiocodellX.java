import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class IlGiocodellX {

    static BufferedReader br;
    static int dimension;
    static boolean running = true;
    static BoardTile[][] boardMatrix;
    static int gameCount = 0;

    static enum Directions{
        UP (-1, 0),
        DOWN (1, 0),
        RIGHT (0, 1),
        LEFT (0, -1),
        LEFTUP(-1, -1),
        RIGHTDOWN(1, 1);

        int y, x;

        Directions(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static class BoardTile{
        int y, x;
        Character val;
        boolean visited;

        BoardTile(int y, int x, Character val){
            this.y = y;
            this.x = x;
            this.val = val;
            visited = false;
        }
    }


    public static void main (String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        while(running)
            playTheGame();
    }

    static void playTheGame() throws IOException {
        dimension = Integer.parseInt(br.readLine());
        String[] input;
        gameCount++;
        boolean wWinner = false;
        boolean bWinner = false;
        if(dimension == 0){
            running = false;
            return;
        }
        boardMatrix = new BoardTile[dimension][dimension];


        for (int i = 0; i < dimension; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < input.length; j++) {
                boardMatrix[i][j] = new BoardTile(i, j, input[j].charAt(0));
            }
        }

        for (int i = 0; i < dimension; i++) {
            if(boardMatrix[i][0].val == 'w'){
                dfs(boardMatrix[i][0], 'w');
            }else{
                continue;
            }


            for (int j = 0; j < dimension; j++) {
                if(boardMatrix[j][dimension - 1].visited && boardMatrix[j][dimension - 1].val == 'w'){
                    wWinner = true;
                }
            }

            if(wWinner){
                System.out.println(gameCount + " W");
                return;
            }
        }

        for (int i = 0; i < dimension; i++) {

            if(boardMatrix[0][i].val == 'b')
                dfs(boardMatrix[0][i], 'b');
            else
                continue;

            for (int j = 0; j < dimension; j++) {
                if(boardMatrix[dimension - 1][j].visited && boardMatrix[dimension - 1][j].val == 'b'){
                    bWinner = true;
                }
            }

            if(bWinner){
                System.out.println(gameCount + " B");
                return;
            }

        }


    }


    static void dfs(BoardTile tile , Character playing){

        if(tile.visited || tile.val != playing){
            return;
        }

        boardMatrix[tile.y][tile.x].visited = true;

        for(Directions d: Directions.values()){
            if(inBounds(tile.y + d.y, tile.x + d.x)){
                dfs(boardMatrix[tile.y + d.y][tile.x + d.x], playing);
            }
        }
    }

    static void bfs(BoardTile startTile, Character playing){

        int newRow = 0;
        int newCol = 0;

        LinkedList queue = new LinkedList();
        startTile.visited = true;
        queue.add(startTile);

        while(!queue.isEmpty()){
            BoardTile t = (BoardTile) queue.remove();

            for(Directions d: Directions.values()){
                newRow = t.y + d.y;
                newCol = t.x + d.x;

                if(inBounds(newRow, newCol)
                        && !boardMatrix[newRow][newCol].visited
                        && boardMatrix[newRow][newCol].val == playing){

                    boardMatrix[newRow][newCol].visited = true;
                    queue.add(boardMatrix[newRow][newCol]);
                }
            }
        }

    }


    static boolean inBounds(int y, int x){
        return x >= 0 && x < dimension && y >= 0 && y < dimension;
    }
}
