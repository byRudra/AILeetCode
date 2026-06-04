# 3751. Total Waviness of Numbers in Range I

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/)

`Math` · `Dynamic Programming` · `Enumeration`

## Intuition  
The waviness of a number depends only on the relative order of its adjacent digits.  
A digit can be a peak or a valley only if it has both a left and a right neighbor, so the first and last digits are irrelevant.  
Thus, for each number we can examine its digits sequentially and count how many interior digits satisfy the peak or valley condition.

## Approach  
1. Iterate through every integer `num` from `num1` to `num2` inclusive.  
2. Convert `num` to a string to access individual digits.  
3. If the string length is less than 3, its waviness is 0.  
4. For each interior position `i` (1 ≤ i < len‑1), compare the digit at `i` with its neighbors at `i‑1` and `i+1`.  
   * If `digit[i]` is strictly greater than both neighbors or strictly smaller than both, increment a counter.  
5. Add the counter for the current number to a running total.  
6. Return the total after the loop.

This direct enumeration matches the problem’s definition and works within the given limits (up to 10⁵ numbers, each with at most 5 digits).

## Complexity  
- **Time:** O((num2‑num1+1) × L) – each number is processed once and each digit (≤ 5) is inspected a constant number of times.  
- **Space:** O(1) – only a few integer variables and a string representation of a single number are stored.

## Solution (java)

```java
class Solution {

    private int currentWaviness(long num){
        String numString = String.valueOf(num);
        if (numString.length() < 3) return 0;
        int count = 0;
        for(int i = 1; i < numString.length() - 1; i++){
            char left = numString.charAt(i - 1);
            char mid = numString.charAt(i);
            char right = numString.charAt(i + 1);
            if((left > mid && mid < right) || (mid > left && mid > right)) count++;
        }
        return count;
    }
    public int totalWaviness(int num1, int num2) {
        long ans = 0;
        for(long num = num1; num <= num2; num++){
            ans += currentWaviness(num);
        }
        return (int) ans;
    }
}
```

---

**Runtime** 27 ms · **Memory** 46.7 MB

<sub>Synced by AILeetHub on 2026-06-04.</sub>
