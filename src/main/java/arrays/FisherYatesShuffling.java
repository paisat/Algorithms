package arrays;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by sarvothampai on 29/12/15.
 * <p/>
 * <p/>
 * Shuffle an array
 */
public class FisherYatesShuffling {


    public static void main(String[] args) {

        FisherYatesShuffling obj = new FisherYatesShuffling();

        int arr[] = { 1, 23, 4, 5, 6, 454, 21 };

        obj.shuffle(arr);
        obj.printArray(arr);

    }


    private void printArray(int arr[]) {
        System.out.println();
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public void shuffle(int arr[]) {

        if (arr != null && arr.length != 0) {


            for (int i = arr.length - 1; i >= 1; i--) {

                int index = ThreadLocalRandom.current().nextInt(0, i + 1);
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
