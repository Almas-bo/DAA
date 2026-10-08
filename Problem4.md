### Problem 4 - Closest Pair (20 points)

+ Given an array of point coordinates $P$, find the minimum distance between two points in the array, return the distance.
+ **5pts.** Implement a brute-force solution as `minDistBrute()` method in [src/Problem4.java](src/Problem4.java).
+ **5pts.** Implement a divide-and-conquer efficient solution as `minDistSmart()` method in [src/Problem4.java](src/Problem4.java).
+ **5pts.** Describe in written form your solution ideas in the **Report** section below.
+ **5pts.** Defend your solutions to your instructor in live during practice sessions.
+ Your code will be tested against various inputs using `JUnit6` testing framework.
+ **Don't change API** of the solutions in [src/Problem4.java](src/Problem4.java).

#### Example
+ Input: `P = {{0,0},{3,4},{-5,-3}}`
+ Output: `5.0`

#### Constraints
+ $1 \leq P.length \leq 10^5$
+ $P[i][j]$ is of type `double`

#### References
1. Chapter 5.6, The Algorithm Design Manual, 3rd Edition, 2020 - Steven H. Skiena
2. Chapter 3.4, Algorithms Illuminated Part1, 2017 - Tim Roughgarden

### Report - Largest Subrange
**Brute-force.** Check all pairs of points. $T(n)=\Theta(n^2)$.

**Divide-and-conquer.** Sort by x, split in half, solve both halves, d = min of the two. Then look at the strip of points with x closer than d to the middle line, sorted by y (done with merge during recursion). For each point in the strip only the next few points with y difference < d need to be checked (constant number). $T(n)=2T(n/2)+\Theta(n)$, so $T(n)=\Theta(n\log{n})$.

**Time (n = 10^5, ns):** brute ~10342540497, smart ~109128782.

### Defense Interview
+ Be ready to justify running times, for example using **Master method** for divide-and-conquer algorithms.
+ Be ready to answer questions on algorithms and your code.
+ Be ready to run your code and test it on various inputs.

Good Luck!