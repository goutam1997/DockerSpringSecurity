package splitwise.atm;

public abstract class MoneyDispenser {
    MoneyDispenser nextDispenser;
    MoneyDispenser(MoneyDispenser nextDispenser){
        this.nextDispenser=nextDispenser;
    }
    void dispense(int amount){
        if (nextDispenser!=null){
            nextDispenser.dispense(amount);
        }
    }
}
