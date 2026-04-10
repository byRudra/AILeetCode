# 3740. Minimum Distance Between Three Equal Elements I

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/minimum-distance-between-three-equal-elements-i/)

`Array` · `Hash Table`

## Intuition  
For a good tuple the three indices must belong to the same value.  
If the indices are \(a<b<c\), the distance simplifies to  
\[
|a-b|+|b-c|+|c-a| = (b-a)+(c-b)+(c-a)=2\,(c-a).
\]
Thus the distance depends only on the smallest and largest indices of the triple.  
To minimise the distance we only need to consider triples that are as close together as possible, i.e. consecutive indices in the sorted list of positions for each value.

## Approach  
1. Scan the array once, recording for each distinct number the list of indices where it appears.  
2. For every list that contains at least three indices, slide a window of size three over the sorted indices.  
3. For each window compute \(2 \times (\text{index}_{j+2} - \text{index}_{j})\) and keep the smallest value found.  
4. If no list has three or more indices, return \(-1\); otherwise return the minimal distance.

The lists are naturally sorted because indices are appended in order of traversal.  
The sliding window guarantees that we examine only the minimal‑span triples for each value.

## Complexity  
- **Time:** \(O(n)\) – one pass to build the index lists and a linear pass over all lists to evaluate windows.  
- **Space:** \(O(n)\) – storage for the index lists in the hash map.

## Solution (python3)

```python
class Solution:
    def minimumDistance(self, nums: List[int]) -> int:
        pos = defaultdict(list)
        ans = float("inf")

        for i, num in enumerate(nums):
            pos[num].append(i)

        for arr in pos.values():
            if len(arr) >= 3:
                for j in range(len(arr) - 2):
                    ans = min(ans, 2 * (arr[j + 2] - arr[j]))

        return -1 if ans == float('inf') else ans 

```

---

**Runtime** 5 ms · **Memory** 19.4 MB

<sub>Synced by AILeetHub on 2026-04-10.</sub>
