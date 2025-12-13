# 1518. Water Bottles

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/water-bottles/)

`Math` · `Simulation`

## Intuition
Each full bottle you drink becomes an empty one. When you have enough empties, you can trade them for a new full bottle. The key observation is that the process can be simulated by repeatedly exchanging as many full bottles as possible, keeping the leftover empties for the next round. The total number of drinks is the sum of the initial bottles plus every new bottle obtained through exchanges.

## Approach
Start with `total = numBottles`. While the current number of bottles (`numBottles`) is at least `numExchange`, split it into `quot = numBottles / numExchange` new bottles and `remainder = numBottles % numExchange` leftover empties.  
Add `quot` to `total` (these are the newly obtained drinks).  
The next round’s bottle count becomes `quot + remainder` (the new full bottles plus the leftover empties).  
Repeat until fewer than `numExchange` bottles remain; at that point no more exchanges are possible. Return `total`.

## Complexity
- **Time:** O(log₍numExchange₎(numBottles)) – each loop reduces the bottle count by a factor of `numExchange`, so the number of iterations grows logarithmically with the initial count.  
- **Space:** O(1) – only a few integer variables are used regardless of input size.

## Solution (java)

```java
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int init = numBottles;
        int quot, remainder;
        while(numBottles > numExchange - 1){
            quot = numBottles / numExchange;
            remainder = numBottles % numExchange;
            numBottles = quot + remainder;
            init += quot;
        }
        return init;
    }
}
```

---

**Runtime** 0 ms · **Memory** 42.2 MB

<sub>Synced by AILeetHub on 2025-12-13.</sub>
