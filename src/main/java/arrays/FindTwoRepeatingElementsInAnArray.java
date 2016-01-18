package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 11/11/15.
 * You are given an array of n+2 elements. All elements of the array are in range 1 to n.
 * And all elements occur once except two numbers which occur twice. Find the two repeating numbers.
 * <p/>
 * For example, array = {4, 2, 4, 5, 2, 3, 1} and n = 5
 * <p/>
 * The above array has n + 2 = 7 elements with all elements occurring once except 2 and 4 which occur twice. So the output should be 4 2.
 *
 * Time Complexity : O(N)
 *
 */
public class FindTwoRepeatingElementsInAnArray {


    public static void main(String []args){


        FindTwoRepeatingElementsInAnArray obj=new FindTwoRepeatingElementsInAnArray();

        System.out.println(obj.findTwoRepeatingElementsInArray(new int[]{1,1,3,3,2}));

    }

    public List<Integer> findTwoRepeatingElementsInArray(int arr[]) {


        List<Integer> result = new ArrayList<Integer>();

        if (arr != null && arr.length != 0) {


            int n = arr.length - 2;

            int xor = 0;

            for (int i = 0; i < arr.length; i++) {
                xor = xor ^ arr[i];
            }

            for (int i = 1; i <= n; i++) {
                xor = xor ^ i;
            }

            int rightMostSetBit = xor & (-xor);

            int a = 0, b = 0;

            for (int i = 0; i < arr.length; i++) {

                if ((arr[i] & rightMostSetBit) != 0) {
                    a = a ^ arr[i];
                } else {
                    b = b ^ arr[i];
                }
            }

            for (int i = 1; i <= n; i++) {


                if ((i & rightMostSetBit) != 0) {
                    a = a ^ i;
                } else {
                    b = b ^ i;
                }
            }

            result.add(a);
            result.add(b);
        }

        return result;

    }
}
