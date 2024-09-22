public class Main {
    public static void main(String[] args) {
        //Length and width of the board (lxl)
        int l = 8;

        //Index will be the x-cord and the value in arr[x-cord] will be the y-cord
        //board[row] = col is enough information to know where it was placed
        placeQueen(createArr(l), 0);
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

            //Sjekk om alle ligger lovlig posisjoner og gå ut hvis ikke
            if(posAvailable(col, row, board)){
                //Send to console
                board[row] = col;
                //Recursive call
                placeQueen(board, row+1);
                return;
            }
        }
    }

    public static int[] createArr ( int length){
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    public static boolean posAvailable(int col, int row, int[] board){

        //We dont't need to check y cords since we always switch row when we place a queen.
        for (int i = 0; i < board.length; i++) {
            //Find formula
            boolean vertical = false;
            boolean diagonal = false;
            if(diagonal && vertical) return true;
        }
        return false;
    }

    public static void printBoard(){

    }
}


