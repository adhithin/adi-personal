package src;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;

public class Sorts {
    private final ArrayList<Integer> data = new ArrayList<>(); // setting up a new arraylist
    private final Duration timeElapsed; // setting up the variable of timeElapsed

    public Sorts(int size) {
        Instant start = Instant.now();  // starting the time
        // build an array
        for (int i = 0; i < size; i++) {
            data.add((int)(Math.random() * (size+1)));
        }
        // use Inheritance and Polymorphism to replace data.sort with your own algorithm

        //data.sort(Comparator.naturalOrder());
        // in the previous line, we're just ordering the data. let's build a bubble sort algo for this.
        bubbleSort(data);

        Instant end = Instant.now();    // time capture -- end
        this.timeElapsed = Duration.between(start, end);
    }

    // just getting the data here:

    public ArrayList<Integer> getData() {
        return data;
    }

    // getting the time:

    public int getTimeElapsed() {
        return timeElapsed.getNano();
    }

    // write in the bubble sort method:

   public ArrayList<Integer> bubbleSort (ArrayList<Integer> arr) {
       for (int i = 0; i < arr.size() - 1; i++) {
           for (int j = arr.size() - 1; j > i; j--) {
               if (arr.get(j - 1) > arr.get(j)) {
                   //Swap
                   int tmp = arr.get(j - 1);
                   arr.set(j -1, arr.get(j));
                   arr.set(j, tmp);
               }
           }
       }

       return arr;
   }


    public static void main(String[] args) {
        int sum=0, time=0, TIMES=12, SIZE=5000;

        for(int i=0; i< TIMES; i++) {
            Sorts s = new Sorts(SIZE);
            for(int j = 0; j < s.getData().size(); j++) {
                // To see data, uncomment next line
                // System.out.println(s.getData());
                sum += s.getData().get(j);
            }
            System.out.println("Average random: " + sum / ((i+1)*SIZE));
            System.out.println("Nanoseconds: " + s.getTimeElapsed());
            time += s.getTimeElapsed();
        }
        System.out.println("Average random: " + sum / (TIMES*SIZE));
        System.out.println("Total Nanoseconds: " + time );
        System.out.println("Total Seconds: " + time /1000000000.0);
    }

}