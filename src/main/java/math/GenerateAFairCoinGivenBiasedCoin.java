package math;

/**
 * Created by sarvothampai on 13/03/16.
 *
 *
 * You are given a function bool rand_bit_p() that returns true with some unknown probability p and false with probability 1 - p.
 Write function rand_bit() using rand_bit_p that will return true and false with equal probability (that is, implement a fair coin, given unfair coin)
 *
 *
 * Explanation
 *
 * If a cheat has altered a coin to prefer one side over another (a biased coin), the coin can still be used for fair results by changing the game slightly. John von Neumann gave the following procedure:[2]

 Toss the coin twice.
 If the results match, start over, forgetting both results.
 If the results differ, use the first result, forgetting the second.
 The reason this process produces a fair result is that the probability of getting heads and then tails must be the same as the probability of getting tails and then heads, as the coin is not changing its bias between flips and the two flips are independent.
 This works only if getting one result on a trial doesn't change the bias on subsequent trials, which is the case for most non-malleable coins (but not for processes such as the Polya urn).
 By excluding the events of two heads and two tails by repeating the procedure, the coin flipper is left with the only two remaining outcomes having equivalent probability.
 This procedure only works if the tosses are paired properly; if part of a pair is reused in another pair, the fairness may be ruined. Also, the coin must not be so biased that one side has a probability of zero.
 This method may be improved slightly by also considering sequences of four tosses. That is, if the coin is flipped twice but the results match, and the coin is flipped twice again but the results match now for the opposite side, then the first result can be used.
 This is because HHTT and TTHH are equally likely. This can be extended to any power of 2.


 TODO Google

 *
 */
public class GenerateAFairCoinGivenBiasedCoin {



    private int biasedCoin() {
        return 1;
    }

    public int fairCoin() {

        int try1 = biasedCoin();
        int try2 = biasedCoin();

        if (try1 == 0 && try2 == 1) {
            return 0;
        }

        if (try1 == 1 && try2 == 0) {
            return 1;
        }

        return fairCoin();

    }

}
