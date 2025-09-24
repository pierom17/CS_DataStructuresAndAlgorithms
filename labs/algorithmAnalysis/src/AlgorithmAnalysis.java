// Name: Piero Miranda
// Student ID: 1062732
// Date: 2025/09/139
// Description: This file has a java class that verifies the ArrayList method
// indexOf() is really O(n)

import java.util.ArrayList;

public class AlgorithmAnalysis {
    public static void main(String[] args) throws Exception {
        // We are creating an ArrayList of random integers
        //And the we call the indexOf method through the getIndexOfTime method
        int [] items = {1000 , 20000, 30000, 40000, 50000};

        // Loop through the times we are going to compare
        for (int item : items){
            System.out.println("Testing for the number of items: " + item);
            ArrayList<Double> times = new ArrayList<>();

            for (int run = 0; run < 25; run++) {
                ArrayList<Integer> numbers = new ArrayList<>();
                for (int i = 0; i < item; i++) {
                    numbers.add(i);
                }
                getIndexOfTime(times, numbers);
            }
            double avg = AverageTime(times);
            System.out.printf("The average of the last 5 runs for this number of items is %,d: %.3f s%n%n", item, avg);
        }
        
    }
    // This method gets the array of the last 5 repetition's time and averages it
    public static double AverageTime(ArrayList<Double> times) {
        double sum = 0;
        for (int i = times.size() - 1; i >= times.size() - 5; i--) {
            sum += times.get(i);
        }
        return sum / 5;
    }

    // This method gets the time of the indexOf method
    // and adds it to the times array
    // It returns the times array
    // Returns long array of times in NANOSECONDS
    public static ArrayList<Double> getIndexOfTime(ArrayList<Double> times, ArrayList<Integer> numbers) {
        long startTime = System.nanoTime();
        for (int i = 0; i < numbers.size(); i++) {
            numbers.indexOf(i); 
        }
        long endTime = System.nanoTime();
        long timeNano = (endTime - startTime);
        Double time = (double) timeNano / 1000000000; // Convert to seconds
        times.add(time);
        return times;
    }
}