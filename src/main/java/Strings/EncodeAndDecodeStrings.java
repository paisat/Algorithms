package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 10/11/15.
 * <p/>
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
 * <p/>
 * Machine 1 (sender) has the function:
 * <p/>
 * string encode(vector<string> strs) {
 * // ... your code
 * return encoded_string;
 * }
 * Machine 2 (receiver) has the function:
 * vector<string> decode(string s) {
 * //... your code
 * return strs;
 * }
 * So Machine 1 does:
 * <p/>
 * string encoded_string = encode(strs);
 * and Machine 2 does:
 * <p/>
 * vector<string> strs2 = decode(encoded_string);
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 * <p/>
 * Implement the encode and decode methods.
 * <p/>
 * Note:
 * The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
 * Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
 * Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
 */
public class EncodeAndDecodeStrings {


    public static void main(String[] args) {

        EncodeAndDecodeStrings obj = new EncodeAndDecodeStrings();

        List<String> strings = new ArrayList<String>();
        strings.add("abc");
        strings.add("sarvotham");
        strings.add("pai");

        String encoded;

        System.out.println(encoded = obj.encode(strings));
        System.out.println(obj.decodeString(encoded));


    }

    public String encode(List<String> strings) {

        String encodedString = null;

        if (strings != null && strings.size() != 0) {

            encodedString = "";

            for (String string : strings) {

                encodedString += string.length() + "#";
                encodedString += string;
            }
        }

        return encodedString;

    }


    public List<String> decodeString(String encodedString) {

        List<String> decodedString = new ArrayList<String>();

        if (encodedString != null && encodedString.length() != 0) {

            int length = encodedString.length();
            int i = 0;

            while (i < length) {
                int index = encodedString.indexOf("#", i);
                int strLength = Integer.valueOf(encodedString.substring(i, index));
                decodedString.add(encodedString.substring(index + 1, index + 1 + strLength));
                i = index + strLength + 1;
            }
        }

        return decodedString;
    }
}
