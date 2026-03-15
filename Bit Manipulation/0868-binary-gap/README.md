# 868. Binary Gap

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/binary-gap/)

`Bit Manipulation`

## Approach

Accepted easy solution in java.
Relevant topics: Bit Manipulation.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
// class Solution {
//     public String binValue(int n) {
//         if (n == 0)
//             return "0";
//         String binValueString = "";
//         while (n > 0) {
//             binValueString = String.valueOf(n % 2) + binValueString;
//             n = n / 2;
//         }
//         return binValueString;
//     }

//     public int binaryGap(int n) {
//         String binVal = binValue(n);
//         boolean beforeOne = false;
//         int maxGap = 0;
//         int currentGap = 0;
//         for (char i : binVal.toCharArray()) {
//             if (!beforeOne && i == '0')
//                 continue;
//             if (i == '1' && beforeOne == false) {
//                 beforeOne = true;
//                 continue;
//             }
//             if (i == '0') {
//                 currentGap++;
//                 continue;
//             }
//             if (i == '1')
//                 currentGap++;
//             maxGap = Math.max(maxGap, currentGap);
//             currentGap = 0;
//         }
//         return maxGap;
//     }
// }
// complexity O(nlog(n))

// better Approach

class Solution{
    public int binaryGap(int n){
        int last = -1;
        int max = 0;
        int position = 0;

        while(n > 0){
            if((n & 1) == 1){
                if(last != -1){
                    max = Math.max(max, position - last);
                }
                last = position;
            }
            n >>= 1;
            position++;
        }
        return max;
    }
}
```

---

**Runtime** 0 ms · **Memory** 42 MB

<sub>Synced by AILeetHub on 2026-03-15.</sub>
