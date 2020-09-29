package vds.api.interfaces;

public interface IProviderTransfer {
    Error DepositMoney(double money);
    String GetCardNumberSecret();
}
