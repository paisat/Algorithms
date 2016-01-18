package arrays;

/**
 * Created by sarvothampai on 24/12/15.
 * <p/>
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity.
 * The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
 * <p/>
 * Now you want to find out who the celebrity is or verify that there is not one.
 * The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B.
 * You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
 * <p/>
 * You are given a helper function bool knows(a, b) which tells you whether A knows B.
 * Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
 */
public class FindCelebrity {


    private boolean knows(int i, int j) {
        return true;
    }

    public int findCelebrity(int n) {


        if (n <= 0) {
            return -1;
        }

        int candidate = 0;

        for (int i = 1; i < n; i++) {

            if (!knows(i, candidate)) {
                candidate = i;
            }

        }

        for (int i = 0; i < n; i++) {

            if (i == candidate) {
                continue;
            }

            if (!knows(i, candidate) || knows(candidate, i)) {
                return -1;
            }

        }

        return candidate;

    }

    /**
     * Time Complexity : O(N)
     */
    int getInfluencer(int M[][]) {
        int cand = 0;
        for (int i = 1; i < M.length; i++) {
            if (M[cand][i] == 1 || M[i][cand] == 0) {
                cand = i;
            }
        }
        // now verify cand is indeed an influencer
        for (int j = 0; j < M.length; j++) {
            if (j == cand) continue;
            if (M[cand][j] == 1 || M[j][cand] == 0) return -1;
        }
        return cand;
    }
}
