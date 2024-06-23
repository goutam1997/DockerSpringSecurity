package splitwise.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class BalanceSheet {
    Map<User, Double> friendsBalance=new HashMap<>();
    private double totalAmountPaid;
    double amountGetBy;
    double amountOwed;

    public void addBalance(User user, double amount){
        friendsBalance.put(user, friendsBalance.getOrDefault(user,0.0)+amount);
    }
}
