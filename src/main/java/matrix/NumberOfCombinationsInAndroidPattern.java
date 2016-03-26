package matrix;

/**
 * Created by sarvothampai on 12/03/16.
 *
 *
 * Find the number of patterns in android lock screen.
 * TODO Google
 *
 *
 *
 */
public class NumberOfCombinationsInAndroidPattern {


    private int count2 = 0;

    public static void main(String[] args) {

        NumberOfCombinationsInAndroidPattern obj = new NumberOfCombinationsInAndroidPattern();

        System.out.println(obj.getNumberOfCombinationsInAndroidPattern(9));
        System.out.println(obj.count2);
    }


    public int getNumberOfCombinationsInAndroidPattern(int n) {

        boolean visited[] = new boolean[n];

        int count = 0;


        for (int length = 4; length <= 9; length++) {
                count += numberOfPatternsHelper(-1, visited, length);
            }

        return count;

    }


    private int numberOfPatternsHelper(int dot, boolean visited[], int length) {

        if (length == 0) {
            return 1;
        }


        int count = 0;


        for (int i = 0; i < 9; i++) {

            if (isChildValid(dot, i, visited)) {
                visited[i] = true;
                count += numberOfPatternsHelper(i, visited, length - 1);
                visited[i] = false;
            }

        }

        return count;

    }

    private boolean isChildValid(int parent, int child, boolean visited[]) {


        if(parent==-1){
            return true;
        }

        if (visited[child]) {
            return false;
        }

        //knight moves
        if ((parent + child) % 2 == 1) {
            return true;
        }


        int mid = (parent + child) / 2;

        if (mid == 4) {
            return visited[4];
        }


        if ((parent % 3 != child % 3) && (parent / 3 != child / 3)) {
            return true;
        }

        return visited[mid];

    }
}
