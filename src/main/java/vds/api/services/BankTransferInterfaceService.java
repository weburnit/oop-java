package vds.api.services;

import vds.api.interfaces.ProviderTransferInterface;

public class BankTransferInterfaceService implements ProviderTransferInterface {
    public String Operator;
    public String CardNumber;
    public String CardNumberSecret;
    public int SecretCode;


    private BankTransferInterfaceService(String operator, String cardNumber, int secretCode){
        this.Operator = operator;
        this.CardNumber = cardNumber;
        this.SecretCode = secretCode;
    }

    public static BankTransferInterfaceService Create(String operator, String cardNumber, int secretCode) {
        return new BankTransferInterfaceService(operator, cardNumber, secretCode);
    }

    @Override
    public Error DepositMoney(double money) {
        // Should delegate with bank operator

        //Get from bank
        this.CardNumberSecret = "429xxxxxxxx1123";
        return null;
    }

    @Override
    public String GetCardNumberSecret() {
        return this.CardNumberSecret;
    }
}
