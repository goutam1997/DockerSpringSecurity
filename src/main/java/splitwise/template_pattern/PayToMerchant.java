package splitwise.template_pattern;

public class PayToMerchant extends SendMoney{
    @Override
    public void validateReq() {
        System.out.println("validate PayToMerchant");
    }

    @Override
    public void debitFromSender() {
        System.out.println("debitFromSender PayToMerchant");

    }

    @Override
    public void chargeFees() {
        System.out.println("chargeFees PayToMerchant");

    }

    @Override
    public void creditToReceiver() {
        System.out.println("creditToReceiver PayToMerchant");

    }

}
