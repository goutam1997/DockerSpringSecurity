package splitwise.atm;

public class Main {
    public static void main(String[] args) {
        MoneyDispenser dispenser=new TwoK(new FiveH(new HundredH(null)));
        dispenser.dispense(3900);
    }
}
