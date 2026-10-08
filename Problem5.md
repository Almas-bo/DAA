### Problem 5 - Integer Multiplication (20 points)

+ Given two long integer $A$ and $B$ represented as `String` objects, output the product of the two numbers.
+ Do not use `java.math.BigInteger`. But you can use it to test that your solutions are correct.
+ **5pts.** Implement a brute-force solution as `multBrute` method in [src/Problem5.java](src/Problem5.java).
+ **5pts.** Implement a divide-and-conquer efficient solution as `multSmart` method in [src/Problem5.java](src/Problem5.java).
+ **5pts.** Describe in written form your solution ideas in the **Report** section below.
+ **5pts.** Defend your solutions to your instructor in live during practice sessions.
+ Your code will be tested against various inputs using `JUnit6` testing framework.
+ **Don't change API** of the solutions in [src/Problem5.java](src/Problem5.java).

#### Example
+ Input: `A = "12345678987654321", B="98765432123456789"`
+ Output: `"1219326320073159566072245112635269"`

#### Constraints
+ $1 \leq A.length(), B.length() \leq 10^4$

#### References
1. Chapter 5.5, The Algorithm Design Manual, 3rd Edition, 2020 - Steven H. Skiena
2. Chapter 1.3, Algorithms Illuminated Part1, 2017 - Tim Roughgarden

### Report - Largest Subrange
**Brute-force.** School multiplication digit by digit. $T(n)=\Theta(n^2)$.

**Divide-and-conquer.** Karatsuba. Split numbers into high and low parts, $x=a\cdot10^h+b$, $y=c\cdot10^h+d$. Compute $ac$, $bd$ and $(a+b)(c+d)$, then $ad+bc=(a+b)(c+d)-ac-bd$. Three recursive multiplications instead of four: $T(n)=3T(n/2)+\Theta(n)$, by Master method $T(n)=\Theta(n^{\log_2 3})\approx\Theta(n^{1.585})$.

**Time (10^4 digits, ns):** brute ~75330431, smart ~486799200. Karatsuba is slower here because I use Strings for add/subtract and the constant is big, it would win only for much longer numbers.

### Defense Interview
+ Be ready to justify running times, for example using **Master method** for divide-and-conquer algorithms.
+ Be ready to answer questions on algorithms and your code.
+ Be ready to run your code and test it on various inputs.

Good Luck!