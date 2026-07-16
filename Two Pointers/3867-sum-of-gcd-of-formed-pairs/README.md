# 3867. Sum of GCD of Formed Pairs

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/)

`Array` · `Math` · `Two Pointers` · `Sorting` · `Simulation` · `Number Theory`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Math, Two Pointers, Sorting, Simulation, Number Theory.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java

class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd(nums[i], max);
        }

        Arrays.sort(prefixGcd);

        long ans = 0;
        int left = 0, right = n - 1;

        while (left < right) {
            ans += gcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
```

---

**Runtime** 54 ms · **Memory** 108 MB

<sub>Synced by AILeetHub on 2026-07-16.</sub>
