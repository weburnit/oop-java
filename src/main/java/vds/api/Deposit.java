package vds.api;

import vds.api.interfaces.ProviderTransferInterface;
import vds.api.services.BankTransferInterfaceService;
import vds.api.services.MobileMoneyService;

public class Deposit {
    private ProviderTransferInterface providerTransfer;

    public int DepositID;
    public int UserID;
    public String Operator;
    public int _OperatorType;
    public double DepositMoney;
    public String CardNumberSecret;
    public int Status;
    public String Message;

    private Deposit (int depositID, int userID, double depositMoney) {
        this.DepositID = depositID;
        this.UserID = userID;
        this.DepositMoney = depositMoney;
    }

    public static Deposit Create(int userID){
        return new Deposit(1, userID,0);
    }

    public Deposit WithBankProvider(String operator, String cardNumber, int secretCode){
        this.providerTransfer = BankTransferInterfaceService.Create(operator, cardNumber, secretCode);
        this.Operator = operator;
        this._OperatorType = OperatorType.TypeBank;
        return this;
    }

    public Deposit WithMobileProvider(String operator, String cardNumber){
        this.providerTransfer = MobileMoneyService.Create(operator, cardNumber);
        this.Operator = operator;
        this._OperatorType = OperatorType.TypeMobile;
        return this;
    }

    public Error Deposit(double money) {
        this.DepositMoney = money;
        this.Status = TrackingStatus.StatusSuccess;
        Error err =  providerTransfer.DepositMoney(money);
        if (err != null) {
            this.Status = TrackingStatus.StatusFail;
            this.Message = err.getMessage();
        }
        this.CardNumberSecret = providerTransfer.GetCardNumberSecret();
        return  err;
    }
}
