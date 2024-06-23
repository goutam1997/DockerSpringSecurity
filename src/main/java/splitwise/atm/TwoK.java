package splitwise.atm;

public class TwoK extends MoneyDispenser {
    TwoK(MoneyDispenser nextDispenser) {
        super(nextDispenser);
    }

    @Override
    void dispense(int amount) {
        System.out.println("Dispensed "+(amount/2000)+" 2000 notes");
        amount%=2000;
        if (amount>0){
            nextDispenser.dispense(amount);
        }
    }
}
