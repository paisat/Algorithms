package arrays;

import java.util.LinkedList;
import java.util.TreeMap;

/**
 * Created by sarvothampai on 01/02/16.
 * <p>
 * You have bunch of numbers coming in, and a given a window size,
 * how would you save numbers so that you can return number if present in window and provide average for current window.
 * (Queue + Hash table + running sum)
 */
public class RunningAverageAndNumberPresent {

    public static void main(String[] args) {

        RunningAverageAndNumberPresent obj = new RunningAverageAndNumberPresent(3);

        obj.addNumber(2);
        obj.addNumber(2);
        obj.addNumber(3);
        obj.addNumber(34);
        obj.addNumber(234);

        obj.printNumbersInWindow();
        System.out.println(obj.average());

    }


    private int sum;
    private LinkedList<Integer> queue;
    private TreeMap<Integer, Integer> hashMap;
    private int windowSize;

    public RunningAverageAndNumberPresent(int windowSize) {
        sum = 0;
        queue = new LinkedList<Integer>();
        hashMap = new TreeMap<Integer, Integer>();
        this.windowSize = windowSize;

    }

    public void printNumbersInWindow() {
        System.out.println(queue);
    }

    public void addNumber(Integer number) {

        if (queue.size() < windowSize) {
            queue.addLast(number);
            sum = sum + number;

            if (hashMap.containsKey(number)) {
                hashMap.put(number, hashMap.get(number) + 1);
            } else {
                hashMap.put(number, 1);
            }

        } else {

            if (!queue.isEmpty()) {
                int num = queue.peek();
                sum = sum - num;
                queue.removeFirst();
                queue.addLast(number);
                sum = sum + number;

                if (hashMap.containsKey(num) && hashMap.get(num) == 1) {
                    hashMap.remove(num);
                } else {
                    hashMap.put(num, hashMap.get(num) - 1);
                }
            }


        }

    }

    public Float average() {
        return (float) sum / queue.size();
    }

    public boolean isNumberPresentInWindow(int number) {
        return hashMap.containsKey(number) && hashMap.get(number) >= 1;

    }


}
