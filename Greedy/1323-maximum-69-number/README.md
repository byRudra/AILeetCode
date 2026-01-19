# 1323. Maximum 69 Number

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/maximum-69-number/)

`Math` · `Greedy`

## Approach

Accepted easy solution in java.
Relevant topics: Math, Greedy.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int maximum69Number(int num) {
  char[] digits = String.valueOf(num).toCharArray();  
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';
                break; 
            }
        }
        return Integer.parseInt(new String(digits));
    }
}
```

---

**Runtime** 1 ms · **Memory** 42.4 MB

<sub>Synced by AILeetHub on 2026-01-19.</sub>
