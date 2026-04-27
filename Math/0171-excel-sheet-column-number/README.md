# 171. Excel Sheet Column Number

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/excel-sheet-column-number/)

`Math` · `String`

## Intuition
Excel column titles behave like a base‑26 numeral system, but the digits start at 1 instead of 0.  
Thus “A” is 1, “B” is 2, … “Z” is 26, “AA” is 27, etc.  
The task is to convert this mixed‑radix representation into its decimal value.

## Approach
1. Initialize `result` to 0.  
2. Iterate over each character `ch` of the input string from left to right.  
3. Convert `ch` to its numeric value: `current = ch - 'A' + 1`.  
4. Update the accumulated number: `result = result * 26 + current`.  
5. After processing all characters, return `result`.

This mirrors the standard conversion from a positional numeral system: each new digit shifts the previous value left by one base (multiply by 26) and adds the new digit’s value.

## Complexity
- **Time:** O(n) – one pass over the string of length *n*.  
- **Space:** O(1) – only a few integer variables are used regardless of input size.

## Solution (java)

```java
class Solution {
    public int titleToNumber(String columnTitle) {
       int result = 0;

       for(char ch : columnTitle.toCharArray()){
        int current = ch - 'A' + 1;
        result = result*26 + current;
       }
       return result; 
    }
}
```

---

**Runtime** 1 ms · **Memory** 43.8 MB

<sub>Synced by AILeetHub on 2026-04-27.</sub>
