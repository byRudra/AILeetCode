# 1979. Find Greatest Common Divisor of Array

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/find-greatest-common-divisor-of-array/)

`Array` · `Math` · `Number Theory` · `Euclidean Algorithm` · `Greatest Common Divisor`

## Intuition  
The task requires the greatest common divisor (GCD) of the smallest and largest elements in the array.  
Since the GCD of any two numbers is at most the smaller one, the GCD of the entire array is bounded by the minimum value.  
However, the problem explicitly asks for the GCD of the min and max, so we only need to identify those two numbers and compute their GCD.

## Approach  
1. **Find min and max** – Iterate once over the array, maintaining two variables: `minValue` and `maxValue`.  
2. **Compute GCD** – Apply the iterative Euclidean algorithm:  
   ```text
   while (b ≠ 0) {
       temp = b;
       b = a % b;
       a = temp;
   }
   ```  
   When the loop terminates, `a` holds the GCD of the two numbers.  
3. Return this value.

The Euclidean algorithm runs in logarithmic time relative to the magnitude of the numbers, which here is bounded by 1000, so it is effectively constant time for the given constraints.

## Complexity  
- **Time:** O(n) – a single pass to find min/max and O(log M) for the Euclidean step, where M ≤ 1000, so overall linear.  
- **Space:** O(1) – only a handful of integer variables are used.

## Solution (java)

```java
class Solution {
    public int calGCD(int num1,int num2){
        while(num2 != 0){
            int temp = num2;
            num2 = num1 % num2; 
            num1 = temp;
        }
        return num1;
    }
    
    public int findGCD(int[] nums) {
        int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;

        for (int num : nums) {
            minValue = Math.min(minValue, num);
            maxValue = Math.max(maxValue, num);
        }

        return calGCD(minValue, maxValue);

    }
}
```

---

**Runtime** 0 ms · **Memory** 44.6 MB

<sub>Synced by AILeetHub on 2025-12-30.</sub>
