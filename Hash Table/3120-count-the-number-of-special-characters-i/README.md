# 3120. Count the Number of Special Characters I

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/count-the-number-of-special-characters-i/)

`Hash Table` · `String`

## Intuition  
A letter is “special” when both its lowercase and uppercase forms appear in the string.  
Because there are only 26 English letters, we can represent the presence of each case with a single bit in a 32‑bit integer.  
If a bit is set in the *lower* mask, the letter has appeared in lowercase; if it is set in the *upper* mask, it has appeared in uppercase.  
The intersection of these masks (bitwise AND) leaves a bit set only for letters that have appeared in both cases.  
Counting the set bits of this intersection gives the answer.

## Approach  
1. Initialize two 32‑bit integers, `lower` and `upper`, to zero.  
2. Iterate over every character `ch` in the input string.  
   * If `ch` is lowercase, set the bit corresponding to `ch - 'a'` in `lower`.  
   * Otherwise set the same bit in `upper`.  
3. Compute `countMask = lower & upper`; this mask has a 1 for each special letter.  
4. Return `Integer.bitCount(countMask)`, which counts the number of set bits.

## Complexity  
- **Time:** O(n) – each of the n characters is processed once.  
- **Space:** O(1) – only a fixed number of integer variables are used, independent of input size.

## Solution (java)

```java
class Solution {
    public int numberOfSpecialChars(String word) {
        int lower = 0;
        int upper = 0;
        for(char ch : word.toCharArray()){
            if(Character.isLowerCase(ch)){
                lower |= (1 << (ch - 'a'));
            }
            else{
                upper |= (1 << (ch - 'a'));
            }
        }
        int count = lower & upper;
        return Integer.bitCount(count);
    }
}
```

---

**Runtime** 1 ms · **Memory** 43.5 MB

<sub>Synced by AILeetHub on 2026-05-26.</sub>
