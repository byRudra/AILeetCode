# 2839. Check if Strings Can be Made Equal With Operations I

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i/)

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
    public boolean canBeEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] even = new int[26];
        int[] odd = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                even[s1.charAt(i) - 'a']++;
                even[s2.charAt(i) - 'a']--;
            } else {
                odd[s1.charAt(i) - 'a']++;
                odd[s2.charAt(i) - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (even[i] != 0 || odd[i] != 0) return false;
        }

        return true;
    }
}
```

---

**Runtime** 1 ms · **Memory** 44.1 MB

<sub>Synced by AILeetHub on 2026-03-29.</sub>
