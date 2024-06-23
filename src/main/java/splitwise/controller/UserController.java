package splitwise.controller;

import lombok.Data;
import splitwise.model.User;

import java.util.List;

@Data
public class UserController {
    private List<User> users;
    public void addUsers(List<User> users){
        this.users=users;
    }
}
