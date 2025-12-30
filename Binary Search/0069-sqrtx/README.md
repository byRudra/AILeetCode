# 69. Sqrt(x)

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/sqrtx/)

`Math` · `Binary Search` · `Newton's Method`

## Approach

Accepted easy solution in java.
Relevant topics: Math, Binary Search, Newton's Method.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
// Linear search till x / 2
// class Solution {
//     public int mySqrt(int x) {
//         if (x < 2) return x;

//         for (int i = 0; i <= x / 2; i++) {
//             long curr = (long) i * i;
//             long next = (long) (i + 1) * (i + 1);

//             if (curr == x) return i;
//             if (next == x) return i + 1;
//             if (curr < x && x < next) return i;
//         }
//         return 0;
//     }
// }

// Binary Search
class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int startRoot = 0;
        int endRoot = x / 2;
        int answer = 0;

        while (startRoot <= endRoot) {
            int midRoot = startRoot + (endRoot - startRoot) / 2;
            long square = (long) midRoot * midRoot;

            if (square == x) {
                return midRoot;
            } else if (square < x) {
                answer = midRoot;       
                startRoot = midRoot + 1;
            } else {
                endRoot = midRoot - 1;
            }
        }
        return answer;
    }
}

```

---

**Runtime** 1 ms · **Memory** 42.4 MB

<sub>Synced by AILeetHub on 2025-12-30.</sub>
