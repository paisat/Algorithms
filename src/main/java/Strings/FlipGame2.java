package Strings;

import java.util.Map;

/**
 * Created by sarvothampai on 12/12/15.
 * <p/>
 * <p/>
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip twoconsecutive "++" into "--".
 * The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * Write a function to determine if the starting player can guarantee a win.
 * <p/>
 * For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".
 * <p/>
 * Time Complexity : N^2
 */
public class FlipGame2 {


    public static void main(String[] args) {

        FlipGame2 obj = new FlipGame2();
        System.out.println(obj.canWin("++++"));

    }

    public boolean canWin(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }

        Map<String, Boolean> states = new java.util.HashMap<String, Boolean>();

        return helper(s, states);


    }

    private boolean helper(String s, Map<String, Boolean> moves) {

        if (moves.containsKey(s)) {
            return moves.get(s);
        }

        for (int i = 0; i < s.length() - 1; i++) {

            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == '+') {

                String afterMove = s.substring(0, i) + "--" + s.substring(i + 2);

                if (!helper(afterMove, moves)) {

                    moves.put(s, true);
                    return true;

                }


            }

        }

        moves.put(s, false);
        return false;

    }


    /**
     * Time Complexity : (2^N)
     */
    public boolean canWin2(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)) {
                String t = s.substring(0, i) + "--" + s.substring(i + 2);

                if (!canWin2(t)) {
                    return true;
                }
            }
        }

        return false;
    }

}
