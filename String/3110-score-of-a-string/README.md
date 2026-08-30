# 3110. Score of a String

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/score-of-a-string/)

`String`

## Intuition  
The score is the sum of absolute differences between every pair of consecutive characters.  
Because the ASCII value of a character can be obtained directly via `charAt`, the problem reduces to a single linear scan of the string.

## Approach  
1. Initialize `sum` to 0.  
2. Iterate from index `0` to `s.length() - 2`.  
3. For each position `i`, compute the absolute difference between `s.charAt(i)` and `s.charAt(i+1)` using `Math.abs`.  
4. Add this difference to `sum`.  
5. After the loop, return `sum`.  
The loop visits each adjacent pair exactly once, ensuring the correct total score.

## Complexity  
- **Time:** O(n) – one pass over the string of length *n*.  
- **Space:** O(1) – only a few integer variables are used, independent of input size.

## Solution (java)

```java
class Solution {
    public int scoreOfString(String s) {
      //ascii value->charAt(smtg) is the ascii value
    // int sum=0;
    //   for(int i=0;i<s.length()-1;i++){
    //     sum+=Math.abs(s.charAt(i) - s.charAt(i+1));
    //   }  
    //   return sum;










    int sum=0;

    for(int i=0;i<s.length()-1;i++){
        sum+=Math.abs(s.charAt(i)-s.charAt(i+1));
    }
    return sum;
    }
}
```

---

**Runtime** 1 ms · **Memory** 43.4 MB

<sub>Synced by AILeetHub on 2026-08-30.</sub>
