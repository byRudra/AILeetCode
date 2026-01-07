# 1903. Largest Odd Number in String

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/largest-odd-number-in-string/)

`Math` · `String` · `Greedy`

## Intuition
The largest odd number that can be formed as a contiguous substring is simply the longest prefix of the original string that ends with an odd digit.  
If the last digit of the whole string is odd, the entire string is already the answer.  
Otherwise, we must cut the string just before the first odd digit encountered when scanning from the right.  
Any longer substring would either be empty or end with an even digit, making it non‑odd.

## Approach
Traverse the string from the last character toward the first.  
For each character, check whether it is odd by testing its numeric value (`digit % 2 == 1`).  
As soon as an odd digit is found, return the substring from the start up to and including that position (`num.substring(0, i + 1)`).  
If the loop finishes without finding an odd digit, return an empty string, indicating no odd substring exists.

This greedy strategy guarantees the returned substring is the longest possible odd number because we stop at the rightmost odd digit, ensuring no longer odd substring can exist.

## Complexity
- **Time:** O(n) – a single pass over the string of length *n*.  
- **Space:** O(1) – only a few integer variables are used; the output string is part of the input’s storage.

## Solution (java)

```java
class Solution {
    public String largestOddNumber(String num) {

        for(int i = num.length() - 1; i >= 0; i--){
            int currDigit = num.charAt(i) - '0';
            if(((int)num.charAt(i)) % 2 == 1){
                return num.substring(0, i + 1);
            }
        } 
        return "";
    }
}
```

---

**Runtime** 1 ms · **Memory** 47.1 MB

<sub>Synced by AILeetHub on 2026-01-07.</sub>
