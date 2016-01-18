package Strings;

import java.util.Arrays;

/**
 * Created by sarvothampai on 12/12/15.
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * Time Complexity : O(n logn)
 *
 */
public class LongestCommonPrefix {


    public String longestCommonPrefix(String[] strs) {

        StringBuilder result =new StringBuilder();

        if(strs!=null && strs.length!=0){

            Arrays.sort(strs);

            char start[]=strs[0].toCharArray();
            char end[]=strs[strs.length-1].toCharArray();

            for(int i=0;i<start.length;i++){

                if(end.length > i && start[i]==end[i]){
                    result.append(start[i]);
                }
                else{
                    return result.toString();
                }
            }


        }

        return result.toString();

    }

}
