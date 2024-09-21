public class Main {
    public static void main(String[] args) {
        placeQueen(createArr(8), 0);
  }

    public static void placeQueen(int[] seq, int pos){
        if(seq.length == pos+1){

        }

        for (int i=0; i < seq.length-1; i++){

            //Sjekk om alle ligger lovlig posisjoner og gå ut hvis ikke
            //Plasser
            //Kall rekursivt


            something();

            placeQueen(seq, pos+1);

            something();
        }
    }

    public static void something(){

    }

    public static void printToConsole(){

    }

    public static int[] createArr(int length){
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i+1;
        }
        return arr;
    }
}
