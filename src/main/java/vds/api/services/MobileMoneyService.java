package vds.api.services;

import vds.api.interfaces.IProviderTransfer;

public class MobileMoneyService implements IProviderTransfer {

    public String Operator;
    public String CardNumber;


    private MobileMoneyService(String operator, String cardNumber){
        this.Operator = operator;
        this.CardNumber = cardNumber;
    }

    public static MobileMoneyService Create(String operator, String cardNumber) {
        return new MobileMoneyService(operator, cardNumber);
    }


    @Override
    public Error DepositMoney(double money) {
        // Delegate with network operator
        return null;
    }

    @Override
    public String GetCardNumberSecret() {
        return this.CardNumber;
    }
}
