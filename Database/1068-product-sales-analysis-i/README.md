# 1068. Product Sales Analysis I

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/product-sales-analysis-i/)

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

# def sales_analysis(sales: pd.DataFrame, product: pd.DataFrame) -> pd.DataFrame:
#     df = sales.merge(product, on='product_id', how='left')
#     return df[['product_name','year','price']]


def sales_analysis(sales: pd.DataFrame, product: pd.DataFrame) -> pd.DataFrame:
        merged_df = pd.merge(sales, product, on='product_id', how='inner')
        return merged_df[['product_name', 'year', 'price']]
```

---

**Runtime** 368 ms · **Memory** 70.2 MB

<sub>Synced by AILeetHub on 2026-03-25.</sub>
