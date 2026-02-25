# 561. Array Partition

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/array-partition/)

`Array` · `Greedy` · `Sorting` · `Counting Sort`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Greedy, Sorting, Counting Sort.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;

        for(int i = 0; i < n; i+=2){
            res += nums[i];
        }
        return res;
        
    }
}
```

---

**Runtime** 17 ms · **Memory** 49.6 MB

<sub>Synced by AILeetHub on 2026-02-25.</sub>
