# 344. Reverse String

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/reverse-string/)

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
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while(left < right){
          char temp = s[left];
          s[left] = s[right];  
          s[right] =temp;
          left++;
          right--;  
        } 
    }
}
```

---

**Runtime** 0 ms · **Memory** 47.6 MB

<sub>Synced by AILeetHub on 2026-05-03.</sub>
