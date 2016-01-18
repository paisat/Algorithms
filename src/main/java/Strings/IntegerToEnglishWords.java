package Strings;

/**
 * Created by sarvothampai on 10/11/15.
 * <p/>
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * <p/>
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Hint:
 * <p/>
 * Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.
 */
public class IntegerToEnglishWords {


    public static void main(String[] args) {

        IntegerToEnglishWords obj = new IntegerToEnglishWords();

        System.out.println(obj.numberToWords(1000326));


    }


    public String numberToWords(int num) {

        String result = null;

        if (num >= 0) {

            String thousands[] = { "Thousand", "Million", "Billion" };

            StringBuilder res = new StringBuilder();

            if (num == 0) {
                res.append("Zero");
            } else {

                int i = 0;

                res.append(convert1000(num % 1000));
                num = num / 1000;

                while (num != 0) {

                    if (num % 1000 != 0) {
                        res.insert(0, convert1000(num % 1000) + " " + thousands[i] + " ");

                    }
                    num = num / 1000;
                    i++;

                }
            }


            result = res.toString().trim();
        }

        return result;

    }


    public String convert1000(int n) {

        StringBuilder wordString = new StringBuilder();

        String oneTo19[] = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };

        String tensMultiple[] = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };


        do {

            if (n >= 100) {


                int d = n / 100;
                n = n % 100;
                wordString.append(oneTo19[d]).append(" Hundred");


            } else {

                if (n >= 0 && n <= 19) {


                    wordString.append(" " + oneTo19[n]);
                    n = n / 100;
                } else {

                    int d = n / 10;
                    n = n % 10;

                    wordString.append(" " + tensMultiple[d]);

                }

            }

        } while (n != 0);

        return wordString.toString().trim();
    }

}
