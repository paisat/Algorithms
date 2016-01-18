package Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// @formatter:off
 /**
 * Created by sarvothampai on 11/11/15.
 *
 * Given a string, we can “shift” each of its letter to its successive letter, for example: “abc” -> “bcd”. We can keep “shifting” which forms the sequence:

 1
 "abc" -> "bcd" -> ... -> "xyz"
 Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

 For example,

 given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], Return:

 [
    ["abc","bcd","xyz"],
    ["az","ba"],
    ["acef"],
    ["a","z"]
 ]
 */
public class GroupShiftedStrings {


     public static void main(String []args){

         GroupShiftedStrings obj =new GroupShiftedStrings();

         String []arr={"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};

         System.out.println(obj.groupStrings(arr));


     }



   public List<List<String>> groupStrings(String[] strings) {


    List<List<String>> result =new ArrayList<List<String>>();

    if(strings!=null && strings.length!=0){


        Map<String,List<String>> hash =new HashMap<String,List<String>>();

        for(String str: strings){

            int shift =  'a'-str.charAt(0);

            String orig="";

            for(int i=0;i<str.length();i++){

                int val = str.charAt(i)+shift;
                val = val <'a' ? val+26 : val;
                orig+=((char)val);

            }

            if(hash.containsKey(orig)){

                hash.get(orig).add(str);

            }
            else{
                List<String> stringList =new ArrayList<String>();
                stringList.add(str);
                hash.put(orig,stringList);
            }

        }


        for(Map.Entry<String,List<String>> entry : hash.entrySet() ){
            Collections.sort(entry.getValue());
            result.add(entry.getValue());
        }

    }

    return result;

}

}
