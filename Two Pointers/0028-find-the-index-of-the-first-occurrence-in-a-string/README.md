# 28. Find the Index of the First Occurrence in a String

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/)

`Two Pointers` · `String` · `String Matching` · `Z Algorithm` · `Knuth–Morris–Pratt Algorithm` · `Boyer–Moore String-Search Algorithm`

## Intuition
We need the first index where `needle` appears in `haystack`. With lengths up to 10⁴ a straightforward linear scan is fast enough. For every possible start position we can extract the slice of `haystack` that has the same length as `needle` and compare it directly.

## Approach
Let `n = haystack.length()` and `m = needle.length()`.  
* If `m == 0` return 0 (empty needle matches at the start).  
* If `m > n` return -1 (needle cannot fit).  
Iterate `i` from 0 to `n - m` inclusive:  
1. Compute `haystack.substr(i, m)` – a temporary string of length `m`.  
2. If this substring equals `needle`, return `i`.  
If the loop ends without a match, return -1. The `substr` call creates a temporary string, and the equality operator compares characters one by one.

## Complexity
- **Time:** O((n‑m+1)·m) – each of the at most `n‑m+1` positions triggers an O(m) substring comparison.  
- **Space:** O(1) – aside from the temporary substring of fixed length `m`, no additional data structures are used.

## Solution (cpp)

```cpp
class Solution {
public:
    int strStr(string haystack, string needle) {
        int n = haystack.length(), m = needle.length();

        if (m == 0) return 0;
        if (m > n) return -1;

        for (int i = 0; i <= n - m; i++){
            if (haystack.substr(i,m) == needle) return i;
        }

        return -1;
    }
};
```

---

**Runtime** 0 ms · **Memory** 8.2 MB

<sub>Synced by AILeetHub on 2024-09-30.</sub>
