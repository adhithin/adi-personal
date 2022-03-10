public class IntByReference {
    private int value;

    // Hack: create IntByReference, swapToLowHighOrder and toString methods

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


    // static method that enables me to see numbers swapped by reference (before, after)
    public static void swapper(int n0, int n1) {
        IntByReference a = new IntByReference(n0);
        IntByReference b = new IntByReference(n1);
        System.out.println("Before: " + a.value + " " + b.value);
        a.swapToLowHighOrder(b);  // conditionally build swap method to change values of a, b
        System.out.println("After: " + a.value + " " + b.value);
        System.out.println();
    }

    // static main method that provides some simple test cases
    public static void main(String[] ags) {
        IntByReference.swapper(21, 16);
        IntByReference.swapper(16, 21);
        IntByReference.swapper(16, -1);
    }
}