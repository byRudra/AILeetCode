# 303. Range Sum Query - Immutable

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/range-sum-query-immutable/)

`Array` · `Design` · `Prefix Sum`

## Intuition
To answer many range‑sum queries quickly, we pre‑compute cumulative sums of the array.  
With a prefix sum array `prefix`, the sum of any subarray `[left, right]` can be obtained by a single subtraction:  
`prefix[right+1] - prefix[left]`.  
This eliminates the need to iterate over the queried segment each time.

## Approach
1. **Construction** – Create an integer array `prefix` of length `nums.length + 1`.  
   Set `prefix[0] = 0`.  
   For each index `i` in `nums`, compute `prefix[i+1] = prefix[i] + nums[i]`.  
   This stores the sum of the first `i` elements at position `i+1`.

2. **Query** – For `sumRange(left, right)`, return `prefix[right+1] - prefix[left]`.  
   The subtraction removes the sum of elements before `left`, leaving exactly the desired range.

The constructor runs once, and each query is answered in constant time.

## Complexity
- **Time:** O(n) to build the prefix array, O(1) per `sumRange` call.  
- **Space:** O(n) to store the prefix sums, where n is the length of `nums`.

## Solution (java)

```java
class NumArray {
    private int prefix[];

    public NumArray(int[] nums) {
        prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
```

---

**Runtime** 8 ms · **Memory** 47.5 MB

<sub>Synced by AILeetHub on 2026-09-03.</sub>
