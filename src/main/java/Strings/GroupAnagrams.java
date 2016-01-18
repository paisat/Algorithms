package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by sarvothampai on 29/09/15.
 *
 * Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]

 ]


 Another approach assign all charaters a prime number . Multiply all prime numbers.
 Group Strings based on product.



 Time Complexity : O(N M log M)
 *
 */
public class GroupAnagrams{

    public static void main(String []args){

        GroupAnagrams groupAnagrams =new GroupAnagrams();

        List<List<String>> anagrams =groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

        for(List<String> anagramList : anagrams){

            System.out.println(anagramList);

        }

        Stack<Integer> integers =new Stack<Integer>();


    }

    public List<List<String>> groupAnagrams(String []strs){

        Arrays.sort(strs);

        List<List<String>> groupedAnagrams =  new ArrayList<List<String>>();

        if(strs!=null && strs.length!=0){

            Map<String,List<String>> anagramMap =new HashMap<String,List<String>>();

            for(String str : strs){

                char c[] = str.toCharArray();
                Arrays.sort(c);
                String sortedString = String.valueOf(c);

                if(anagramMap.get(sortedString)==null){
                    List<String> groupedAnagramList = new ArrayList<String>();
                    groupedAnagramList.add(str);
                    anagramMap.put(sortedString,groupedAnagramList);
                }
                else{
                    anagramMap.get(sortedString).add(str);
                }

            }

            for(Map.Entry<String,List<String>> entry : anagramMap.entrySet()){

                groupedAnagrams.add(entry.getValue());
            }

        }

        return groupedAnagrams;

    }
}