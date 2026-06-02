# 3633. Earliest Finish Time for Land and Water Rides I

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-i/)

`Array` · `Two Pointers` · `Binary Search` · `Greedy` · `Sorting`

## Approach

Accepted easy solution in java.
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

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {

                // Land -> Water
                int landFinish = landStartTime[i] + landDuration[i];
                int finish1 = Math.max(landFinish, waterStartTime[j])
                                + waterDuration[j];

                // Water -> Land
                int waterFinish = waterStartTime[j] + waterDuration[j];
                int finish2 = Math.max(waterFinish, landStartTime[i])
                                + landDuration[i];

                ans = Math.min(ans, Math.min(finish1, finish2));
            }
        }

        return ans;
    }
}
```

---

**Runtime** 3 ms · **Memory** 46.9 MB

<sub>Synced by AILeetHub on 2026-06-02.</sub>
