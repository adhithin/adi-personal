

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;

public class Sorts {
    private static ArrayList<Integer> data = new ArrayList<>();
    private Duration timeElapsed;

    // what is this doing? it's giving a timing.

    public Sorts(int size) {
        Instant start = Instant.now();  // time capture -- start
        // build an array
        for (int i = 0; i < size; i++) { // for loop
            data.add((int)(Math.random() * size)); // for every number in the size, add a RANDOM number to the data
        }
        data.sort(Comparator.naturalOrder()); //  we're sorting the data by least to greatest
        Instant end = Instant.now();    // time capture -- end
        this.timeElapsed = Duration.between(start, end); // getting the number of the time elapsed
    }

    public ArrayList<Integer> getData() {
        return data;
    }

    public int getTimeElapsed() {
        return timeElapsed.getNano();
    }

// bubble sort algo. it's not being used tho.
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(arr[j-1] > arr[j]){
                    //swap elements
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }

            }
        }

    }


    public static void main(String[] args) {
        int sum=0, TIMES=10, SIZE=5000;

        for(int i=0; i< TIMES; i++) {
            Sorts s = new Sorts(SIZE);
            //System.out.println(s.getData());
            System.out.println("Nanoseconds: " + s.getTimeElapsed());
            sum += s.getTimeElapsed();

        }

        System.out.println(data);
        System.out.println("Average    : " + sum / TIMES);
    }

}