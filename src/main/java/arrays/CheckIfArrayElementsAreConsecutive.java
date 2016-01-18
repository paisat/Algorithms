package arrays;

import java.util.HashSet;

/**
 * Created by sarvothampai on 19/12/15.
 *
 *
 * Time COmplexity : O(N)
 * Space Complexity : O(N)
 *
 */
public class CheckIfArrayElementsAreConsecutive {

    public static void main(String []args){

        int arr[]={5,5, 2, 3, 1, 4};
        int arr2[]={83, 78, 80, 81, 79, 82};
        int arr3[]={ 34, 23, 52, 12, 3 };

        CheckIfArrayElementsAreConsecutive obj=new CheckIfArrayElementsAreConsecutive();

        System.out.println(obj.isConsecutive(arr));
        System.out.println(obj.isConsecutive(arr2));
        System.out.println(obj.isConsecutive(arr3));


    }


    public boolean isConsecutive(int arr[]){

        boolean result=false;

        if(arr!=null && arr.length!=0){

            HashSet<Integer> set=new HashSet<Integer>();

            for(int i:arr){
                set.add(i);
            }

            for(int i=0;i<arr.length;i++){

                if(!set.contains(arr[i]-1)){

                    int num=arr[i];
                    int equalElements=0;

                    while (set.contains(num)){
                        equalElements++;
                        num++;
                    }

                    if(equalElements==set.size()){
                        result=true;
                        break;
                    }
                }

            }


        }

        return result;

    }
}
