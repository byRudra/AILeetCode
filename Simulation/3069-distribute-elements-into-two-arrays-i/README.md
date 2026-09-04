# 3069. Distribute Elements Into Two Arrays I

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/distribute-elements-into-two-arrays-i/)

`Array` · `Simulation`

## Approach

Accepted easy solution in Java.
Relevant topics: Array, Simulation.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

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

**Runtime** 1 ms (beats 99.8%) · **Memory** 46.7 MB (beats 36.8%)

<sub>Synced by AILeetHub on 2026-09-04.</sub>
