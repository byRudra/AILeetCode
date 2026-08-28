# 242. Valid Anagram

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/valid-anagram/)

`Hash Table` · `String` · `Sorting`

## Intuition  
An anagram contains exactly the same characters as the original string, just reordered.  
If we can count how many times each letter appears in both strings and confirm the counts match, the strings are anagrams.  
Because the input is limited to lowercase English letters, a fixed‑size array of 26 integers suffices to store these counts.

## Approach  
1. Create an integer array `cnt[26]`.  
2. Iterate over `s`, incrementing `cnt[ch - 'a']` for each character `ch`.  
3. Iterate over `t`. For each `ch`, if `cnt[ch - 'a']` is already zero, `t` contains an extra character → return `false`.  
   Otherwise decrement `cnt[ch - 'a']`.  
4. After processing both strings, if their lengths differ, return `false`; otherwise all counts have been matched and return `true`.  

The algorithm ensures that each character in `t` consumes a corresponding occurrence counted from `s`. Any mismatch or length discrepancy causes an immediate rejection.

## Complexity  
- **Time:** O(n) – each string is scanned once, where *n* is the length of the longer string.  
- **Space:** O(1) – the 26‑element array is a fixed constant, independent of input size.

## Solution (java)

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        int array[] = new int[26];
        for (char ch : s.toCharArray()) {
            array[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            if (array[ch - 'a'] == 0)
                return false;
            array[ch - 'a']--;
        }
        if (s.length() == t.length())
            return true;
        return false;
    }
}
```

---

**Runtime** 2 ms · **Memory** 44.8 MB

<sub>Synced by AILeetHub on 2026-08-28.</sub>
