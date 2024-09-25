import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Length and width of the board (lxl)
        int l = 8;
        int[] board = new int[l];

        //Index will be the x-cord and the value in arr[x-cord] will be the y-cord
        //board[row] = col is enough information to know where it was placed
        placeQueen(board, 0);
  }

    public static void placeQueen(int[] board, int row){
        //Base case
        if(board.length == row){
            printBoard(board);
            return;
        }

        //Sub problem
        //Loop through the row
        for (int col=0; col < board.length; col++){

            //Check for the first legal position
            if(posAvailable(col, row, board)){
                //Update board
                System.out.println("row:"+row+" col:"+col);
                board[row] = col;
                //Recursive call  (go to next row)
                placeQueen(board, row+1);
            }
        }
    }

    public static boolean posAvailable(int checkCol, int checkRow, int[] board){

        //(checkCol, checkRow) cords for currently placed

        int dexter = checkRow;
        int sinister = checkRow;
        //We dont't need to check horizontally since we always switch row when we place a queen.
        for(int rowNum = 0; rowNum < board.length; rowNum++) {
            for (int colNum = 0; colNum < board.length; colNum++) {
                //We are on currently placed row
                if(colNum == checkCol) break;

                boolean dexterCheck = false;
                boolean sinisterCheck = false;
                boolean verticalCheck = board[rowNum] == checkCol;
                //Checks if we are on a diagonal
                //May remove --> " 0 <= checkCol-dexter && checkCol-dexter < board.length && "
                if(colNum == checkCol-dexter) {
                    dexterCheck = colNum == board[rowNum];
                }
                if(colNum == checkCol+sinister){
                    sinisterCheck = colNum == board[rowNum];
                }
                if (dexterCheck || verticalCheck || sinisterCheck) return false;
            }
            dexter++;
            sinister--;
        }
        return true;
    }

    public static void printBoard(int[] board){
        System.out.println(Arrays.toString(board));
  }
}


