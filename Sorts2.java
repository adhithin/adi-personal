import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;

import LinkedLists.LinkedList;

public class Sorts2 {

    // establish our variables
    private ArrayList<Integer> data = new ArrayList<Integer>(); // setting up a new arraylist
    public static Duration bblTime; // setting up the variable of timeElapsed
    public static Duration selectTime;
    public static Duration mergeTime;
    public static Duration insertTime;


    // create our constructor:

    public Sorts2(int len){

        System.out.print("Here are the numbers in the data set: ");
        for (int i = 0; i < len; i++) {
            int a = (int)(Math.random()*9 + 1);
            data.add(a);
            System.out.print(a);
            this.data = data;
        }


        this.data = data;

    }

    // create our bubbleSort method. we can call it from the object.
    public ArrayList<Integer> bubbleSort(){

        Instant start = Instant.now();  // starting the time

        // here is our bubble sort algorithm:

        for (int i = 0; i < data.size() - 1; i++) {
            for (int j = data.size() - 1; j > i; j--) {
                if (data.get(j - 1) > data.get(j)) {
                    // swap
                    int tmp = data.get(j - 1);
                    data.set(j -1, data.get(j));
                    data.set(j, tmp);
                }
            }
        }

        // now we're stopping the time.

        for (Integer a : data){
            System.out.print(a);
        }

        Instant end = Instant.now();    // time capture -- end



        this.bblTime = Duration.between(start, end);
        return data;
    }

    // create our selection sort. also calling this from our object.


    public ArrayList<Integer> selectSort(){

        Instant b = Instant.now();  // starting the time

        for (int i = 0; i < data.size(); i++) {
            // find position of smallest num between (i + 1)th element and last element
            int pos = i;
            for (int j = i; j < data.size(); j++) {
                if (data.get(j) < data.get(pos))
                    pos = j;
            }
            // Swap min (smallest num) to current position on array
            int min = data.get(pos);
            data.set(pos, data.get(i));
            data.set(i, min);
        }

        Instant e = Instant.now();    // time capture -- end

        this.selectTime = Duration.between(b, e);

        this.data = data;

        for (Integer a : data){
            System.out.print(a);
        }

        return data;
    }

    // Merge Sort Code

    // okay so within this we have to procedures. one is to divide the elemnts into a list
    // within that list, we sort.

    public ArrayList<Integer> divide() {

        int startIndex = data.get(0);
        int endIndex = data.get(data.size() - 1);

        //Divide till you breakdown your list to single element
        if (startIndex < endIndex && (endIndex - startIndex) >= 1) {
            int mid = (endIndex + startIndex) / 2;
            //divide(startIndex, mid);
           // divide(mid + 1, endIndex);

            //merging Sorted array produce above into one sorted array
            //merger(startIndex, mid, endIndex);
        }

        for (Integer a : data){
            System.out.print(a);
        }

        return data;
    }




    public ArrayList<Integer> merge() {
            //Below is the mergedarray that will be sorted array Array[i-midIndex] , Array[(midIndex+1)-endIndex]
            ArrayList<Integer> mergedSortedArray = new ArrayList<Integer>();

            Instant s1 = Instant.now();    // time capture -- end

            int leftIndex = data.get(0);
            int rightIndex = data.get(data.size() - 1);
            int midIndex = data.size()/2;
            int endIndex = data.size() - 1;
            int startIndex = 0;

            while (leftIndex <= midIndex && rightIndex <= endIndex) {
                if (data.get(leftIndex) <= data.get(rightIndex)) {
                    mergedSortedArray.add(data.get(leftIndex));
                    leftIndex++;
                } else {
                    mergedSortedArray.add(data.get(rightIndex));
                    rightIndex++;
                }
            }

            //Either of below while loop will execute
            while (leftIndex <= midIndex) {
                mergedSortedArray.add(data.get(leftIndex));
                leftIndex++;
            }

            while (rightIndex <= endIndex) {
                mergedSortedArray.add(data.get(rightIndex));
                rightIndex++;
            }

            int i = 0;
            int j = startIndex;
            //Setting sorted array to original one
            while (i < mergedSortedArray.size()) {
                data.set(j, mergedSortedArray.get(i++));
                j++;
            }

            Instant e1 = Instant.now();    // time capture -- end

            this.mergeTime = Duration.between(s1, e1);

            this.data = mergedSortedArray;



            return data;
        }


    // our insertion sort
    public ArrayList<Integer> insertSort(){

        Instant begin = Instant.now();    // time capture -- end

        for(int i=1;i<data.size();i++){


            int key = data.get(i);

            for(int j= i-1;j>=0;j--){
                if(key < data.get(j)){
                    // Shifting Each Element to its right as key is less than the existing element at current index
                    data.set(j+1,data.get(j));

                    // Special case scenario when all elements are less than key, so placing key value at 0th Position
                    if(j==0){
                        data.set(0, key);
                    }
                }

                else {
                    // Putting Key value after element at current index as Key value is no more less than the existing element at current index
                    data.set(j+1,key);
                    break; // You need to break the loop to save un necessary iteration
                }

            }

            for (Integer x : data){
                System.out.print(x);
            }

        }


        Instant stop = Instant.now();    // time capture -- end

        this.insertTime = Duration.between(begin, stop);

        this.data = data;


        return data;

    }


    //our main driver and main method:

    public static void main(String[] args) {
       Sorts2 test1 = new Sorts2(5);

       // Bubble Sort

       System.out.println();
       System.out.print("Bubble Sort: ");
       test1.bubbleSort();
       System.out.println();
       System.out.print("Time Elapsed: " + bblTime);

       // Select Sort
        System.out.println();
        System.out.print("Select Sort: ");
        test1.selectSort();
        System.out.println();
        System.out.print("Time Elapsed: " + selectTime);


        // Sorting our linkedlist
        System.out.println();
        System.out.print("Merge Sort: ");
        test1.divide();
        test1.merge();
        System.out.println();
        System.out.print("Time Elapsed: " + mergeTime);

        // Sorting our linkedlist
        System.out.println();
        System.out.print("Insertion Sort: ");
        test1.insertSort();
        System.out.println();
        System.out.print("Time Elapsed: " + insertTime);


    }
}
