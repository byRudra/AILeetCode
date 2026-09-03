# 621. Task Scheduler

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/task-scheduler/)

`Array` · `Hash Table` · `Greedy` · `Sorting` · `Heap (Priority Queue)` · `Counting`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Hash Table, Greedy, Sorting, Heap (Priority Queue), Counting.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freqs[] = new int[26];

        for(char task : tasks)
            freqs[task - 'A']++;
        int maxFreq = 0;
        for(int freq : freqs)
            maxFreq = Math.max(maxFreq, freq);
        int maxCount = 0;
        for(int freq : freqs){
            if(freq == maxFreq)
                maxCount++;
        }
        
        int frameSize = (maxFreq - 1) * (n + 1) + maxCount; 
        return Math.max(frameSize, tasks.length);
    }
}
```

---

**Runtime** 2 ms · **Memory** 48.3 MB

<sub>Synced by AILeetHub on 2026-09-03.</sub>
