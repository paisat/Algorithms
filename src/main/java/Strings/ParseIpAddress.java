package Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sarvothampai on 19/01/16.
 * <p>
 * ((25[0-5]|2[0-4][0-9]|[1]?[0-9][0-9]?)\.){3}(25[0-5]|2[0-4][0-9]|[1]?[0-9][0-9]?)
 * <p>
 * <p>
 * ^	Start of a string.
 * $	End of a string.
 * .	Any character (except \n newline)
 * |	Alternation.
 * {...}	Explicit quantifier notation.
 * [...]	Explicit set of characters to match.
 * (...)	Logical grouping of part of an expression.
 * 0 or more of previous expression.
 * +	1 or more of previous expression.
 * ?	0 or 1 of previous expression; also forces minimal matching when an expression might match several strings within a search string.
 * \	Preceding one of the above, it makes it a literal instead of a special character. Preceding a special matching character, see below.
 * <p>
 * grep -E -w -o “((25[0-5]|2[0-4][0-9]|[1]?[0-9][0-9]?)\.){3}(25[0-5]|2[0-4][0-9]|[1]?[0-9][0-9]?)” test.txt
 */
public class ParseIpAddress {


    public static void main(String[] args) {

        String s = "10.0.0.4 hi hello 23.2.2.45 \n" +
                "1.2.3 hello 23.46.22.11";

        ParseIpAddress obj = new ParseIpAddress();

        System.out.println(obj.parseIpAddress(s));


    }

    public List<String> parseIpAddress(String s) {


        List<String> result = new ArrayList<String>();

        Pattern p = Pattern.compile("(((25[0-5]|2[0-4][0-9]|[1]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[1]?[0-9][0-9]?))");

        Matcher m = p.matcher(s);


        while (m.find()) {
            result.add(m.group());
        }

        return result;
    }
}
