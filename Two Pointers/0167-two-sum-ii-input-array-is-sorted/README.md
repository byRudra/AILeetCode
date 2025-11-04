# 167. Two Sum II - Input Array Is Sorted

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)

`Array` · `Two Pointers` · `Binary Search`

## Intuition

Because the array is sorted, the sum of the smallest and largest elements gives a clear boundary. If the sum is too small we need a larger number, so we move the left pointer right; if it is too large we need a smaller number, so we move the right pointer left. This guarantees that we will eventually hit the unique pair that sums to the target.

## Approach

Initialize two indices, `left` at the start and `right` at the end. While `left < right`, compute `sum = numbers[left] + numbers[right]`. If `sum` equals the target, return `[left+1, right+1]` (1‑based indices). If `sum` is less than the target, increment `left` to increase the sum. If `sum` is greater, decrement `right` to decrease the sum. The loop terminates when the pair is found, guaranteed by the problem constraints.

## Complexity

- **Time:** O(n) – each iteration moves one pointer, so at most `n-1` steps.  
- **Space:** O(1) – only two integer variables are used regardless of input size.

## Solution (java)

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){return new int[]{ ++left, ++right};}

            if(sum < target){
                left++;
            }
            if(sum > target){
                right--;
            }
        }
        return new int[]{};
    }
}
```

---

**Runtime** 3 ms · **Memory** 48.4 MB

<sub>Synced by AILeetHub on 2025-11-04.</sub>
