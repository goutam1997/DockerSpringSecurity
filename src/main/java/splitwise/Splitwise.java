package splitwise;

import lombok.extern.slf4j.Slf4j;
import splitwise.controller.ExpenseController;
import splitwise.controller.GroupController;
import splitwise.controller.UserController;
import splitwise.model.Expense;
import splitwise.model.Group;
import splitwise.model.SplitType;
import splitwise.model.User;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Splitwise {
    static UserController userController=new UserController();
    static ExpenseController expenseController=new ExpenseController();
    static GroupController groupController=new GroupController();

    public static void main(String[] args) {
        User goutam=new User("goutam","gk@gmail.com");
        User suman= new User("suman","gk@gmail.com");
        User piyush=new User("piyush","gk@gmail.com");
        User kaushal=new User("kaushal","gk@gmail.com");
        User lakhan= new User("lakhan","gk@gmail.com");
        userController.addUsers(Arrays.asList(
                goutam, suman,piyush,kaushal,lakhan
                ));
        groupController.setGroups(List.of(new Group("blr", Arrays.asList(goutam, piyush, kaushal))));
        Expense expense=new Expense();
        expense.setPaidBy(goutam);
        expense.setDescription("food");
        expense.setAmount(300);
        expense.setSplitType(SplitType.EQUAL);
        expense.setUsers(Arrays.asList(goutam,piyush,kaushal));
        expenseController.createExpense(expense);

        log.info("goutam: {}", goutam.getBalanceSheet());
        log.info("goutam: {}", piyush.getBalanceSheet());
        log.info("goutam: {}", kaushal.getBalanceSheet());
    }
}
