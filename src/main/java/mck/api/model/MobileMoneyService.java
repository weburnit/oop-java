package mck.api.model;

import mck.api.interfaces.ProviderTransferInterface;

public class MobileMoneyService implements ProviderTransferInterface {

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
