# Report - Problem 1: Number of Occurrences

Brute-force solution. In `countFreqBrute()` I go through the whole array from the beginning to the end and increase a counter every time the element is equal to the key. It does not use the fact that the array is sorted. It always looks at all n elements, so the running time is $T(n)=\Theta(n)$ in the best, worst and average case.

Divide-and-conquer solution. In `countFreqSmart()` I use the sorted order. I wrote a binary search `lower()` that returns the first index where the element is >= x. The number of occurrences of key is `lower(key+1) - lower(key)`. Each binary search throws away half of the array every step, so I do not need to look at every element.

Running time analysis. For binary search the recurrence is $T(n)=T(n/2)+O(1)$. By the Master method $a=1$, $b=2$, $d=0$, so $a=b^d$ and $T(n)=\Theta(\log{n})$. I call it two times, so the total is still $\Theta(\log{n})$. Memory is $O(1)$ for both solutions.

Empirical comparison. I measured with `System.nanoTime()` on a sorted array of $n=10^5$ elements (average of 1000 calls). Brute-force took about 48676 ns, smart took about 231 ns, so the smart solution is around 200 times faster. This matches the theory, linear against logarithmic.

Conclusion. If the array is sorted binary search is much better than a simple loop and the difference grows with n. I also checked both solutions against each other on 2000 random tests and the answers were always the same.
