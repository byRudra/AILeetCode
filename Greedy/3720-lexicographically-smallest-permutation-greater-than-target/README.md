# 3720. Lexicographically Smallest Permutation Greater Than Target

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/lexicographically-smallest-permutation-greater-than-target/)

`Hash Table` · `String` · `Greedy` · `Counting` · `Enumeration`

## Intuition  
To obtain the lexicographically smallest string that is still greater than `target`, we should keep the prefix of the result identical to `target` as long as possible.  
At the first position where we can replace the target character by a larger one (using only the letters available in `s`), we pick the smallest such larger letter.  
After that replacement, the remaining letters can be arranged in ascending order to keep the overall string minimal.

## Approach  
1. Count the occurrences of each letter in `s` (`remaining[26]`).  
2. Scan `target` from left to right.  
   * For the current position `i`, look for the smallest letter `c` (`c > target[i]`) that still has a positive count in `remaining`.  
   * If found, record `i`, `c`, and clone the current `remaining` array (`bestRemaining`).  
   * If the exact target letter is unavailable, stop the scan – no further prefix can match.  
3. If no suitable position was found, return an empty string.  
4. Build the answer:  
   * Append `target[0…i-1]`.  
   * Append the chosen larger letter `c`.  
   * Decrement its count in `bestRemaining`.  
   * Append all remaining letters in alphabetical order using the counts in `bestRemaining`.  
5. Return the constructed string.

## Complexity  
- **Time:** O(n + 26 × n) → O(n) – a single pass over `target` with at most 26 checks per position, plus linear construction of the result.  
- **Space:** O(26) → O(1) – constant‑size arrays for letter counts and a clone of size 26.

## Solution (java)

```java
class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int remaining[] = new int[26];
        for(char ch : s.toCharArray()) remaining[ch - 'a']++;

        int bestI = -1, bestChar = -1;
        int [] bestRemaining = null;

        for(int i = 0; i < n; i++){
            int t = target.charAt(i) - 'a';
            for(int c = t + 1; c < 26; c++){
                if(remaining[c] > 0){
                    bestI = i;
                    bestChar = c;
                    bestRemaining = remaining.clone();
                    break;
                }
            }
            if(remaining[t] == 0) break;
            remaining[t]--;
        }

        if (bestI == -1) return "";

        StringBuilder result = new StringBuilder();
        result.append(target, 0, bestI);
        result.append((char)('a' + bestChar));
        bestRemaining[bestChar]--;
        for(int i = 0; i < 26; i++){
            for(int k = 0; k < bestRemaining[i]; k++){
                result.append((char)('a' + i));
            }
        }

        return result.toString();
    }
}
```

---

**Runtime** 2 ms · **Memory** 46.5 MB

<sub>Synced by AILeetHub on 2026-08-28.</sub>
