# Report - Problem 2: Median of Two Sorted Arrays

Brute-force solution. In `getMedianBrute()` I merge the two sorted arrays into one new sorted array, like in merge sort, with two pointers. After that the median is the middle element if the total length is odd, or the average of two middle elements if it is even. The merge visits every element once, so $T(n,m)=\Theta(n+m)$ and it needs $\Theta(n+m)$ extra memory.

Divide-and-conquer solution. In `getMedianSmart()` I reduce the problem to finding the k-th smallest element of two sorted arrays (for even length I find two elements and take the average). In `kth()` I compare `A[k/2]` and `B[k/2]`. The array with the smaller value cannot contain the k-th element in its first k/2 positions, so I cut these elements off and decrease k. If one array is empty the answer is directly in the other one.

Running time analysis. Every step k becomes about two times smaller, so $T(k)=T(k/2)+O(1)$. By the Master method ($a=1$, $b=2$, $d=0$) we get $T=\Theta(\log{k})=\Theta(\log{(n+m)})$. The recursion uses only $O(\log{(n+m)})$ stack and no extra arrays.

Empirical comparison. I measured with `System.nanoTime()` on two arrays of 1000 elements (average of 1000 calls). Brute-force took about 9490 ns and smart about 293 ns, which is around 30 times faster. For small inputs the difference is not very big in real time, but it grows with the size.

Conclusion. The smart solution does not need to merge the arrays, so it is faster and uses less memory. The hardest part was the edge cases when k is small or when one array is shorter than k/2. I tested both versions on 2000 random inputs and they gave equal results.
