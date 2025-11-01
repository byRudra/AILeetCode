# 1854. Maximum Population Year

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/maximum-population-year/)

`Array` · `Counting` · `Prefix Sum`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Counting, Prefix Sum.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] population = new int[101];

        for (int [] year: logs){
            population[year[0] - 1950]++;
            population[year[1] - 1950]--;
        }
        
        // Calculating max population
        int maxPop = 0, curPop = 0, curYear = 1950;

        for(int i = 0; i < 101; i++){
            curPop += population[i];

            if (curPop > maxPop) {
                maxPop = curPop;
                curYear = 1950 + i;
            }
        }
        return curYear;

    }
}
```

---

**Runtime** 0 ms · **Memory** 43.1 MB

<sub>Synced by AILeetHub on 2025-11-01.</sub>
