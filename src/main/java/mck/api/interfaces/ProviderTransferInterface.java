package mck.api.interfaces;

public interface ProviderTransferInterface {
    Error DepositMoney(double money);
    String GetCardNumberSecret();

    public class BankTransferDTO {
        float credit;
        String destinationAccount;
    }
}
