package arrays;

/**
 * Created by sarvothampai on 03/10/15.
 */


public class MoveZeroes{

    public static void main(String args[]){

        MoveZeroes moveZeroes =new MoveZeroes();

        int []nums={1,0};

        moveZeroes.moveZeroes(nums);

        for(int i:nums){
            System.out.print(i+" ");
        }




    }

    public void moveZeroes(int []nums){

        if(nums!=null && nums.length!=0){

            int count=0;

            for(int i =0;i<nums.length;i++){

                if(nums[i]!=0){
                    nums[count]=nums[i];
                    count++;
                }
            }

            while(count<nums.length){

                nums[count]=0;
                count++;
            }

        }

    }


    /**
     *
     * Note this method doesnt maintain order of elements.
     *
     *
     *
     * */

    public void moveZeroes2(int[] nums) {


        if(nums!=null && nums.length!=0){

            int low=0;
            int high=nums.length-1;

            while(low<high){

                while(low<high  && nums[low]!=0){
                    low++;
                }

                while(low<high && nums[high]==0){
                    high--;
                }

                if(low<high){

                    int temp=nums[low];
                    nums[low]=nums[high];
                    nums[high]=temp;
                }
            }
        }

    }
}
