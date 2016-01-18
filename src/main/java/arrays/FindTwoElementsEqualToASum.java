package arrays;

import java.util.Arrays;

/**
 * Created by sarvothampai on 16/09/15.
 */
public class FindTwoElementsEqualToASum {

    public static void main(String[] args) {

        int arr[] = {-1, -2, -3,-4,-5};

        FindTwoElementsEqualToASum obj = new FindTwoElementsEqualToASum();
        int [] solution= obj.twoSum(arr,-8);

        for(int i :solution){
            System.out.println(i);
        }


    }

    private void findTwoElmentsEqualToASum(int arr[], int n) {

        Arrays.sort(arr);

        int l = 0;
        int r = arr.length - 1;

        while (l < r) {

            int sum = arr[l] + arr[r];

            if (sum == n) {
                System.out.println("Two elements are " + arr[l] + " " + arr[r]);
                return;
            } else if (sum < n) {
                l++;
            } else {
                r--;
            }
        }

        System.out.println("No elements found");


    }

    private int[] twoSum(int[] nums, int target) {

        int solution[] =new int[2];
        int indexes[]=new int[2];

        int numsCopy[]=nums.clone();


        Arrays.sort(numsCopy);

        int l = 0;
        int r = numsCopy.length - 1;

        while (l < r) {

            int sum = numsCopy[l] + numsCopy[r];

            if (sum == target) {
                solution[0]=numsCopy[l];
                solution[1]=numsCopy[r];
                break;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(solution[0]==nums[i] && indexes[0]==0){
                indexes[0]=i+1;
            }
            else if(solution[1]==nums[i] && indexes[1]==0){
                indexes[1]=i+1;
            }

        }

        Arrays.sort(indexes);


        return indexes;

    }

}
