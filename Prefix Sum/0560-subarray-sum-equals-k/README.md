# 560. Subarray Sum Equals K

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/subarray-sum-equals-k/)

`Array` · `Hash Table` · `Prefix Sum`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Hash Table, Prefix Sum.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumFrequency = new HashMap<>();
        prefixSumFrequency.put(0, 1);  // base case

        int prefixSum = 0;
        int subarrayCount = 0;

        for (int index = 0; index < nums.length; index++) {
            prefixSum += nums[index];

            int requiredPrefix = prefixSum - k;

            if (prefixSumFrequency.containsKey(requiredPrefix)) {
                subarrayCount += prefixSumFrequency.get(requiredPrefix);
            }

            prefixSumFrequency.put(
                prefixSum,
                prefixSumFrequency.getOrDefault(prefixSum, 0) + 1
            );
        }

        return subarrayCount;
    }
}
```

---

**Runtime** 24 ms · **Memory** 49.1 MB

<sub>Synced by AILeetHub on 2026-01-14.</sub>
