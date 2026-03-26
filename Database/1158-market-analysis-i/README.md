# 1158. Market Analysis I

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/market-analysis-i/)

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
SELECT U.user_id AS buyer_id, U.join_date, Count(O.order_id) AS orders_in_2019
FROM Users AS U
LEFT JOIN Orders AS O
ON U.user_id = O.buyer_id
AND YEAR(O.order_date) = 2019
GROUP BY U.user_id,U.join_date
```

---

**Runtime** 1191 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-03-26.</sub>
