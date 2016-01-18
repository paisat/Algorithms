package tree;

/**
 * Created by sarvothampai on 24/10/15.
 * <p/>
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * <p/>
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 */

public class NumberOfUniqueBST {

    public static void main(String[] args) {


        NumberOfUniqueBST obj = new NumberOfUniqueBST();

        System.out.println(obj.numTrees(19));

    }

    public int numTrees(int n) {

        int catalan[] = new int[n + 1];

        // Initialize first two values in table
        catalan[0] = catalan[1] = 1;

        // Fill entries in catalan[] using recursive formula
        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++)
                catalan[i] += catalan[j] * catalan[i - j - 1];
        }

        // Return last entry
        return catalan[n];

    }
}
