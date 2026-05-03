# 1539. Kth Missing Positive Number

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/kth-missing-positive-number/)

`Array` · `Binary Search`

## Intuition  
For a sorted array `arr`, the number of missing positives up to index `i` equals `arr[i] - (i + 1)`.  
If this value is less than `k`, the `k`‑th missing number lies to the right; otherwise it lies to the left.  
Thus we can binary‑search for the first position where the missing count reaches or exceeds `k`.

## Approach  
1. Set `low = 0`, `high = arr.length - 1`.  
2. While `low <= high`:
   * Compute `mid = low + (high - low) / 2`.  
   * If `arr[mid] - (mid + 1) < k`, the `k`‑th missing number is to the right → `low = mid + 1`.  
   * Else, it is to the left → `high = mid - 1`.  
3. After the loop, `low` is the smallest index where the missing count is at least `k`.  
4. The answer is `low + k` because the first `low` elements account for `low` numbers, and we need `k` more.

## Complexity  
- **Time:** O(log n) – binary search halves the search space each iteration.  
- **Space:** O(1) – only a few integer variables are used regardless of input size.

## Solution (java)

```java
class Solution {
    public int findKthPositive(int[] arr, int k) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] - (mid + 1) < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low + k;
    }
}
```

---

**Runtime** 0 ms · **Memory** 44.3 MB

<sub>Synced by AILeetHub on 2026-05-03.</sub>
