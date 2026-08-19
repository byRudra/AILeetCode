# 416. Partition Equal Subset Sum

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/partition-equal-subset-sum/)

`Array` · `Dynamic Programming` · `Knapsack Problem` · `0-1 Knapsack`

## Intuition
The problem reduces to finding a subset of the array whose sum equals half of the total sum.  
If the total sum is odd, such a partition is impossible.  
Otherwise, we need to determine whether a subset sum of `target = total/2` can be formed.

## Approach
1. Compute the total sum of all elements.  
2. If `total` is odd, return `false`.  
3. If any single element equals `target`, return `true`.  
4. Create a 2‑D boolean DP table `dp[n+1][target+1]` where `dp[i][j]` indicates whether a sum `j` can be achieved using the first `i` numbers.  
5. Initialize `dp[0][0] = true`.  
6. For each element `i` (1‑based) and each possible sum `j` (1‑to‑target):  
   - Set `dp[i][j]` to `dp[i‑1][j]` (exclude current element).  
   - If `nums[i‑1] ≤ j`, also consider including it: `dp[i][j] |= dp[i‑1][j‑nums[i‑1]]`.  
7. The answer is `dp[n][target]`.

## Complexity
- **Time:** O(n × target) – each of the `n` elements is processed for every sum up to `target`.  
- **Space:** O(n × target) – the DP table stores a boolean for each pair of `(i, j)`.

## Solution (java)

```java
class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum =0;
        for(int num : nums)
            totalSum += num;
        if(totalSum % 2 != 0) return false;
        int target = totalSum/2;
        for(int num : nums)
            if(target == num) return true;
        int n = nums.length;
        boolean dp[][] = new boolean[n + 1][target + 1];
        dp[0][0] = true;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= target; j++){
                dp[i][j] = dp[i-1][j];
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i][j] || dp[i-1][j - nums[i-1]];
                }
            }
        }
        return dp[n][target];
        
    }
}
```

---

**Runtime** 67 ms · **Memory** 47.5 MB

<sub>Synced by AILeetHub on 2026-08-19.</sub>
