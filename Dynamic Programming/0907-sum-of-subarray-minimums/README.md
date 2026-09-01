# 907. Sum of Subarray Minimums

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/sum-of-subarray-minimums/)

`Array` · `Dynamic Programming` · `Stack` · `Monotonic Stack`

## Intuition
For each position `i` the value `arr[i]` is the minimum of all subarrays that end at `i` and whose previous smaller element is at index `j`.  
All subarrays that end at `i` and start after `j` have `arr[i]` as their minimum.  
If we know the total contribution of subarrays ending at `j` (`sum[j]`), we can extend them by adding `arr[i]` to each of the `(i‑j)` new subarrays that start between `j+1` and `i`.  
Thus the contribution of subarrays ending at `i` is `sum[j] + arr[i] * (i‑j)`.

## Approach
The algorithm scans the array once from left to right.  
For each `i` (1‑based index in the code) it finds the nearest index `j` to the left with a smaller value (`left[i]`).  
This is done by walking back through previously computed `left` indices while the current value is not smaller, effectively maintaining a monotonic stack in array form.  
Once `j` is known, `sum[i]` is computed as `sum[j] + arr[i] * (i‑j)` and added to the running total modulo `10^9+7`.  
The arrays `right`, `left`, and `sum` store the original values, the previous smaller indices, and the cumulative contributions respectively.

## Complexity
- **Time:** O(n) – each element is processed once and the while‑loop jumps over already visited indices, giving linear total work.  
- **Space:** O(n) – three auxiliary arrays of size `n+1` store values, previous smaller indices, and cumulative sums.

## Solution (java)

```java
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = (int) 1e9 + 7;
        int[] right = new int[n + 1];
        int[] left = new int[n + 1];
        int[] sum = new int[n + 1];

        for (int i = 0; i < n; ++i) {
            right[i + 1] = arr[i];
        }
        int res = 0;

        for (int i = 1; i <= n; i++) {
            int curr = right[i];
            int j = i - 1;

            while (right[j] >= curr) {
                j = left[j];
            }
            left[i] = j;
            sum[i] = sum[j] + curr * (i - j);
            res = (res + sum[i]) % mod;
        }
        return res;
    }
}
```

---

**Runtime** 10 ms · **Memory** 72.9 MB

<sub>Synced by AILeetHub on 2026-09-01.</sub>
