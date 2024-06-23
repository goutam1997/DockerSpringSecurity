package splitwise.atm;

public class FiveH extends MoneyDispenser {
    FiveH(MoneyDispenser nextDispenser) {
        super(nextDispenser);
    }

    @Override
    void dispense(int amount) {
        System.out.println("Dispensed "+(amount/500)+" 500 notes");
        amount%=500;
        if (amount>0){
            nextDispenser.dispense(amount);
        }
    }
}
