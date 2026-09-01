# 278. First Bad Version

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/first-bad-version/)

`Binary Search` · `Interactive`

## Approach

Accepted easy solution in java.
Relevant topics: Binary Search, Interactive.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                // mid is bad, so first bad version is
                // either mid or somewhere to the left
                right = mid;
            } else {
                // mid is good, so first bad version must be after mid
                left = mid + 1;
            }
        }

        return left;
    }
}
```

---

**Runtime** 13 ms · **Memory** 42.4 MB

<sub>Synced by AILeetHub on 2026-09-01.</sub>
