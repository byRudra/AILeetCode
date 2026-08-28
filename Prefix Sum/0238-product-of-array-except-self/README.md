# 238. Product of Array Except Self

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/product-of-array-except-self/)

`Array` · `Prefix Sum`

## Intuition
We need each position to hold the product of all elements except the one at that index. The product of a prefix and a suffix can be computed independently; multiplying them gives the desired value. By traversing the array twice we can accumulate these prefix and suffix products without division.

## Approach
1. Create an array `result` of the same length.  
2. First pass (left to right): set `result[0] = 1`. For each `i > 0`, set `result[i] = result[i‑1] * nums[i‑1]`. After this pass `result[i]` holds the product of all elements to the left of `i`.  
3. Second pass (right to left): keep a running product `rightProd = 1`. For each index `j` from the end to the start, multiply `result[j]` by `rightProd` (the product of all elements to the right of `j`) and then update `rightProd *= nums[j]`.  
4. Return `result`.

The two passes together give `result[i] = (product of left side) * (product of right side)` for every index.

## Complexity
- **Time:** O(n) – two linear scans over the array.  
- **Space:** O(1) – only a few scalar variables besides the output array, which is not counted as extra space.

## Solution (java)

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int result[] = new int [nums.length];

        result[0] = 1;

        for(int i = 1; i < nums.length; i++){
            result[i] = result[i - 1] * nums[i - 1];
        }

        int rightProd = 1;

        for(int j = nums.length - 1; j >= 0; j--){
            result[j] *= rightProd;
            rightProd *=  nums[j]; 
        }
        return result;
    }
}
```

---

**Runtime** 2 ms · **Memory** 72.3 MB

<sub>Synced by AILeetHub on 2026-08-28.</sub>
