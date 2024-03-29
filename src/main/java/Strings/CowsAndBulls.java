package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sarvothampai on 18/11/15.
 * <p/>
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is.
 * Each time your friend makes a guess,
 * you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls")
 * and how many digits match the secret number but locate in the wrong position (called "cows").
 * Your friend will use successive guesses and hints to eventually derive the secret number.
 * <p/>
 * For example:
 * <p/>
 * Secret number:  "1807"
 * Friend's guess: "7810"
 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".
 * <p/>
 * Please note that both secret number and friend's guess may contain duplicate digits, for example:
 * <p/>
 *
 * Secret number:  "1123"
 * Friend's guess: "0111"
 * In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
 * You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 *
 *
 * Time Complexity : O(N) . Where N is the length of the string.
 * Space Complexity : O(1)
 *
 *
 */
public class CowsAndBulls {

    public static void main(String[] args) {

        CowsAndBulls obj = new CowsAndBulls();

        System.out.println(obj.getHint("1807","7810"));


    }

    public String getHint(String secret, String guess) {


        int digitCount[]=new int[10];
        int bulls=0,cows=0;

        for(int i=0;i<secret.length();i++){

            int s= Character.getNumericValue(secret.charAt(i));
            int g=Character.getNumericValue(guess.charAt(i));

            if(s==g){
                bulls++;
            }
            else{

                if(digitCount[g]>0){
                    cows++;
                }

                if(digitCount[s]<0){
                    cows++;
                }

                digitCount[s]++;
                digitCount[g]--;



            }

        }

        return bulls+"A"+cows+"B";



    }
}
