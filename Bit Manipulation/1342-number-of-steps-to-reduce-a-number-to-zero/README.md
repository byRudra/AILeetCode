# 1342. Number of Steps to Reduce a Number to Zero

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/)

`Math` · `Bit Manipulation`

## Approach

Accepted easy solution in java.
Relevant topics: Math, Bit Manipulation.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int numberOfSteps(int num) {
        int steps = 0;
        while(num > 0){
            while(num % 2 == 0){
                num /= 2;
                steps++;
            }
            if(num == 0) return steps;
            num -= 1;
            steps++;
        }
        return steps;
    }
}
```

---

**Runtime** 0 ms · **Memory** 42.3 MB

<sub>Synced by AILeetHub on 2026-09-02.</sub>
