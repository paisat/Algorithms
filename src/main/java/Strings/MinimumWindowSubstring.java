package Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sarvothampai on 03/10/15.
 * <p/>
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p/>
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * <p/>
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * <p/>
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * <p/>
 * Time Complexity : O(N)
 */


public class MinimumWindowSubstring {


    public static void main(String[] args) {


        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println(obj.minWindow("cabwefgewcwaefgcf", "cae"));
        System.out.println(obj.minWindow2("a","a"));

    }

    public String minWindow(String s, String t) {

        String result = "";


        if (s != null && t != null && s.length() != 0 && t.length() != 0) {

            Map<Character, Integer> needToFind = new HashMap<Character, Integer>();
            Map<Character, Integer> hasFound = new HashMap<Character, Integer>();

            for (int i = 0; i < t.length(); i++) {

                if (needToFind.get(t.charAt(i)) == null) {
                    needToFind.put(t.charAt(i), 1);
                } else {
                    needToFind.put(t.charAt(i), needToFind.get(t.charAt(i)) + 1);
                }
            }

            int minLength = Integer.MAX_VALUE;
            int begin = 0, end = 0;
            int l = 0, r = 0;
            int count = 0;


            for (int i = 0; i < s.length(); i++) {

                char a = s.charAt(i);
                if (needToFind.get(a) == null) {
                    continue;
                }

                if (hasFound.get(a) == null) {
                    hasFound.put(a, 1);
                } else {
                    hasFound.put(a, hasFound.get(a) + 1);
                }

                if (hasFound.get(a) <= needToFind.get(a)) {
                    count++;
                }

                if (count == t.length()) {


                    while (needToFind.get(s.charAt(begin)) == null || hasFound.get(s.charAt(begin)) >
                            needToFind.get(s.charAt(begin))) {

                        if (hasFound.get(s.charAt(begin)) != null && hasFound.get(s.charAt(begin)) >
                                needToFind.get(s.charAt(begin))) {
                            hasFound.put(s.charAt(begin), hasFound.get(s.charAt(begin)) - 1);
                        }
                        begin++;

                    }

                    int length = i - begin + 1;
                    if (length < minLength) {
                        minLength = length;
                        l = begin;
                        r = i;

                    }
                }

            }

            if (minLength != Integer.MAX_VALUE) {
                result = s.substring(l, r + 1);
            }


        }


        return result;

    }


    /**
     *
     *
     * Using array instead of map.
     * Time Complexity : O(N)
     *
     * */
    public String minWindow2(String s , String t){


        if(s!=null && s.length()!=0 && t!=null && t.length()!=0){

            int needToFind[] =new int[256];
            int hasFound[] =new int[256];


            for(int i=0;i<t.length();i++){
                char ch=t.charAt(i);
                needToFind[ch]++;
            }

            int count=0; int begin=0; int start=0; int end=0; int minLength=Integer.MAX_VALUE;

            for(int j=0;j<s.length();j++){

                char ch=s.charAt(j);

                if(needToFind[ch]==0){
                    continue;
                }

                hasFound[ch]++;

                if(hasFound[ch]<=needToFind[ch]){
                    count++;
                }

                if(count==t.length()){

                    while ( begin<s.length() && needToFind[s.charAt(begin)]==0 || hasFound[s.charAt(begin)] > needToFind[s.charAt(begin)] ){


                        if(needToFind[s.charAt(begin)]!=0 && hasFound[s.charAt(begin)]>needToFind[s.charAt(begin)]){

                            hasFound[s.charAt(begin)]--;
                        }

                        begin++;

                    }

                    if(j-begin+1 < minLength){

                        minLength=j-begin+1;
                        start=begin;
                        end=j;
                    }



                }


            }

            if(minLength!=Integer.MAX_VALUE) {

                return s.substring(start, end + 1);
            }


        }

        return "";

    }


}


