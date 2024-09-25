import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Length and width of the board (lxl)
        int l = 8;
        int[] board = new int[l];
        for (int i = 0; i < board.length; i++) {
            board[i] = -1;
        }
        //Index will be the x-cord and the value in arr[x-cord] will be the y-cord
        //board[row] = col is enough information to know where it was placed
        placeQueen(board, 0);
        printBoard(board);
  }

    public static void placeQueen(int[] board, int row){
        //Base case
        if(board.length == row){
            printBoard(board);
            return;
        }

        boolean available;
        //Sub problem
        //Loop through the row
        for (int col=0; col < board.length; col++){
            //Check for the first legal position
            available = posAvailable(col, row, board);
            System.out.println(available);
            if(available){
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
                //If we are on currently placed row we go to next row
                //System.out.println(rowNum == checkRow);

                if(rowNum == checkRow){
                    System.out.println("We break at colNum: "+colNum);
                    break;
                }

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
                System.out.println("dexIF:"+(colNum == checkCol-dexter)+" sinIF:"+(colNum == checkCol+sinister));
                System.out.println("Dex:"+dexterCheck+" Vert:"+verticalCheck+" Sin:"+sinisterCheck);
                if (dexterCheck || verticalCheck || sinisterCheck) return false;
            }
            dexter++;
            sinister--;
        }
        return true;
    }

    public static void printBoard(int[] board){
        System.out.println(Arrays.toString(board));
        String out =  "";
        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board.length; i++) {
                if(board[j] == i) out += "Q";
                else out += ".";
            }
            out += "\n";
        }
        System.out.println(out);

  }
}


