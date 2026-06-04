# 3635. Earliest Finish Time for Land and Water Rides II

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-ii/)

`Array` · `Two Pointers` · `Binary Search` · `Greedy` · `Sorting`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Two Pointers, Binary Search, Greedy, Sorting.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int earliestFinishTime(
            int[] landStartTime,
            int[] landDuration,
            int[] waterStartTime,
            int[] waterDuration) {


        int minLandFinish = Integer.MAX_VALUE;
        int minWaterFinish = Integer.MAX_VALUE;

        for(int i = 0; i < landStartTime.length; i++){
            minLandFinish = Math.min(minLandFinish, landStartTime[i] + landDuration[i]);
        }

        for(int i = 0; i < waterStartTime.length; i++){
            minWaterFinish = Math.min(minWaterFinish, waterStartTime[i] + waterDuration[i]);
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < waterStartTime.length; i++){
             int startWater =
                (minLandFinish <= waterStartTime[i])
                ? waterStartTime[i]
                : minLandFinish;

            ans = Math.min(ans, startWater + waterDuration[i]);
        }

        for(int i = 0; i < landStartTime.length; i++){
             int startLand =
                (minWaterFinish <= landStartTime[i])
                ? landStartTime[i]
                : minWaterFinish;

            ans = Math.min(ans, startLand + landDuration[i]);
        }
        return ans;
    }
}
```

---

**Runtime** 3 ms · **Memory** 92 MB

<sub>Synced by AILeetHub on 2026-06-04.</sub>
