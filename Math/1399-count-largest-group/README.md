# 1399. Count Largest Group

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/count-largest-group/)

`Hash Table` · `Math` · `Counting`

## Intuition  
The numbers 1…n can be classified by the sum of their decimal digits.  
The largest possible digit sum for n ≤ 10⁴ is 36 (9999 → 9+9+9+9).  
Thus we can keep a fixed‑size counter array indexed by digit sum and find the most frequent sum.

## Approach  
1. **Digit‑sum helper** – `findDigitSum` iterates over the digits of a number, accumulating the sum.  
2. **Counting groups** – Create an array `groups[37]` (indices 0–36).  
   For each integer `i` from 1 to `n`:  
   * Compute `digitsum = findDigitSum(i)`.  
   * Increment `groups[digitsum]`.  
   * Update `maxGroup` with the largest value seen so far.  
3. **Result** – After the loop, scan the `groups` array and count how many entries equal `maxGroup`.  
   Return that count as the number of largest groups.

The algorithm uses a single pass over 1…n, constant‑size storage, and simple arithmetic.

## Complexity  
- **Time:** O(n) – each of the n numbers is processed once, and digit extraction is O(1) for the given limits.  
- **Space:** O(1) – the array size is fixed at 37, independent of n.

## Solution (java)

```java
class Solution {
    private int findDigitSum(int num){
        int result = 0;
        while(num > 0){
            result += num % 10;
            num /= 10;
        }
        return result;
    }
    public int countLargestGroup(int n) {
        int [] groups = new int [37];
        int maxGroup = 0;
        for (int i = 1; i <= n; i++){
            int digitsum = findDigitSum(i);
            groups[digitsum]++;
            maxGroup = Math.max(maxGroup, groups[digitsum]);
        }
        int count = 0;
        for (int size : groups){
            if (size == maxGroup){
                count++;
            }
        }
        return count;
    }
}
// class Solution {
//     private int findDigitSum(int num){
//         int result = 0;
//         while(num > 0){
//             result += num % 10;
//             num /= 10;
//         }
//         return result;
//     }
//     public int countLargestGroup(int n) {
//         int maxSize = 0;
//         HashMap <Integer, Integer> Map = new HashMap<Integer, Integer>();
//         for (int i = 1; i <= n; i++){
//             int digitsum = findDigitSum(i);
//             Map.put(digitsum, Map.getOrDefault(digitsum, 0) + 1);
//             maxSize = Math.max(maxSize, Map.get(digitsum));   

//         }
//         int count = 0;
//         for (int size : Map.values()){
//             if (size == maxSize) {count ++;}
//         }
//         return count;
//     }
// }
```

---

**Runtime** 5 ms · **Memory** 40.2 MB

<sub>Synced by AILeetHub on 2025-04-24.</sub>
