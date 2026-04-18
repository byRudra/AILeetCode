# 3783. Mirror Distance of an Integer

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/mirror-distance-of-an-integer/)

`Math`

## Intuition
The mirror distance is simply the absolute difference between a number and its digit‑reversed counterpart.  
Reversing a number can be done by repeatedly extracting the last digit and appending it to a new number.  
Once the reversed value is known, the distance is the absolute value of the subtraction.

## Approach
1. Keep a copy of the original `n` in `num`.  
2. Initialize `reverse` to 0.  
3. While `n` is non‑zero:  
   * `digit = n % 10` – the last digit.  
   * `reverse = reverse * 10 + digit` – append the digit to the reversed number.  
   * `n /= 10` – drop the processed digit.  
4. After the loop, `reverse` holds the integer formed by the digits of the original number in reverse order.  
5. Return `Math.abs(num - reverse)`.

## Complexity
- **Time:** O(d) – each digit of `n` is processed once, where d ≈ log₁₀ n.  
- **Space:** O(1) – only a few integer variables are used, independent of input size.

## Solution (java)

```java
class Solution {

    public int mirrorDistance(int n) {
        int reverse = 0;int num=n;
        while(n != 0){
            int digit = n % 10;
            reverse = reverse * 10 + digit;
            n /= 10;
        }
        return Math.abs(num - reverse);
    }
}
```

---

**Runtime** 1 ms · **Memory** 42.6 MB

<sub>Synced by AILeetHub on 2026-04-18.</sub>
