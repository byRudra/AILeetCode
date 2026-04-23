# 387. First Unique Character in a String

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/first-unique-character-in-a-string/)

`Hash Table` · `String` · `Queue` · `Counting`

## Approach

Accepted easy solution in java.
Relevant topics: Hash Table, String, Queue, Counting.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int firstUniqChar(String s) {
        
        int charArray[] = new int[26];

        for(char ch : s.toCharArray()){
            charArray[ch - 'a']++; 
        }

        for(int i = 0; i < s.length(); i++){
           if (charArray[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
```

---

**Runtime** 6 ms · **Memory** 46.8 MB

<sub>Synced by AILeetHub on 2026-04-23.</sub>
