package splitwise.service;

import splitwise.model.BalanceSheet;
import splitwise.model.Expense;

public abstract class SplitExpense {
    public abstract void splitExpense(Expense expense);
}
