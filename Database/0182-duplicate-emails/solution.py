import pandas as pd

def duplicate_emails(person: pd.DataFrame) -> pd.DataFrame:
    return person[person.duplicated('email', keep=False)][['email']].drop_duplicates()
    