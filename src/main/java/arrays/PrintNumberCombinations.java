package arrays;

/**
 * Created by sarvothampai on 15/01/16.
 */
public class PrintNumberCombinations {


    public static void main(String[] args) {

        PrintNumberCombinations obj = new PrintNumberCombinations();
        obj.printNumberCombinations(12);

    }

    public void printNumberCombinations(int n) {


        int arr[] = new int[400];
        combinationPrintHelper(n, arr, 0);

    }

    private void combinationPrintHelper(int n, int arr[], int i) {

        if (n == 0) {
            print(arr, i);
        } else if(n>0) {

            for (int j = 1; j <= 9; j++) {
                arr[i] = j;
                combinationPrintHelper(n - j, arr, i + 1);
            }

        }


    }

    private void print(int arr[], int size) {

        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
