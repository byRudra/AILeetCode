# 3436. Find Valid Emails

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/find-valid-emails/)

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
SELECT user_id, email
FROM Users
WHERE email REGEXP "^[A-Za-z0-9]+@[A-Za-z]+\\.com$"
ORDER BY user_id ASC
```

---

**Runtime** 516 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-04-14.</sub>
