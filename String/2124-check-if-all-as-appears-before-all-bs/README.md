# 2124. Check if All A's Appears Before All B's

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/)

`String`

## Approach

Accepted easy solution in java.
Relevant topics: String.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public boolean checkString(String s) {

        int count = 0;
        for (int c : s.toCharArray()) {
            if (c == 'b') {
                count++;
            } else if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
```

---

**Runtime** 0 ms · **Memory** 43.2 MB

<sub>Synced by AILeetHub on 2026-02-11.</sub>
