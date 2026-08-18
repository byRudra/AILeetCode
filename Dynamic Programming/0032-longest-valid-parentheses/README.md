# 32. Longest Valid Parentheses

![Hard](https://img.shields.io/badge/Difficulty-Hard-ff375f?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/longest-valid-parentheses/)

`String` · `Dynamic Programming` · `Stack` · `Bracket Sequences`

## Intuition
The longest valid parentheses substring can be found by scanning the string while keeping a balance between opening and closing brackets. A valid substring must contain an equal number of '(' and ')', and the count of closing brackets should never exceed the count of opening brackets when scanning from left to right. However, a string may start with more '(' than ')', so a single left‑to‑right scan misses valid substrings that are balanced only when considered from the right side. Performing a second scan from right to left corrects this asymmetry.

## Approach
The algorithm performs two linear passes:

1. **Left‑to‑Right Scan**  
   - Maintain counters `left` and `right`.  
   - Increment `left` on '(' and `right` on ')'.  
   - When `left == right`, a balanced substring ends at the current index; update `max` with `2 * left`.  
   - If `right > left`, the current prefix cannot be part of a valid substring; reset both counters to zero.

2. **Right‑to‑Left Scan**  
   - Reset `left` and `right`.  
   - Iterate from the end of the string, incrementing counters in the same way.  
   - When `left == right`, update `max`.  
   - If `left > right`, reset counters because an excess of '(' cannot be matched to the right.

The maximum length found across both scans is returned.

## Complexity
- **Time:** O(n) – each character is examined twice, once in each scan.  
- **Space:** O(1) – only a few integer counters are used, independent of input size.

## Solution (java)

```java
class Solution {
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;
            if (left == right)
                max = Math.max(max, left * 2);
            else if (right > left) {
                right = 0;
                left = 0;
            }
        }

        left = 0;
        right = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if (s.charAt(i) == '(')
                left++;
            else
                right++;
            if (left == right)
                max = Math.max(max, left * 2);
            else if (left > right) {
                right = 0;
                left = 0;
            }
        }
        return max;
    }
}
```

---

**Runtime** 2 ms · **Memory** 44.4 MB

<sub>Synced by AILeetHub on 2026-08-18.</sub>
