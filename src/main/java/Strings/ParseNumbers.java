package Strings;

/**
 * Created by sarvothampai on 30/01/16.
 * <p>
 * Given a string parse numbers in that and make a sum;
 */
public class ParseNumbers {

    public static void main(String[] args) {

        ParseNumbers obj = new ParseNumbers();

        System.out.println(obj.parseNumber("1231.232 adbsa 23"));
        System.out.println(obj.parseNumber("-.5364.abcd1"));
        System.out.println(obj.parseNumber("-34232.2323abcd-232.34"));
        System.out.println(obj.parseNumber("adadada"));
        System.out.println(obj.parseNumber("...2"));
        System.out.println(obj.parseNumber("+++++2"));
        System.out.println(obj.parseNumber("------------3"));
    }


    public float parseNumber(String s) {

        //Float.MIN_VALUE

        Float result = 0F;

        if (s != null && s.length() != 0) {

            s = s.trim();


            for (int i = 0; i < s.length(); i++) {

                char ch = s.charAt(i);

                boolean pointSeen = false;
                boolean positive = true;

                if (ch == '.') {
                    pointSeen = true;
                    i++;
                } else if (ch == '+' || ch == '-') {
                    positive = (ch == '+') ? true : false;
                    i++;
                }

                Float decimal = 0.1F;
                Float number = 0F;

                while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.')) {

                    char chi = s.charAt(i);

                    if (pointSeen && s.charAt(i) == '.') {
                        break;
                    }

                    if (!pointSeen && s.charAt(i) == '.') {
                        pointSeen = true;
                        i++;
                        continue;
                    }

                    if (!pointSeen) {
                        number = number * 10 + Character.getNumericValue(s.charAt(i));
                    } else {
                        number = number + decimal * Character.getNumericValue(s.charAt(i));
                        decimal = decimal * 0.1F;
                    }

                    i++;

                }

                number = (positive) ? number : -number;
                result = result + number;

            }

        }

        return result;


    }
}
