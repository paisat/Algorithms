package ds;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by sarvothampai on 05/01/16.
 *
 *
 * Space Complexity : O(N)
 * Time Complexity : Log(n)
 *
 */

class TSTNode {
    char data;
    boolean isEnd;
    TSTNode left, middle, right;

    /**
     * Constructor
     **/
    public TSTNode(char data) {
        this.data = data;
        this.isEnd = false;
        this.left = null;
        this.middle = null;
        this.right = null;
    }
}

/**
 * class TernarySearchTree
 **/
class TernarySearchTree {
    private TSTNode root;
    private ArrayList<String> al;

    /**
     * Constructor
     **/
    public TernarySearchTree() {
        root = null;
    }

    /**
     * function to check if empty
     **/
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * function to clear
     **/
    public void makeEmpty() {
        root = null;
    }

    /**
     * function to insert for a word
     **/
    public void insert(String word) {
        root = insert(root, word.toCharArray(), 0);
    }

    /**
     * function to insert for a word
     **/
    public TSTNode insert(TSTNode r, char[] word, int ptr) {
        if (r == null)
            r = new TSTNode(word[ptr]);

        if (word[ptr] < r.data)
            r.left = insert(r.left, word, ptr);
        else if (word[ptr] > r.data)
            r.right = insert(r.right, word, ptr);
        else {
            if (ptr + 1 < word.length)
                r.middle = insert(r.middle, word, ptr + 1);
            else
                r.isEnd = true;
        }
        return r;
    }

    /**
     * function to delete a word
     **/
    public void delete(String word) {
        delete(root, word.toCharArray(), 0);
    }

    /**
     * function to delete a word
     **/
    private void delete(TSTNode r, char[] word, int ptr) {
        if (r == null)
            return;

        if (word[ptr] < r.data)
            delete(r.left, word, ptr);
        else if (word[ptr] > r.data)
            delete(r.right, word, ptr);
        else {
            /** to delete a word just make isEnd false **/
            if (r.isEnd && ptr == word.length - 1)
                r.isEnd = false;

            else if (ptr + 1 < word.length)
                delete(r.middle, word, ptr + 1);
        }
    }

    /**
     * function to search for a word
     **/
    public boolean search(String word) {
        return search(root, word.toCharArray(), 0);
    }

    /**
     * function to search for a word
     **/
    private boolean search(TSTNode r, char[] word, int ptr) {
        if (r == null)
            return false;

        if (word[ptr] < r.data)
            return search(r.left, word, ptr);
        else if (word[ptr] > r.data)
            return search(r.right, word, ptr);
        else {
            if (r.isEnd && ptr == word.length - 1)
                return true;
            else if (ptr == word.length - 1)
                return false;
            else
                return search(r.middle, word, ptr + 1);
        }
    }

    /**
     * function to print tree
     **/
    public String toString() {
        al = new ArrayList<String>();
        traverse(root, "");
        return "\nTernary Search Tree : " + al;
    }

    /**
     * function to traverse tree
     **/
    private void traverse(TSTNode r, String str) {
        if (r != null) {
            traverse(r.left, str);

            str = str + r.data;
            if (r.isEnd)
                al.add(str);

            traverse(r.middle, str);
            str = str.substring(0, str.length() - 1);

            traverse(r.right, str);
        }
    }
}

/**
 * class TernarySearchTree
 **/
class TernarySearchTreeTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        /* Creating object of TernarySearchTree */
        TernarySearchTree tst = new TernarySearchTree();
        System.out.println("Ternary Search Tree Test\n");

        char ch;
        /*  Perform tree operations  */
        do {
            System.out.println("\nTernary Search Tree Operations\n");
            System.out.println("1. insert word");
            System.out.println("2. search word");
            System.out.println("3. delete word");
            System.out.println("4. check empty");
            System.out.println("5. make empty");

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter word to insert");
                    tst.insert(scan.next());
                    break;
                case 2:
                    System.out.println("Enter word to search");
                    System.out.println("Search result : " + tst.search(scan.next()));
                    break;
                case 3:
                    System.out.println("Enter word to delete");
                    tst.delete(scan.next());
                    break;
                case 4:
                    System.out.println("Empty Status : " + tst.isEmpty());
                    break;
                case 5:
                    System.out.println("Ternary Search Tree cleared");
                    tst.makeEmpty();
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            System.out.println(tst);

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }
}