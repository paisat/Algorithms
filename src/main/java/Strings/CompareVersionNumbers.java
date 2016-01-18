package Strings;

/**
 * Created by sarvothampai on 11/11/15.
 * <p/>
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * <p/>
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three",
 * it is the fifth second-level revision of the second first-level revision.
 * <p/>
 * Here is an example of version numbers ordering:
 * <p/>
 * 0.1 < 1.1 < 1.2 < 13.37
 */
public class CompareVersionNumbers {

    public static void main(String[] args) {

        CompareVersionNumbers obj = new CompareVersionNumbers();

        System.out.println(obj.compareVersion("1.1", "1.01.0"));

    }


    public int compareVersion(String version1, String version2) {

        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");

        int i = 0;

        while (i < ver1.length || i < ver2.length) {


            if (i < ver1.length && i < ver2.length) {

                if (Integer.parseInt(ver1[i]) < Integer.parseInt(ver2[i])) {
                    return -1;
                } else if (Integer.parseInt(ver1[i]) > Integer.parseInt(ver2[i])) {
                    return 1;
                }
            } else if (i < ver1.length) {

                //required for inputs like 1.0 and 1
                if (Integer.parseInt(ver1[i]) != 0) {
                    return 1;
                }
            } else if (i < ver2.length) {

                if (Integer.parseInt(ver2[i]) != 0) {
                    return -1;
                }

            }

            i++;

        }

        return 0;


    }


}
