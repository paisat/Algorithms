package arrays;

/**
 * Created by sarvothampai on 19/12/15.
 *
 * Given an unsorted array arr[] and two numbers x and y, find the minimum distance between x and y in arr[].
 * The array might also contain duplicates.
 * You may assume that both x and y are different and present in arr[].
 *
 * Time Complexity : O(N)
 *
 */
public class MinimumDistanceBetweenTwoNumbers {

    public static void main(String []args){

        MinimumDistanceBetweenTwoNumbers obj=new MinimumDistanceBetweenTwoNumbers();

        int arr1[]={1, 2}; int x1=1,y1=2;
        int arr2[]={3, 4, 5}; int x2=3,y2=5;
        int arr3[]={3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}; int x3=3,y3=6;


        System.out.println(obj.minimumDistanceBetweenTwoNumbers(arr1,x1,y1));
        System.out.println(obj.minimumDistanceBetweenTwoNumbers(arr2,x2,y2));
        System.out.println(obj.minimumDistanceBetweenTwoNumbers(arr3,x3,y3));


    }


    public Integer minimumDistanceBetweenTwoNumbers(int arr[],int x,int y){

        Integer result=Integer.MAX_VALUE;

        if(arr!=null && arr.length!=0){

            int prev=-1;

            int i=0;

            for( i=0;i<arr.length;i++){

                if(arr[i]==x|| arr[i]==y){
                    prev=i;
                    break;
                }

            }

            if(prev!=-1){


                for(;i<arr.length;i++){

                    if (arr[i]==x || arr[i]==y){

                        if(arr[prev]!=arr[i] && i-prev<result ){
                            result=i-prev;
                            prev=i;

                        }
                        else {
                            prev=i;
                        }

                    }

                }

            }


        }

        return (result==Integer.MAX_VALUE)?null:result;
    }
}
