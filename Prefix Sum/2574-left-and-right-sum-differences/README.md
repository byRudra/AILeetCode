# 2574. Left and Right Sum Differences

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/left-and-right-sum-differences/)

`Array` · `Prefix Sum`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Prefix Sum.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int length = nums.length;
        int rightSum = 0;
        int leftSum = 0;
        int resultArray[] = new int[length];
        for(int num : nums){
            rightSum += num;
        }
        //now right sum = sum of all elements in nums

        //question wants an array where each index has the value of rightSum - leftSum - currentElement;
        for(int i = 0; i < length; i++){
            resultArray[i] = Math.abs(rightSum - leftSum - nums[i]);
            rightSum -= nums[i];
            leftSum += nums[i];
        }
        return resultArray;


    }
}
```

---

**Runtime** 2 ms · **Memory** 46.6 MB

<sub>Synced by AILeetHub on 2026-06-06.</sub>
