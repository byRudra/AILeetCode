# 1075. Project Employees I

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/project-employees-i/)

`Database`

## Intuition  
The goal is to compute, for each project, the mean experience of all employees assigned to it.  
Because the `Project` table lists employee–project pairs and the `Employee` table holds the experience, we need to combine the two tables, aggregate by project, and round the result.

## Approach  
1. **Join** the two tables on `employee_id` so each row contains a project and the corresponding employee’s experience.  
2. **Group** the joined rows by `project_id`.  
3. For each group, calculate the average of `experience_years` using `AVG`.  
4. **Round** the average to two decimal places with `ROUND(..., 2)` and alias the column as `average_years`.  
5. Return the `project_id` and the rounded average.  
The query uses an `INNER JOIN` because only employees that exist in both tables should be considered; the `GROUP BY` ensures one row per project.

## Complexity  
- **Time:** O(n + m) – each row of `Project` and `Employee` is processed once during the join and aggregation.  
- **Space:** O(p) – the result set stores one row per distinct project, where *p* is the number of projects.

## Solution (mysql)

```sql
SELECT 
P.project_id, ROUND(AVG(E.experience_years), 2) AS average_years
FROM Project AS P
INNER JOIN Employee AS E
ON P.employee_id = E.employee_id
GROUP BY P.project_id;
```

---

**Runtime** 642 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-03-27.</sub>
