# 169. Majority Element

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/majority-element/)

`Array` · `Hash Table` · `Divide and Conquer` · `Sorting` · `Counting` · `Boyer–Moore Majority Vote Algorithm`

## Intuition
The majority element appears more than half the time, so if we pair each occurrence of a different number with a majority element, the majority will never be fully paired away. By keeping a running count that increases for the current candidate and decreases for other values, the candidate that survives when the count reaches zero must be the majority.

## Approach
Initialize the first element as the candidate and set its count to 1. Iterate through the array starting from the second element:
- If the current element equals the candidate, increment the count.
- Otherwise, decrement the count.
When the count drops to zero, the current element becomes the new candidate and the count resets to 1. This process guarantees that after a full pass the remaining candidate is the majority element, because it outnumbers all other elements combined. Finally, return the candidate.

## Complexity
- **Time:** O(n) – a single linear scan of the array.  
- **Space:** O(1) – only two integer variables are used regardless of input size.

## Solution (java)

```java
class Solution {
    // O(n log(n))
    // public int majorityElement(int[] nums) {
    //     Arrays.sort(nums);
    //     return nums[nums.length / 2];
    // }

    // O(n)
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for(int i = 1; i < nums.length; i++){
            
            if (candidate == nums[i])
                count++;
            else
                count--;

            if(count == 0){
                count = 1;
                candidate = nums[i];
            }
        }
        return candidate;
    }
}
```

---

**Runtime** 2 ms · **Memory** 55.3 MB

<sub>Synced by AILeetHub on 2026-05-05.</sub>
