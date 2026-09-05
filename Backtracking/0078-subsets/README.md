# 78. Subsets

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/subsets/)

`Array` · `Backtracking` · `Bit Manipulation`

## Intuition  
When we have already enumerated all subsets of the first *k* numbers, each subset either contains the next number *num* or it does not. Therefore the complete family of subsets after processing *num* is obtained by taking every existing subset, copying it, appending *num*, and adding that copy to the collection. This observation eliminates the need for a recursive back‑track or a separate pass to combine results; we can grow the power set in a single forward sweep. The pattern is an **iterative subset construction** using two nested loops.

## Approach  
1. **Initialize** `result` with the empty subset `[]`.  
2. **Outer loop** – `for (int num : nums)`:  
   *Exit condition*: the iterator finishes when all elements of `nums` have been visited.  
   *Invariant*: before processing `num`, `result` holds **all** subsets of the elements seen so far.  
3. Capture the current number of subsets: `int size = result.size();`. This size is the boundary for the inner loop and guarantees we only extend subsets that existed *before* adding `num`.  
4. **Inner loop** – `for (int i = 0; i < size; i++)`:  
   *Exit condition*: `i == size`.  
   *Invariant*: at each iteration `i`, `result.get(i)` is a subset that does **not** contain `num`.  
   a. Clone that subset: `new ArrayList<>(result.get(i))`.  
   b. Append `num` to the clone.  
   c. Append the new subset to `result`.  
5. After the inner loop finishes, `result` now contains every old subset plus a new one that includes `num`, satisfying the invariant for the next outer iteration.  
6. Return `result` after all numbers have been processed.

**Edge considerations**  
- The input length is guaranteed ≥ 1, so the initial empty subset is always present.  
- Because `nums` contains unique values, no duplicate subsets can be produced; the algorithm never checks for duplicates.  
- The inner loop uses `i < size` (not `<=`) to avoid iterating over the subsets that are appended during the same outer iteration, which would otherwise cause exponential blow‑up within a single step.

## Dry Run  

**Input**: `[1, 2, 3]`

| outer step (`num`) | i | size before inner loop | result size after iteration | change |
|--------------------|---|------------------------|-----------------------------|--------|
| start (init)       | – | –                      | 1                           | `result = [[]]` |
| `num = 1`          | 0 | 1                      | 2                           | copy `[]` → `[1]` |
| `num = 2`          | 0 | 2                      | 3                           | copy `[]` → `[2]` |
|                    | 1 | 2                      | 4                           | copy `[1]` → `[1,2]` |
| `num = 3`          | 0 | 4                      | 5                           | copy `[]` → `[3]` |
|                    | 1 | 4                      | 6                           | copy `[1]` → `[1,3]` |
|                    | 2 | 4                      | 7                           | copy `[2]` → `[2,3]` |
|                    | 3 | 4                      | 8                           | copy `[1,2]` → `[1,2,3]` |

After the last outer step the collection holds eight subsets, which is exactly the power set of three distinct elements.

## Complexity  
- **Time:** `O(n * 2^n)` – each of the `n` numbers iterates over the current `2^{k}` subsets, doubling the count at every step.  
- **Space:** `O(2^n)` – the result list stores all subsets; aside from the output, the algorithm uses only a few scalar variables.

## Solution (Java)

```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int num : nums){
            int size = result.size();
            for(int i = 0; i < size; i++){
                ArrayList<Integer> currentSet = new ArrayList<>(result.get(i));
                currentSet.add(num);
                result.add(currentSet);
            }
        }
        return result;


    }
}
```

---

**Runtime** 1 ms (beats 86.7%) · **Memory** 44.3 MB (beats 38.6%)

<sub>Synced by AILeetHub on 2026-09-05.</sub>
