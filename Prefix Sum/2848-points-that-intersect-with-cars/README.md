# 2848. Points That Intersect With Cars

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/points-that-intersect-with-cars/)

`Array` · `Hash Table` · `Prefix Sum`

## Intuition  
The task is to count every integer point that lies inside at least one of the given intervals.  
Instead of marking each point individually for every interval (which would be \(O(n \cdot L)\)), we can record only the *changes* at interval boundaries.  
If we know how many intervals start or end at each coordinate, we can sweep once over the line and keep a running total of how many intervals currently cover the point.  
Whenever this running total is positive, the point is covered.

## Approach  
1. Create an array `diff` large enough to hold indices up to the maximum possible coordinate (100) plus one extra slot for the “end + 1” marker.  
2. For each car `[start, end]`:
   * Increment `diff[start]` to indicate an interval starts here.  
   * Decrement `diff[end + 1]` to indicate the interval ends after `end`.  
3. Perform a prefix sum over `diff` from 0 to 100, maintaining a running `count`.  
4. Every time `count` is greater than zero, increment the answer because that integer point is covered by at least one car.  
5. Return the accumulated answer.

This technique is a classic range‑addition trick that turns many interval updates into a single linear scan.

## Complexity  
- **Time:** \(O(n + M)\) – we process each of the \(n\) cars once and then scan the 101 possible coordinates.  
- **Space:** \(O(M)\) – the `diff` array of fixed size 102 holds the boundary markers.

## Solution (java)

```java
class Solution {
    // Using Brute Force
    // ''' 
    // Make a huge boolean array which will store 1 or 0 for visited points
    // make the value at index at value i '1' in the range of the points of car ex [2,5]
    // mark 2, 3, 4, 5 indexs as 1 and then sum the whole array.
    // '''

    // Using HashSet
    // public int numberOfPoints(List<List<Integer>> nums) {
    //     HashSet<Integer> points = new HashSet<>();

    //     for(List<Integer> car : nums){
    //         int start = car.get(0);
    //         int end = car.get(1);

    //         for(int i = start; i <= end; i++){
    //             points.add(i);
    //         }
    //     }

    //     return points.size();
    // }

    // Bettter Approach using "Prefix Sum / Range Marking"
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] diff = new int[102];

        for(List<Integer> car : nums){
            int start = car.get(0);
            int end = car.get(1);
            diff[start] += 1;
            diff[end + 1] -= 1;
        }

        int count = 0;
        int result = 0;
        for(int i = 0; i <= 100; i++){
            count += diff[i];
            if(count > 0){result++;}
        }
        return result;
    }

}
```

---

**Runtime** 1 ms · **Memory** 44.6 MB

<sub>Synced by AILeetHub on 2025-10-29.</sub>
