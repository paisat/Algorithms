package ds;

/**
 * Created by sarvothampai on 03/01/16.
 * <p/>
 * Trie is an efficient information retrieval data structure.
 * Using trie, search complexities can be brought to optimal limit (key length).
 * If we store keys in binary search tree, a well balanced BST will need time proportional to M * log N,
 * where M is maximum string length and N is number of keys in tree. Using trie, we can search the key in O(M) time.
 * However the penalty is on trie storage requirements.
 * <p/>
 * insert and search cost is O(KeyLength)
 * Space (26*key_length*N)
 * N is number of keys in trie.
 * <p/>
 * Space Complexity : O(W*L)
 * W is number of words
 * And L is the average length of each word.
 */

class TrieNode {
    // Initialize your data structure here.

    boolean isWord;

    TrieNode children[];


    public TrieNode() {
        children = new TrieNode[26];
    }
}

public class Trie {

    public static void main(String[] args) {

        Trie root = new Trie();

        root.insert("ab");

    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {

        if (word != null && word.length() != 0) {


            TrieNode cur = root;

            for (int i = 0; i < word.length(); i++) {

                char ch = word.charAt(i);
                int index = ch - 'a';

                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.isWord = true;

        }


    }

    // Returns if the word is in the trie.
    public boolean search(String word) {

        if (word != null && word.length() != 0) {

            TrieNode cur = root;

            for (int i = 0; i < word.length(); i++) {

                char ch = word.charAt(i);
                int index = ch - 'a';

                if (cur.children[index] == null) {
                    return false;
                }
                cur = cur.children[index];
            }

            return (cur != null) && cur.isWord;

        }

        return false;
    }

    public void deleteWord(String word) {

        if (root != null) {
            deleteWordHelper(root, word, 0);
        }

    }

    private boolean isNodeFree(TrieNode node) {

        for (int i = 0; i < 26; i++) {

            if (node.children[i] != null) {
                return false;
            }

        }
        return true;
    }

    private boolean isAleafNode(TrieNode root) {

        if (root.isWord) {
            return true;
        }

        return false;
    }

    private boolean deleteWordHelper(TrieNode root, String word, int pos) {

        if (root != null) {


            if (pos == word.length() - 1) {

                if (root.isWord) {
                    root.isWord = false;
                }

                if (isNodeFree(root)) {
                    return true;
                }

                return false;


            } else {

                int index = word.charAt(pos) - 'a';

                if (deleteWordHelper(root.children[index], word, pos + 1)) {

                    root.children[index] = null;

                    if (!isAleafNode(root) && isNodeFree(root)) {
                        return true;
                    }

                    return false;

                }
            }

        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {

        if (prefix != null && prefix.length() != 0) {

            TrieNode cur = root;
            for (int i = 0; i < prefix.length(); i++) {

                char ch = prefix.charAt(i);
                int index = ch - 'a';

                if (cur.children[index] == null) {
                    return false;
                }

                cur = cur.children[index];

            }

            return true;
        }
        return false;
    }

}
