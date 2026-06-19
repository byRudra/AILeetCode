# 1732. Find the Highest Altitude

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/find-the-highest-altitude/)

`Array` · `Prefix Sum`

## Intuition
We need the maximum altitude reached while moving along the road.  
Starting at altitude 0, each element of `gain` changes the altitude by that amount.  
The highest altitude is simply the maximum of all intermediate sums.

## Approach
Maintain two variables:  
* `currentAlti` – altitude after the current step (initially 0).  
* `highest` – greatest altitude seen so far (initially 0).  

Iterate through `gain`. For each `num`:
1. Add `num` to `currentAlti`.  
2. Update `highest` to `max(highest, currentAlti)`.  

After the loop, `highest` holds the answer. This works because the altitude after each point is the cumulative sum of gains up to that point, and we track the maximum as we accumulate.

## Complexity
- **Time:** O(n) – one pass over the array.  
- **Space:** O(1) – only a few integer variables are used, independent of input size.

## Solution (java)

```java
// class Solution {
//     public int largestAltitude(int[] gain) {
//         int realArray[] = new int[gain.length + 1];
//         realArray[0] = 0;
//         for(int i = 0; i < gain.length; i++) {
//             realArray[i + 1] = realArray[i] + gain[i];
//         }
//         int highest = Integer.MIN_VALUE;
//         for(int num : realArray){
//             highest = Math.max(num, highest);
//         }
//         return highest;
//     }
// }

class Solution {
    public int largestAltitude(int[] gain) {
        int highest = 0;
        int currentAlti = 0;
        for(int num : gain){
            currentAlti += num;
            highest = Math.max(currentAlti, highest);
        }
        return highest;
    }
}
```

---

**Runtime** 0 ms · **Memory** 43.3 MB

<sub>Synced by AILeetHub on 2026-06-19.</sub>
