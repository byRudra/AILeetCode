# 875. Koko Eating Bananas

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/koko-eating-bananas/)

`Array` · `Binary Search`

## Intuition
The required eating speed is monotonic: a larger speed never increases the time needed, while a smaller speed never decreases it.  
Thus the answer lies between 1 and the size of the largest pile.  
Binary searching this interval gives the minimal speed that satisfies the hour constraint.

## Approach
1. **Bounds** – `low = 1`, `high = max(piles)`.  
2. **Binary search loop** – While `low <= high`:
   * `mid = low + (high - low) / 2` is a candidate speed.
   * Compute the total hours needed at this speed: for each pile `p`, the hours contributed are  
     `ceil(p / mid) = (p + mid - 1) / mid`.  
     Accumulate these into `hours`.
   * If `hours <= h`, the speed is sufficient; try a smaller one: `high = mid - 1`.  
   * Otherwise the speed is too slow: `low = mid + 1`.
3. When the loop ends, `low` is the smallest speed that allows finishing within `h` hours.

The algorithm uses only integer arithmetic and a single pass over the piles per binary‑search iteration.

## Complexity
- **Time:** O(n log M) – `n` piles, `M` = maximum pile size; each iteration scans all piles and the binary search runs `log M` times.  
- **Space:** O(1) – only a few integer variables are maintained.

## Solution (java)

```java
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
      int low = 1, high = 0;
      for(int pile : piles){
        high = Math.max(pile, high);
      } 
      while(low <= high){
        int mid = low + (high - low) / 2;
        long hours = 0;

        for(int p : piles){
            hours += (p + mid - 1) / mid;
        } 
        if(hours <= h){ // ok speed can be improved
            high = mid - 1;
        }
        else{
            low = mid + 1;
        }
      }
      return low;
    }
}
```

---

**Runtime** 8 ms · **Memory** 48.2 MB

<sub>Synced by AILeetHub on 2026-01-11.</sub>
