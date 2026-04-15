# 2515. Shortest Distance to Target String in a Circular Array

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/)

`Array` · `String`

## Intuition  
The array is circular, so from the starting index we can reach any other index by moving either clockwise or counter‑clockwise.  
The shortest distance to a target is simply the smallest number of steps needed to land on an index that holds the target string.  
Instead of computing distances for every index, we can test increasing step counts until we find the target.

## Approach  
Let `n` be the length of `words`.  
Iterate a distance `d` from `0` to `n‑1`.  
For each `d` compute the two indices that are exactly `d` steps away from `startIndex`:

* `forward = (startIndex + d) % n` – moving clockwise.
* `backward = (startIndex - d + n) % n` – moving counter‑clockwise.

If either `words[forward]` or `words[backward]` equals `target`, `d` is the minimal number of steps required, so return `d`.  
If the loop finishes without a match, the target does not exist in the array; return `-1`.

This approach guarantees the first match found is the shortest distance because we test distances in ascending order.

## Complexity  
- **Time:** O(n) – each distance is checked once, with constant‑time index calculations.  
- **Space:** O(1) – only a few integer variables are used regardless of input size.

## Solution (java)

```java
// class Solution {
//     public int closestTarget(String[] words, String target, int startIndex) {
//         int closest = Integer.MAX_VALUE;
//         for(int i = 0; i < words.length; i++){
//             if(words[i].equals(target)){
//                 int dist = Math.abs(i - startIndex);
//                 closest = Math.min(closest, Math.min(dist, words.length - dist));
//             }
//         }
//         return closest == Integer.MAX_VALUE ? -1 : closest;
//     }
// }

class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        for(int i = 0; i < n; i++){
            int forward = (i + startIndex) % n;
            int backward = (startIndex - i + n) % n;
            if(words[forward].equals(target) || words[backward].equals(target)) return i;

        }
        return -1;
    }
}
```

---

**Runtime** 0 ms · **Memory** 47 MB

<sub>Synced by AILeetHub on 2026-04-15.</sub>
