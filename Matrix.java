public class Matrix {
    private final int[][] matrix;

    // store matrix
    public Matrix(int[][] matrix) {
        this.matrix = matrix; // the matrix is being connected to the matrix variable above
    }



    // Hack: create toString method using nested for loops to format output of a matrix
    public String toString(){

        int x = 0;

        //printing the matrix
        for (int i = 0; i < matrix.length; i++){ // for loop for the length of the matrix

            for (int j = 0; j < matrix[x].length; j++){ // this is the line that doesn't go through the matrix that doesn't have everything
               // nested for loops, this second one is the width of the matrix

                if (matrix[i][j] == -1){
                    System.out.print("  ");
                }

                else if (matrix[i][j] > 9){
                    String n = Integer.toHexString(matrix[i][j]);
                    System.out.print(n);
                    System.out.print(" ");
                }

                else {
                    System.out.print(matrix[i][j]);
                    System.out.print(" ");
                }


            }
            System.out.println("");
            x++;
        }

        // printing the matrix backwards



        for (int i = matrix.length-1; i > -1; i--){

            x--;


            for (int j = matrix[x].length-1; j > -1 ; j--){

                if (matrix[i][j] == -1){
                    System.out.print("  ");
                }

                else if (matrix[i][j] > 9){
                    String n = Integer.toHexString(matrix[i][j]);
                    System.out.print(n);
                    System.out.print(" ");
                }


                else {
                    System.out.print(matrix[i][j]);
                    System.out.print(" ");
                }

            }
            System.out.println("");


        }



        return " ";
    }


    // declare and initialize a matrix for a keypad
    static int[][] keypad() {
        return new int[][]{ { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, {-1, 0, -1} };
    }

    // declare and initialize a random length arrays
    static int[][] numbers() {
        return new int[][]{ { 0, 1 },
                { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 } };
    }

    // tester method for matrix formatting
    public static void main(String[] args) {
        Matrix m0 = new Matrix(keypad());
        System.out.println("Keypad:");
        System.out.println(m0);

        Matrix m1 = new Matrix(numbers());
        System.out.println("Numbers Systems:");
        System.out.println(m1);
    }

}