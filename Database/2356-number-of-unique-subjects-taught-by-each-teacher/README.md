# 2356. Number of Unique Subjects Taught by Each Teacher

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/number-of-unique-subjects-taught-by-each-teacher/)

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
SELECT teacher_id , COUNT(DISTINCT subject_id) as cnt
FROM Teacher
GROUP BY teacher_id
```

---

**Runtime** 500 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-04-10.</sub>
