# 1092. Shortest Common Supersequence 

![Hard](https://img.shields.io/badge/Difficulty-Hard-ff375f?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/shortest-common-supersequence/)

`String` · `Dynamic Programming` · `Longest Common Subsequence`

## Approach

Accepted hard solution in java.
Relevant topics: String, Dynamic Programming, Longest Common Subsequence.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        // building LCS
        int dp[][] = new int[n+1][m+1];
        for(int i = 1; i <=n; i++){
            for(int j = 1; j <= m; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // Building SCS string

        StringBuilder scs = new StringBuilder();
        int i = n, j = m;
        while(i > 0 && j > 0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                scs.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if (dp[i-1][j] > dp[i][j-1]){
                scs.append(str1.charAt(i-1));
                i--;
            }
            else{
                scs.append(str2.charAt(j-1));
                j--;
            }
        }
        while(i > 0){
            scs.append(str1.charAt(i-1));
            i--;
        }

        while(j > 0){
            scs.append(str2.charAt(j-1));
            j--;
        }
        return scs.reverse().toString();
    }
}
```

---

**Runtime** 23 ms · **Memory** 54 MB

<sub>Synced by AILeetHub on 2026-04-16.</sub>
