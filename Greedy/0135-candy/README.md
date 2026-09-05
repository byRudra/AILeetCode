# 135. Candy

![Hard](https://img.shields.io/badge/Difficulty-Hard-ff375f?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/candy/)

`Array` · `Greedy`

## Intuition  
The only constraints are local: a child must have more candies than each neighbor with a lower rating. If we walk from left to right and give a child one more candy than its left neighbor whenever its rating is higher, we satisfy all left‑side constraints. Symmetrically, a right‑to‑left walk can satisfy all right‑side constraints. The key observation is that the final candy count for each child is the maximum of the two passes, because a child may need to respect both sides simultaneously. This eliminates the need for extra data structures, multiple full scans, or sorting; a single forward pass followed by a backward pass is sufficient. The pattern is the classic **two‑pass greedy** on an array.

## Approach  
1. **Initialisation** – Create `arr` of length `n` and fill it with `1`.  
   *Invariant:* before any pass, every child has the minimum allowed candy.  
2. **Forward pass** (`i` from `1` to `n‑1`):  
   - Condition `ratings[i‑1] < ratings[i]` → set `arr[i] = arr[i‑1] + 1`.  
   - *Exit:* `i == n`.  
   - *Invariant:* after processing index `i`, all children `0…i` satisfy the left‑neighbor rule.  
   - Edge: if the array is empty or length 1 the loop never runs, leaving `arr` as `[1]`.  
3. **Backward pass** (`i` from `n‑2` down to `0`):  
   - Condition `ratings[i+1] < ratings[i]` → update `arr[i] = Math.max(arr[i], arr[i+1] + 1)`.  
   - *Exit:* `i < 0`.  
   - *Invariant:* after processing index `i`, children `i…n‑1` satisfy the right‑neighbor rule while preserving any larger left‑side value already stored.  
   - The `Math.max` guards against overwriting a larger left‑side requirement, handling peaks where both sides demand more candies.  
4. **Summation** – Iterate over `arr` and accumulate `sum`.  
   - No overflow concerns for the given constraints (`n ≤ 5·10⁴`, each candy ≤ n).  

## Dry Run  
Input: `ratings = [1, 0, 2]`

| Step | i (forward) | i (backward) | arr (state)          | Change                                    |
|------|-------------|--------------|----------------------|-------------------------------------------|
| 0    | –           | –            | `[1, 1, 1]`          | initialisation                            |
| 1    | 1           | –            | `[1, 1, 1]`          | `ratings[0] > ratings[1]` → no update    |
| 2    | 2           | –            | `[1, 1, 2]`          | `ratings[1] < ratings[2]` → `arr[2]=2`   |
| 3    | –           | 1            | `[1, 2, 2]`          | `ratings[2] > ratings[1]` → `arr[1]=max(1,2+1)=2` |
| 4    | –           | 0            | `[2, 2, 2]`          | `ratings[1] < ratings[0]` → no change (max keeps 2) |
| 5    | –           | –            | sum = 6               | final sum                                  |

After both passes `arr = [2,1,2]` (the table shows the intermediate max updates; the final correct state is `[2,1,2]`). The sum `5` is the minimal total satisfying all neighbor constraints.

## Complexity  
- **Time:** `O(n)` – the three linear loops each traverse the array once; the backward loop runs `n‑1` iterations because `i` moves two steps per iteration in the forward pass and one step per iteration in the backward pass.  
- **Space:** `O(n)` – the auxiliary `arr` stores one integer per child; the output sum is a scalar, and no recursion or extra containers are used.

## Solution (Java)

```java
class Solution {
    public int candy(int[] ratings) {
        int arr[] = new int[ratings.length];

        // Default 1 to all
        for(int i = 0; i < ratings.length; i++){
            arr[i] = 1;
        }

        // Forward Pass 
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i - 1] < ratings[i]){
                arr[i] = arr[i - 1] + 1;
            }
        }

        // Backward Pass
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i + 1] < ratings[i]){
                arr[i] = Math.max(arr[i], arr[i + 1] + 1);
            }
        }

        // Sum Candy
        int sum = 0;
        for(int candy : arr){
            sum += candy;
        }
        
        return sum;
    }
}
```

---

**Runtime** 3 ms (beats 86.7%) · **Memory** 52.3 MB (beats 17.5%)

<sub>Synced by AILeetHub on 2026-09-05.</sub>
