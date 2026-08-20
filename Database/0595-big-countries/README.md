# 595. Big Countries

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/big-countries/)

`Database`

## Intuition  
A country is considered big if it satisfies either of two thresholds: an area of at least 3 million km² or a population of at least 25 million. The task is simply to extract the rows that meet either condition and return the required columns.

## Approach  
The solution performs a single table scan of **World**.  
1. **Filter**: The `WHERE` clause checks `population >= 25000000 OR area >= 3000000`.  
2. **Projection**: Only the columns `name`, `population`, and `area` are selected.  
Because the query uses only a straightforward comparison and logical OR, the database can use indexes on `population` or `area` if present, but even without them the operation is a linear scan.

## Complexity  
- **Time:** O(n) – each row of the table is examined once to evaluate the two numeric conditions.  
- **Space:** O(k) – the result set holds at most all rows that satisfy the predicate, where k is the number of qualifying countries.

## Solution (mysql)

```sql
# Write your MySQL query statement below
SELECT name, population, area FROM World WHERE population >= 25000000 OR area >= 3000000 
```

---

**Runtime** 329 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-08-20.</sub>
