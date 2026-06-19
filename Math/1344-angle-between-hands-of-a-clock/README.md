# 1344. Angle Between Hands of a Clock

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/angle-between-hands-of-a-clock/)

`Math`

## Approach

Accepted medium solution in java.
Relevant topics: Math.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public double angleClock(int hour, int minutes) {
        hour %= 12;
        double hourAngle = hour * 30 + minutes * 0.5;
        double minuteAngle = minutes * 6;

        double diff = Math.abs(hourAngle - minuteAngle);
        return Math.min(diff, 360 - diff);
    }
}
```

---

**Runtime** 0 ms · **Memory** 45.1 MB

<sub>Synced by AILeetHub on 2026-06-19.</sub>
