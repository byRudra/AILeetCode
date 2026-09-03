# 3876. Construct Uniform Parity Array II

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/construct-uniform-parity-array-ii/)

`Array` · `Math`

## Intuition
The only operation that can change the parity of a number is subtracting another element.  
If the smallest element is odd, subtracting it from any even number turns that even number into an odd one (odd − even = odd).  
All odd numbers can stay unchanged. Thus, with an odd minimum we can always build an all‑odd array.  
If the minimum is even, the only way to keep parity uniform is to have every element already even; otherwise an odd element can never be turned even by subtracting an even number.

## Approach
1. Scan the array once to find the smallest value and to check whether every element is even.  
2. If the smallest value is odd, return `true` – we can convert all evens to odds by subtracting this smallest element.  
3. If the smallest value is even, return `true` only when all elements were even; otherwise return `false`.

The algorithm uses a single pass and constant extra space.

## Complexity
- **Time:** O(n) – one traversal of the array.  
- **Space:** O(1) – only a few scalar variables are maintained.

## Solution (java)

```java
class Solution {
    public boolean uniformArray(int[] nums1) {
        int smallestNo = Integer.MAX_VALUE;
        boolean isAllEven = true;

        for(int num : nums1){
            smallestNo = Math.min(smallestNo, num);
            if(num % 2 != 0) isAllEven = false;
        }
        return (smallestNo % 2 == 1) || isAllEven;
    }
}
```

---

**Runtime** 5 ms · **Memory** 121.6 MB

<sub>Synced by AILeetHub on 2026-09-03.</sub>
