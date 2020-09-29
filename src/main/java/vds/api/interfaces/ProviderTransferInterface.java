package vds.api.interfaces;

public interface ProviderTransferInterface {
    Error DepositMoney(double money);
    String GetCardNumberSecret();
}
