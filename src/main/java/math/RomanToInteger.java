package math;

import java.util.HashMap;

/**
 * Created by sarvothampai on 26/12/15.
 */
public class RomanToInteger {


    public int romanToInt(String s) {

        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int result = map.get(s.charAt(len -1));
        int pivot = result;
        for(int i = len -2; i>= 0;i--){
            int curr = map.get(s.charAt(i));
            if(curr >=  pivot){
                result += curr;
            }else{
                //XCVI 96
                result -= curr;
            }
            pivot = curr;
        }
        return result;
    }


}
