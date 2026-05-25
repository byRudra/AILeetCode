# 1871. Jump Game VII

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/jump-game-vii/)

`String` · `Dynamic Programming` · `Sliding Window` · `Prefix Sum`

## Approach

Accepted medium solution in java.
Relevant topics: String, Dynamic Programming, Sliding Window, Prefix Sum.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int length = s.length();
        boolean [] visited = new boolean[length];
        visited[0] = true;

        int reachable = 0;
        for(int i = 1; i < length; i++){

            if(i - minJump >= 0 && visited[i - minJump ]){
                reachable++;
            }

            if(i - maxJump - 1 >= 0 && visited[i - maxJump - 1]){
                reachable--;
            }
            if(reachable > 0 && s.charAt(i) == '0')
                visited[i] = true;
        }
        return visited[length-1];
    }
}
```

---

**Runtime** 9 ms · **Memory** 47.3 MB

<sub>Synced by AILeetHub on 2026-05-25.</sub>
