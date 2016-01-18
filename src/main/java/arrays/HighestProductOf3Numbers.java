package arrays;

import java.util.Arrays;

/**
 * Created by sarvothampai on 30/12/15.
 * <p/>
 * <p/>
 * Return maxiumum product of 3 numbers.
 */
public class HighestProductOf3Numbers {

    public static void main(String[] args) {
        HighestProductOf3Numbers obj = new HighestProductOf3Numbers();

        System.out.println(obj.highestProductOfThreeNumbers(new int[] { -200, -200, 12, 12, 44, 345, 123, 1 }));
        System.out.println(obj.highestProductOfThreeNumbers(new int[] { -5, -7, 4, 2, 1, 9 }));
        System.out.println(obj.highestProductOfThreeNumbers(new int[] { 4, 5, -19, 3 }));

        System.out.println(obj.highestProductOfThreeNumbers2(new int[] { -200, -200, 12, 12, 44, 345, 123, 1 }));
        System.out.println(obj.highestProductOfThreeNumbers2(new int[] { -5, -7, 4, 2, 1, 9 }));
        System.out.println(obj.highestProductOfThreeNumbers2(new int[] { 4, 5, -19, 3 }));

    }


    public int highestProductOfThreeNumbers(int arr[]) {

        int result = 0;

        if (arr != null && arr.length >= 3) {
            Arrays.sort(arr);
            int product1 = arr[arr.length - 1] * arr[arr.length - 2] * arr[arr.length - 3];
            int product2 = arr[0] * arr[1] * arr[arr.length - 1];
            result = Math.max(product1, product2);

        }

        return result;

    }

    public int highestProductOfThreeNumbers2(int arr[]) {
        int result = 0;

        if (arr != null && arr.length >= 3) {

            int maxOne = Integer.MIN_VALUE;
            int maxTwo = Integer.MIN_VALUE;
            int maxThree = Integer.MIN_VALUE;

            int lowest1 = Integer.MAX_VALUE;
            int lowest2 = Integer.MAX_VALUE;

            for (int i = 0; i < arr.length; i++) {

                if (arr[i] > maxOne) {
                    maxThree = maxTwo;
                    maxTwo = maxOne;
                    maxOne = arr[i];
                } else if (arr[i] > maxTwo) {
                    maxThree = maxTwo;
                    maxTwo = arr[i];
                } else if (arr[i] > maxThree) {
                    maxThree = arr[i];
                }

                if (arr[i] < lowest1) {
                    lowest2 = lowest1;
                    lowest1 = arr[i];
                } else if (arr[i] < lowest2) {
                    lowest2 = arr[i];
                }
            }

            int product1 = maxOne * maxThree * maxTwo;
            int product2 = lowest1 * lowest2 * maxOne;

            result = Math.max(product1, product2);

        }

        return result;

    }

}
