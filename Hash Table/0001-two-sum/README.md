# 1. Two Sum

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/two-sum/)

`Array` · `Hash Table`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Hash Table.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> needing = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int needingVal = target - nums[i];
            if (needing.containsKey(needingVal)) return new int[] {needing.get(needingVal), i};
            needing.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
```

---

**Runtime** 2 ms · **Memory** 46.9 MB

<sub>Synced by AILeetHub on 2026-05-06.</sub>
