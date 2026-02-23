# 3640. Trionic Array II

![Hard](https://img.shields.io/badge/Difficulty-Hard-ff375f?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/trionic-array-ii/)

`Array` · `Dynamic Programming`

## Approach

Accepted hard solution in java.
Relevant topics: Array, Dynamic Programming.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {

    public long maxSumTrionic(int[] nums) {

        int n = nums.length;
        long maxTotal = Long.MIN_VALUE;

        for (int start = 0; start < n; start++) {
            int idx = start + 1;
            long total = 0;

            // First Increase
            while (idx < n && nums[idx - 1] < nums[idx])
                idx++;

            int peakIndex = idx - 1;

            // checking progress
            if (peakIndex == start)
                continue;

            total += nums[peakIndex] + nums[peakIndex - 1];

            // Decrease Segment
            while (idx < n && nums[idx - 1] > nums[idx]) {
                total += nums[idx];
                idx++;
            }

            int valleyIndex = idx - 1;

            // invalid trionic structure
            if (valleyIndex == peakIndex ||
                valleyIndex == n - 1 ||
                (idx < n && nums[idx] <= nums[valleyIndex])) {

                start = valleyIndex;
                continue;
            }

             total += nums[valleyIndex + 1];

            // best extra contribution from third segment
            long bestRightExtra = 0;
            long runningRight = 0;

            for (int k = valleyIndex + 2;
                 k < n && nums[k] > nums[k - 1];
                 k++) {

                runningRight += nums[k];
                bestRightExtra = Math.max(bestRightExtra, runningRight);
            }

            total += bestRightExtra;

            long bestLeftExtra = 0;
            long runningLeft = 0;

            for (int k = peakIndex - 2; k >= start; k--) {
                runningLeft += nums[k];
                bestLeftExtra = Math.max(bestLeftExtra, runningLeft);
            }

            total += bestLeftExtra;

            // ===== UPDATE ANSWER =====
            maxTotal = Math.max(maxTotal, total);

            // skip processed region
            start = valleyIndex - 1;

        }

        return maxTotal;
    }
}
```

---

**Runtime** 4 ms · **Memory** 95.2 MB

<sub>Synced by AILeetHub on 2026-02-23.</sub>
