package Strings;

/**
 * Created by sarvothampai on 19/09/15.
 */
public class LongestPlaindromicString {

    public static void main(String[] args) {

        String input = "ababbbbbb";
        LongestPlaindromicString obj = new LongestPlaindromicString();
        //System.out.println(obj.getLongestPalindromicSequenceDynamic(input));
        System.out.println(obj.getLongestPalindromicSequence(input));
        System.out.println(obj.longestPalindromicSubstringLinear(new String("abaxabaxabybaxabyb").toCharArray()));

    }


    public int longestPalindromicSubstringLinear(char input[]) {
        int index = 0;
        //preprocess the input to convert it into type abc -> $a$b$c$ to handle even length case.
        //Total size will be 2*n + 1 of this new array.
        char newInput[] = new char[2*input.length + 1];
        for(int i=0; i < newInput.length; i++) {
            if(i % 2 != 0) {
                newInput[i] = input[index++];
            } else {
                newInput[i] = '$';
            }
        }

        //create temporary array for holding largest palindrome at every point. There are 2*n + 1 such points.
        int T[] = new int[newInput.length];
        int start = 0;
        int end = 0;
        //here i is the center.
        for(int i=0; i < newInput.length; ) {
            //expand around i. See how far we can go.
            while(start >0 && end < newInput.length-1 && newInput[start-1] == newInput[end+1]) {
                start--;
                end++;
            }
            //set the longest value of palindrome around center i at T[i]
            T[i] = end - start + 1;

            //this is case 2. Current palindrome is proper suffix of input. No need to proceed. Just break out of loop.
            if(end == T.length -1) {
                break;
            }
            //Mark newCenter to be either end or end + 1 depending on if we dealing with even or old number input.
            int newCenter = end + (i%2 ==0 ? 1 : 0);

            for(int j = i + 1; j <= end; j++) {

                //i - (j - i) is left mirror. Its possible left mirror might go beyond current center palindrome. So take minimum
                //of either left side palindrome or distance of j to end.
                T[j] = Math.min(T[i - (j - i)], 2 * (end - j) + 1);
                //Only proceed if we get case 3. This check is to make sure we do not pick j as new center for case 1 or case 4
                //As soon as we find a center lets break out of this inner while loop.
                if(j + T[i - (j - i)]/2 == end) {
                    newCenter = j;
                    break;
                }
            }
            //make i as newCenter. Set right and left to atleast the value we already know should be matching based of left side palindrome.
            i = newCenter;
            end = i + T[i]/2;
            start = i - T[i]/2;
        }

        //find the max palindrome in T and return it.
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < T.length; i++) {
            int val;
      /*      if(i%2 == 0) {
                val = (T[i] -1)/2;
            } else {
                val = T[i]/2;
            }*/
            val = T[i]/2;
            if(max < val) {
                max = val;
            }
        }
        return max;
    }




    /**
     * Time Complexity : O(N^2)
     * <p/>
     * Space Complexity : O(1)
     */
    private String getLongestPalindromicSequence(String s) {

        String result = null;

        if (s != null && s.length() != 0) {
            int maxLength = 1;
            int start = 0;

            int n = s.length();

            int high, low;


            for (int i = 1; i < n; i++) {

                //odd plaindromes
                high = i;
                low = i - 1;

                while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {

                    if (high - low + 1 > maxLength) {
                        maxLength = high - low + 1;
                        start = low;
                    }

                    high++;
                    low--;

                }

                //even palindromes
                low = i - 1;
                high = i + 1;

                while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {

                    if (high - low + 1 > maxLength) {
                        maxLength = high - low + 1;
                        start = low;
                    }

                    high++;
                    low--;

                }

            }

            return s.substring(start, start + maxLength);

        }

        return result;

    }


    /**
     * Time Complexity : O(N^2)
     */
    private String getLongestPalindromicSequenceDynamic(String s) {

        String result = null;

        if (s != null && s.length() != 0) {

            int maxlength = 1;
            int start = 0;
            int n = s.length();

            boolean[][] table = new boolean[s.length()][s.length()];


            for (int i = 0; i < n; i++) {
                table[i][i] = true;
                maxlength = 1;
            }

            for (int i = 0; i < n - 1; i++) {

                if (s.charAt(i) == s.charAt(i + 1)) {
                    table[i][i + 1] = true;
                    maxlength = 2;
                    start = i;
                }

            }

            for (int k = 3; k <= n; k++) {
                for (int i = 0; i <= n - k; i++) {

                    int j = i + k - 1;

                    if (table[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {

                        table[i][j] = true;

                        if (k > maxlength) {
                            maxlength = k;
                            start = i;
                        }

                    }

                }
            }
            return s.substring(start, start + maxlength);
        }
        return result;
    }

}
