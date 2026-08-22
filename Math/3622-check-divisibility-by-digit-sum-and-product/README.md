# 3622. Check Divisibility by Digit Sum and Product

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/)

`Math`

## Intuition  
The problem reduces to a single arithmetic check: a number `n` is valid if it is divisible by the sum of two values derived from its own digits – the digit sum and the digit product. Both values can be obtained by iterating over the decimal representation of `n`.

## Approach  
1. **Digit Sum** – Repeatedly extract the least‑significant digit (`n % 10`), add it to a running total, and truncate the digit (`n /= 10`).  
2. **Digit Product** – Perform the same extraction, but multiply the digit into a running product, starting from 1.  
3. **Divisibility Test** – Compute `total = sum + product` and return whether `n % total == 0`.  
The helper methods `sumOfDigits` and `productOfDigits` encapsulate the digit extraction logic, keeping the main `checkDivisibility` method concise.

## Complexity  
- **Time:** O(d) – each digit of `n` is processed once in both helper functions, where `d` is the number of digits.  
- **Space:** O(1) – only a few integer variables are used regardless of input size.

## Solution (java)

```java
class Solution {
    public int sumOfDigits(int n){
        int sum = 0;
        while(n > 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    public int productOfDigits(int n){
        int product = 1;
        while(n > 0){
            product *= n % 10;
            n /= 10;
        }
        return product;
    }
    public boolean checkDivisibility(int n) {
        return n % (sumOfDigits(n) + productOfDigits(n)) == 0;
    }
}
```

---

**Runtime** 0 ms · **Memory** 42.3 MB

<sub>Synced by AILeetHub on 2026-08-22.</sub>
