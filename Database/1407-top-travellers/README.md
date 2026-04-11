# 1407. Top Travellers

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/top-travellers/)

`Database`

## Intuition  
We need each user’s total distance, even if they never rode. A left join keeps all users, and summing the rides’ distances gives the required total. When a user has no rides, the sum is NULL, so we replace it with 0. Finally, we sort by the summed distance descending and break ties with the user’s name ascending.

## Approach  
1. **Join** `Users` with `Rides` on `Users.id = Rides.user_id` using a `LEFT JOIN` so every user appears.  
2. **Aggregate** the joined rows with `GROUP BY Users.id`.  
3. **Sum** the `distance` column; use `COALESCE(SUM(R.distance), 0)` to turn NULLs into 0 for users without rides.  
4. **Select** the user’s `name` and the computed `travelled_distance`.  
5. **Order** the result set by `travelled_distance` descending, then by `name` ascending to satisfy the tie‑breaking rule.

## Complexity  
- **Time:** O(n + m) – each user and each ride is processed once during the join and aggregation.  
- **Space:** O(n) – the result holds one row per user, and the join buffer stores all users.

## Solution (mysql)

```sql
# Write your MySQL query statement below
SELECT U.name,  COALESCE(SUM(R.distance), 0) AS travelled_distance
FROM Users AS U
LEFT JOIN Rides AS R
ON U.id = R.user_id
GROUP BY U.id
ORDER BY travelled_distance DESC, U.name ASC;
```

---

**Runtime** 829 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-04-11.</sub>
