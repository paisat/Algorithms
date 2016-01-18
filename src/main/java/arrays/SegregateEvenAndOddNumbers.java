package arrays;

/**
 * Created by sarvothampai on 19/12/15.
 *
 * Given an array A[], write a function that segregates even and odd numbers. The functions should put all even numbers first, and then odd numbers.

 Example

 Input  = {12, 34, 45, 9, 8, 90, 3}
 Output = {12, 34, 8, 90, 45, 9, 3}
 In the output, order of numbers can be changed, i.e., in the above example 34 can come before 12 and 3 can come before 9.


 Time Complexity : O(N)

 *
 */
public class SegregateEvenAndOddNumbers {

    public static void main(String args[]){


        int arr[]={12, 34, 45, 9, 8, 90, 3};

        SegregateEvenAndOddNumbers obj=new SegregateEvenAndOddNumbers();

        obj.seggregateEvenAndOddNumbers(arr);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }


    }


    public void seggregateEvenAndOddNumbers(int arr[]){


        if(arr!=null && arr.length!=0){

            int left=0;
            int right=arr.length-1;

            while (left<right){

                while(left<right && arr[left]%2==0 ){
                    left++;
                }

                while (left<right && arr[right]%2==1){
                    right--;
                }

                if(left<right){
                    int temp=arr[left];
                    arr[left]=arr[right];
                    arr[right]=temp;

                    left++;
                    right--;
                }

            }

        }

    }


}
