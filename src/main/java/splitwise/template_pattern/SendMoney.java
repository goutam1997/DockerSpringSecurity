package splitwise.template_pattern;

public abstract class SendMoney {
    public abstract void validateReq();
    public abstract void debitFromSender();
    public abstract void chargeFees();
    public abstract void creditToReceiver();

    public final void sendMoney() {
        validateReq();

        debitFromSender();

        chargeFees();

        creditToReceiver();
    }
}
