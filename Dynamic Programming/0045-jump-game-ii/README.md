# 45. Jump Game II

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/jump-game-ii/)

`Array` · `Dynamic Programming` · `Greedy`

## Intuition  
At each position we only care about how far we can reach with the current jump.  
If we know the farthest index reachable from all positions within the current jump’s range, we can decide when to make the next jump: exactly when we exhaust the current range. This guarantees the minimum number of jumps because any earlier jump would not extend the reachable frontier.

## Approach  
Traverse the array once, keeping three variables:  
- `maxJump` – the farthest index reachable from any index seen so far.  
- `currEnd` – the farthest index that can be reached with the current number of jumps.  
- `count` – the number of jumps taken.  

For each index `i` (except the last one), update `maxJump` with `i + nums[i]`.  
When `i` reaches `currEnd`, we must make another jump: increment `count` and set `currEnd` to `maxJump`.  
The loop stops before the last element because reaching or surpassing it is guaranteed by the problem constraints. The final `count` is the minimal jumps needed.

## Complexity  
- **Time:** O(n) – a single pass over the array.  
- **Space:** O(1) – only a few integer variables are used regardless of input size.

## Solution (java)

```java
class Solution {
    public int jump(int[] nums) {
        // Greedy Approach

        int maxJump = 0, count = 0, currEnd = 0;

        for(int i = 0; i < nums.length - 1; i++){
            maxJump = Math.max(maxJump, i + nums[i]);

            if(i == currEnd){
                count++;
                currEnd = maxJump;
            }

            // if(currEnd >= nums.length - 1 ) return count;

        }
        return count;

    }
}
```

---

**Runtime** 1 ms · **Memory** 47.5 MB

<sub>Synced by AILeetHub on 2025-11-13.</sub>
