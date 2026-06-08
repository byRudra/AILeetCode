# 2161. Partition Array According to Given Pivot

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/partition-array-according-to-given-pivot/)

`Array` · `Two Pointers` · `Simulation`

## Intuition  
The required ordering is a stable partition: all values smaller than the pivot must precede all values equal to the pivot, which in turn must precede all values larger than the pivot.  
Because the relative order within each group must be preserved, we cannot simply swap elements in place; we need to build a new ordering that respects the original sequence.

## Approach  
Create a new array of the same length as `nums`.  
Traverse the original array three times:  
1. Copy every element `< pivot` into the new array, appending in the order encountered.  
2. Copy every element `== pivot` next, preserving their original order.  
3. Finally copy every element `> pivot`.  

The index pointer in the new array is advanced after each insertion, ensuring that the three groups are concatenated in the correct order.  
The original array remains unchanged; the method returns the newly constructed array.

## Complexity  
- **Time:** O(n) – three linear scans over the input array.  
- **Space:** O(n) – an auxiliary array of the same size as the input is allocated.

## Solution (java)

```java
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int arrayResult[] = new int[nums.length];
        int index = 0;
        for(int num : nums){
            if(num < pivot){
                arrayResult[index++] = num;
            }
        }
        for(int num : nums){
            if(num == pivot){
                arrayResult[index++] = num;
            }
        }
        for(int num : nums){
            if(num > pivot){
                arrayResult[index++] = num;
            }
        }
        return arrayResult;
    }
}
```

---

**Runtime** 4 ms · **Memory** 159.9 MB

<sub>Synced by AILeetHub on 2026-06-08.</sub>
