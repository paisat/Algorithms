package Strings;

/**
 * Created by sarvothampai on 13/01/16.
 * <p/>
 * <p/>
 * Time Complexity : O(Log n)
 */
public class CharacterCeiling {

    public static void main(String[] args) {

        CharacterCeiling obj = new CharacterCeiling();
        System.out.println(obj.findCeilingOfCharacter(new Character[] { 'c', 'f', 'j', 'p', 'v' }, 'a'));
        System.out.println(obj.findCeilingOfCharacter(new Character[] { 'c', 'f', 'j', 'p', 'v' }, 'c'));
        System.out.println(obj.findCeilingOfCharacter(new Character[] { 'c', 'f', 'j', 'p', 'v' }, 'k'));
        System.out.println(obj.findCeilingOfCharacter(new Character[] { 'c', 'f', 'j', 'p', 'v' }, 'z'));
        System.out.println(obj.findCeilingOfCharacter(new Character[] { 'c', 'f', 'k' }, 'f'));
        System.out.println(obj.findCeilingOfCharacter(new Character[] { 'c', 'f', 'k' }, 'c'));
        System.out.println(obj.findCeilingOfCharacter(new Character[] { 'c', 'f', 'k' }, 'd'));
        System.out.println(obj.findCeilingOfCharacter(new Character[] { 'c', 'f', 'k' }, 'f'));


    }

    public Character findCeilingOfCharacter(Character[] chars, Character search) {

        if (chars == null || chars.length == 0 || search == null) {
            return null;
        }


        int low = 0;
        int high = chars.length - 1;

        while (low <= high) {


            if (search < chars[low]) {
                return chars[low];
            }

            int mid = low + (high - low) / 2;

            if (chars[mid] == search && mid < chars.length - 1) {
                return chars[mid + 1];
            }

            if (chars[mid] < search) {

                if (mid < chars.length - 1 && chars[mid + 1] > search) {
                    return chars[mid + 1];
                } else {
                    low = mid + 1;
                }

            } else if (chars[mid] > search) {

                if (mid > 0 && chars[mid - 1] < search) {
                    return chars[mid];
                } else {
                    high = mid - 1;
                }

            }


        }

        return chars[0];

    }
}
