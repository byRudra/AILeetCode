# 14. Longest Common Prefix

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/longest-common-prefix/)

`Array` · `String` · `Trie`

## Intuition  
The longest common prefix must be a prefix of the first string in the array.  
If any character at a given position differs among the strings or one string ends, the common prefix cannot extend past that point.  
Thus, we can scan the first string character by character and stop as soon as a mismatch or a string boundary is encountered.

## Approach  
1. Handle the trivial case where the input array is empty or null, returning an empty string.  
2. Iterate over each index `i` of the first string.  
3. For each `i`, record the character `c` from the first string.  
4. Compare `c` with the character at the same index in every other string.  
   * If the current string’s length equals `i`, the prefix ends at `i`.  
   * If the characters differ, the prefix ends at `i`.  
5. When a mismatch or boundary is found, return the substring of the first string from `0` to `i`.  
6. If the loop completes, the entire first string is common to all, so return it.

## Complexity  
- **Time:** O(n · m) – in the worst case we compare every character of each string until the end of the shortest string.  
- **Space:** O(1) – only a few variables are used; the result is a substring of the input.

## Solution (java)

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(i == strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
```

---

**Runtime** 1 ms · **Memory** 41.4 MB

<sub>Synced by AILeetHub on 2025-08-27.</sub>
