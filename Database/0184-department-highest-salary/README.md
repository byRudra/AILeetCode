# 184. Department Highest Salary

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/department-highest-salary/)

`Database`

## Approach

Accepted medium solution in mysql.
Relevant topics: Database.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (mysql)

```sql
# Write your MySQL query statement below
SELECT D.name AS Department, E.name AS Employee, E.salary AS Salary
FROM Department as D
LEFT JOIN Employee as E
ON D.id = E.departmentId
WHERE (E.departmentId, E.salary) IN (
    SELECT departmentId, MAX(salary)
    FROM Employee
    GROUP BY departmentId
);
```

---

**Runtime** 599 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-03-24.</sub>
