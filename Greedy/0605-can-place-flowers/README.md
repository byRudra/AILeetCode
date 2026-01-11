# 605. Can Place Flowers

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/can-place-flowers/)

`Array` · `Greedy`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Greedy.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
// class Solution {
//     public boolean canPlaceFlowers(int[] flowerbed, int n) {
//         if (flowerbed.length == 1) {
//             if (n == 0)
//                 return true;
//             return flowerbed[0] == 0;
//         }

//         for (int i = 0; i < flowerbed.length; i++) {
//             if (i == 0 && flowerbed[0] == 0 && flowerbed[1] == 0) {
//                 flowerbed[0] = 1;
//                 n--;
//             } else if (i == flowerbed.length - 1 && flowerbed[flowerbed.length - 1] == 0
//                     && flowerbed[flowerbed.length - 2] == 0) {
//                 flowerbed[flowerbed.length - 1] = 1;
//                 n--;
//             } else {
//                 if (i > 0 && i < flowerbed.length - 1) {
//                     if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
//                         flowerbed[i] = 1;
//                         n--;
//                     }
//                 }
//             }
//         }
//         return n <= 0;
//     }
// }

class Solution {
    public boolean canPlaceFlowers(int[] f, int n) {
        for(int i = 0; i < f.length; i+=2){
            if(f[i] == 0){
                if(i == f.length - 1 || f[i] == f[i+1]){
                    n--;
                }
                else i++;
            }
        }
        return n <= 0;
    }
}
```

---

**Runtime** 0 ms · **Memory** 47.9 MB

<sub>Synced by AILeetHub on 2026-01-11.</sub>
