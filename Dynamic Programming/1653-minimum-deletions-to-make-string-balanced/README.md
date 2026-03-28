# 1653. Minimum Deletions to Make String Balanced

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/)

`String` · `Dynamic Programming` · `Stack`

## Intuition
A balanced string contains all `a`s before any `b`.  
While scanning the string from left to right we keep track of how many `b`s have appeared so far.  
When an `a` is found after at least one `b`, the pair `(b, a)` violates the balance.  
We can either delete that `a` or delete one of the preceding `b`s.  
Choosing to delete the `a` is always optimal because it removes the current violation and keeps all earlier `b`s available for future `a`s.  
Thus we increment the deletion counter and pretend that one of the earlier `b`s was removed by decreasing the stored `b` count.

## Approach
1. Initialize `res = 0` (deletions) and `count = 0` (number of `b`s seen).  
2. Iterate over each character `c` in `s`.  
   * If `c` is `'b'`, increment `count`.  
   * If `c` is `'a'` and `count > 0`, a violation exists:  
     - Increment `res` (delete this `a`).  
     - Decrement `count` (as if one earlier `b` were removed).  
3. Return `res`.

This greedy strategy ensures that at every step the string up to the current position can be made balanced with the minimal deletions counted.

## Complexity
- **Time:** O(n) – each character is processed once.  
- **Space:** O(1) – only a few integer variables are used, independent of input size.

## Solution (java)

```java
class Solution {
    public int minimumDeletions(String s) {

        int res = 0, count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                count++;
            } else if (count != 0) {
                res++;
                count--;
            }
        }
        return res;
    }
}
```

---

**Runtime** 18 ms · **Memory** 47.6 MB

<sub>Synced by AILeetHub on 2026-03-28.</sub>
