package splitwise.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
public class User {
    private String name;
    private String email;
    private BalanceSheet balanceSheet;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        balanceSheet=new BalanceSheet();
    }

    public String toString(){
        return "name: "+name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
