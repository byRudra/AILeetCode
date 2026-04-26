# 627. Swap Sex of Employees

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/swap-sex-of-employees/)

`Database`

## Intuition  
The goal is to toggle the gender value for every employee in one pass.  
Because the column `sex` contains only two possible values (`'m'` or `'f'`), a simple conditional expression can map each value to its opposite.

## Approach  
Execute a single `UPDATE` on the `Salary` table.  
Use a `CASE` expression in the `SET` clause:  
- If the current `sex` is `'m'`, set it to `'f'`.  
- Otherwise (the only remaining value is `'f'`), set it to `'m'`.  
This statement scans the table once, evaluates the condition for each row, and writes the new value back, achieving the swap without any auxiliary tables or temporary storage.

## Complexity  
- **Time:** O(n) – each of the `n` rows is visited once to evaluate the `CASE` and update the column.  
- **Space:** O(1) – only a constant amount of memory is used for the expression evaluation; no additional data structures are created.

## Solution (mysql)

```sql
# Write your MySQL query statement below
UPDATE Salary
SET sex = CASE
            WHEN sex = 'm' THEN 'f'
            ELSE 'm'
          END;
```

---

**Runtime** 274 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-04-26.</sub>
