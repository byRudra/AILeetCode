# 3761. Minimum Absolute Distance Between Mirror Pairs

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/)

`Array` · `Hash Table` · `Math`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Hash Table, Math.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    private int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + (num % 10);
            num /= 10;
        }
        return rev;
    }
    public int minMirrorPairDistance(int[] nums) {
        HashMap <Integer, Integer> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            int reversed = reverse(nums[i]);

            if(map.containsKey(nums[i])){
                minDistance = Math.min(minDistance, i - map.get(nums[i]));
            }
            map.put(reversed, i);
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}
```

---

**Runtime** 47 ms · **Memory** 95.4 MB

<sub>Synced by AILeetHub on 2026-04-21.</sub>
