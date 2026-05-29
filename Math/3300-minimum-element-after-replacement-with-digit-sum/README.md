# 3300. Minimum Element After Replacement With Digit Sum

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/)

`Array` · `Math`

## Intuition  
The task reduces to finding the smallest digit‑sum among all numbers in the array.  
Each element can be replaced independently, so we can process the array in a single pass, computing the sum of digits for each value and keeping the minimum seen so far.

## Approach  
1. Initialize `minSum` to the largest possible integer.  
2. Iterate over every element `x` in `nums`.  
   * Compute `sumDigit(x)` by repeatedly taking `x % 10` (the last digit) and adding it to a running total, then dividing `x` by 10 until it becomes zero.  
   * Update `minSum` with the smaller of its current value and the computed digit sum.  
3. After the loop, return `minSum`, which is the minimum digit sum in the array.

The helper `sumDigit` runs in time proportional to the number of decimal digits of its input, which is at most five for the given constraints.

## Complexity  
- **Time:** O(n · d) – each of the `n` numbers is processed digit by digit (≤ 5 digits).  
- **Space:** O(1) – only a few integer variables are used regardless of input size.

## Solution (java)

```java
class Solution {
    public int minElement(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            minSum = Math.min(minSum, sumDigit(nums[i]));
        }   
        return minSum;
    }
    private int sumDigit(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
```

---

**Runtime** 1 ms · **Memory** 45 MB

<sub>Synced by AILeetHub on 2026-05-29.</sub>
