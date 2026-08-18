# 1143. Longest Common Subsequence

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/longest-common-subsequence/)

`String` · `Dynamic Programming` · `Longest Common Subsequence`

## Intuition  
The longest common subsequence (LCS) problem can be solved by building a table that records the best result for every pair of prefixes of the two strings.  
If the current characters match, the LCS length for those prefixes increases by one from the result of the previous prefixes.  
If they differ, the best we can do is to ignore one of the characters, so we take the maximum of the two possibilities: drop the character from the first string or drop it from the second.

## Approach  
Create a 2‑D array `dp` of size `(m+1) × (n+1)` where `m` and `n` are the lengths of `text1` and `text2`.  
Iterate `i` from 1 to `m` and `j` from 1 to `n`.  
* If `text1[i‑1] == text2[j‑1]`, set `dp[i][j] = dp[i‑1][j‑1] + 1`.  
* Otherwise, set `dp[i][j] = max(dp[i‑1][j], dp[i][j‑1])`.  
The answer is stored in `dp[m][n]`.

## Complexity  
- **Time:** O(m × n) – each of the `m × n` table cells is computed once.  
- **Space:** O(m × n) – the full DP table of that size is maintained.

## Solution (java)

```java
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]  + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
```

---

**Runtime** 19 ms · **Memory** 54 MB

<sub>Synced by AILeetHub on 2026-08-18.</sub>
