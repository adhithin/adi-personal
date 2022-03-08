public class IntByReference {
    private int value;


    // static method that enables me to see numbers swapped by reference (before, after)
    public static int swapper(int n0, int n1) {

        if (n0 > n1){
            System.out.println(n1 + " " + n0);
        }

        else {
            System.out.println(n0 + " " + n1);

        }

        return 0;

    }

    // static main method that provides some simple test cases
    public static void main(String[] args) {
        swapper(21, 16);
        swapper(16, 21);
        swapper(16, -1);
    }
}