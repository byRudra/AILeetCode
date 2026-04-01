# 180. Consecutive Numbers

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/consecutive-numbers/)

`Database`

## Intuition  
To detect a number that appears at least three times in a row, we only need to verify that a row has the same value in the immediately preceding and following rows. If such a pattern exists, that number qualifies.

## Approach  
The query performs a self‑join of the `logs` table three times:

1. `l1` represents the middle row of a potential triple.  
2. `l2` is joined where `l2.id = l1.id - 1` and `l2.num = l1.num`, ensuring the previous row has the same value.  
3. `l3` is joined where `l3.id = l1.id + 1` and `l3.num = l1.num`, ensuring the next row also matches.

Rows that satisfy all three conditions form a consecutive sequence of at least three identical values. The `SELECT DISTINCT` clause extracts the unique `num` values from these sequences, producing the final list of numbers that appear consecutively three or more times.

## Complexity  
- **Time:** O(n²) – the triple self‑join scans combinations of rows, but the index on `id` limits the search to adjacent rows, effectively reducing the cost.  
- **Space:** O(1) – only a few temporary row references are held during the join; no additional data structures are created.

## Solution (mysql)

```sql
# Write your MySQL query statement below
select distinct l1.num as ConsecutiveNums
from logs l1
     ,logs l2
     ,logs l3
where l2.num = l1.num and l2.id = l1.id - 1
and   l3.num = l1.num and l3.id = l1.id + 1;
```

---

**Runtime** 544 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-04-01.</sub>
