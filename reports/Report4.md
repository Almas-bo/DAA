# Report - Problem 4: Closest Pair

Brute-force solution. In `minDistBrute()` I check the distance between every pair of points with two nested loops and keep the minimum. There are $n(n-1)/2$ pairs, so $T(n)=\Theta(n^2)$.

Divide-and-conquer solution. In `minDistSmart()` I first sort the points by x. Then I split them into the left and right half by the middle point and solve both halves recursively. Let d be the smaller of the two answers. The closest pair can still be split between the halves, so I take points that are closer than d to the middle vertical line (the strip), sorted by y. For each point in the strip I compare only with the next points whose y difference is less than d. There can be only a constant number of such points, so the strip is checked in linear time. Sorting by y is done by merging during the recursion.

Running time analysis. The recurrence is $T(n)=2T(n/2)+\Theta(n)$. By the Master method $a=2$, $b=2$, $d=1$, so $T(n)=\Theta(n\log{n})$ (the first sort by x is also $O(n\log{n})$, so the total does not change).

Empirical comparison. I measured with `System.nanoTime()` on $n=10^5$ random points. Brute-force took about 10.3 s (10342540497 ns) and smart about 109 ms (109128782 ns), so smart is around 95 times faster. For small n (like 3 or 4 points) brute-force is used inside the recursion as the base case.

Conclusion. The strip idea is the main trick of the algorithm, without it the combine step would be quadratic. I compared both solutions on 2000 random tests with many repeated coordinates and the distances were equal.
