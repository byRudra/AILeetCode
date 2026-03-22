# 175. Combine Two Tables

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/combine-two-tables/)

`Database`

## Approach

Accepted easy solution in mysql.
Relevant topics: Database.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (mysql)

```sql
select firstName, lastName, city, state
from person a left join address b on
a.personid = b.personid
```

---

**Runtime** 426 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-03-22.</sub>
