# 1890. The Latest Login in 2020

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/the-latest-login-in-2020/)

`Database`

## Approach

Accepted easy solution in mysql.
Relevant topics: Database.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (mysql)

```sql
# Write your MySQL query statement below
SELECT 
    user_id,
    MAX(time_stamp) AS last_stamp
FROM Logins
WHERE YEAR(time_stamp) = 2020
GROUP BY user_id;
```

---

**Runtime** 595 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-04-12.</sub>
