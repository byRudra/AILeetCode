# 268. Missing Number

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/missing-number/)

`Array` · `Hash Table` · `Math` · `Binary Search` · `Bit Manipulation` · `Sorting`

## Intuition  
The numbers 0 through n form an arithmetic sequence whose sum is known:  
\(S = n(n+1)/2\).  
If one element is missing, the sum of the given array will be \(S - \text{missing}\).  
Thus the missing number can be recovered by subtracting the actual sum from the expected sum.

## Approach  
1. Determine \(n\) as the length of the input array.  
2. Compute the expected sum \(S = n(n+1)/2\).  
3. Iterate once over the array, accumulating the current sum.  
4. Return \(S - \text{currentSum}\), which equals the missing number.

The algorithm uses a single pass over the data and only a handful of integer variables, so it satisfies the O(1) extra space requirement.

## Complexity  
- **Time:** O(n) – one linear scan to sum the elements.  
- **Space:** O(1) – only a constant number of integer variables are used.

## Solution (java)

```java
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int currentSum = 0;
        for(int num : nums) currentSum += num;
        return expectedSum - currentSum;
    }
}

```

---

**Runtime** 0 ms · **Memory** 47.3 MB

<sub>Synced by AILeetHub on 2026-05-04.</sub>
