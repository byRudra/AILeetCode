# 620. Not Boring Movies

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/not-boring-movies/)

`Database`

## Intuition  
The task is to return only those movies whose `id` is odd and whose `description` is not “boring”.  
Once the qualifying rows are identified, the result must be sorted by `rating` in descending order so that the highest‑rated movies appear first.

## Approach  
1. **Filter rows** – Use a `WHERE` clause that keeps rows where `id % 2 != 0` (odd ids) and `description != 'boring'`.  
2. **Order the result** – Apply `ORDER BY rating DESC` to arrange the filtered rows from highest to lowest rating.  
3. **Return all columns** – The `SELECT *` statement outputs the full row (`id`, `movie`, `description`, `rating`) for each qualifying movie.

This straightforward SQL query directly implements the required filtering and ordering without any additional processing.

## Complexity  
- **Time:** O(n log n) – scanning all `n` rows for the filter and then sorting the qualifying subset.  
- **Space:** O(1) – the query uses constant extra space; sorting is performed in place by the database engine.

## Solution (mysql)

```sql
# Write your MySQL query statement below
SELECT * FROM Cinema WHERE id % 2 != 0 AND description != "boring" ORDER BY rating DESC
```

---

**Runtime** 304 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-08-20.</sub>
