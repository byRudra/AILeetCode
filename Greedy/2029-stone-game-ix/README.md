# 2029. Stone Game IX

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/stone-game-ix/)

`Array` · `Math` · `Greedy` · `Minimax` · `Counting` · `Game Theory` · `Nim Game` · `Zero-Sum Game`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Math, Greedy, Minimax, Counting, Game Theory, Nim Game, Zero-Sum Game.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public boolean stoneGameIX(int[] stones) {
        int keys[] = new int [3];
        for(int  i = 0; i < stones.length; i++)
            keys[stones[i] % 3]++;
        int c0 = keys[0];
        int c1 = keys[1];
        int c2 = keys[2];
        if(c0 % 2 == 0) return c1 > 0 && c2 > 0;

        return Math.abs(c1 - c2) > 2;

    }
}
```

---

**Runtime** 4 ms · **Memory** 114.6 MB

<sub>Synced by AILeetHub on 2026-08-16.</sub>
