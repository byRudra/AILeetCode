# 3069. Distribute Elements Into Two Arrays I

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/distribute-elements-into-two-arrays-i/)

`Array` · `Simulation`

## Intuition  
The process is a deterministic simulation: at each step we decide which of the two growing arrays should receive the next number based solely on the last elements already placed. Because all numbers are distinct, the comparison is unambiguous and the decision never changes once made.

## Approach  
1. Create two auxiliary arrays `arr1` and `arr2` large enough to hold all `n` elements.  
2. Place the first element of `nums` into `arr1` and the second into `arr2`.  
3. For every remaining element `nums[k]` (k ≥ 2), compare the last inserted values:  
   * if `arr1[last] > arr2[last]`, append `nums[k]` to `arr1`;  
   * otherwise append it to `arr2`.  
4. After all elements are distributed, build the final result by copying the used portions of `arr1` followed by the used portions of `arr2`.  
The algorithm follows the exact rule set from the problem statement, ensuring the final concatenated array matches the required order.

## Complexity  
- **Time:** O(n) – one pass to distribute elements and another to concatenate, each linear in `n`.  
- **Space:** O(n) – auxiliary arrays `arr1`, `arr2`, and the output array each store at most `n` integers.

## Solution (Java)

```java
class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        int i = 0, j = 0;

        arr1[i++] = nums[0];
        arr2[j++] = nums[1];

        for (int k = 2; k < n; k++) {
            if (arr1[i - 1] > arr2[j - 1]) {
                arr1[i++] = nums[k];
            } else {
                arr2[j++] = nums[k];
            }
        }

        int[] result = new int[n];

        int index = 0;

        for (int x = 0; x < i; x++) {
            result[index++] = arr1[x];
        }

        for (int x = 0; x < j; x++) {
            result[index++] = arr2[x];
        }

        return result;
    }
}
```

---

**Runtime** 1 ms (beats 99.8%) · **Memory** 46.5 MB (beats 87.3%)

<sub>Synced by AILeetHub on 2026-09-04.</sub>
