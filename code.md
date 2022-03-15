# Welcome to Adi's Data Structures Repository 
## Week 0 Timebox 

Check out my website: 
https://adhithin.github.io/adi-personal/

Issue + Ticket: https://github.com/adhithin/adi-personal/issues/1

<table>
     <tr>
         <td><a href=".">Home</a></td>
         <td><a href="code">Code</a></td>
         <td><a href="review">Review</a></td>
     </tr>
 </table>
 

<h3 id="week-1">Week 1</h3>
Matrix Code Snippet

`for (int i = 0; i < matrix.length; i++){ // for loop for the length of the matrix`

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

IntByReference Code Snippet


    public IntByReference(int n){
        this.value = n;
    }

    public IntByReference swapToLowHighOrder(IntByReference x){


        IntByReference temp = new IntByReference (value);

        if (x.value < value){

            temp.value = value;
            value = x.value;
            x.value = temp.value;

        }

        else {

            return x;
        }


        return x;

    }
