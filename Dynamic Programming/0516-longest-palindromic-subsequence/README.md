# 516. Longest Palindromic Subsequence

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/longest-palindromic-subsequence/)

`String` · `Dynamic Programming`

## Intuition  
The longest palindromic subsequence of a string is the longest sequence that reads the same forward and backward.  
If we reverse the original string, any subsequence that appears in both the original and its reverse must be a palindrome.  
Thus the problem reduces to finding the longest common subsequence (LCS) between the string and its reverse.

## Approach  
Let `rev` be the reverse of `s`.  
Create a 2‑D DP table `dp` where `dp[i][j]` stores the length of the LCS of the first `i` characters of `s` and the first `j` characters of `rev`.  
Initialize the table with zeros.  
Iterate `i` from 1 to `n` and `j` from 1 to `n`:

* If `s[i‑1] == rev[j‑1]`, the characters match and contribute to the LCS:  
  `dp[i][j] = dp[i‑1][j‑1] + 1`.
* Otherwise, the best LCS up to `(i, j)` comes from either dropping the current character of `s` or of `rev`:  
  `dp[i][j] = max(dp[i‑1][j], dp[i][j‑1])`.

After filling the table, `dp[n][n]` holds the length of the longest palindromic subsequence.

## Complexity  
- **Time:** O(n²) – each of the n² table cells is computed in constant time.  
- **Space:** O(n²) – the DP table of size (n+1)×(n+1) stores intermediate LCS lengths.

## Solution (java)

```java
class Solution {
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int dp[][] = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                   dp[i][j] =  Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }
}
```

---

**Runtime** 57 ms · **Memory** 63.8 MB

<sub>Synced by AILeetHub on 2026-08-18.</sub>
