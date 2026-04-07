# 657. Robot Return to Origin

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/robot-return-to-origin/)

`String` · `Simulation`

## Approach

Accepted easy solution in python.
Relevant topics: String, Simulation.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (python)

```python
class Solution(object):
    def judgeCircle(self, moves):
        """
        :type moves: str
        :rtype: bool
        """
        xresult = 0
        yresult = 0
        for move in moves:
            if move == 'U':
                xresult += 1
            elif move == 'D':
                xresult -= 1
            elif move == 'L':
                yresult -= 1
            elif move == 'R':
                yresult += 1
        return xresult == 0 and yresult == 0
        
```

---

**Runtime** 35 ms · **Memory** 12.5 MB

<sub>Synced by AILeetHub on 2026-04-07.</sub>
