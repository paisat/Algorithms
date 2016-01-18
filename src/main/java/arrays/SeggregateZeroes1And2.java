package arrays;

/**
 * Created by sarvothampai on 01/01/16.
 * <p/>
 * Time Complexity : O(N)
 */
public class SeggregateZeroes1And2 {


    public static void main(String[] args) {

        SeggregateZeroes1And2 obj = new SeggregateZeroes1And2();
        int input[] = new int[] { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        obj.seggregate012(input);

        for (int i : input) {
            System.out.print(i + " ");
        }

    }


    public void seggregate012(int arr[]) {

        if (arr != null && arr.length == 0) {
            return;
        }

        int length = arr.length;
        int high = length - 1;
        int mid = 0;
        int low = 0;


        while (mid <= high) {

            switch (arr[mid]) {

                case 0:
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, high, mid);
                    high--;
                    break;
            }

        }

    }


    private void swap(int arr[], int x, int y) {

        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

    }
}
