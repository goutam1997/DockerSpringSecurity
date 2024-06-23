package splitwise.controller;

import lombok.Data;
import splitwise.model.Expense;
import splitwise.model.Group;
import splitwise.service.SplitExpense;
import splitwise.service.SplitFactory;

import java.util.ArrayList;
import java.util.List;

@Data
public class ExpenseController {
    private List<Expense> expenses=new ArrayList<>();
    SplitExpense splitExpense;
    public void createExpense(Expense expense){
        validateSplit(expense);
        expenses.add(expense);
        splitExpense= SplitFactory.get(expense.getSplitType());
        splitExpense.splitExpense(expense);
    }

    private void validateSplit(Expense expense) {

    }
}
