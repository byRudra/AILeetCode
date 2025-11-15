# 134. Gas Station

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/gas-station/)

`Array` · `Greedy`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Greedy.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, start = 0, tank = 0;

        for(int i = 0; i < gas.length; i++){
            int diff = gas[i] - cost[i];

            tank += diff;
            total += diff;

            if(tank < 0){
                start = i + 1;
                tank = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
}
```

---

**Runtime** 3 ms · **Memory** 119.3 MB

<sub>Synced by AILeetHub on 2025-11-15.</sub>
