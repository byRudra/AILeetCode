# 1291. Sequential Digits

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/sequential-digits/)

`Enumeration`

## Intuition  
Sequential digits form a very small, predictable set: every valid number is a contiguous block of the string “123456789”.  
Because the maximum length of a sequential number that fits in the 32‑bit integer range is 9 digits, we can simply generate all such blocks and keep those that lie between `low` and `high`.

## Approach  
1. Store the digits “123456789” in a string.  
2. For each possible length `len` from 2 to 9 (inclusive):  
   * Slide a window of size `len` over the digit string.  
   * Convert the window to an integer.  
   * If the integer is within `[low, high]`, append it to the result list.  
3. Return the accumulated list, which is naturally sorted because the windows are processed in increasing order of length and starting position.

The algorithm enumerates at most 36 candidates (sum of 1 + 2 + … + 8), so the loop count is constant.

## Complexity  
- **Time:** O(1) – a fixed number of iterations (≤ 36) regardless of input size.  
- **Space:** O(1) – the result list holds at most 36 integers, a constant bound.

## Solution (java)

```java
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();

        String digits = "123456789";
        for(int len = 2; len < 10; len++){
            for(int start = 0; start+len < 10; start++){
                int num = Integer.parseInt(digits.substring(start, start+len));

                if (num >= low && num <= high) result.add(num);
            }
        }
        return result;
    }
}
```

---

**Runtime** 0 ms · **Memory** 42.1 MB

<sub>Synced by AILeetHub on 2026-07-13.</sub>
