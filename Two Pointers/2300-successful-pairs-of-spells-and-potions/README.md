# 2300. Successful Pairs of Spells and Potions

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/successful-pairs-of-spells-and-potions/)

`Array` · `Two Pointers` · `Binary Search` · `Sorting`

## Intuition  
For a fixed spell, the set of potions that produce a successful pair is a suffix of the sorted potion strengths.  
If the potions are sorted ascending, the first potion that satisfies  
`spell * potion >= success` marks the boundary; all later potions automatically satisfy the condition.  
Thus, for each spell we only need to locate this boundary index.

## Approach  
1. **Sort** the `potions` array once.  
2. For every `spell` in the original order, perform a binary search on the sorted `potions` to find the smallest index `idx` such that `potions[idx] * spell >= success`.  
   * If `potions[mid] * spell >= success`, move the right bound to `mid`.  
   * Otherwise, move the left bound to `mid + 1`.  
3. The number of successful potions for that spell is `potions.length - idx`.  
4. Store the count in the result array at the corresponding position.

The algorithm keeps the original order of spells while leveraging the sorted potions for efficient queries.

## Complexity  
- **Time:** `O(m log m + n log m)` – sorting the potions takes `O(m log m)`; each of the `n` binary searches costs `O(log m)`.  
- **Space:** `O(1)` – aside from the output array, only a few integer variables are used; the sorting is in‑place.

## Solution (java)

```java
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int result[] = new int[spells.length];
        int st = 0;
        for(int spell: spells){
            int start = 0;
            int end = potions.length;
            while(start <end){
                int mid = start + (end - start) / 2;
                if((long)potions[mid] * spell >= success){
                    end=mid;
                }
                else
                    start = mid + 1;
            }
            result[st++] = potions.length - start;
        }
        return result;
    }
}
```

---

**Runtime** 48 ms · **Memory** 146.8 MB

<sub>Synced by AILeetHub on 2026-08-26.</sub>
