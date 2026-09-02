# 2053. Kth Distinct String in an Array

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/kth-distinct-string-in-an-array/)

`Array` · `Hash Table` · `String` · `Counting`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Hash Table, String, Counting.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
// class Solution {
//     public String kthDistinct(String[] arr, int k) {
//         LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
//         for(String x : arr){
//             map.put(x, map.getOrDefault(x, 0) + 1);
//         }
//         for(String x : map.keySet()){
//             if(map.get(x) == 1){
//                 k--;
//             }
//             if(k == 0){
//                 return x;
//             }
//         }
//         return "";   
//     }
// }

class Solution {
    public String kthDistinct(String[] arr, int k) {

        HashMap<String, Integer> map = new HashMap<>();

        // 1. Count frequency
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        // 2. Traverse original array to preserve order
        for (String s : arr) {
            if (map.get(s) == 1) {
                k--;

                if (k == 0) {
                    return s;
                }
            }
        }

        return "";
    }
}
```

---

**Runtime** 7 ms · **Memory** 45.9 MB

<sub>Synced by AILeetHub on 2026-09-02.</sub>
