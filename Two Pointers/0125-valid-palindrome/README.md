# 125. Valid Palindrome

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/valid-palindrome/)

`Two Pointers` · `String`

## Approach

Accepted easy solution in java.
Relevant topics: Two Pointers, String.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while(start <= end){
             while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }

            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
             if (Character.toLowerCase(s.charAt(start)) != 
                Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--; 
        }
        return true;
    }
}
```

---

**Runtime** 2 ms · **Memory** 44.3 MB

<sub>Synced by AILeetHub on 2026-08-28.</sub>
