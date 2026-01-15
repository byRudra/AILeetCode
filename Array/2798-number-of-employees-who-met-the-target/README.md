# 2798. Number of Employees Who Met the Target

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/number-of-employees-who-met-the-target/)

`Array`

## Intuition
The task is to count how many employees have worked at least a given number of hours. Since the input array is small (≤ 50 elements) and each element can be inspected independently, a single linear scan suffices.

## Approach
Iterate over the `hours` array once. For each element `hour`, compare it with `target`. If `hour` is greater than or equal to `target`, increment a counter. After the loop, return the counter as the number of employees meeting the requirement. This straightforward method avoids any additional data structures or sorting, directly reflecting the problem’s requirement.

## Complexity
- **Time:** O(n) – one pass through the `n` elements of `hours`.  
- **Space:** O(1) – only a constant‑size counter is used, regardless of input size.

## Solution (java)

```java
class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;
        for(int hour : hours){
            if (hour >= target) count ++;
        }
        return count;
    }
}
```

---

**Runtime** 0 ms · **Memory** 44.5 MB

<sub>Synced by AILeetHub on 2026-01-15.</sub>
