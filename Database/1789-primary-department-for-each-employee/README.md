# 1789. Primary Department for Each Employee

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/primary-department-for-each-employee/)

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
# Write your MySQL query statement below
SELECT employee_id, department_id FROM Employee where primary_flag = "Y"    OR employee_id IN (
       SELECT employee_id
       FROM Employee
       GROUP BY employee_id
       HAVING COUNT(*) = 1
   );
```

---

**Runtime** 622 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-08-21.</sub>
