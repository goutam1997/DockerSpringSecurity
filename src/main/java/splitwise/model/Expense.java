package splitwise.model;


import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Expense {
    private String description;
    private double amount;
    private User paidBy;
    private SplitType splitType;
    private List<User> users;
    Map<User,Double> splits;
}
