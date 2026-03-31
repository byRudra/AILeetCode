import pandas as pd

# def find_customers(visits: pd.DataFrame, transactions: pd.DataFrame) -> pd.DataFrame:
#     merged = visits.merge(transactions, on='visit_id', how='left')

#     result = merged[merged["transaction_id"].isna()].groupby('customer_id').size().reset_index(name="count_no_trans")
#     return result
def find_customers(visits: pd.DataFrame, transactions: pd.DataFrame) -> pd.DataFrame:
    
    filtered = visits[~visits["visit_id"].isin(transactions["visit_id"])]
    
    return filtered.groupby("customer_id").size().reset_index(name="count_no_trans")