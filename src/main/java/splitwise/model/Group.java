package splitwise.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Group {
    String groupName;
    List<User> users;
    List<Expense> expenses;

    public Group(String groupName, List<User> users) {
        this.groupName = groupName;
        this.users = users;
        expenses=new ArrayList<>();
    }
}
