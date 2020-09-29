package vds.api.services;

import vds.api.interfaces.IProviderTransfer;

public class BankTransferService implements IProviderTransfer {
    public String Operator;
    public String CardNumber;
    public String CardNumberSecret;
    public int SecretCode;


    private BankTransferService(String operator, String cardNumber, int secretCode){
        this.Operator = operator;
        this.CardNumber = cardNumber;
        this.SecretCode = secretCode;
    }

    public static BankTransferService Create(String operator, String cardNumber, int secretCode) {
        return new BankTransferService(operator, cardNumber, secretCode);
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
