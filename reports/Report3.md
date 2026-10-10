# Report - Problem 3: Largest Subrange

Brute-force solution. In `maxSumBrute()` I try every start index i and every end index j and keep a running sum while j moves to the right, so I do not recalculate the sum from the beginning. The answer is the maximum of all sums. There are about $n^2/2$ pairs, so $T(n)=\Theta(n^2)$.

Divide-and-conquer solution. In `maxSumSmart()` I split the array in the middle. The best subarray is in one of three places: fully in the left half, fully in the right half, or it crosses the middle. The first two are solved recursively. For the crossing case I find the best sum going left from the middle and the best sum going right from the middle and add them. The answer is the maximum of the three values.

Running time analysis. Finding the crossing sum takes $\Theta(n)$, so $T(n)=2T(n/2)+\Theta(n)$. By the Master method $a=2$, $b=2$, $d=1$, so $a=b^d$ and $T(n)=\Theta(n\log{n})$. The recursion depth is $\log{n}$.

Empirical comparison. I measured with `System.nanoTime()` on a random array of $n=10^5$ elements. Brute-force took about 4.08 s (4079419130 ns), smart took about 3.1 ms (3088270 ns), so around 1300 times faster. The quadratic solution becomes really slow for big n.

Conclusion. Divide and conquer gives $\Theta(n\log{n})$, which is much better than $\Theta(n^2)$. There is also a linear solution (Kadane), but the task asks for divide-and-conquer. Both of my solutions gave the same answers on 2000 random tests, including arrays with all negative numbers.
