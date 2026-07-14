# 392. Is Subsequence

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/is-subsequence/)

`Two Pointers` · `String` · `Dynamic Programming`

## Intuition  
A subsequence preserves the order of characters but allows gaps.  
If we walk through `t` once and keep a pointer into `s`, each time we see the current character of `s` we can “consume” it.  
When the pointer reaches the end of `s`, all its characters have appeared in order within `t`.

## Approach  
1. Initialise an index `i = 0` for `s`.  
2. Iterate over each character `t[j]` of `t`.  
3. If `t[j]` equals `s[i]`, increment `i`.  
4. Stop early if `i` equals `s.length()` (all characters matched).  
5. After the loop, return `i == s.length()`.

This two‑pointer scan guarantees that we only traverse `t` once and never backtrack, so the relative order of matched characters is preserved automatically.

## Complexity  
- **Time:** O(|t|) – each character of `t` is examined at most once.  
- **Space:** O(1) – only a single integer index is used regardless of input size.

## Solution (java)

```java
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;

        for (int j = 0; j < t.length() && i < s.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }

        return i == s.length();
    }
}
```

---

**Runtime** 2 ms · **Memory** 42.9 MB

<sub>Synced by AILeetHub on 2026-07-14.</sub>
