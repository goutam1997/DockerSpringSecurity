package splitwise.template_pattern;

public class PayToFriend extends SendMoney{
    @Override
    public void validateReq() {
        System.out.println("validate PayToFriend");
    }

    @Override
    public void debitFromSender() {
        System.out.println("debitFromSender PayToFriend");

    }

    @Override
    public void chargeFees() {
        System.out.println("chargeFees PayToFriend");

    }

    @Override
    public void creditToReceiver() {
        System.out.println("creditToReceiver PayToFriend");

    }

}
