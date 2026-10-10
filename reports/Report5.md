# Report - Problem 5: Integer Multiplication

Brute-force solution. In `multBrute()` I multiply like in school. Every digit of A is multiplied by every digit of B and the result is added to the correct position of an int array, after that I do the carries from right to left and remove leading zeros. For two numbers with n digits this is $T(n)=\Theta(n^2)$.

Divide-and-conquer solution. In `multSmart()` I use the Karatsuba algorithm. I split both numbers in two parts: $A=a\cdot10^h+b$ and $B=c\cdot10^h+d$. Normal splitting needs 4 multiplications ($ac$, $ad$, $bc$, $bd$), but $ad+bc=(a+b)(c+d)-ac-bd$, so only 3 recursive multiplications are needed. The result is $ac\cdot10^{2h}+(ad+bc)\cdot10^h+bd$. I wrote my own `add()` and `sub()` for strings because `BigInteger` is not allowed. When both numbers are short (up to 18 digits) I multiply them with `long`.

Running time analysis. The recurrence is $T(n)=3T(n/2)+\Theta(n)$ because additions, subtractions and shifts are linear. By the Master method $a=3$, $b=2$, $d=1$, so $a>b^d$ and $T(n)=\Theta(n^{\log_2{3}})\approx\Theta(n^{1.585})$, which is better than $\Theta(n^2)$ of the brute-force.

Empirical comparison. I measured with `System.nanoTime()` on two random numbers with 10000 digits each. Brute-force took about 75 ms (75330431 ns) and Karatsuba took about 487 ms (486799200 ns), so in my implementation Karatsuba is slower on this size. The reason is that I work with Strings and create many new strings in `add`, `sub` and `substring`, so the constant is very big. Karatsuba would start to win only for much longer numbers or with a better implementation (arrays of digits and a bigger base).

Conclusion. Theoretically Karatsuba is better, but for $n\leq10^4$ the simple solution was faster in practice. Both solutions gave the same result as `BigInteger` on 2000 random tests, which I used only for testing.
