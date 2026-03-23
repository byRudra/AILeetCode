# 182. Duplicate Emails

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/duplicate-emails/)

`Database`

## Approach

Accepted easy solution in pythondata.
Relevant topics: Database.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (pythondata)

```python
import pandas as pd

def duplicate_emails(person: pd.DataFrame) -> pd.DataFrame:
    return person[person.duplicated('email', keep=False)][['email']].drop_duplicates()
    
```

---

**Runtime** 266 ms · **Memory** 66.8 MB

<sub>Synced by AILeetHub on 2026-03-23.</sub>
