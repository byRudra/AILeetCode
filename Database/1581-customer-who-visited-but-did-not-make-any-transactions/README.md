# 1581. Customer Who Visited but Did Not Make Any Transactions

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/customer-who-visited-but-did-not-make-any-transactions/)

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

# def find_customers(visits: pd.DataFrame, transactions: pd.DataFrame) -> pd.DataFrame:
#     merged = visits.merge(transactions, on='visit_id', how='left')

#     result = merged[merged["transaction_id"].isna()].groupby('customer_id').size().reset_index(name="count_no_trans")
#     return result
def find_customers(visits: pd.DataFrame, transactions: pd.DataFrame) -> pd.DataFrame:
    
    filtered = visits[~visits["visit_id"].isin(transactions["visit_id"])]
    
    return filtered.groupby("customer_id").size().reset_index(name="count_no_trans")
```

---

**Runtime** 333 ms · **Memory** 67.4 MB

<sub>Synced by AILeetHub on 2026-03-31.</sub>
