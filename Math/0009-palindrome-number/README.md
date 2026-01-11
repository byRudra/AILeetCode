# 9. Palindrome Number

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/palindrome-number/)

`Math`

## Intuition
A number is a palindrome if its decimal representation reads the same forwards and backwards.  
By converting the integer to a string we can leverage built‑in string operations to check this property in a straightforward manner.

## Approach
1. **Edge cases** – Any negative number is not a palindrome because of the leading minus sign.  
   Also, numbers ending in `0` (except `0` itself) cannot be palindromes because the reversed string would start with `0`.  
2. **String conversion** – Convert the integer to a string `s`.  
3. **Reversal** – Create a reversed copy of `s` using `StringBuilder`’s `reverse()` method.  
4. **Comparison** – Return `true` if the original string equals its reversed version; otherwise return `false`.

This method relies on Java’s efficient string handling and avoids manual digit extraction.

## Complexity
- **Time:** O(n) – where *n* is the number of digits in `x`; each digit is processed once during conversion and reversal.  
- **Space:** O(n) – the string representation and its reversed copy each store *n* characters.

## Solution (java)

```java
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        String s = String.valueOf(x);
        String reversed = new StringBuilder(s).reverse().toString();

        return s.equals(reversed);
    }
}

```

---

**Runtime** 8 ms · **Memory** 46.3 MB

<sub>Synced by AILeetHub on 2026-01-11.</sub>
