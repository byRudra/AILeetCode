# 3741. Minimum Distance Between Three Equal Elements II

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/minimum-distance-between-three-equal-elements-ii/)

`Array` · `Hash Table`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Hash Table.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int minimumDistance(int[] nums) {
        if (nums.length < 3)
            return -1;
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int ans = Integer.MAX_VALUE;

        for (List<Integer> list : map.values()) {
            if (list.size() >= 3) {
                for (int i = 0; i + 2 < list.size(); i++) {
                    int current = 2 * (list.get(i + 2) - list.get(i));
                    ans = Math.min(current, ans);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
```

---

**Runtime** 102 ms · **Memory** 275.5 MB

<sub>Synced by AILeetHub on 2026-04-11.</sub>
