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
            printBoard();
            return;
        }

        //Sub problem
        //Loop through the row
        for (int col=0; col < board.length; col++){

            //Check for the first legal position
            if(posAvailable(col, row, board)){
                //Update board
                board[row] = col;
                //Recursive call  (go to next row)
                placeQueen(board, row+1);
            }
        }
    }

    public static boolean posAvailable(int checkCol, int checkRow, int[] board){

        int dif = checkRow-board.length;
        //We dont't need to check horizontally since we always switch row when we place a queen.
        for (int i = 0; i < board.length; i++) {
            //Find formula
            boolean vertical = checkRow == i-x;
            boolean diagonal = checkCol == board[i]-x && checkRow == i-x;
            if(diagonal && vertical) return true;
        }
        return false;
    }

    public static void printBoard(){

    }
}


