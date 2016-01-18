package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 12/12/15.
 * <p/>
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip twoconsecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * Write a function to compute all possible states of the string after one valid move.
 * For example, given s = "++++", after one move, it may become one of the following states:
 * [
 * "--++",
 * "+--+",
 * "++--"
 * ]
 * If there is no valid move, return an empty list [].
 *
 * Time Complexity : O(N)
 *
 */
public class FlipGame {

    public static void main(String []args){

        FlipGame obj =new FlipGame();
        System.out.println(obj.generatePossibleNextMoves("++++"));

    }


    public List<String> generatePossibleNextMoves(String s) {

        List<String> result = new ArrayList<String>();

        if (s != null && s.length() != 0) {

            for (int i = 0; i < s.length() - 1; i++) {

                if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == '+') {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i + 2);

                    String temp = s1 + "--" + s2;

                    result.add(temp);
                }
            }
        }

        return result;

    }


}
