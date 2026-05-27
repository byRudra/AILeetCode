# 520. Detect Capital

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/detect-capital/)

`String`

## Intuition
The rule for a correct capital usage can be expressed purely in terms of how many letters are uppercase.  
- If every letter is uppercase, the word is valid.  
- If no letter is uppercase, the word is also valid.  
- If exactly one letter is uppercase, it must be the first character.  
Any other distribution of uppercase letters violates the rule.

## Approach
Iterate through the characters of the input string once, counting how many are uppercase.  
After the loop, three conditions are checked:
1. `countCapital == word.length()` – all letters are uppercase.  
2. `countCapital == 0` – all letters are lowercase.  
3. `countCapital == 1 && Character.isUpperCase(word.charAt(0))` – only the first letter is uppercase.  
If any of these holds, the function returns `true`; otherwise it returns `false`.  
This directly implements the logical definition of correct capital usage without any auxiliary data structures.

## Complexity
- **Time:** O(n) – a single pass over the string of length *n* to count uppercase letters.  
- **Space:** O(1) – only a few integer variables are used, independent of input size.

## Solution (java)

```java
class Solution {
    public boolean detectCapitalUse(String word) {
        int countCapital = 0;
        for(char ch : word.toCharArray()) {
            if(Character.isUpperCase(ch)) countCapital++;
        }
        return (countCapital == word.length()) || (countCapital == 1 && Character.isUpperCase(word.charAt(0))) || (countCapital == 0);
    }
}
```

---

**Runtime** 1 ms · **Memory** 43.1 MB

<sub>Synced by AILeetHub on 2026-05-27.</sub>
