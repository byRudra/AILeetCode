# 389. Find the Difference

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/find-the-difference/)

`Hash Table` · `String` · `Bit Manipulation` · `Sorting`

## Approach

Accepted easy solution in java.
Relevant topics: Hash Table, String, Bit Manipulation, Sorting.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public char findTheDifference(String s, String t) {
        char result = 0;
        for(char ch : s.toCharArray()){
            result ^= ch;
        }
        for(char ch : t.toCharArray()){
            result ^= ch;
        }
        return result;
    }
}
```

---

**Runtime** 1 ms · **Memory** 43.5 MB

<sub>Synced by AILeetHub on 2026-06-10.</sub>
