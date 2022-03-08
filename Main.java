public class Main {

    public Option () {

    }


    public int val (int n ) {
        System.out.print(n);
    }

    public static void main(String[] args) {

        for (int i = 0; i < 6; i++){
            Option op = new Option ();
            op.val(i);
        }

        System.out.print("hello world");
    }
}
