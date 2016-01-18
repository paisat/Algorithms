package arrays;

/**
 * Created by sarvothampai on 19/12/15.
 */
public class MaxSumSuchThatNoTwoElementsAreAdjacent {


    public static void main(String []args){

        MaxSumSuchThatNoTwoElementsAreAdjacent obj=new MaxSumSuchThatNoTwoElementsAreAdjacent();

        int arr[]={5,  5, 10, 40, 50, 35};

        System.out.println(obj.maxSum(arr));

    }


    public int maxSum(int arr[]){

        int esum=0;

        if(arr!=null && arr.length!=0){

            int isum=0;
            for(int i=0;i<arr.length;i++){
                esum=Math.max(esum,isum);
                isum=esum+arr[i];
            }
        }
        return esum;

    }
}
