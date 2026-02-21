# 3379. Transformed Array

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/transformed-array/)

`Array` · `Simulation`

## Intuition  
The array is circular, so moving a positive number of steps to the right or a negative number of steps to the left is equivalent to adding the step count to the current index and wrapping around the array.  
The target index for position `i` can be found with a single modular arithmetic expression that naturally handles both positive and negative displacements.

## Approach  
For each index `i` in `nums`:
1. Compute the raw destination index as `i + nums[i]`.  
2. Normalize it to the valid range `[0, n-1]` (where `n` is the array length) by applying  
   `((i + nums[i]) % n + n) % n`.  
   The first modulo may produce a negative result; adding `n` and taking modulo again guarantees a non‑negative index.  
3. Set `ans[i]` to the value at this normalized index in the original array.  
The loop runs once per element, producing the transformed array in linear time.

## Complexity  
- **Time:** O(n) – each element is processed once with constant‑time arithmetic.  
- **Space:** O(1) – aside from the output array, no additional data structures are used.

## Solution (java)

```java
class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int ans[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            ans[i] = nums[((i + nums[i]) % nums.length + nums.length) % nums.length];
        }
        return ans;
    }
}
```

---

**Runtime** 1 ms · **Memory** 46.8 MB

<sub>Synced by AILeetHub on 2026-02-21.</sub>
