# 921. Minimum Add to Make Parentheses Valid

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/)

`String` · `Stack` · `Greedy` · `Bracket Sequences`

## Approach

Accepted medium solution in java.
Relevant topics: String, Stack, Greedy, Bracket Sequences.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int minAddToMakeValid(String s) {
        int opening = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                opening++;
            } 
            else {
                if (opening > 0) {
                    opening--;
                } 
                else {
                    ans++;
                }
            }
        }

        return ans + opening;
    }
}
```

---

**Runtime** 0 ms · **Memory** 43 MB

<sub>Synced by AILeetHub on 2026-08-18.</sub>
