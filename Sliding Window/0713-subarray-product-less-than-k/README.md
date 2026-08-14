# 713. Subarray Product Less Than K

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/subarray-product-less-than-k/)

`Array` · `Binary Search` · `Sliding Window` · `Prefix Sum`

## Intuition  
When the product of a contiguous subarray is below `k`, extending the subarray to the right can only increase the product. Therefore, for each right‑hand boundary we can keep a left boundary that guarantees the product stays below `k`. If the product becomes too large, we shrink the window from the left until it is valid again. Every time the window is valid, all subarrays that end at the current right index and start anywhere between the left and right indices are also valid.

## Approach  
1. If `k <= 1`, no subarray can satisfy the condition, return 0.  
2. Use two pointers: `start` (left boundary) and `end` (right boundary).  
3. Maintain `currProd`, the product of elements in the current window.  
4. For each `end` from 0 to `n‑1`:  
   - Multiply `currProd` by `nums[end]`.  
   - While `currProd >= k`, divide by `nums[start]` and increment `start` to shrink the window.  
   - After the window is valid, all subarrays ending at `end` and starting at indices `start … end` are valid, so add `end - start + 1` to the answer.  
5. Return the accumulated count.

## Complexity  
- **Time:** O(n) – each element is added to the product once and removed at most once.  
- **Space:** O(1) – only a few integer variables are used, independent of input size.

## Solution (java)

```java
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int count = 0;
        int start = 0;
        int currProd = 1;
        for (int end = 0; end < nums.length; end++) {
            currProd *= nums[end];
            while (currProd >= k) {
                currProd /= nums[start++];
            }
            count += end - start + 1;
        }
        return count;
    }
}
```

---

**Runtime** 2 ms · **Memory** 48.9 MB

<sub>Synced by AILeetHub on 2026-08-14.</sub>
