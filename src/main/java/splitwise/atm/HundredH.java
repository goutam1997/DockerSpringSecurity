package splitwise.atm;

public class HundredH extends MoneyDispenser {
    HundredH(MoneyDispenser nextDispenser) {
        super(nextDispenser);
    }

    @Override
    void dispense(int amount) {
        System.out.println("Dispensed "+(amount/100)+" 100 notes");
        amount%=100;
        if (amount>0){
            nextDispenser.dispense(amount);
        }
    }
}
