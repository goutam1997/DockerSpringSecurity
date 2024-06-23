package splitwise.service;

import lombok.extern.slf4j.Slf4j;
import splitwise.model.BalanceSheet;
import splitwise.model.Expense;
import splitwise.model.User;

@Slf4j
public class EqualSplit extends SplitExpense {
    BalanceSheet balanceSheet;
    public void splitExpense(Expense expense){
        log.info("Inside equal split for {}",expense);
        double splitAmount=expense.getAmount()/(expense.getUsers().size());

        User paidBy = expense.getPaidBy();
        paidBy.getBalanceSheet().setTotalAmountPaid(paidBy.getBalanceSheet().getTotalAmountPaid() + expense.getAmount());

        for (User user: expense.getUsers()){
            if (!paidBy.equals(user)) {
                user.getBalanceSheet().addBalance(paidBy, -splitAmount);
                user.getBalanceSheet().setAmountOwed(user.getBalanceSheet().getAmountOwed() + splitAmount);

                paidBy.getBalanceSheet().addBalance(user, splitAmount);
                paidBy.getBalanceSheet().setAmountGetBy(paidBy.getBalanceSheet().getAmountGetBy() + splitAmount);
            }
        }
    }
}
